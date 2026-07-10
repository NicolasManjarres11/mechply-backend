package com.devsenior.nmanja.mechply.security.jwt;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.devsenior.nmanja.mechply.security.jwt.Service.JwtService;
import com.devsenior.nmanja.mechply.security.jwt.model.vo.JwtUser;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        var header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        var token = header.substring(7);

        if (!jwtService.validateToken(token)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or expired token");
            return;
        }

        try {
            var auth = getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
        } catch (JwtException | IllegalArgumentException e) {
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }

        private Authentication getAuthentication(String token) {
        var subject = jwtService.getSubject(token);

        var userId = jwtService.getClaim(token, "user-id", String.class);
        var roles = jwtService.getClaimList(token, "roles", String.class);

        var authorities = roles.stream()
                .map(SimpleGrantedAuthority::new)
                .toList();

        var principal = new JwtUser(subject, userId, authorities);
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }
    
}

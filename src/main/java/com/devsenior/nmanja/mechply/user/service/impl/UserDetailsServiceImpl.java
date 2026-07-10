package com.devsenior.nmanja.mechply.user.service.impl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.devsenior.nmanja.mechply.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implementación del método para cargar el usuario por nombre de usuario
        var user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el correo: " + username));

        //Para el caso en que los roles los manejemos como lista

/*         var authorities = user.getRole().stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .toList(); */


        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(new SimpleGrantedAuthority("ROLE_"+user.getRole().name()))
                .build();
                
    }
    
}

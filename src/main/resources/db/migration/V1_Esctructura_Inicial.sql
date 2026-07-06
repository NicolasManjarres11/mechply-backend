
-- ---------------------------------------------------------
-- Tabla: "user"
-- ---------------------------------------------------------
CREATE TABLE "user" (
    id              BIGSERIAL PRIMARY KEY,
    workshop_id     BIGINT,
    name            VARCHAR(150) NOT NULL,
    email           VARCHAR(150) NOT NULL,
    password_hash   VARCHAR(255) NOT NULL,
    phone_number    VARCHAR(20),
    role            VARCHAR(20) NOT NULL,
    active          BOOLEAN NOT NULL DEFAULT TRUE,
    creation_date   TIMESTAMP NOT NULL DEFAULT now(),
 
    CONSTRAINT uq_user_email UNIQUE (email),
    CONSTRAINT ck_user_role CHECK (role IN ('ADMIN', 'MECHANIC', 'CLIENT'))
);
 
COMMENT ON COLUMN "user".phone_number IS 'Número usado para notificaciones vía WhatsApp';
COMMENT ON COLUMN "user".workshop_id IS 'FK pendiente hacia workshop.id (tabla aún no creada en este sprint), se mantendrá opcional, no todos los usuarios son mecánicos que tienen un taller.';
 
-- Índice recomendado sobre email (además del UNIQUE, útil para búsquedas explícitas)
CREATE INDEX idx_user_email ON "user" (email);
 
-- ---------------------------------------------------------
-- Tabla: vehicles
-- ---------------------------------------------------------
CREATE TABLE vehicles (
    id              BIGSERIAL PRIMARY KEY,
    client_id       BIGINT NOT NULL,
    license_plate   VARCHAR(10) NOT NULL,
    make_model      VARCHAR(50),
    year            SMALLINT,
    color           VARCHAR(30),
    mileage         INT NOT NULL DEFAULT 0,
    creation_date   TIMESTAMP NOT NULL DEFAULT now(),
 
    CONSTRAINT uq_vehicles_license_plate UNIQUE (license_plate),
    CONSTRAINT fk_vehicles_client
        FOREIGN KEY (client_id) REFERENCES "user" (id)
        ON DELETE RESTRICT
);
 
COMMENT ON COLUMN vehicles.client_id IS 'FK hacia user.id (cliente dueño del vehículo)';
 
-- Índice recomendado sobre license_plate (además del UNIQUE)
CREATE INDEX idx_vehicles_license_plate ON vehicles (license_plate);
 
-- Índice adicional útil para el patrón de acceso "1:N (cliente)" -> vehicles por cliente
CREATE INDEX idx_vehicles_client_id ON vehicles (client_id);
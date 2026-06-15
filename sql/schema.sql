-- Schema y datos iniciales para el proyecto integrador
CREATE DATABASE IF NOT EXISTS proy_db DEFAULT CHARACTER SET utf8mb4;
USE proy_db;

CREATE TABLE IF NOT EXISTS roles (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  role_id INT NOT NULL,
  FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Datos de prueba
INSERT IGNORE INTO roles (id, name) VALUES (1,'ADMIN'), (2,'OPERATOR'), (3,'GUEST');
INSERT IGNORE INTO users (username,password,role_id) VALUES
('admin','admin123',1),
('operador','oper123',2),
('invitado','guest123',3);

CREATE TABLE IF NOT EXISTS plc_readings (
  id INT AUTO_INCREMENT PRIMARY KEY,
  timestamp DATETIME NOT NULL,
  tag VARCHAR(100) NOT NULL,
  value DOUBLE NOT NULL,
  status VARCHAR(50) NOT NULL,
  description VARCHAR(255)
);

INSERT IGNORE INTO plc_readings (timestamp, tag, value, status, description) VALUES
('2026-06-08 08:00:00','TAP_01',1.0,'OK','Primer tap emulado'),
('2026-06-08 08:00:05','TAP_02',0.0,'OK','Segundo tap emulado'),
('2026-06-08 08:00:10','TAP_03',1.0,'ALERT','Tercer tap con alerta');

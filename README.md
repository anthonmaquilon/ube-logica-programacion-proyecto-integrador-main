# Proyecto Integrador - Lógica de Programación

Proyecto base para la entrega final: aplicación de escritorio Java (Swing) para monitoreo y control básico de un PLC emulado en tiempo real, con gestión de roles, conexión a MySQL y reportes.

Dominio: lectura de taps de PLC emulado, registro de eventos y paneles de estado.

Requisitos mínimos:
- Java 8+
- MySQL en localhost (usuario `root`, con contraseña si corresponde)
- Maven

Pasos rápidos:
1. Importar el proyecto en su IDE (Maven) o ejecutar `mvn package`.
2. Crear la base de datos y tablas ejecutando `sql/schema.sql` en su servidor MySQL local.
3. Ejecutar la clase `com.ube.proyintegrador.Main`.

Usuarios de prueba (según `sql/schema.sql`):
- admin / admin123 (ADMIN)
- operador / oper123 (OPERATOR)
- invitado / guest123 (GUEST)

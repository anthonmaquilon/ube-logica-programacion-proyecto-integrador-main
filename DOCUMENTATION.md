# Documentación técnica (esqueleto)

Este documento sigue la estructura exigida por la guía del proyecto.

1. Portada y Metadatos
- Título: Aplicación de Escritorio Java con Gestión de Roles
- Integrantes: (Rellenar)
- IDE elegido: (Rellenar)
- Repositorio GitHub: (Enlace)
- Video demo: (Enlace)

2. Definición del Problema y Alcance
- Dominio elegido: Monitoreo de PLC emulado con lecturas de taps en tiempo real.
- Alcance: La aplicación permite a usuarios autenticados con roles de Administrador, Operador e Invitado acceder a un panel principal, visualizar datos de lectura de PLC, registrar eventos de taps emulados y generar reportes filtrados. No incluye comunicación con hardware real; el PLC se emula mediante datos generados y almacenados en la base de datos en localhost.

3. Modelado UML
- Incluir: Diagrama de casos de uso, diagrama de clases, flujo de autenticación.
- Se creó `uml/ProjectUML.puml` con el diagrama de clases y `uml/README.md` con descripción de casos de uso y flujo.

4. Arquitectura de Datos
- Motor: MySQL en localhost
- Credenciales: root / (vacía o con contraseña local)
- Script SQL: `sql/schema.sql`
- Tablas: `roles`, `users`, `plc_readings`.

5. Lógica en Java (UI + Negocio)
- Estructura de paquetes mostrada en `src/main/java`
- Clases clave: `DBManager`, `UserDAO`, `PlcReadingDAO`, `LoginFrame`, `MainFrame`, `PlcReadingsFrame`, `PlcReadingFormFrame`, `PlcDashboardFrame`.
- `MainFrame` habilita acceso según rol: Administrador/Operador pueden gestionar lecturas PLC; cualquier usuario puede ver reportes y el panel de métricas.

6. Reportes y Paneles
- Se implementó una tabla con lecturas PLC (`PlcReadingsFrame`) con filtros dinámicos de tag y estado.
- Se agregó un panel gráfico (`PlcDashboardFrame`) con una gráfica de barras de estados PLC usando JFreeChart.

7. Manual de Despliegue Local
- Instrucciones para ejecutar MySQL, importar `schema.sql`, compilar con Maven, ejecutar `Main`.

8. Bitácora de Uso Crítico de IA
- Ver `IA_AUDIT.md`.

9. Acuerdos de Trabajo Colaborativo
- Herramienta elegida: (Rellenar)
- Distribución de commits: (Rellenar)

10. Referencias Bibliográficas
- Incluir al menos 4 referencias en formato APA 7.

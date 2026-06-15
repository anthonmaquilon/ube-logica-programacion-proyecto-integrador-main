# Lógica de Programación - Proyecto Integrador
La aplicación consiste en un sistema de escritorio desarrollado en Java Swing que permite monitorear y controlar un `PLC emulado en tiempo real`. El sistema implementa autenticación de usuarios mediante roles, almacenamiento persistente en `MySQL`, visualización de estados operativos y generación de reportes de eventos registrados.

La lógica principal se basa en la simulación continua de señales provenientes de un PLC, las cuales son procesadas, almacenadas y presentadas al usuario según sus permisos de acceso.

1. Requisitos Mínimos:
* Java JDK 8 o superior.
* Servidor MySQL instalado y configurado en localhost.
* Usuario de base de datos con permisos de acceso (por defecto: `root`).
* Apache Maven para la gestión de dependencias y compilación del proyecto.
* Entorno de desarrollo compatible con proyectos Maven (NetBeans, IntelliJ IDEA o Eclipse).

2. Pasos para la Configuración y Ejecución del Proyecto:
* Importación y Compilación del Proyecto `mvn package`.
* Abrir el entorno de desarrollo (NetBeans, IntelliJ IDEA o Eclipse).
* Crear la base de datos y tablas ejecutando `sql/schema.sql` en su servidor MySQL local.
* Seleccionar la opción Importar Proyecto Maven.
* Cargar la carpeta raíz del proyecto que contiene el archivo `pom.xml`.
* Esperar a que Maven descargue automáticamente las dependencias necesarias.
* Ejecutar la clase `com.ube.proyintegrador.Main`.

3. Acceso al Sistema con usuarios de prueba (`sql/schema.sql`):
* admin / admin123 (ADMIN)
* operador / oper123 (OPERATOR)
* invitado / guest123 (GUEST)

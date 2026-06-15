# Proyecto Integrador Monitoreo y Control de PLC Emulado - Lógica de Programación

Descripción:
Aplicación de escritorio desarrollada en Java Swing para el monitoreo y control básico de un `PLC emulado en tiempo real`. El sistema permite la gestión de usuarios mediante roles, el registro de eventos operativos, la visualización del estado del proceso y la generación de reportes almacenados en una base de datos `MySQL`.

Este proyecto fue desarrollado como parte de una actividad académica orientada a la aplicación de lógica de programación, programación orientada a objetos, bases de datos y diseño de interfaces gráficas.

## Características Principales:
* Autenticación de usuarios con control de acceso por roles.
* Gestión de tres tipos de usuarios:
  * Administrador (ADMIN)
  * Operador (OPERATOR)
  * Invitado (GUEST)
* Simulación de lectura de señales (taps) de un PLC en tiempo real.
* Registro automático de eventos y actividades del sistema.
* Panel de monitoreo con indicadores de estado.
* Generación de reportes filtrados.
* Persistencia de datos mediante MySQL.
* Arquitectura basada en Java Swing y Maven.

## Tecnologías Utilizadas:
* Java 8 o superior
* Java Swing
* Maven
* MySQL
* JDBC

## Estructura del Proyecto:

```text
UBE-Logica-Programacion-Proyecto-Integrador-main
│
├── DOCUMENTATION.md
├── IA_AUDIT.md
├── pom.xml
├── README.md
│
├── lib
│   └── mysql.jar
│
├── sql
│   └── schema.sql
│
└── src
    └── main
        └── java
            └── com
                └── ube
                    └── proyintegrador
                        │
                        ├── Main.java
                        │
                        ├── dao
                        │   ├── PlcReadingDAO.java
                        │   └── UserDAO.java
                        │
                        ├── db
                        │   └── DBManager.java
                        │
                        ├── models
                        │   ├── PlcReading.java
                        │   └── User.java
                        │
                        └── ui
                            ├── LoginFrame.java
                            ├── MainFrame.java
                            ├── PlcDashboardFrame.java
                            ├── PlcReadingFormFrame.java
                            └── PlcReadingsFrame.java
```

## Requisitos Previos
Antes de ejecutar el proyecto asegúrese de tener instalado:

* JDK 8 o superior
* Apache Maven
* MySQL Server
* IDE compatible con Maven (NetBeans, IntelliJ IDEA o Eclipse)

## Instalación y Ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/usuario/proyecto-integrador.git
cd proyecto-integrador
```

### 2. Crear la base de datos

Ejecutar el script:

```sql
sql/schema.sql
```

En el servidor MySQL local.

### 3. Configurar la conexión

Verificar que los parámetros de conexión coincidan con la configuración local:

```properties
host=localhost
puerto=3306
usuario=root
password=*****
```

### 4. Compilar el proyecto

```bash
mvn clean package
```

### 5. Ejecutar la aplicación

Desde el IDE:

```java
com.ube.proyintegrador.Main
```

o mediante Maven:

```bash
mvn exec:java
```

## Usuarios de Prueba

| Usuario  | Contraseña | Rol      |
| -------- | ---------- | -------- |
| admin    | admin123   | ADMIN    |
| operador | oper123    | OPERATOR |
| invitado | guest123   | GUEST    |

## Funcionalidades por Rol

### ADMIN

* Gestión completa del sistema.
* Acceso a reportes y registros.
* Visualización de todos los eventos.

### OPERATOR

* Monitoreo del PLC emulado.
* Registro de operaciones.
* Consulta de información operativa.

### GUEST

* Acceso de solo lectura.
* Consulta básica del estado del sistema.

## Objetivo Académico

Demostrar la aplicación práctica de:
* Lógica de programación.
* Programación orientada a objetos.
* Manejo de interfaces gráficas con Java Swing.
* Conexión y operaciones con bases de datos MySQL.
* Gestión de usuarios y control de acceso basado en roles.
* Simulación de procesos industriales mediante PLC virtual.

## Licencia

Proyecto desarrollado con fines educativos y académicos.

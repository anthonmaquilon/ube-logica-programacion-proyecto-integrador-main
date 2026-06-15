# UML del Proyecto PLC Emulado

## Casos de uso

1. Autenticación: el usuario ingresa credenciales y obtiene un rol.
2. Monitoreo PLC: el usuario visualiza lecturas emuladas de taps en tiempo real.
3. Gestión de datos PLC: el Administrador u Operador puede crear nuevas lecturas emuladas.
4. Reportes: cualquier usuario puede ver reportes o tablas filtradas de lecturas.

## Diagrama de clases

El sistema utiliza las siguientes clases principales:

- `User`: representa el usuario autenticado con su rol.
- `PlcReading`: representa cada lectura de tap emulado.
- `DBManager`: administra la conexión JDBC singleton.
- `UserDAO`: obtiene usuarios según credenciales.
- `PlcReadingDAO`: recupera e inserta lecturas PLC.
- `LoginFrame`: interfaz de login.
- `MainFrame`: panel principal con acceso por rol.
- `PlcReadingsFrame`: tabla de reportes de lecturas PLC.
- `PlcReadingFormFrame`: formulario para crear lecturas PLC.

## Flujo de autenticación

1. El usuario ingresa nombre y contraseña en `LoginFrame`.
2. `LoginFrame` usa `UserDAO.findByCredentials`.
3. Si las credenciales son válidas, se crea `User` con el rol.
4. Se abre `MainFrame` y los botones se habilitan según el rol.
5. El usuario accede a monitoreo o gestión según permisos.

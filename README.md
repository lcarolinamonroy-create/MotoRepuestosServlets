# Módulo Moto Repuestos Express con Servlets y JSP

Módulo académico desarrollado para la evidencia **GA7-220501096-AA2-EV02: Módulos de software codificados y probados**.

El proyecto demuestra la implementación de un módulo web utilizando Java Servlets, JSP, JDBC, MySQL y los métodos HTTP GET y POST. El módulo permite consultar y registrar productos de la aplicación Moto Repuestos Express.

## Requisitos

- Java JDK 17 o superior.
- Maven.
- MySQL Server.
- MySQL Workbench.
- Apache Tomcat 10.1 o superior.

## Tecnologías utilizadas

- Java.
- Jakarta Servlets.
- JSP.
- JSTL.
- JDBC.
- MySQL.
- Maven.
- Apache Tomcat.
- HTML y CSS.

## Base de datos

La aplicación utiliza la base de datos `motorepuestos`.

Para crear la base de datos y las tablas, se debe ejecutar el archivo `database.sql` desde MySQL Workbench.

La conexión utiliza el usuario `root` y la variable de entorno `DB_PASSWORD`.

En PowerShell se puede configurar la contraseña temporalmente con:

```powershell
$env:DB_PASSWORD="TU_CONTRASEÑA_MYSQL"
```

Se debe reemplazar `TU_CONTRASEÑA_MYSQL` por la contraseña configurada en MySQL.


## Estructura del proyecto

```text
moto-repuestos-servlets/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/motorepuestos/servlets/
│       │       ├── controller/
│       │       │   └── ProductoServlet.java
│       │       ├── model/
│       │       │   └── Producto.java
│       │       └── repository/
│       │           ├── ConexionBD.java
│       │           └── ProductoRepository.java
│       └── webapp/
│           ├── index.jsp
│           └── WEB-INF/
│               └── views/
│                   └── productos.jsp
├── database.sql
├── pom.xml
├── mvnw
├── mvnw.cmd
├── README.md
└── .gitignore
```

## Descripción de los componentes

### ProductoServlet

Es el controlador principal del módulo. Atiende las peticiones realizadas por el navegador mediante los métodos `doGet()` y `doPost()`.

### Producto

Es la clase modelo que representa la información de un producto:

- Identificador.
- Nombre.
- Categoría.
- Precio.
- Stock.

### ProductoRepository

Contiene las operaciones necesarias para consultar y registrar productos en la base de datos MySQL.

### ConexionBD

Centraliza la conexión JDBC entre la aplicación Java y la base de datos MySQL.

### productos.jsp

Es la vista del módulo. Contiene el formulario HTML para registrar productos y la tabla que muestra los productos almacenados.

## Construcción del proyecto

Desde la carpeta principal del proyecto ejecutar en PowerShell:

```powershell
.\mvnw.cmd clean package
```

Si la construcción se realiza correctamente, aparecerá el mensaje:

```text
BUILD SUCCESS
```

El archivo generado se encontrará en:

```text
target/moto-repuestos-servlets.war
```

## Despliegue en Apache Tomcat

Copiar el archivo:

```text
target/moto-repuestos-servlets.war
```

en la carpeta:

```text
C:\Program Files\Apache Software Foundation\Tomcat 10.1\webapps
```

Luego iniciar Apache Tomcat.

Tomcat desplegará automáticamente la aplicación web.

## Acceso al módulo

Abrir en el navegador:

```text
http://localhost:8080/moto-repuestos-servlets/productos
```

## Operaciones demostradas

### Consulta de productos

Método:

```text
GET
```

Ruta:

```text
/productos
```

Esta operación consulta los productos registrados en MySQL y los muestra en una tabla HTML dentro de la página JSP.

### Registro de productos

Método:

```text
POST
```

Ruta:

```text
/productos
```

Esta operación recibe los datos enviados desde el formulario JSP, valida la información y registra el producto en la base de datos.

Los campos utilizados son:

- Nombre.
- Categoría.
- Precio.
- Stock.

## Validaciones implementadas

El sistema valida que:

- El nombre no esté vacío.
- La categoría no esté vacía.
- El precio sea mayor que cero.
- El stock sea igual o mayor que cero.
- Los datos enviados tengan el formato correcto.

## Patrón de diseño utilizado

El módulo utiliza una estructura basada en el patrón MVC:

- **Modelo:** clase `Producto`.
- **Vista:** archivo `productos.jsp`.
- **Controlador:** clase `ProductoServlet`.
- **Repositorio:** clase `ProductoRepository`.

El Servlet procesa las solicitudes, el repositorio administra la comunicación con MySQL y la página JSP presenta la información al usuario.

## Pruebas realizadas

Se realizaron las siguientes pruebas:

1. Construcción del proyecto mediante Maven.
2. Despliegue del archivo WAR en Apache Tomcat.
3. Consulta de productos mediante el método GET.
4. Registro de un producto mediante el método POST.
5. Verificación del producto registrado en MySQL.
6. Validación de datos vacíos o incorrectos.
7. Comprobación de la conexión entre la aplicación y la base de datos.

## Resultado final

El módulo fue compilado exitosamente con Maven, desplegado en Apache Tomcat y ejecutado desde el navegador.

Se verificó el funcionamiento de los métodos GET y POST, el formulario JSP, la conexión JDBC con MySQL y el registro y consulta de productos.

Este proyecto corresponde al módulo desarrollado para la evidencia:

**GA7-220501096-AA2-EV02: Módulos de software codificados y probados.**

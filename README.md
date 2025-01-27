# **Guía para levantar el proyecto en local**

Este documento proporciona las indicaciones necesarias para configurar y levantar el proyecto en tu entorno local. Asegúrate de seguir los pasos en el orden indicado para evitar problemas de configuración.

---

## **Prerrequisitos**

Antes de comenzar, asegúrate de tener instalados los siguientes programas en tu máquina:

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Git](https://git-scm.com/downloads)
- [Java 21](https://jdk.java.net/21/)
- [Gradle](https://gradle.org/install/)
- PostgreSQL y Redis deben estar instalados y en funcionamiento.

---

## **Clonar el repositorio**

Primero, clona el repositorio del proyecto en tu máquina local:

```bash
git clone https://github.com/nestoragredollanten/tenpo.git
cd tenpo
```

---

## **Configuraciones para levantar el proyecto**

### **1. Configuración de variables de entorno**

Si estás utilizando IntelliJ IDEA, configura las siguientes variables en la opción **Environment variables**:

```text
spring.profiles.active=dev
```

### **2. Configuración de la base de datos**

Modifica los datos de conexión según tu base de datos PostgreSQL para el perfil `dev` en el archivo `application-dev.yml` o en tu configuración de entorno:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/dev_postgres
    username: dev_postgres
    password: dev_password
```

---

## **Levantar servicios necesarios**

### **1. PostgreSQL y Redis**

Asegúrate de que los servicios de **PostgreSQL** y **Redis** estén funcionando antes de levantar la aplicación. Si usas Docker, puedes utilizar el siguiente comando para levantarlos rápidamente:

```bash
docker-compose up -d
```

Asegúrate de que el archivo `docker-compose.yml` tenga configuraciones correctas para PostgreSQL y Redis.

---

## **Levantar la aplicación**

Una vez configurados los pasos anteriores, puedes levantar la aplicación desde tu IDE (recomendado IntelliJ IDEA) o con el siguiente comando desde la terminal:

```bash
./gradlew bootRun
```

---

## **Probar la API**

Una vez levantada la aplicación, puedes acceder al **Swagger** para revisar y probar los endpoints disponibles:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## **Notas adicionales**

- **Perfiles activos:** Asegúrate de que el perfil `dev` esté activo para garantizar el correcto funcionamiento de las configuraciones locales.
- **Logs y errores:** Si encuentras problemas durante la ejecución, verifica los logs generados por el servicio y asegúrate de que todas las dependencias externas estén configuradas correctamente.

---

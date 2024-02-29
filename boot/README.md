# Módulo Boot

Este módulo es responsable de arrancar y configurar la aplicación, sirviendo como el punto de entrada para el sistema.
Utiliza Spring Boot para simplificar la configuración inicial, el arranque de la aplicación y la integración de
componentes.

## Características Principales

- **Configuración de Spring Boot:** Define la configuración necesaria para iniciar la aplicación Spring Boot, incluyendo
  la configuración del servidor, contextos de aplicación y más.
- **Punto de Entrada de la Aplicación:** Contiene la clase principal que inicia la aplicación usando Spring Boot.
- **Integración de Módulos:** Coordina la carga e integración de los diferentes módulos del proyecto (
  como `domain`, `application` e `infrastructure`), asegurando que todos los componentes estén correctamente
  configurados y disponibles para su uso.

## Estructura del Módulo

El módulo `boot` contiene principalmente la clase principal anotada con `@SpringBootApplication`, que es reconocida por
Spring Boot como el punto de arranque de la aplicación:

### Clase Principal

- **Ubicación:** `src/main/java/com/miguelluque/apifirst/boot/`
- **Descripción:** La clase principal utiliza la anotación `@SpringBootApplication` y contiene el método `main` que
  ejecuta `SpringApplication.run`. Esta clase inicia el contexto de aplicación de Spring y arranca el servidor web
  embebido.

## Cómo Ejecutar

Para ejecutar la aplicación desde este módulo, puedes utilizar el siguiente comando Maven desde la línea de comandos:

```bash
mvn spring-boot:run

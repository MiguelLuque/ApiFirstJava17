# Módulo Application

Este módulo actúa como una capa intermedia en la arquitectura de la aplicación, facilitando la comunicación entre la
capa de presentación (o API) y la capa de dominio. Define la lógica de aplicación necesaria para procesar y transformar
datos entre las representaciones externas (DTOs) y las entidades de dominio.

## Estructura del Módulo

El módulo `application` está organizado en subcarpetas que reflejan sus responsabilidades principales:

### Mapper

- **Ubicación:** `mapper/`
- **Descripción:** Contiene mappers para convertir entre entidades de dominio y Data Transfer Objects (DTOs). Estos
  mappers son esenciales para separar la representación de datos utilizada en la API externa de la estructura de las
  entidades de dominio.
- **Componente Clave:** `ProductMapper` es responsable de las conversiones entre `Producto`, `ProductoDto`,
  y `ProductoCreateDto`, así como de generar respuestas paginadas para listas de productos.

### Servicio

- **Ubicación:** `service/`
- **Descripción:** Define los servicios que implementan los casos de uso de la aplicación, encapsulando la lógica de
  aplicación específica y las reglas de negocio.
- **Componente Clave:** `ManageProductoService` implementa la interfaz `ManageProductUseCase`, proporcionando la lógica
  de negocio para operaciones CRUD sobre productos.
- **Gestion de autorización:** `ManageAuthService` implementa la interfaz `ManageAuthtUseCase`, proporcionando la lógica
  para la autorización de usuarios.
- **Gestion de tokens:** `JwtTokenService` este componente ayuda a la gestión de los token JWT.

## Responsabilidades Clave

El módulo `application` se encarga de:

- **Transformación de Datos:** Convertir datos entre las entidades de dominio y los DTOs para abstraer las
  representaciones internas de los datos de las interfaces externas.
- **Orquestación de Lógica de Negocio:** Ejecutar operaciones definidas en los casos de uso, interactuando con el módulo
  de dominio para acceder y modificar datos, y aplicando cualquier lógica de negocio adicional requerida.
- **Abstracción de la Capa de Dominio:** Proporcionar una interfaz clara para las operaciones de negocio que puede ser
  utilizada por la capa de presentación o API, sin exponer los detalles de implementación de la capa de dominio.
- **Especificación:** es la clase que contiene la lógica que se seguirá en la query dinamica que se crea. Este elemento
  está en este módulo por comodidad.

## MapStruct para Mapeo de Objetos

El módulo utiliza MapStruct, una herramienta de generación de código para mapeo de objetos Java, que simplifica la
implementación de mappers entre diferentes representaciones de modelos de datos. Esto facilita mantener el código limpio
y la lógica de mapeo separada de la lógica de negocio principal.

## Uso de Spring Data para Abstracción de Persistencia

Aunque el módulo `application` se centra en la lógica de aplicación, interactúa estrechamente con el módulo de dominio,
utilizando repositorios definidos en el módulo de dominio para realizar operaciones de persistencia, lo que demuestra la
separación de responsabilidades en la arquitectura de la aplicación.

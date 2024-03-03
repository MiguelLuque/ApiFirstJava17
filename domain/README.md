# Módulo Domain

Este módulo contiene la lógica de dominio central de la aplicación, incluyendo la definición de entidades, repositorios
y casos de uso específicos para la gestión de productos. Es responsable de definir la estructura de datos y las
operaciones de negocio que se pueden realizar sobre esos datos.

## Estructura del Módulo

El módulo `domain` está organizado en varias carpetas clave, cada una con un propósito específico:

### OpenAPI

- **Ubicación:** `openapi/openapi.yml`
- **Descripción:** Contiene la definición de OpenAPI para la API de productos. Esta especificación describe los
  endpoints disponibles, sus parámetros, y los modelos de datos utilizados para las operaciones CRUD sobre productos.

### Entity

- **Ubicación:** `entity/`
- **Descripción:** Contiene las entidades de dominio de la aplicación. En este módulo, definimos la entidad `Producto`,
  que representa la información clave de los productos gestionados por la aplicación, así como `User` y `Role`
  como entidades necesarias para la gestión de la autorización

### Repository

Los repositorios situados en esta capa sirven como un contrato, su implementación se encuentra en infrastructure

- **Ubicación:** `repository/`
- **Descripción:** Define los repositorios utilizados para acceder y manipular datos de las entidades de dominio. Por
  ejemplo, `ProductRepository` proporciona operaciones para consultar y persistir la entidad `Producto`.

### Use Case

- **Ubicación:** `usecase/`
- **Descripción:** Contiene los casos de uso que encapsulan la lógica de negocio específica de la
  aplicación. `ManageProductUseCase` es responsable de orquestar las operaciones de negocio relacionadas con los
  productos, como crear, actualizar, borrar y listar productos.`ManageAuthUseCase` es responsable de orquestar las
  operaciones de negocio relacionadas con
  la autorización de usuarios.

### Tax

- **Ubicación:** `tax/`
- **Descripción:** Contiene la interfaz `CalculadorDeImpuestos` y las clases `CalculadorDeImpuestosIVA`
  y `CalculadorDeImpuestosITBIS` que la implementan

## Responsabilidades Clave

El módulo `domain` se centra en encapsular la lógica de negocio y las reglas de dominio de la aplicación, proporcionando
una capa claramente definida que puede ser utilizada por otros módulos de la aplicación (como `application`
o `infrastructure`) para realizar operaciones de alto nivel sin tener que preocuparse por los detalles de implementación
de acceso a datos o manipulación de entidades específicas.

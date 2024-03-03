# Api first java 17

## Consideraciones a tener en cuenta:

Todos los módulos tienen un README con más información pero dejo algunas consideraciones:

- **Gestión de errores:** soy consciente que la gestión de errores es bastante mejorable pero considero que dado
  el contexto de esta prueba es suficiente.
- **Gestión de dependencias:** al igual que con los errores, las dependencias entre módulos podrían estar mejor
  gestionadas
  reubicandolas entre los diferentes módulos para que solo esten declaradas en los módulos concretos que hagan uso de
  ellas.
- **Strategy para la gestión de impuestos:** La configuración para la gestión del Bean del calculo de impuestos se
  encuentra boot.
- **Endpoint de filtrado dinamico:** este endpoint se ha puesto en `/productos/search` para ser coherentes con el resto
  aunque soy consciente que lo que tiene sentido es que este endpoint fuera el mismo que el que los lista todos. Ambos
  endpoints
  han sido dotados con paginación.
- **Spanglish:** he mantenido algunas cosas en español porque no estaba seguro de como preferís que se implemente aunque
  desde mi puntos de vista tendría que haberlo hecho todo en inglés, por este motivo no hay mucha coherencia con este
  punto.

## Uso de la aplicación:

He usado intelij para el desarrollo por lo que he añadido los comandos que he usado.

Este proyecto usa lombok por lo que habría que tenerlo en cuenta por si diese algún problema al compilarlo.

Un detalle **importante** es que los DTO son autogenerados, por lo que para poder usar el proyecto correctamente
hay que compilarlo para que genere estas clases. Además los módulos tienen que marcar con sources las clases generadas
de la carpeta target `target/generated-sources/openapi/src/main/java`.
Esto lo podemos hacer en intellij desde `file->project structure->modules->Aqui marcamos en cada modulo el source`

Con ejecutar clean install debería ser suficiente para poder arrancar la aplicación.

Además os adjuntaré el postman que he usado para que podáis usarlo.

## Siguientes pasos:

Para este proyecto he usado una base de datos en memoria H2 pero lo adecuado sería cambiarla por una base de datos
Postgresql pro ejemplo.
Además estaría bien dockerizarla para poder levantarlo todo e implementar un flujo de integración continua para si
despliegue,
así como por ejemplo usar jacoco para controlar el coverage de la aplicación, subir los niveles de este y hacer tests de
integración.








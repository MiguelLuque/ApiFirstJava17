Esta configuración de Spring seleccionará la implementación correcta del CalculadorDeImpuestos basada en la propiedad
app.tax.calculator definida en tu archivo de propiedades. Al hacerlo, estás aplicando polimorfismo a través de la
configuración, permitiendo cambiar el comportamiento de la aplicación en tiempo de ejecución simplemente modificando el
archivo de configuración, sin necesidad de recompilar el código.
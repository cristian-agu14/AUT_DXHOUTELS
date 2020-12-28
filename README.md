# Introducción 🚀
Este artefacto es un proyecto de automatización de pruebas funcionales para el front de DX HOTELS

# Features, Escenarios y casos de prueba 📋
Los features tienen pasos en los antecedentes, esto para que se ejecuten siempre estos pasos antes de cada escenario.

1. Feature HOTELS
    1.1. @find-hotel-cheaper
    Caracteristica para encontrar el hotel mas economico para un lugar en especifico.
	    

# Software dependencies 🛠️
* El proyecto de automatización esta construido con GRADLE
* Serenity
* Cucumber

# Arquitectura de la automatización 🔧
La automatización está realizada con Serenity y con las capas que recomienda Screenplay, se manejan pruebas controladas 
por el comportamiento BDD.
Las urls se cargan desde un archivo .properties localizado en la ruta src/test/resources/urls. Al metodo planteado en los StepDefinitions se debe enviar el key del valor de la url para abrir la pagina requerida. * Esto ya está configurado

# Ejecución de la automatización ⚙️
Para ejecutar la automatización se debe realizar la importación del proyecto tipo gradle desde un IDE adecuado o ejecutando el comando 'gradle build aggregate' desde una consola de comandos en la raiz de la carpeta del proyecto y con este comando se puede generar el informe automatico de Serenity.



### Saludos...



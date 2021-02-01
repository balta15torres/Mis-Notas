# Base de la ingeniería del software

<a name="top"></a>
## Índice de contenidos
|Conceptos generales              |
|---------------------------------|
|[Especificación](#especificación)|
|[Diseño](#diseño)                |
|[Construcción](#construcción)    |
|[Validación,verificación,pruebas](#validación-verificación-y-pruebas)|

## Conceptos generales:
- Especificación
- Diseño
- Construcción
- Validación, verificación y pruebas:
- Mantenimiento

[Ir al indice](#top)

### Especificación
Es la tarea de escribir detalladamente el software a ser desarrollado, en una forma matemáticamente rigurosa. En la realidad, la
mayoría de las buenas especificaciones han sido escritas para entender y afinar aplicaciones que ya estaban desarrolladas. Las
especificaciones son más importantes para las interfaces externas, que deben permanecer estables.

[Ir al indice](#top)

### Diseño
Se refiere a determinar cómo funcionará el software de forma general sin entrar en detalles. Consisten en incorporar
consideraciones de la implementación tecnológica, como el hardware, la red, etc. Se definen los casos de uso para cubrir las
funciones que realizará el sistema, y se transformarán las entidades definidas en el análisis de requisitos en clases de diseño,
obteniendo un modelo cercano a la programación orientada a objetos.

Extraer los requisitos y requerimientos de un producto de software es la primera etapa para crearlo. El resultado del análisis de 
requerimientos con el cliente se plasma en el [documento ERS](https://es.wikipedia.org/wiki/Especificaci%C3%B3n_de_requisitos_de_software#:~:text=La%20especificaci%C3%B3n%20de%20requisitos%20de,son%20conocidos%20como%20requisitos%20funcionales.),
cuya estructura puede venir definida por varios estándares, tales como [CMMI](https://normasyestandaresproyectosti.wordpress.com/2015/01/29/cmmi/).
Asimismo, se define un diagrama de Entidad/Relación, en el que se plasman las principales entidades que participarán en el 
desarrollo del software.

La captura, análisis y especificación de requerimientos (incluso pruebas de ellos), es una parte crucial; de esta etapa depende en
gran medida el logro de los objetivos finales.

[La IEEE Std. 830-1998](https://www.ctr.unican.es/asignaturas/is1/IEEE830_esp.pdf) normaliza la creación de las especificaciones 
de requerimientos de software.

[Ir al indice](#top)

### Construcción
Traducir un diseño a código puede ser la parte más obvia del trabajo de ingeniería del software, pero no necesariamente es la
que demanda mayor trabajo ni la más complicada. La complejidad y la duración de esta etapa está íntimamente relacionada al o a
los lenguajes de programación utilizados, así como al diseño previamente realizado.

[Ir al indice](#top)

### Validación, verificación y pruebas:
Consiste en comprobar que el software realice correctamente las tareas indicadas en la especificación del problema. Una técnica
de prueba es probar por separado cada módulo del software, y luego probarlo de forma integral, para así llegar al objetivo.

Se recomienda que las pruebas sean efectuadas por alguien distinto al desarrollador que la programó, idealmente un área de pruebas 
aunque el programador debe hacer sus propias pruebas.

En general hay dos grandes formas de organizar un área de pruebas:

1. que esté compuesta por personal inexperto, de esta forma se evalúa que la documentación entregada pueda entenderla cualquiera 
y comprobar que el software hace las cosas tal y como están descritas.

2. es tener un área de pruebas conformada por programadores con experiencia y poner atención en condiciones que puede fallar en la aplicación. 

[Ir al indice](#top)

### Mantenimiento
Mantener y mejorar el software para solventar errores descubiertos y tratar con nuevos requisitos. El mantenimiento puede ser
de cuatro tipos: 

1. perfectivo: mejorar la calidad interna de los sistemas.

2. evolutivo: incorporaciones, modificaciones y eliminaciones necesarias en un producto software para cubrir la expansión o cambio 
en las necesidades del usuario. 

3. adaptativo: modificaciones que afectan a los entornos en los que el sistema opera, por ejemplo, cambios de configuración del hardware.

4. preventivo: revisión constante del software para detectar posibles fuentes de problemas que puedan surgir en el futuro.

[Ir al indice](#top)

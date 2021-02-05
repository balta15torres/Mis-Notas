# Base de la ingeniería del software

<a name="top"></a>
## Índice de contenidos
|[Conceptos generales](#conceptos-generales)                          |[Ciclo de vida del software y Tipos de Metodologías](#ciclo-de-vida-del-software-y-tipos-de-metodologías)|[Ingeniería estructurada](#ingeniería-del-software-estructurada)       |[Paradigma de orientación a objetos](#paradigma-de-orientación-a-objetos)|
|---                                                                  |---                                                                                                      |---                                                                    |---
|[Especificación](#especificación)                                    |[En cascada (waterfall)](#en-cascada-waterfall)                                                          |[Estructura secuencial](#estructura-secuencial)                        |[Clases y objetos](#clases-y-objetos)
|[Diseño](#diseño)                                                    |[Iterativo](#iterativo)                                                                                  |[Estructura condicionales](#estructura-condicionales)                  |[Encapsulamiento y ocultación](#encapsulamiento-y-ocultación)
|[Construcción](#construcción)                                        |[En V](#en-v)                                                                                            |[Estructuras de repetición (bucles)](#estructuras-de-repetición-bucles)|[Organización de los objetos](#organización-de-los-objetos)
|[Validación,verificación,pruebas](#validación-verificación-y-pruebas)|[Basado en componentes (CBSE)](#basado-en-componentes-cbse)                                              |[Bucle for](#for)                                                      |[Herencia y polimorfismo](#herencia-y-polimorfismo)
|                                                                     |[Desarrollo rápido (RAD)](#desarrollo-rápido-rad)                                                        |[Bucle while](#while)                                                  |[set y get](#propiedades-selectores-get-y-modificadores-set)


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

## Ciclo de vida del software y Tipos de Metodologías
El ciclo del vida del software es una estructura aplicada al desarrollo de un producto de software. Hay varios modelos a seguir
para el establecimiento de un proceso para el desarrollo de software, cada uno de los cuales describe un enfoque diferente para
diferentes actividades que tienen lugar durante el proceso. Algunos autores consideran un modelo de ciclo de vida un término más
general que un determinado proceso para el desarrollo de software. Por ejemplo, hay varios procesos de desarrollo de software
específicos que se ajustan a un modelo de ciclo de vida de espiral.

Las metodologías de ingeniería software se propusieron con la finalidad de establecer unos pasos a la hora de desarrollar un
programa de forma que evitara, en la medida de lo posible, que el software se volviera inviable de desarrollar a mitad del proceso.

[Ir al indice](#top)

### En cascada (waterfall)
El ciclo de vida inicialmente propuesto por Royce en 1970, fue adaptado para el software a partir de ciclos de vida de otras
ramas de la ingeniería. Es el primero de los propuestos y el más ampliamente seguido por las organizaciones (se estima que el
90% de los sistemas han sido desarrollados así).

![Modelo de ciclo de vida en cascada](../images/1.4cascada.png)

Este modelo admite la posibilidad de hacer iteraciones, por ejemplo; durante las modificaciones que se hacen en el mantenimiento se 
puede ver la necesidad de cambiar algo en el diseño, lo cual significa que se harán los cambios necesarios en la codificación y se 
tendrán que realizar de nuevo las pruebas y así hasta recorrer de nuevo el resto de las etapas comprobando si se puede pasar a la siguiente. 

Trabaja en base a documentos, es decir, la entrada y la salida de cada estapa es un tipo de documento específico. Idealmente,
cada estapa podría hacerla un equipo diferente. Los documentos son:

- Análisis: toma como entrada una descripción en lenguaje natural de lo que quiere el cliente. Produce el S.R.D. (Software
Requirements Document).

- Diseño: su entrada es el S.R.D. Produce el S.D.D. (Software Design Document)

- Codificación: a partir del S.D.D. produce módulos. En esta fase se hacen también pruebas de unidad.

- Pruebas: a partir de los módulos probados se realiza la integración y pruebas de todo el sistema. El resultado es el producto final.

##### Tipos de proyectos para los que es adecuado
- Aquellos para los que se dispone de todas las especificaciones desde el principio, por ejemplo, los de reingeniería.

- Se está desarrollando un tipo de producto que no es novedoso.

- Proyectos complejos que se entienden bien desde el principio

> [ventajas y desventajas](https://sites.google.com/site/proyectoadpmodelosdedesarrollo/home/modelo-en-cascada/modelo-en-cascada-ventajas-y-desventajas) 

[Ir al indice](#top)

### Iterativo
Para entender los requisitos antes de entregar el producto se puede hacer un desarrollo iterativo durante las fases de análisis y 
diseño global. Esto consistiría en:

1. Preguntar al usuario.
2. Hacer el diseño global que se desprende del punto anterior.
3. Hacer un prototipo de interfaz de usuario, entrevistas con los usuarios, etc y volver con ello al primer punto para identificar más
requisitos o corregir malentendidos.

El resto es igual al ciclo de vida en cascada

[Ir al indice](#top)

### Incremental
En este caso se va creando el sistema añadiendo pequeñas funcionalidades. Cada uno de los pequeños incrementos es parecido
a lo que ocurre dentro de la fase de mantenimiento.

Hay dos partes en el ciclo de vida, similares al [Iterativo](#iteratico). Por un lado está el análisis y el diseño global. 
Por otra parte están los pequeños incrementos, con las fases de diseño detallado, codificación y mantenimiento.

![Modelo de ciclo de vida incremental](../images/1.4incremental.png)

>  La ventaja de este método es que no es necesario tener todos los requisitos en un principio. El inconveniente es que los errores 
>en la detección de requisitos se encuentran tarde.

[Ir al indice](#top)

### En V
Propuesto por Alan Davis, tiene las mismas fases que el [Incremental](#incremental), pero se considera el nivel de abstracción de cada una. 
Una fase además de utilizarse como entrada para la siguiente, sirve para validar o verificar otras fases posteriores.

![Modelo de ciclo de vida en V](../images/1.4v.png)

[Ir al indice](#top)

### Basado en componentes (CBSE)
Los tipos de ciclos de vida que se han visto hasta ahora son relativos al análisis y diseño estructurados, pero los objetos tienen
una particularidad, y es que están basados en componentes que se relacionan entre ellos a través de interfaces, son mas modulares y 
por lo tanto el trabajo se puede dividir en un conjunto de miniproyectos. Es típico en una metodología de diseño orientado a objetos 
es iterativo e incremental.

Las metas de la CBSE son la reutilización, la adaptación y la extensión:
- Soportar el desarrollo de sistemas construidos mediante componentes.

- El desarrollo de componentes como una entidad reutilizable. Un componente es reutilizable en la medida en que sus servicios
pueden ser utilizados por otro software.

- El mantenimiento y mejoramiento de sistemas mediante la personalización y sustitución de componentes. Un componente es
adaptable si su proveedor ha previsto los posibles cambios que puede sufrir dicho componente y es extensible si su
proveedor proporciona los mecanismos para modificar los servicios que ofrece el componente.

[Ir al indice](#top)

### Desarrollo rápido (RAD)
El desarrollo de software de "métodos rápidos" (también Modelo rápido ó AG) definido por James Martin a principios de la década de 1980, 
consiste en un ciclo de desarrollo corto basado en tres fases (Requisitos, Diseño y Construcción) con un plazo de entrega ideal de 90 
a 120 días como máximo reduce el tiempo del ciclo de vida del software.

Para el desarrollo rápido la primera instancia es una versión del prototipo y después integrar la funcionalidad de manera iterativa para 
satisfacer los requisitos del cliente y controlar todo el ciclo de desarrollo.

Los métodos rápidos se originaron por la inestabilidad del entorno técnico y el hecho de que el cliente a veces es incapaz de
definir cada uno de los requisitos al inicio del proyecto. El término "rápido" es una referencia a la capacidad de adaptarse a los
cambios de contexto y a los cambios de especificaciones que ocurren durante el proceso de desarrollo. En el año 2001, se redacto el 
manifiesto ágil, con los siguientes puntos principales:
- Individuos e interacciones en lugar de procesos y herramientas.

- Desarrollo de software en lugar de documentación exhaustiva.

- Trabajo con el cliente en lugar de negociaciones contractuales.
- Apertura para los cambios en lugar de cumplimiento de planes poco flexibles.

> Con la ayuda de los métodos rápidos, el cliente tiene control total de su proyecto y logra una rápida implementación del
software, permitiendo al usuario involucrarse desde el inicio del proyecto.

[Ir al indice](#top)

## Ingeniería del software estructurada
La ingeniería estructurada se basa en las estructuras de control que van a determinar el orden en el que se ejecutan las
instrucciones de un programa.

[Ir al indice](#top)

### Estructura secuencial
La estructura más básica y fundamental es la secuencial, es decir, las órdenes se ejecutarán secuencialmente en el orden en el
que aparezcan.    

![Estructura secuencial](../images/1.5secuencial.png)

[Ir al indice](#top)

### Estructura condicionales
Las estructura condicionales nos permiten ejecutar un bloque de instrucciones en función de que se cumplan o no una o varias condiciones. 
La estructura de control clásica es:

![Estructura condicionales](../images/1.5condicionales.png)

Donde la cláusula else es opcional.

Debemos entender esta estructura del siguiente tipo: Si condición es verdadera, se ejecutará acciones1, en otro caso, se ejecutará acciones2.

Hay que destacar que podemos hacer estructuras más complejas de este tipo, sin más que introducir más if/else dentro de otros
if/else

Las condiciones también suelen llamarse expresiones lógicas porque sólo pueden dar como resultado los valores verdadero o
falso. Para ello podemos utilizar los operadores de comparación para crear expresiones: == (igual a), != (distinto a), 
< (menor que), > (mayor que), <= (menor o igual que), >= (mayor o igual que), también se puede utilizar los operadores lógicos 
AND, OR y NOT.

En JavaScript el operador AND se representa con los símbolos &&, OR con || y NOT con !
Así, una expresión del tipo: exp1 AND exp2 se evalúa a verdadero sólo en el caso de que tanto exp1 como exp2 se evalúen a
verdadero. En cualquier otro caso, la expresión se evaluará a falso.

Sin embargo, exp1 OR exp2 se evalúa a verdadero en el caso de que bien exp1 o bien exp2 se evalúen a verdadero. En el caso 
de que ninguna se evalúe a verdadero, la expresión total se evaluará a falso.

Finalmente, NOT exp1 se evalúa a verdadero si exp1 se evalúa a falso y se evalúa a falso si exp1 se evalúa a verdadero. Es
decir, realiza la negación de exp1.

[Ir al indice](#top)

### Estructuras de repetición (bucles)
Estas estructuras sirven para repetir un número determinado de veces un conjunto de instrucciones o, sin conocer dicho número, 
desear repetirlas mientras se cumpla cierta condición. Esto quiere decir que existen dos tipos de estructuras de repetición:

##### for:
Especificámos el número de veces que quiere que se repita un conjunto de instrucciones. Por lo tanto, ese número debe ser conocido. 
La sintaxis correcta de esta estructura de repetición es:

![Bucle for](../images/1.5for.png)

Debemos entender esta estructura como: La “expresión” suele consistir en dar un valor inicial a una variable.

Este valor se va comparando en cada una de las repeticiones según la “condición” establecida. “Operación” permite acercar el
valor inicial al valor final, es decir, en el cual ya no se realizarán más repeticiones.

En cada vuelta del bucle se ejecutará 1 vez lo que diga “acciones”

##### while:
Si no sabe cuántas veces se va a repetir el bucle. Utilizando la estructura while, usted podrá repetir un conjunto de instrucciones 
mientras se cumpla cierta condición. La sintaxis correcta de esta estructura es:

![Bucle while](../images/1.5while.png)

Que lo que hará será ejecutar las acciones hasta que la condición sea Falsa.

En ocasiones, usted deseará salir de un bucle aunque la condición de prueba no se haya cumplido. En estos casos puede utilizar la 
sentencia break si desea salir completamente del bucle o continúe si lo que quiere es no ejecutar el resto de sentencias del 
cuerpo del bucle, sino pasar a la siguiente repetición. 

Puedes anidar bucles en el interior de otros bucles. En estos casos, para cada repetición del bucle exterior, se ejecuta
completamente el bucle interior.

Tenga en cuenta que la incorporación de bucles en el interior de otros bucles puede hacer que la ejecución del código consuma
mucho tiempo.

[Ir al indice](#top)

## Paradigma de orientación a objetos
La orientación a objetos es una forma de programar que rompe con la forma de programar clásica. En un entorno clásico de programación 
el problema o sistema que se está analizando se divide en funciones: este sistema hace esto, esto y esto.

Para llevar a cabo el análisis con la programación orientada a objetos hay que tener en cuenta que los programas se codifican
pensando en objetos que interactúan. Los objetos tendrán unas determinadas propiedades y serán capaces de hacer ciertas cosas 
mediante los métodos que se les hayan definido.

Si se hace un buen diseño de los objetos y de las clases, se podrán usar en nuevos programas y proyectos fácilmente, favoreciendo la reusabilidad.

[Ir al indice](#top)

### Metodologías de la programación orientada a objetos

#### Clases y objetos
La orientación a objetos promete mejoras de amplio alcance en la forma de diseño, desarrollo y mantenimiento del software 
ofreciendo una solución a la falta de portabilidad del código y reusabilidad, código que es difícil de modificar, ciclos de 
desarrollo largos y técnicas de codificación no intuitivas.

Un lenguaje orientado a objetos tiene tres características básicas: debe estar basado en objetos, basado en clases y capaz 
de tener herencia de clases.

Podemos definir un objeto como un conjunto complejo de datos y programas que poseen estructura y forman parte de una organización.
Esta definición específica varias propiedades importantes de los objetos. En primer lugar, un objeto no es un dato simple, sino
que contiene en su interior cierto número de componentes bien estructurados. En segundo lugar, cada objeto no es un ente
aislado, sino que forma parte de una organización jerárquica o de otro tipo.

Estructura de un objeto; un objeto puede considerarse como una especie de cápsula dividida en tres partes y cada una desempeña 
un papel totalmente independiente:

1. Relaciones: permiten que el objeto se inserte en la organización y están formadas esencialmente por punteros a otros objetos.

2. Propiedades: distinguen un objeto determinado de los restantes que forman parte de la misma organización y tiene valores que 
dependen de la propiedad de que se trate. Las propiedades de un objeto pueden ser heredadas a sus descendientes en la organización.

3. Métodos: son las operaciones que pueden realizarse sobre el objeto, que normalmente estarán incorporados en forma de programas 
(código) que el objeto es capaz de ejecutar y que también pone a disposición de sus descendientes a través de la herencia.

[Ir al indice](#top)

#### Encapsulamiento y ocultación
Cada objeto es una estructura compleja en cuyo interior hay datos y programas, todos ellos relacionados entre sí. Esta propiedad 
(encapsulamiento), es una de las características fundamentales en la OOP.

Los objetos son inaccesibles, e impiden que otros objetos, los usuarios, o incluso los programadores conozcan cómo está
distribuida la información o qué información hay disponible. Esta propiedad de los objetos se denomina ocultación de la
información.

Para poder conocer lo necesario respecto a un objeto y a lo que contiene, las peticiones de información a un objeto deben 
realizarse a través de mensajes dirigidos a él, con la orden de realizar la operación pertinente. La respuesta a estas órdenes 
será la información requerida, siempre que el objeto considere que quien envía el mensaje está autorizado para obtenerla.

El hecho de que cada objeto sea una cápsula facilita enormemente que un objeto determinado pueda ser transportado a otro
punto de la organización, o incluso a otra organización totalmente diferente que precise de él. Si el objeto ha sido bien construido,
sus métodos seguirán funcionando en el nuevo entorno sin problemas. Esta cualidad hace que la OOP sea muy apta para la
reutilización de programas.

[Ir al indice](#top)

#### Organización de los objetos
En principio, los objetos forman siempre una organización jerárquica, en el sentido de que ciertos objetos son superiores a otros
de cierto modo.

Existen varios tipos de jerarquías: serán simples cuando su estructura pueda ser representada por medio de un "árbol". En otros
casos puede ser más compleja. En estas estructuras puede distinguirse tres niveles de objetos:

- La raíz de la jerarquía. Se trata de un objeto único y especial. Este se caracteriza por estar en el nivel más alto de la 
estructura y suele recibir un nombre muy genérico, que indica su categoría especial, como por ejemplo objeto madre, Raíz o Entidad.

- Los objetos intermedios. Son aquellos que descienden directamente de la raíz y que a su vez tienen descendientes.
Representan conjuntos o clases de objetos, que pueden ser muy generales o muy especializados, según la aplicación.
Normalmente reciben nombres genéricos que denotan al conjunto de objetos que representan, por ejemplo, VENTANA,
CUENTA, FICHERO. En un conjunto reciben el nombre de clases o tipos si descienden de otra clase o subclase.

- Los objetos terminales. Son todos aquellos que descienden de una clase o subclase y no tienen descendientes. Suelen
llamarse casos particulares, instancias o ítems porque representan los elementos del conjunto representado por la clase o
subclase a la que pertenecen

[Ir al indice](#top)

#### Herencia y polimorfismo 
En orientación a objetos la herencia es, después de la agregación o composición, el mecanismo más utilizado para alcanzar
algunos de los objetivos como lo son la reutilización y la extensibilidad. La herencia facilita la creación de objetos a partir 
de otros ya existentes (ya comprobados y verificados) e implica que una subclase obtiene todo el comportamiento (métodos) y 
eventualmente los atributos (variables) de su superclase.

Es la relación entre una clase general y otra clase más específica. Por ejemplo: Si declaramos una clase párrafo derivada de una
clase texto, todos los métodos y variables asociadas con la clase texto, son automáticamente heredados por la subclase párrafo. 

Es la relación entre una clase general y otra clase más específica. Por ejemplo: Si declaramos una clase párrafo derivada de una
clase texto, todos los métodos y variables asociadas con la clase texto, son automáticamente heredados por la subclase párrafo.

En los lenguajes que cuentan con un sistema de tipos fuerte y estrictamente restrictivo con el tipo de datos de las variables, la
herencia suele ser un requisito fundamental para poder emplear el Polimorfismo, al igual que un mecanismo que permita decidir en
tiempo de ejecución qué método debe invocarse en respuesta a la recepción de un mensaje, conocido como enlace tardío (late
binding) o enlace dinámico (dynamic binding).

En programación orientada a objetos el polimorfismo se refiere a la posibilidad de enviar un mensaje a un grupo de objetos cuya
naturaleza puede ser heterogénea. El único requisito que deben cumplir los objetos que se utilizan de manera polimórfica es saber
responder al mensaje que se les envía.

[Ir al indice](#top)

#### Propiedades: selectores (get) y modificadores (set)
- get: permite al usuario recuperar el valor de la propiedad, leerlo, por lo que su salida debe ser correspondiente con la que se
espera de la propiedad (por ejemplo, no tendría sentido que la propiedad “nombre” del ejemplo devolviese un número). Si
sólo creamos una función get para una propiedad, ésta es de sólo lectura.

- set: es usado para darle un valor a la propiedad, normalmente se añaden aquí los controles para asegurarse que el valor que
se asigna es del tipo deseado (y evitar que la clase colapse por un error de tipo de datos). La función de set, al ser para
escribir en la propiedad no devuelve ningún tipo de datos, pero debe tener un parámetro que es el valor que se pasará a la
variable. Al contrario de get, no puede haber una clase de sólo escritura (después de todo, no tiene ningún sentido tener una
propiedad a la que se le pueda asignar un valor pero este no pueda ser recuperado).

> Un nuevo paso en la abstracción de paradigmas de programación es la Programación Orientada a Aspectos (POA). Aunque es
  todavía una metodología en estado de maduración, cada vez atrae a más investigadores e incluso proyectos comerciales en todo el
  mundo.

[Ir al indice](#top)


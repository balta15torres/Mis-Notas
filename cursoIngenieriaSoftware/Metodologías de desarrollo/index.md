# Metodología de desarrollo del software

<a name="top"></a>
## Índice de contenidos
|Metodología de desarrollo|
|---
|[¿Que es?](#que-es-la-metodología-de-desarrollo)
|[ISO/IEC/IEEE 12207](#isoiecieee-12207)
|[Lenguaje de programación](#lenguaje-de-programación)
|[Metodologías](#metodologías-de-desarrollo-software) 
|[UML](#lenguaje-uml)
|[Proceso Unificado de Desarrollo](#proceso-unificado-de-desarrollo)

## RECUERDA
> - Una metodología de desarrollo de software se refiere a un framework que es usado para estructurar, planear y controlar el
> proceso de desarrollo en sistemas de información.
>  - Un lenguaje de programación es un idioma artificial diseñado para expresar procesos que pueden ser llevadas a cabo por
> máquinas como las computadoras.
> - Para escribir programas que proporcionen los mejores resultados, cabe tener en cuenta una serie de detalles:   
> - Portabilidad: capacidad de poder ejecutarse en una plataforma, ya sea hardware o software, diferente a aquella en la que se elaboró.
> - UML en primera instancia es independiente del proceso de desarrollo que se siga. Aun así, los mismos creadores de UML
> recomiendan una metodología de desarrollo denominada Proceso Unificado de Desarrollo.

### ¿Que es la metodología de desarrollo?
Una metodología de desarrollo de software se refiere a un framework que es usado para estructurar, planear y controlar el
proceso de desarrollo en sistemas de información.

El framework para metodología de desarrollo de software consiste en:

- Una filosofía de desarrollo de programas de computación con el enfoque del proceso de desarrollo de software

- Herramientas, modelos y métodos para asistir al proceso de desarrollo de software

Estos frameworks son a menudo vinculados a algún tipo de organización, que además desarrolla, apoya el uso y promueve la
metodología.

[Ir al indice](#top)

### ISO/IEC/IEEE 12207
ISO/IEC 12207 Information Technology / Software Life Cycle Processes, es el estándar para los procesos de ciclo de vida del
software de la organización ISO.

La estructura del estándar ha sido concebida de manera que pueda ser adaptada a las necesidades de cualquiera que lo use.
Para conseguirlo, el estándar se basa en dos principios fundamentales:

- Modularidad: con ella se pretende conseguir procesos con un mínimo acoplamiento y una máxima cohesión.

- Responsabilidad: con ella se busca establecer un responsable para cada proceso, facilitando la aplicación del estándar en  
proyectos en los que pueden existir distintas personas u organizaciones involucradas, no importando el uso que se le dé a este.

[Ir al indice](#top)

### Lenguaje de programación
Un lenguaje de programación es un idioma artificial diseñado para expresar procesos que pueden ser llevadas a cabo por
máquinas como las computadoras. Pueden usarse para crear programas que controlen el comportamiento físico y lógico de una
máquina, para expresar algoritmos con precisión, o como modo de comunicación humana.

Está formado por un conjunto de símbolos y reglas sintácticas y semánticas que definen su estructura y el significado de sus
elementos y expresiones. Al proceso por el cual se escribe, se prueba, se depura, se compila y se mantiene el código fuente de un
programa informático se le llama programación que se define  como el proceso de creación de un programa de computadora, mediante  
la aplicación de procedimientos lógicos, a través de los siguientes pasos:

- El desarrollo lógico del programa para resolver un problema en particular.

- Escritura de la lógica del programa empleando un lenguaje de programación específico (codificación del programa).

- Ensamblaje o compilación del programa hasta convertirlo en lenguaje de máquina.

- Prueba y depuración del programa.

- Desarrollo de la documentación.

La programación permite especificar de manera precisa sobre qué datos debe operar una computadora, cómo deben ser almacenados o
transmitidos y qué acciones debe tomar bajo una variada gama de circunstancias. Todo esto, a través de un lenguaje que intenta
estar relativamente próximo al lenguaje humano o natural. Una característica relevante de los lenguajes de programación es
precisamente que más de un programador pueda usar un conjunto común de instrucciones que sean comprendidas entre ellos para
realizar la construcción de un programa de forma colaborativa.

> Un error común es tratar por sinónimos 'lenguaje de programación' y 'lenguaje informático'. Los lenguajes informáticos  
> engloban a los lenguajes de programación y a otros más, como por ejemplo HTML (lenguaje para el marcado de páginas Web 
> que no es un lenguaje de programación, sino un conjunto de instrucciones que permiten diseñar el contenido de los documentos).

[Ir al indice](#top)

### Metodologías de desarrollo software
##### 1. Corrección 
Un programa es correcto si hace lo que debe hacer tal y como se estableció en las fases previas a su desarrollo.

##### 2. Claridad
Es muy importante que el programa sea lo más claro y legible posible, para facilitar así su desarrollo y posterior
mantenimiento.

Se debe intentar que su estructura sea sencilla, coherente y cuidar el estilo en la edición. Facilitando el trabajo del 
programador, tanto en la fase de creación como en las fases posteriores de corrección de errores, ampliaciones, modificaciones, etc, 
que pueden ser realizadas incluso por otro programador.

##### 3. Eficiencia
Se trata de que el programa, además de ser correcto lo haga gestionando de la mejor forma posible los recursos que utiliza. 
Como por ejemplo: el tiempo que tarda en realizar la tarea para la que ha sido creado, la cantidad de memoria que necesita, 
espacio en disco que utiliza, tráfico de red que genera, etc.

##### 4. Portabilidad
Es la capacidad de poder ejecutarse en una plataforma, ya sea hardware o software, diferente a aquella en la que se elaboró.
 
Es una característica muy deseable para un programa, ya que permite, por ejemplo, a un programa que se ha desarrollado para 
sistemas GNU/Linux ejecutarse también en un sistema operativo Window. Esto permite que el programa pueda llegar a más usuarios más fácilmente.

[Ir al indice](#top)

### Lenguaje UML
Es un lenguaje de comunicación para especificar, construir, visualizar y documentar los artefactos de un sistema de software orientado a objeto. 

> Un artefacto es una información que es utilizada o producida mediante un proceso de desarrollo de software.

UML se quiere convertir en un lenguaje estándar con el que sea posible modelar (por modelos) todos los componentes del proceso de desarrollo
de aplicaciones. Los modelos son simplificaciones de conceptos y realidades, que nos permiten reconocimiento efectivo y sencillo 
de los mismos. Al contar con unidades modeladas, manejar la complejidad de un sistema o el desarrollo de un software se convierte 
en una tarea mucho más sencilla, sin depender del lenguaje de desarrollo en absoluto para tal labor. Pero hay que tener en 
cuenta un aspecto importante del modelo: no pretende definir un modelo estándar de desarrollo, sino únicamente un lenguaje de modelado.

En UML los procesos de desarrollo son diferentes según los distintos dominios de trabajo; no puede ser el mismo el proceso 
para crear una aplicación en tiempo real, que el proceso de desarrollo de una aplicación orientada a gestión, por poner un ejemplo.

Las diferencias son muy marcadas y afectan a todas las fases del proceso. El método del UML recomienda utilizar los procesos
que otras metodologías tienen definidos.

> El UML surge de la necesidad de un lenguaje que no sólo comunique las ideas a otros desarrolladores, sino para que también  
  sirviera de apoyo a la hora de analizar los distintos problemas que surgen a lo largo de la fase de desarrollo de un proyecto 
  software. La opción más eficiente para ello fue desarrollar un lenguaje con una notación gráfica muy clara que permitiera 
  representar con mayor o menor abstracción todas las fases del proyecto de software.
  
> En 1994 comenzó a surgir este lenguaje de manos de Rumbaugh y Boosch, dos investigadores de metodología de software de 
  renombre. Se marcaron el objetivo de unificar tanto el método de Boosch y el OMT (Object modelling Tool), surgiendo el primer 
  esbozo de esta unión el año siguiente. Jacobson se unió a la empresa y sus ideas fueron incluidas, mejorando este futuro lenguaje. 
  No fue un desarrollo cerrado, sino que se abrió la posibilidad de que otras empresas colaboraran y aportaran sus ideas, lo que llevó 
  a la primera versión de UML. Esta primera versión se convirtió en 1997 en uno de los estándares de OMG (Object Management 
  Group)

[echale un vistazo al Análisis orientado a objetos con UML](https://github.com/balta15torres/Mis-Notas/blob/master/cursoIngenieriaSoftware/OOP/index.md#análisis-orientado-a-objetos-UML)

[Ir al indice](#top)

### Proceso Unificado de Desarrollo
UML en primera instancia es independiente del proceso de desarrollo que se siga. Aun así, los mismos creadores de UML
recomiendan esta metodología de desarrollo.

Este proceso se basa en componentes. A efectos de producción, cualquier sistema software es una amalgama de diferentes
componentes software que están interrelacionados e interconectados mediante interfaces bien definidas.

Este proceso hace del UML para expresar gráficamente todos los esquemas de este sistema, si bien el proceso en sí no viene 
definido por esto, sino por tres aspectos fundamentales:

- Se dirige a los casos de uso: los desarrolladores deben basarse siempre en ellos, creando los modelos para llevarlos a cabo.

- Centrado en la arquitectura: las características más significativas del sistema deben estar claramente representados.

- Iterativo e incremental: siempre que se trabaja con proyectos informáticos complejos, es más viable realizar una división de
los mismos por fases, en las que cada fase incrementa y revisa la anterior.

Podemos dividir el Proceso Unificado en diferentes fases:

1. Se define el proyecto, así como sus características más destacables, como las posibles arquitecturas, casos de uso, estimación de costes, etc.

2. Vamos obteniendo una visión más refinada del proyecto, en la que ya tenemos la mayoría de requisitos del sistema, los riesgos, 
validación de la estructura y arquitectura base.

3. Se construye el producto hasta llegar a una versión que cumpla una serie de requisitos mínimos. Dado el ámbito de esta fase, 
es la más larga del proceso, ya que aquí se afinan errores, casos de uso, iteraciones, etc.

4. Finalmente, se despliega el producto al usuario final, sirviéndonos del feedback de los usuarios para refinar el sistema 
en posteriores iteraciones.

[Ir al indice](#top)


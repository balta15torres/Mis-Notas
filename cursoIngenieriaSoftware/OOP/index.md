# Programción orientada a objetos

<a name="top"></a>
## Índice de contenidos
|[OOP](#oop)|
|---
|[Comportamiento de un objeto](#comportamiento-de-un-objeto)
|[Métodos constructores](#métodos-constructores)
|[Diagrama de clases](#diagrama-de-clases)
|[Encapsulamiento](#encapsulamiento)
|[Herencia](#herencia)

## OOP
En la programación orientada a objetos, el sistema se divide en objetos o entidades que podemos encontrar en la realidad.

Veamos un ejemplo. Imagine que está realizando la simulación de un coche, hablaría de: El coche dispone de un motor que se 
puede arrancar y apagar utilizando para ello el contacto.

Además, el coche dispone de un volante que permite que nos desplacemos en una determinada dirección: derecha o izquierda.
Al aumentar la velocidad utilizando el acelerador, debemos cambiar a una marcha más alta. Si reducimos la velocidad con el freno,
puede que sea conveniente cambiar a una marcha inferior...

En la descomposición en objetos nos hemos centrado en qué elementos podemos encontrar: motor, volante, acelerador, freno, caja de
cambios, etc.
Al pensar en objetos en lugar de en funciones, usted se acerca más a la realidad, ya que es la forma en que lo haría en cualquier
otra situación cotidiana.
De esta forma, una vez encontrados los objetos que intervienen, podremos asignarles las tareas que tienen que realizar

[Ir al indice](#top)

### Comportamiento de un objeto
El comportamiento de un objeto viene definido por la serie de procedimientos o funciones que definimos y éste puede desarrollar

Estos métodos, que también definimos nosotros, son operaciones que se pueden realizar con el objeto. Si en un objeto coche
tenemos los métodos Acelerar y Frenar, que aumentan o disminuyen el valor de la variable Velocidad, estos procedimientos
constituyen el comportamiento del objeto coche.

La identidad, como en cualquier otra variable, no es más que el identificador. Cuando definimos “cómo” es un objeto, después
podemos crear ese tipo de objetos. Si ya hemos definido nuestro objeto coche, podemos declarar diferentes instancias de este 
objeto, como coche01, coche02, etc. Cada vez que queramos acceder a cualquiera de los métodos o atributos, lo haremos
llamando al objeto por el identificador correspondiente.

El elemento que conforma la definición de un objeto recibe el nombre de Clase. Una clase no es otra cosa que una plantilla para
la creación de objetos, según un modelo que definamos. Las clases nos permiten abstracción sobre los datos y las operaciones
asociadas al objeto. A continuación explicaremos más extensamente el concepto de abstracción.

![Representación del objeto coche](../images/3.1coche.png)  

[Ir al indice](#top)

### Métodos constructores
Son un tipo específico de método que siempre tiene el mismo nombre de la clase y se utiliza para construir objetos de esa clase.

No tiene tipo de dato específico de retorno, ni siquiera void. Esto se debe a que el tipo que debe devolver un constructor de clase
es el propio tipo de clase.

Los constructores pueden sobrecargarse. Si el programador no declara un constructor el sistema siempre crea un constructor por defecto.

Para inicializar un objeto basta con llamar a su constructor después de la palabra reservada new y asignarlo a una referencia
declarada previamente. Ejemplo:
```` 
$ejem = new Contructor()
```` 
Un constructor es un método que se ejecuta cada vez que se crea un objeto, el propósito de este procedimiento es el de inicializar 
los datos del objeto. El nombre del constructor siempre es igual al nombre de la clase.

Los métodos destructores se encargan de liberar la memoria de los objetos. En alguno lenguajes como Java no existen métodos
destructores ya que es el propio sistema el que se encarga de liberar la memoria de los objetos que ya han perdido la referencia,
es decir, objetos que ya no tienen ningún nombre que permita acceder a ellos. Al llegar al final de un bloque en el que habían sido
definidos, porque a la referencia se le ha asignado el valor null o porque a la referencia se le ha asignado la dirección de otro
objeto.

[Ir al indice](#top)

### Diagrama de clases
Sirve para visualizar las relaciones entre las clases que involucran el sistema, las cuales pueden ser asociativas, de herencia, 
de uso y de contenimiento. Una vez creada la clase diagrama podemos empezar a crear elementos: clases, etc… en ella.

![Diagrama de clases](../images/3.2diagramaClass.png) 

[Ir al indice](#top)

### Encapsulamiento
Por protección de nuestros objetos, no es conveniente que sus datos miembro o estado, sean accesibles de cualquier forma y en
cualquier momento. Para evitar esto, se procede al encapsulamiento, que protege los datos asociados de un objeto contra su
modificación por quien no tenga derecho a acceder a ellos, previniendo posibles problemas posteriores por usos indebidos o no
autorizados.

La encapsulación va de la mano de la abstracción, ya que parte de la finalidad del encapsulamiento también es el 
conocimiento innecesario del usuario del cómo y porqué funciona un objeto, limitándose a usarlo.

No es necesario que el usuario de un objeto sepa cómo está estructurado por dentro. Los niveles de encapsulamiento nos
proporcionan tres distintos niveles de acceso a los datos de un objeto o clase, que son los siguientes:

- Público: es el nivel de protección más bajo y permite el acceso de cualquier función a los datos miembro de la clase

- Protegido: el acceso a estos datos está restringido a esta clase y a sus subclases (Ver punto HERENCIA).

- Privado: es el nivel más alto de protección. Sólo los métodos de esta clase en particular podrán tener acceso a los datos.

[Ir al indice](#top)

### Herencia
Cuanto más especializada es la clase, mayor nivel de abstracción conlleva mientras que, al revés, cuanto más vayamos hacia el
origen de la herencia, más general es, y por tanto, menos abstracta.

Esta relación se consigue gracias a la herencia, que como ya explicamos, se produce cuando aprovechamos la estructura de
clases ya existentes para crear clases nuevas basadas en esta, las cuales contienen todos los atributos y métodos de la clase
superior de la que proceden, lo que posibilita crear nuevas clases con nuevos matices que las diferencien entre sí, pero también
con nuevos métodos que se apliquen a los atributos y métodos heredados.

![Diagrama de clases](../images/3.3herencia.png) 

A las clases que sólo existen con la finalidad de agrupar y abstraer atributos y métodos comunes entre clases, se las conoce
como clases abstractas, mientras que a las clases que sí serán instanciadas, se las conoce como clases.

En UML existen 4 especificaciones en lo que a la herencia y sus subclases se refiere:

- {incomplete} indica que el conjunto de subclases no cubre todos los escenarios posibles de la clase madre. En nuestro
ejemplo, la herencia sería de este tipo, ya que existen más tipos de coches aparte del 4X4,el deportivo y el utilitario.

- {complete} indica que el conjunto de subclases cubre todas las posibilidades de escenario de la clase madre.

- {disjoint} nos indica que las subclases no tienen instancias comunes. Por ejemplo, aunque un Coche y un Helicóptero son
ambos Vehículos, no existe uno vehículo que sea ambos a la vez.

- {overlapping} nos indica que, al contrario que disjoint, tenemos una o varias instancias en comun entre las subclases. En
nuestro ejemplo, tambíen serían de este tipo, ya que hoy en día existen vehículos que pueden ser considerados a la vez
utilitarios y 4x4 por ejemplo.

En el caso que acabamos de mencionar, un vehículo SUV es a la vez Utilitario y 4X4, lo que hace que tenga herencia múltiple y,
a la vez, un conflicto, ya que el método Acelerar() lo tiene definido dos veces.

En el caso que acabamos de mencionar, un vehículo SUV es a la vez Utilitario y 4X4, lo que hace que tenga herencia múltiple y,
a la vez, un conflicto, ya que el método Acelerar() lo tiene definido dos veces.

[Ir al indice](#top)


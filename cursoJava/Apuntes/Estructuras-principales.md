# 2. ESTURCTURAS PRINCIPALES
---	
## Con java podemos generar estos tipos de programas:

- Aplicaciones de console 
- Aplicaciones de proposito general
- Applets

## Partes de un programa con Java:
- Java es un lenguaje **Case Sensitive** quiere decir que distingue entre minúsculas y mayusculas. 
- Modificador de acceso **public**
- **Class** todo programa Java tiene que ir dentro de esta clase y siempre el nombre de la clase tiene que empezar por mayusculas
- **{ }** la llaves serán el scope de la clase, metido etc… y tiene que seguir el mismo orden de apertura y cierre; la primera abierta cerrará la ultima y así sucesivamente
- Todas las sentencias terminan en **;** las clases, métodos, bucles no tienen que terminar en **;**
- Todo class en Java tiene que contener Métodos al menos el método **main** y Constructores, excepto en un programa tipo Applet que se sustituye por el método **init**
- Constructor: es un método especial y la característica principal es que posee el mismo nombre de la clase, otra característica es qu para utilizarlo hay que poner delante de el la palabra **new*** puede ser que una clase contenga varios métodos constructores.

## Tipos de datos primitivos en Java:
- ENTEROS que son números enteros que se dividen en:
	- INT : 4 bytes de espacio de almacenamiento. Desde -2,147,483,648 hasta 2,147,483,647
	- SHORT :  2 bytes de espacio de almacenamiento. Desde -32,768 hasta 32,767  
	- LONG :  8 bytes de espacio de almacenamiento y tiene que llevar el sufijo L
	- BYTE : 1 byte de espacio de almacenamiento. Desde -128 hasta 127
		(puede ser que un número tenga  todos los tipos de ENTEROS por ejemplo 35 que entra dentro de cada rango de cada tipo ENTERO)
- COMA FLOTANTE que son nuevos decimales  que se dividen en:
	- FLOAT : 4 bytes de espacio de almacenamiento. Aproximadamente 6 a 7 cifras decimales y tiene que llevar el sufijo F
	- DOUBLE : 8 bytes de espacio de almacenamiento. Aproximadamente 15 cifras decimales.
- CHAR : para representar caracteres y deberán de ir dentro de comillas simples ‘ ’ 
- BOOLEAN : true y false

## Tipos de clases en Java:
- Propia: estas clases con las que creamos nosotros 


> *tiene que contener siempre un método main.*

- Predefinidas: estas clases están predefinidas en un programa Java y cada una tiene sus propios métodos .Ejemplo: String, Math, Array, Thread ( hay muchas )
	
> *Existe en Java una biblioteca de Clases = API JAVA; en la que están todas las clases predefinidas.*
	
## Almacenamiento de información:

### Variables en Java:
- le damos un valor, que inicialíza la variable “nombre de la variable” = “valor”. 

Ejemplo:
 ````
 numero = 5;
````
- se puede hacer todo en una linea de código. 

Ejemplo: 
````
int numero = 5;
````
- se puede declarar varias variables en una misma linea. 

Ejemplo:
````
 int num1, num2, num3;
````
- se declara “tipo de dato” “nombre de la variable”.

Ejemplo:
````
int numero;
````
> *siempre tiene que acabar con “ ; “*

### Contantes en Java es te valor no podrá se modificado:
- se declara: final “tipo de  dato” “nombre de la constante”.

Ejemplo: 
````
final init numero = 5;
````
#### Tipos de constantes en Java,como el tipo de Clases en Java hay 2 tipos de constantes:
- Propias: estas constantes son las que definimos nosotros
- Predefinidas ó constantes de Class: son aquellas que acompañan a la clase predefinida y almacenan valores que no pueden ser modificados. 

### Arrays: 
Estructura de datos que contiene una coleccion de valores del mismo tipo, siven para almacenar valores.Digamos que es un grupo de variables del mismo tipo.

Al igual que las variables y constantes, podremos declararlas en una linea y despues en otra inicalizarla ó podemos hacer todo en una linea:

- Ejemplo de la sintaxis de declaración en una linea:
```
 int[] nameArray = new int[5]
```
En el ejemplo primero le decimos que tipo vamos a almacenar en ese array, acontinuacion el nombre del array y despues la instanciamos con el numero de elementos entre [ ] 

- Ejemplo de la sintaxis de iniciación en una linea: 
````
nameArray[0] = 15;
nameArray[1] = 25;
nameArray[2] = 1;
nameArray[3] = 14;
nameArray[4] = 8;
````

En el ejemplo de estamos diciendo entre los [ ] el indice al que le vamos a dar el valor.

- Ejemplo de hacerlo todo en una linea:
```
int[] nameArray = {15,25,1,14,8};
```

En el ejemplo de estamos dando un valor por orden del indice entre las { },

#### Array Bidimensional
Es una array dentro de otro array.

- Ejemplo de la sintaxis de declaración en una linea:
```
 int[][] nameArray = new int[2][2]
```
En el ejemplo primero le decimos que tipo vamos a almacenar en ese array y cuantas dimensiones va a tener, acontinuacion el nombre del array y despues la instanciamos con el numero de elementos que contiene cada dimension entre [ ] [ ]

- Ejemplo de la sintaxis de iniciación en una linea: 
````
array[0][0]= 1;
array[0][1]= 2;
		
array[1][0]= 1;
array[1][1]= 2;
````

En el ejemplo de estamos diciendo entre los [ ] [ ] los indice a los que le vamos a dar el valor.

- Ejemplo de hacerlo todo en una linea:
```
int[][] nameArray = { 
    {1,2},
    {1,2}
};
```

En el ejemplo de estamos dando un valor por orden del indice a cada dimension entre las { },

> *Cuando en consola nos da un error = “ Exeption ” es un error en el que todavía no se a compilado el código.*
		
## Operadores en Java que se dividen en:
- ARITMÉTICOS:
	- ( + - * / )
- LÓGICOS, RELACIONALES Y BOOLEANOS:
	- ( < > != == &&  ) para las comparaciones ”como en JS”
- INCREMENTOS Y DECREMENTO
	- ( ++  — ) incrementa o decreménta en 1 al valor que lo apliques
	- ( +=nº  -=nº ) incrementa o decreménta el valor asignado después del = 
- CONCATENACION
	- ( + ) concatena
- Otros cálculos numéricos:
	- Class Math: esta clase es predefinida y tiene muchos métodos como :
		- Math.sqrt(nº): calcula la raíz cuadrada del nº que le pasamos como parámetro.
		- Math.pow(base,expon): calcula la potencia de los parámetros que le pasamos, teniendo una base y un exponente.
		- Math.sin(ang), Math.cos(ang), Math.tan(ang), Math.atan(ang): para hacer operaciones de calculo con ángulos que le pasamos como parámetro.
		- Math.round(dec): para redondear un numero decimal.
		- Math.PI:  es un método que contiene una constante de clase.

> *para darle formato al resultado de un número con muchos decimales podemos hacerlo con el siguiente ejemplo: System.out.printf(“%1,2f”, num), en el método .printf() se le pasa como 1º argumento el formato y 2º el valor.*
	
## Refundiciones:
Una refundación consiste en convertir un tipo de dato en otro diferente.
 
Ejemplo:
 ````
 int raíz = (int)Math.round(num)
````
En este caso el método Math.round() devuelve un numero tipo LONG que queremos almacenar en una variable tipo INT y dará error, por lo que tendremos que realizar una Refundición, que  se hace añadiendo (int) justo antes del método Math.round() y así le decimos que convierta el tipo de dato que nos va a retornar el método a un tipo INT que es con el que hemos iniciado la variable.
	
## Manipulación de cadenas de caracteres:
- clase String “ no es un tipo primitivo ” : 

almacenar una cadena de caracteres en una variable Objeto .
	 
Ejemplo: 
````
String name = “Balta”; 
 ````
En este caso ya la variable Objeto name, será una instancia de la clase String.
     
- Class String tiene muchos métodos como:
	- length(): devuelve la longitud de la cadena
	- charAt(nº): te devuelve el valor del índex que le pasamos como parámetro
	- subsString(x,y): te devuelve la subcadena que hay entre los índex pasados como parámetros
	- equals(cadena):devuelve un booleano al comparar una cadena de caracteres con la cadena de caracteres pasada como parámetro
	- equalsIgnoreCase(cadena):es igual que equals() pero ignora las mayusculas y minúsculas
	
## Packages Java:
Podríamos decir que son carpetas que almacenan clases predefinidas.El paquete Java.lang es el paquete por defecto de Java. Por defecto podríamos utilizar las clases que contiene el paquete Java.lang en nuestra clase que estamos creando; si en algún caso queremos utilizar en otra clase que no este en este paquete la tendremos que importar fuera de la case que estamos creando. Ejem:  import java.util.*; En este caso estamos importando todas las clases del paquete java.util

> *METODO NO ESTÁTICO quiere decir que no hace falta poner el nombre a la clase que pertenece delante del propio método, pero tendríamos que utilizar un Objeto de la clase a la que pertenece el método*

> *METODO ESTÁTICO quiere decir que tienes que utilizar el nombre de la clase delante del metodo, pero no tendremos que instanciar la clase para utilizarlo. Ejemplo: JOptionPane.showInputDialog()*
	
## Entrada y salida de datos
#### entrada de datos con clases de paquetes de Java a nuestra clase: 
- clase Scanner que permite introducir datos por consola y para ello tiene varios métodos que no son estáticos como:
	- nextLine(): para introducir texto
	- nextInt(): para introducir números enteros
	- nextDouble(): para introducir números decimales
- clase JOptionPane que permite crear una ventana con un campo para introducir datos y 2 botones de aceptar y cancelar, esta clase contiene un método estático:
	- showInputDialog(): para añadir info en la ventana creada por la clase JOptionPane, tendremos que  pasarle el texto que queremos que aparezca en la ventana como parámetro en el método ósea dentro de los paréntesis ( )

> *System.in = es un método del objeto CONSOLA del sistema, pero para introducir información a nuestra clase, seria también un “File source”*

> *System.out = es un método del objeto CONSOLA del sistema, pero para sacar información a la consola y  imprimirlo en consola*

## Flujo de control 
Orden de la ejecución de un programa Java que siempre ira de arriba hacia abajo, para modificar el flujo=orden de ejecución existe 2 estructura:
#### Condicionales:
- if( condición ){ código }: 
    - ejecuta el código que hay entre { } si la condición que va entre ( ) devuelve un true, se puede acompañar con otra estructura else()
- switch( value a evaluar ) { Case1 valor : código; break ; } : 
    - ejecutara el código del caso que se de true, se puede acompañar con otra estructura default() 
#### Bucles Java; repetir una serie de código en el programa, hay 2 tipos:
- Bucles indeterminados; no se sabe la serie de repeticiones de código que hará sin ejecutar el programa y hay estos tipos:
  - While: se ejecutara el codigo de su interior si se cumple la condición
  - Do-while: la diferencia con While, es que se ejecutara por lo menos 1 vez antes de llegar a la condición, con lo que los condicionales iran dentro del DO.
- Bucles determinados; se sabe antes de ejecutarlo cuantas repeticiones de código hará y hay estos tipos:
  - For
  - For-each
  

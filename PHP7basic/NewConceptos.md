# Conceptos nuevos con PHP7 
En este documento añadí nuevos conceptos respecto a otros lenguajes aprendidos. 

## Índice
|Arrays                                     |Funciones                   |Declaraciones                              |Clases                                                     |Herencia                              |Cookie y Session
|-------------------------------------------|----------------------------|-------------------------------------------|-----------------------------------------------------------|--------------------------------------|---
|[Tipos](#tipos-de-arrays)                  |[Tipos](#tipos-de-funciones)|[Tipo escalar](#declaraciones-tipo-escalar)|[Niveles de acceso](#niveles-de-acceso)                    |[Heredar una clase](#heredar-un-clase)|[Cookie](#cookie)
|[foreach()](#foreach-iteración-de-un-array)|                            |                                           |[Getters y Setters](#getters-y-setters)                    |                                      |[Session](#session)
|                                           |                            |                                           |[Crear intancia](#crear-intancia)                          |                                      |
|                                           |                            |                                           |[Acceder a Static](#acceder-a-propiedades-y-métodos-static)|                                      |


---

## Arrays

### Tipos de arrays

#### Array asociativo
Este tipo de array contiene para cada valor una clave(key)
````
$arrAsoci = array(
    'name'     => 'Balta',
    'lastName' => 'Bueno',
    'age'      => 20
);
````
Podemos acceder al valor por la key
````
echo $arrIndex['name];
````

[Ir al indice](#índice)

### foreach(); Iteración de un array

Sintaxis básica: 
````
$arr = array(1,2,3,4);

foreach($arr as $value){
    echo $value;
}
````
Para modificar cada elemento del array, podemos utilizar la siguiente sintaxis:
````
$arr = array(1,2,3,4);

foreach($arr as &$value){
    $value = $value*2;
}
````
Para recorrer un array y acceder al indice de cada valor, podemos utilizar la siguiente sintaxis:
````
$arr = array(1,2,3,4);

foreach($arr as $key => $value){
    echo "$Key ... $value";
}
````
en este ejemplo la variable $key nos mostrara el índice de cada elemento y $value el valor.

[Ir al indice](#índice)

## Tipos de Funciones

### Funciones por referencia
En PHP podremos modificar el valor de una variable definida mediante una funcion sin un return; Tendremos que pasarle 
como parámetro la variable a modificar y añadir delante del parámetro el simbolo '&':
````
function resta(&$num){
    $num = 20 - $num;
}

$result = 5;

resta($result);
````  
Por lo que vemos en el ejemplo; $result es la varible que declaramos y pasamos como parámetro a la funcion resta(), por 
lo que de esta forma una vez que se ejecuta la funcion el valor de la variable $result cambiara su valor; en este caso a 15.

### Funciones variables
````
function saludo($saludo){
    echo "Soy la function variable $saludo";
}

$var = 'saludo';

echo $var('Hola); 
````
En el ejemplo, PHP buscará una function con el nombre del valor de la variable $var en este caso 'saludo' y ejecutara dicha 
function. Pero este tipo de funciones no podemos utilizarla con funciones internas de PHP.

[Ir al indice](#índice)

## Declaraciones

### Declaraciones tipo escalar
Con este tipo de declaraciones podemos forzar los tipo de parámetros que queremos en una funcion. Son de dos tipos: 

- coercitivo (por defecto) 
````
function sum(int $a, int $b){
    return $a + $b;
}

//Pimera llamada
echo sum(1,2);

//Segunda llamda
echo sum('1',2);
````
Como vemos en el ejemplo anterior la primera llama a la function sum() pasamos como parámetros 2 números tipo int que son 
los que recibimos como parámetros en la function sum() y coinciden con el tipo que queremos en dichos parámetros por lo 
que retornara int(3).

Ahora nos situamos en la segunda llamada y vemos que en este caso pasamos como primer parámetro un string, pero en este 
tipo(coercitivo) de declaraciones, PHP va a transformar nuestro primer parámetro string a number y retornara int(3). 

- estricto

    Para habilitar el modo estricto se debe colocar una simple directiva [declare()](https://www.php.net/manual/es/control-structures.declare.php) 
    al inicio del fichero.
````
declare(strict_types=1);

function res(int $a, int $b){
    return $a - $b;
}

//Pimera llamada
echo res(1,2);

//Segunda llamda
echo res('1',2);
````
Como podemos ver en el ejemplo anterior en la primera llamada pasamos los tipos de parámetros correcto por lo que nos 
retornara in(1), pero en el caso de la segunda llamada, pasamos como primer parámetro un string por lo que este  en caso
si que nos retornara un error, diciendo que el primer parámetro no es correcto; Por eso este tipo es llamado estricto. 

También en este tipo de declaración(estricto), podemos forzar el tipo de dato que retorna. Para ello, despúes de la 
declaración de la function pasamos (: int) que es el tipo de dato que queremos que nos retorne la function mul().  
````
declare(strict_types=1);

function mul($a, $b): int{
    return $a * $b;
}

//Pimera llamada
echo mul(1,2);

//Segunda llamda
echo mul(1.5,2);
````
Como podemos ver en el ejemplo anterior, en la primera llamada nos retornara int(2); mientras que en la segunda llamada 
nos retornara un error ya que el primer parámetro que pasamos a la function mul() es de tipo float.

[Ir al indice](#índice)

## Clases 

### Niveles de acceso
- public: Si declaramos en nuestra clase propiedades ó métodos con el prefijo ( public ), todas las demas clases tendra   
acceso a dichas propiedades ó métodos. Este es el nivel de protección mas bajo.

- private: Si declaramos en nuestra clase propiedades ó métodos con el prefijo ( private ), solo la misma clase tendra 
acceso a dichas propiedades ó métodos. Este es el nivel de protección mas alto.

- protected: Si declaramos en nuestra clase propiedades ó métodos con el prefijo ( protected ), utiliza la [herencia](#herencia);  
esto quiere decir, que solo tendran acceso las clases que hereden de esta clase( las clases hijo). 


[Ir al indice](#índice)

### Getters y Setters
Como ya sabemos estos métodos lo vamos a utilizar para módificar las propiedades creadas mediante el encapsulamiento; que 
te recuerdo que son las propiedades y métodos que le añadimos el prefijo (private).

#### Crear métodos
Podemos utilizar los métodos mágicos de PHP7 para crear los métodos get y set:

- get:
````
public function __get($propiedad)
{
    return $this->$propiedad; 
}
````

- set:  
````
public function __set($propiedad, $valor)
{
    $this->$propiedad = $valor;
}
````

#### Utilizar métodos mágicos get y set en la intancia
Te daras cuenta en el siguiente ejemplo por que se le llaman métodos mágicos. 

Vamos a acceder a una propiedad de la clase a través de la nueva intancia(en este caso persona), mediante el método mágico 
( __get ):
````
$persona->propiedad;
````
Vamos a asignar un valor a una propiedad de la clase a través de la nueva intancia(en este caso persona), mediante el método  
mágico ( __set ):
````
$persona->propiedad = valor;
````


[Ir al indice](#índice)

### Crear intancia
Para poder crear una intancia de una clase, antes tendremos que incluir el archivo que contiene dicha clase. Para ello 
tenemos varias formas:

- include: el archivo es incluido con base a la ruta que coloquemos acontinuación. Si no encuentra el archivo genera un 
error fatal y no seguira ejecutando.
- require: mismo funcionamiento que include, pero con la diferencia; que si no encuentra el archivo genera una advertencia 
y continua ejecutando.
- include_once: la diferencia de include y include_once; es que si el archivo esta incluido ya no lo volvera a incluir.
- require_once: la diferencia de require y require_once; es que si el archivo esta incluido ya no lo volvera a incluir.
````
require_once 'Clases/Persona.php';
````
**Por lo que se aconseja utilizar (require_once) que devolvera un error fatal en el caso de que no encuentre el archivo 
y también no incluira el archivo 2 veces.**

Entonces la intancia de una clase quedaría tal que así:
````
<?php

require_once 'Clases/Persona.php';

$otraPersona = new Persona();

//Acedemos a propiedades y métodos publicos de la clase Persona

?>
````
Como vemos en el ejemplo; antes de realizar la intancia, tendremos que incluir la clase.

[Ir al indice](#índice)

### Acceder a propiedades y métodos Static
Para poder acceder a métodos ó propiedades estaticos de la intancia(en este caso Persona). Podemos acceder de 2 maneras:

- a través de la instancia ó directamente de la clase:
````
<?php

require_once 'Clases/Persona.php';

$otraPersona = new Persona();

//mediante la intancia
$otraPersona::$propiedad;

//mediante la clase
Persona::$propiedad;

?>
````

[Ir al indice](#índice)

## Herencia
Como ya sabemos la herencia nos permite derivar una nueva clase apartir de una clase existente. La clase existente es 
conocida como: clase padre, super clase ó clase báse y la clase que deriva es conocida como clase hijo.

### Heredar una clase
Para poder heredar vamos a tener que añadir a nuestra clase el subfijo ( extends ) seguido del nombre de la clase a heredar
(clase padre) y de esta forma vamos a poder utilizar todas propiedades ó métodos de la clase padre(en este caso Persona) 
que hemos creado con los prefijos ( public y protected ). Pero tendremos que tener en cuenta; que poder hacer referencia 
a la clase padre(en este caso Persona) lo tendremos que hacer con la palabra clave ( parent:: ).
````
class Vendedor extends Persona{ 
 
    public function ejemplo()
    {
        $x = parent::metodoDelPadre();
    }

}
````

[Ir al indice](#índice)

## Cookie y Session

### Cookie
Son un tipo de variables que se utiliza para guardar información en el lado del cliente. Para crear una cookie se utiliza 
( setcookie(); ). Es importante saber que no es aconsejable guardar información delicada, ya que se guarda en el lado del 
cliente. 

- Crear un cookie: utilizamos el método ( setcookie(); ) y le pasamos como parámetros el nombre de la cookie, el valor y el 
timepo que tardará en expirar dicha cookie.
````
setcookie('nombreCookie', 'valorCokkie', time());
````

- Modificar un cookie: podemos modificar una cookie de con la misma sintaxis que la creamos y podriamos modificar dicha 
cookie después de que haya sido inicializada.
````
setcookie('nombreCookie', 'nuevoValorCokkie');
````
  
- Acceder a un cookie: podemos acceder a la cookie creada con la variable reservada ( $_COOKIE  )
````
$_COOKIE[''nombre_de_cookie]
````

- Eliminar un cookie: con el método ( unset(); ),añadiendo el cookie que queremos eliminar y el el método ( setcookie(); ) 
con los siguiente parámetros:
````
unset($_COOKIE['nombreCookie']);
setcookie('nombreCookie', null, -1);
````

[Ir al indice](#índice)

### Session
Son un tipo de variables que se utiliza para guardar información en el lado del servidor. Para inicializar una sesión se 
utiliza ( session_start(); ) en el archivo que queremos que utilice dicha session y así podremos crear, eliminar y modificar 
una sesión.

- Inicializar sesion:
````
session_start();
````
**Recuerda que para utilizar en un archivo una sesion debes inicializar con ( session_start(); )**

- Crear una sesión: se crea utilizando una variable reservada ( $_SESSION )
````
$_SESSION['nombreSesion'] = 'valor_de_sesion';
````
- Modificar una sesión: podemos modificar una sesión de con la misma sintaxis que la creamos y podriamos modificar dicha 
sessión después de que haya sido inicializada.
````
$_SESSION['nombreSesion'] = 'nuevo_valor_de_sesion';
````
- Eliminar una sesión: para borrar todas las sesiones que han sido inicializadas.
````
session_destroy();
````
Pero también podemos eliminar una sesión concreta, con el método ( unset(); ) y añadiendo la sesión que queremos eliminar:
````
unset($_SESSION['nombreSesion']);
````

Otra de las novedades de PHP7, es que podemos anular las [directivas de configuración de sesión](https://www.php.net/manual/es/session.configuration.php), 
establecidas en el archivo 
( php.init ) pasandole a la inicialización de la sesión ( session_start(); ) una matríz de opciones.
Ejemplo:
````
session_start(['name' => 'NOMBRE_SESSION']);
````
También podemos saber el estado de nuestra sesión con:
````
session_status(); 
````

[Ir al indice](#índice)

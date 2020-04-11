# Manejo de errores. Excepciones
Cuando ocurre un error durante la ejecución en un programa Java por detrás se esta creando un Objeto de tipo error.
Con el manejo de errores lo que podemos solventar es que si por ejemplo tenemos un programa con bastantes lineas de 
código y hay un error al principio, en cuanto se de el error no seguira avanzando el programa aunque el demas código
no tenga nada que ver con el error. Para que el programa siga su curso tendremos que manejar los errores.

### Tipos de errores. Excepciones
- Tiempo de compilación: Son los denominados errores de sintaxis. Denominado: Error en tiempo de compilación. Estos errores
los comete el programador.

- Tiempo de ejecución: Estos errores no son por errores de sintaxis, son errores que dependen de otros factores. Por ejemplo errores 
de lógica del programa. Este error ocurrira despues de compilar el programa. Denominado: Error en tiempo de ejecución una
vez que se genera el archivo Class.

Apartir de la clase "Throwable" es desde donde comienza la jerarquía de clases que maneja los errores, esto
quiere decir que todo Objeto error que se genera hereda de esta clase. 

En esta jerarquía despues de la clase "Throwable" hay 2 clases:
- Clase Error: Normalmente cuando un error hereda de esta clase el error sera de Hardware. Solamente podremos 
controlar el error para avisar al usuario de que a ocurrido dicho error.

- Clase Exception: Cuando un error hereda de esta clase si que podemos manejarlo de una forma mas profunda.
Por debajo de esta clase en la jerarquía de la herencia tenemos 2 tipos mas:
    - IOException: Los errores que heredan de esta clase son denominados (excepciones comprobadas). Estos errores
    no son culpa del programador y Java nos obliga a capturar este error con la estructura try{} catch(){}.
    - RuntimeException: Los errores que heredan de esta clase son denominados (excepciones no comprobadas). Estos
    errores son generalmente por culpa del programador y en este caso no estamos obligados a capturar el error.

### Lanzamiento de excepciones
#### Cláusula throws
Esta cláusula la vamos a utilizar en la declaración de un método para indicar que este método podria lanzar una Excepción.
Podemos utilizar la cláusula throws aunque a veces es de mala practica, por que si la Excepcion es no comprobada, podriamos 
refactorizar el código y solucionarlo. Ejemplo:
```
public static Example() throws IOException {
   
    < código >
}
try{

    Example();

}catch(IOException e){

        < aquí el código que se ejecutara si algo va mal y se ejecuta la Excepcion IOException >

}
```
En este ejemplo vamos a controlar la Excepcion en la estructura try() y catch(){}.Se ejecutara toda la clase Example()
que esta dentro del try{} si todo va bien y si en algun caso algo va mal, se ejecutara la cláusula throws que estara 
dentro del catch(){} generando un Objeto de tipo IOException que hemos renombrado como e, que en este caso es el mismo que 
hemos puesto acontinuacion de la cláusula throws, siempre tiene ser el mismo Objeto o algun tipo que este por encima de
la jerarquia de esta clase en este ejemplo podriamos capturar Excepcion en el parametro del catch(){}.

#### Excepcion comprobada
Para poder manejar de alguna forma un supuesto error en una clase creada, utilizamos la cláusula throws que nos creara 
un Objeto con el tipo de error especificado. Ejemplo de una Excepcion comprobada:
```
public static Example(File input) throws IOException{
    
    try{
        
        imagen.ImageIO.read(new File("src/excepciones/Exam.gif"));
    
    }catch(IOException e){
        
        System.out.println("La img no se encuentra")
    
    }
}
```
En este ejemplo estamos declarando que si la clase no va bien nos genere una Excepcion Objeto de la clase tipo IOException.
Para capturar estos errores que heredan de IOException y manejar estos errores, Java nos exige a utilizar la estructura,
try{} catch(){}.

En Try le decimos que queremos que se haga si todo va bien, y con el Catch le decimos lo que tiene que hacer si en algun
caso el Try va mal.
> Todos los errores que hereden del tipo IOException, Java te obliga a utilizar try{} y catch(){}

#### Cláusula throw "sin S"
Esta cláusula la vamos a utilizar en cualquier parte del código para lanzar y forzar de forma manual una Excepción.Una vez
creada esta excepción, el siguiente paso seria comprobar si esa excepción es o hereda de una clase tipo comprobada para 
entonces capturar el error con la estructura try{} catch(){} en la llamada del método.
Ejemplo:
```
//Declaración de la exepción
static void Example(String examp) throws IOException{
    
    if(examp<=3){
    
        throw new IOException();

    }else{

        System.out.println("Sigue adelante");

    }

}

//Captura de la excepción en la llamada del método
try{

Example(el_examp);

}catch(IOException e){

    System.out.println("El examp no es correcto");

}
```
En este ejemplo estamos utilizando también la cláusula Throws por que vamos a forzar un error en este método y acontinuación
estamos generando una nueva instancia de la Excepcion (IOException) que vamos a forzar con la cláusula Throw.
> Este seria un ejemplo para ver la sintaxis, la excepcion utilizada no tiene ninguna lógica en esta clase.

#### Cláusula finally
Esta cláusula la vamos a utilizar en los casos que tengamos que ejecutar un código dandonos igual si nuestra captura de
excepción a ido correctamente ó incorrectamente. Esto quiere decir que en algun caso capturando la excepcion se puede 
ejecutar lo que este en el try{} ó de lo contrario lo que haya en el catch(){}, pero ¿si queremos ejecutar código tanto
si a ido bien el try{} como si a ido mal?.En ese caso entra en acción la cláusula finally. Ejemplo:
```
public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    try{
    
        example = input.nextInt();
    
    }catch(){
        
        System.out.println("Ha ocurrido un error");
    
    }finally{
    
        input.close();
    
    }
}
```
> La cláusula finally siempre se ejecutara, ignorando todos los resultado de lo demas. 

### Creación de excepciones propias
Si en algun caso queremos lanzar una excepción en algun método y en algun caso en la API de Java no se contempla el tipo 
de excepción que queremos lanzar podemos crear una excepción propia.

Para ello vamos a tener que crear una clase con su nombre y le vamos a decir que herede de Exception. Acontinuación 
se recomienda que nuestra clase tenga 2 constructores, uno que pueda recibir parametros que sera un mensaje y el otro 
que no reciba parametros.Ejemplo:
````
class Longitud_examp_erronea extends Exception{

    public Longitud_examp_erronea(){};
    public Longitud_examp_erronea(String msj_error){

    super(msj_error);
    
    };
}
````
Y ahora podremos utilizar nuestra excepción propia en cualquier clase utilizando la cláusula throws seguido del nombre
de la clase de la excepcion y acontinuación generamos una nueva instancia de uno de los constructores de la clase de la
excepción. Por lo que en la instancia del contructor podemos pasarle como parametro el mensaje de la excepción. Ejemplo:
```
static void Example(String examp) throws Longitud_examp_erronea{
    
    if(examp<=3){
    
        throw new Longitud_examp_erronea("La longitud no es correcta");

    }else{

        System.out.println("La longitud es correcta");

    }

}
```
Por ultimo tendremos que tener encuenta de que tipo es la excepcion que hemos creado por si en algun caso hay que capturar
la excepción con try{} catch(){}.

**¡¡Recuerde!!** 
> Todos los errores que hereden del tipo IOException, Java te obliga a utilizar try{} y catch(){}

#### Captura de varias excepciones
En algun caso tendremos que capturar varias excepciones, para ello seria exactamente igual que capturar uno pero en este
caso en la estructura de try{} catch(){} podremos enlazar varios catch(){} capturando en el cada una de la excepciones.
Ejemplo:
````
//Captura de la excepción en la llamada del método
try{

Example();

}catch(ArithmeticException e){

    System.out.println("El examp no es una operacion valida" + e.getClass());

}catch(NumberFormatException e){
 
     System.out.println("El examp no es un numero correcto" + e.getMessage());
 
 }
````
> Podremos utilizar los métodos heredados, como por ejemplo; getClass(), getName(), getMessage. Para saber mas información
> sobre la excepción.

# POO Programación orientada a objetos

### Formas de programar 

- POP Programación orientada a procedimientos "más antiguos"

- POO Programación orientada a objetos "más modernos"

Los Objetos tienen un estado , un comportamiento y unas propiedades ó atributos.

> Ventajas programación orientada a objetos: 
> - Programas divididos en "trozos", "partes", "módulos", "clases" = **Modularización**
> - Muy reutilizable = **Herencia**
> - Si existe fallo en una línea de código, el programa sigue funcionando = **Tratamiento  de Excepciones**
> - Encapsulamiento 

Un programa creado en Java, es un grupo de clases unidas entre si de alguna forma para que funcionen como una unidad.

## Vocabulario de la POO

- Clase
- Objeto
- Ejemplar de clase. Instancia de clase. Ejemplarizar una clase. Instanciar una clase.
- Modularización
- Encapsulamiento / Encapsulación
- Herencia
- Polimorfismo

#### Clases y Objetos
- Clase: Una clase es un modelo donde se redacta las caracteristicas comunes de un grupo de objetos.

- Objeto: Es un ejemplar perteneciente a una clase. Un obejeto contiene propiedades ó atributos y comportamientos.

> Para acceder a una propiedad ó comportamiento (metodo) de un Objeto se hace con " . " 
> Ejemplos:
>
> propiedad = coche.color = "verde";
>
> metodo = coche.arranca();

Una Clase contiene un método constructor, es un método especial que se encarga de dar un estado inicial al Objeto.La caracteristica de este método es que siempre tiene que tener el mismo nombre que el de la Clase.

Ejemplo:
```
package poo;

public class Coche {

    int ruedas;
    int largo;
    int ancho;
    int peso;
    int motor;

// método Constructor //
    public Coche() {
        
        ruedas = 4 ;
        largo = 2000;
        ancho = 300;
        peso = 500;
        motor = 1600;

    }

}
```

#### Instanciar una clase ó Ejemplarizar una clase

Como crear una instancia de una clase existente, vamos a crearla en el ejemplo siguiendo con la clase creada en el ejemplo anterior.

Ejemplo: 
```
package poo;

public class UsoCoche {

    public static void main(String[] args) {

        Coche Renault = new Coche();


    }

}

```
En este ejemplo para crear la nueva intancia de la clase coche tendremos que hacer referencia al nombre de la clase, 
despues el nombre que le vamos a dar a la nueva intancia, utilizar acontinuación del = el operador " new " y por último 
hacer referencia al método contructor " Coche() "

#### Modularización

Dividir un programa en pequeños modulos (clases).Siempre en un programa hay una clase principal que es la clase que contiene
el método " main ", por que el programa siempre empezara a ejecutarse desde el método " main " hacia abajo.

#### Encapsulación

Las clases se comunican entre si con métodos, cuando varias clases estan comunicadas entre si, se debe utilizar la encapsulación.
La ecapsulación consiste en que cada clase tenga su propia funcionabilidad y no dependa de ninguna otra clase en dicha funcionabilidad.

Las propiedades Encapsuladas podríamos decir que son las propiedades que definimos en el método constructor de la clases no se podrán modificar en ninguna otra clase.

Para llevar acabo esta encapsulación tendremos que utilizar un modificador de acceso "private" a la propiedad que queremos encapsular.

Ejemplo: 
```
private int ruedas;
private int largo;
private int ancho;
private int peso;
private int motor;
```
Cuando encapsulamos cualquier propiedad no podremos ni modificar, ni acceder a ellas directamente de otra clase que no sea la 
constructora.Para poder acceder a ellas desde otra clase utilizaremos métodos.

Los métodos nos van a permitir que nuestras clases interactuen entre si, formado una unidad para que un programa funcione correctamente.

##### Getters y Setters

Para poder comunicar entre módulos(clases) y acceder a las propiedades que hemos encapsulador tendremos que utilizar los estos métodos.

- Getters o captadores:
    - Se encarga de propocionar el valor de una propiedad de un Objeto.
    - Siempre devuelve un valor y una caracteristica para saber que es un Getter es que siempre tiene que contener 
    un "return".
    - La sintaxis es la siguiente: 
````
public "tipo de dato a devolver" "nómbre del metodo"(){ código + return }

public String getRuedas() {
		
    return "Número de ruedas " + ruedas;
		
}
````

- Setters o definidores:
    - Se encarga de definir o modificar el valor de una propiedad de un Objeto.
    - Este método no devuelve un valor y una de las caracteristicas para saber que no devuelve un valor y por lo tanto es
    un Setter, es que siempre tiene que contener un "void".
    - La sintaxis es la siguiente:
````
public void "nómbre del método"(){ código }

public void setRuedas() {
		
    ruedas = 4;
	
}

````

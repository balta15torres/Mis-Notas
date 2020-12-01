# Introducción a MySQL

## ¿Que es MySQL?
MySQL es un interpretador de SQL, es un servidor de base de datos.

MySQL permite crear base de datos y tablas, insertar datos, modificarlos, eliminarlos, ordenarlos, hacer consultas y 
realizar muchas operaciones, etc., resumiendo: administrar bases de datos.

## ¿Que es el SQL?
SQL, Structure Query Language (Lenguaje de Consulta Estructurado) es un lenguaje de programacion para trabajar con base 
de datos relacionales como MySQL, Oracle, etc.

## ¿Que es una base de datos?
Una base de datos es un conjunto de tablas.

Una base de datos tiene un nombre con el cual accederemos a ella.

## ¿Que es una tabla en la data base?
Las tablas forman parte de una base de datos.

Una base de datos almacena sus datos en tablas.

Una tabla es una estructura de datos que organiza los datos en columnas y filas; cada columna es un campo (o atributo) y
 cada fila, un registro. La intersección de una columna con una fila, contiene un dato específico, un solo valor.

Cada registro contiene un dato por cada columna de la tabla.

Cada campo (columna) debe tener un nombre. El nombre del campo hace referencia a la información que almacenará.

Cada campo (columna) también debe definir el tipo de dato que almacenará.

## ¿Que es un registro?
Un registro es una fila de la tabla que contiene los datos propiamente dichos. Cada registro tiene un dato por cada columna.

## ¿Que es una clave primaria? 
Una clave primaria pueden ser simples(un solo campo) ó compuestas(varios campos) y identifica 1 solo registro (fila) en 
una tabla.

Para un valor del campo clave existe solamente 1 registro. Los valores no se repiten ni pueden ser [nulos](https://github.com/balta15torres/Mis-Notas/blob/master/MySQL/EstructuraTabla.md#valores-null-en-un-campo-columna).

Establecemos que un campo sea clave primaria(simple) al momento de creación de la tabla:
````
 create table usuarios (
  nombre varchar(20),
  clave varchar(10),
  primary key(nombre)
 );
````
En el caso de que ningún campo, por si solo cumpla con la condición para ser clave, es decir, debe identificar un solo 
registro y el valor no puede repetirse, debemos usar 2 campos; clave primaria(compuesta), así identificamos unívocamente 
cada registro.
````
create table vehiculos(
  marca char(6) not null,
  tipo char(4),
  horallegada time not null
  horasalida time,
  primary key(patente,horallegada)
 );                                                                                        
````          
Nombramos los campos que formarán parte de la clave separados por comas.Un campo que es parte de una clave primaria(compuesta) 
puede ser autoincrementable sólo si es el primer campo que compone la clave, si es secundario no se permite.                                                                              
 
Es posible eliminar un campo que es parte de una clave primaria, la clave queda con los campos restantes; siempre que no 
queden registros con clave repetida;

## ¿Que es una vista?
Una vista es una alternativa para mostrar datos de una o varias tablas. Una vista es como una tabla virtual que almacena 
una consulta.

Entonces, una vista almacena una consulta como un objeto para utilizarse posteriormente. Las tablas consultadas en una 
vista se llaman tablas base. En general, se puede dar un nombre a cualquier consulta y almacenarla como una vista.

Una vista suele llamarse también tabla virtual porque los resultados que retorna y la manera de referenciarlas es la misma que para una tabla.

## ¿Que son los procedimientos almacenados? 
 
Un procedimiento almacenado es un conjunto de instrucciones (comandos SQL) a las que se les da un nombre, que se almacena 
en el servidor. Permiten encapsular tareas repetitivas.

Un procedimiento almacenados puede hacer referencia a objetos (tablas, vistas etc.) que no existen al momento de crearlo. 
Los objetos deben existir cuando se ejecute el procedimiento almacenado.

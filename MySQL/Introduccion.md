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
Una clave primaria es un campo (o varios) que identifica 1 solo registro (fila) en una tabla.

Para un valor del campo clave existe solamente 1 registro. Los valores no se repiten ni pueden ser nulos.

Establecemos que un campo sea clave primaria al momento de creación de la tabla:
````
 create table usuarios (
  nombre varchar(20),
  clave varchar(10),
  primary key(nombre)
 );
````

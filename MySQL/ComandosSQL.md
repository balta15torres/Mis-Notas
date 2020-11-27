# Instrucciones para el servidor MySQL
<a name="top"></a>
## Índice de contenidos
|Base de datos                                     |Tablas                                                                                    |Modificar estructura tabla                                                |Registros                                                           |
|--------------------------------------------------|------------------------------------------------------------------------------------------|--------------------------------------------------------------------------|--------------------------------------------------------------------|
|[Mostrar(show)](#mostrar-base-de-datos-existentes)|[Mostrar tabla(show)](#mostrar-las-tablas-existentes-de-la-base-de-datos)                 |[Modificar estructura(alter table)](#modificar-la-estructura-de-una-tabla)|[Funciones de agrupamiento](#funciones-de-agrupamiento)             |
|[Crear(create)](#crear-una-base-de-datos)         |[Crear(create)](#crear-una-tabla)                                                         |[Agregar campo(alter table - add)](#agregar-nuevos-campos-alter-table---add))                                                                         |[Selecionar grupo(having)](#selecionar-grupo-registros-having)      |
|[Eliminar(drop)](#eliminar-una-base-de-datos)     |[Eliminar(drop)](#eliminar-una-tabla)                                                     |                                                                          |[Obviar duplicados(distinct)](#obviar-registros-duplicados-distinct)|
|                                                  |[Mostrar estructura(describe)](#mostrar-la-estructura-de-una-tabla)                       |   ||
|                                                  |[Agregar(insert)](#agregar-un-registro-a-la-tabla)                                        |   ||
|                                                  |[Reemplazar registro(replace)](#remplazar-registros-de-una-tabla)                         |   ||
|                                                  |[Mostrar registro(select)](#mostrar-registros-de-una-tabla)                               |   ||
|                                                  |[Mostrar registros aleatorios(rand())](#mostrar-registros-en-forma-aleatoria-de-una-tabla)|   ||
|                                                  |[Cláusula order by](#cláusula-order-by-del-select)                                        |   ||
|                                                  |[Eliminar registro(delete ó truncate)](#eliminar-registros-de-una-tabla)                  |   ||
|                                                  |[Modificar registros(update)](#modificar-registros-de-una-tabla)                          |   ||
|                                                  |[Alias](#alias)                                                                           |   ||
---
## Base de datos
### Mostrar base de datos existentes: 
```
show databases;
```

### Crear una base de datos:
```
create database nombre_db;
```

### Eliminar una base de datos:
```
drop database nombre_db;
```

## Tablas

### Mostrar las tablas existentes de la base de datos:
```
show tables;    
```
[Ir al indice](#top)

### Crear una tabla: 
Debemos resolver qué campos (columnas) tendrá y que tipo de datos almacenarán cada uno de ellos, es 
decir, su [estructura](https://github.com/balta15torres/Mis-Notas/blob/master/MySQL/EstructuraTabla.md). La tabla debe 
ser definida con un nombre que la identifique y con el cual accederemos a ella. Al ingresar los datos de cada registro 
debe tenerse en cuenta la cantidad y el orden de los campos.
```
create table nombre_tabla (
    nombre varchar(30),
    clave varchar(10)
);
```
[Ir al indice](#top)

### Eliminar una tabla:
```
drop table nombre_tabla;
```
Podemos pordemos especificar que elimine la tabla si existe:
```
drop table if exists nombre_tabla;
```
[Ir al indice](#top)

### Mostrar la estructura de una tabla:
```
describe nombre_tabla;
```
Muestra cada campo, su tipo, lo que ocupa en bytes y otros datos como la aceptación de valores nulos etc...

[Ir al indice](#top)

### Modificar la estructura de una tabla:
Para modificar la estructura de una tabla existente, usamos "alter table" y se puede usar para:

#### Agregar nuevos campos(alter table - add):
````
 alter table nombre_tabla add cantidad smallint unsigned not null;
````
Usamos "alter table" seguido del nombre de la tabla y "add" seguido del nombre del nuevo campo con su tipo y los modificadores.

Si intentamos agregar un campo con un nombre existente, aparece un mensaje de error indicando que el campo ya existe y la 
sentencia no se ejecuta.lo coloca al final, después de todos los campos existentes; podemos indicar su posición (luego de 
qué campo debe aparecer) con "after":
````
 alter table nombre_tabla add cantidad tinyint unsigned after autor;
````
#### Eliminar campos existentes(alter table - drop):
````
 alter table nombre_tabla drop editorial;
````
Usamos "alter table" junto con "drop" y el nombre del campo a eliminar. Si intentamos borrar un campo inexistente aparece 
un mensaje de error y la acción no se realiza.

Si se borra un campo de una tabla que es parte de un índice, también se borra el índice; pero sin ser el último campo. 
Es posible eliminar un campo que es clave primaria, por lo que hay que tener cuidado al eliminar un campo.

Podemos eliminar 2 campos en una misma sentencia:
````
 alter table nombre_tabla drop editorial, drop cantidad;
````

#### Modificar el tipo de dato de un campo(alter table - modify):
````
alter table nomre_tabla modify cantidad smallint unsigned;
````
Usamos "alter table" seguido del nombre de la tabla y "modify" seguido del nombre del nuevo campo con su tipo y los 
modificadores.

Hay que tener cuidado al alterar los tipos de los campos de una tabla que ya tiene registros cargados y dicha modificación 
puede afectar al valor del registro.Si intentamos definir "auto_increment" un campo que no es clave primaria, aparece un 
mensaje de error indicando que el campo debe ser clave primaria.

#### Modificar el nombre de un campo(alter table - change):
````
alter table nombre_tabla change nombre_actual nombre_nuevo decimal (5,2);
````
Usamos "alter table" seguido del nombre de la tabla y "change" seguido del nombre actual y el nombre nuevo con su tipo y 
los modificadores. En la misma sentencia, también podemos cambiar el tipo y sus modificadores.

#### Agregar o eliminar la clave primaria(alter table):
````
alter table nombre_tabla add primary key (nombre_campo);
````
Usamos "alter table" con "add primary key" y entre paréntesis el nombre del campo que será clave. Si existe ya una 
[clave primaria](https://github.com/balta15torres/Mis-Notas/blob/master/MySQL/Introduccion.md#que-es-una-clave-primaria), 
aparecerá un mensaje de error.

Para que un campo agregado como clave primaria sea autoincrementable, es necesario agregarlo como clave y luego redefinirlo 
con "modify" como "auto_increment". No se puede agregar una clave y al mismo tiempo definir el campo autoincrementable.
Si intentamos establecer como clave primaria un campo que tiene valores repetidos, aparece un mensaje de error y la 
operación no se realiza.

Para eliminar una clave primaria usamos:
````
 alter table libros drop primary key;
````
Con "alter table" y "drop primary key" eliminamos una clave primaria. Si queremos eliminar la clave primaria establecida 
en un campo "auto_increment"; Primero se debe modificar el campo quitándole el atributo "auto_increment" y luego se podrá 
eliminar la clave, de lo contrario aparece un mensaje de error. **(recuerde)** un campo con "auto_increment" atributo DEBE 
ser clave primaria. 
                                                                                                                                                                                                                                                                                                      
#### Agregar y eliminar índices(alter table - add index - drop index):
- Agregar índice:
````
alter table nombre_tabla add index nombre_índice (editorial);
````
Usamos "alter table" junto con "add index" seguido del nombre que le daremos al índice y entre paréntesis el nombre de 
el o los campos por los cuales se indexará.

Para índices comunes o únicos, si no colocamos nombre de índice, se coloca uno por defecto, como cuando los creamos junto 
con la tabla.

Para agregar un índice único multicampo, por los campos "titulo" y "editorial", usamos la siguiente sentencia:
````
 alter table nombre_tabla add unique index nombre_índice (titulo,editorial);
````
Usamos "alter table" junto con "add unique index" seguido del nombre que le daremos al índice y entre paréntesis el 
nombre de el o los campos por los cuales se indexará.

- Eliminar índice:
````
 alter table nombre_tabla drop index nombre_índice;
````
Usamos "alter table" y "drop index" seguido del nombre del índice a borrar.

#### Renombrar una tabla (alter table - rename - rename table):
````
alter table nombre_tabla rename nombre_nuevo;
````
Usamos "alter table" seguido del nombre actual, "rename" y el nuevo nombre.

También podemos cambiar el nombre a una tabla usando:
````
rename table amigos to contactos;
````
Si queremos intercambiar los nombres de dos tablas:
````
 rename table amigos to auxiliar, contactos to amigos, auxiliar to contactos;
````

### Agregar un registro a la tabla:                           
```
insert into nombre_tabla (nombre, clave) values ('Baltasar','Balta');
```
Es importante ingresar los valores en el mismo orden en que se nombran los campos.Los campos de cadenas de caracteres se
 colocan entre comillas simples.

[Ir al indice](#top)

### Remplazar registros de una tabla:
Para reemplaza un registro por otro empleamos "replace", , el registro existente se borra y se ingresa el nuevo, de esta 
manera no se duplica el valor único.
````
 replace into nombre_tabla values(23,'Java en 10 minutos','Mario Molina','Emece',25.5);
````
"replace" funciona como "insert" en los siguientes casos:

- si los datos ingresados no afectan al campo único, es decir no se ingresa valor para el campo indexado, aparece un 
mensaje indicando que se afectó un solo registro, el ingresado, que se guarda con valor de código 0.
     
- si el dato para el campo indexado que se ingresa no existe, aparece un mensaje indicando que se afectó solo una fila, 
no hubo reemplazo porque el código no existía antes de la nueva inserción.

- si la tabla no tiene indexación, como ninguna [clave primaria](https://github.com/balta15torres/Mis-Notas/blob/master/MySQL/Introduccion.md#que-es-una-clave-primaria) 
(ni [índice único](https://github.com/balta15torres/Mis-Notas/blob/master/MySQL/EstructuraTabla.md#unique)), podríamos 
ingresar varios registros con igual valor de campo, aparecería un mensaje indicando que se afectó 1 registro (el ingresado)
, no se reemplazó ninguno y ahora habría 2 valores de campo iguales.

[Ir al indice](#top)

### Mostrar registros de una tabla:
```
select nombre,clave from nombre_tabla;
```
Al comando select le indicamos los nombres de los campos a mostrar y el nombre de la tabla.

Con el asterisco (*) indicamos que seleccione todos los campos de la tabla que nombramos.
```
select * from nombre_tabla;
```
#### Cláusula where del select
Es opcional, con ella podemos recuperar algunos registros, sólo los que cumplan con ciertas condiciones indicadas con la 
cláusula "where".
```
select nombre, clave from nombre_tabla where nombre='Baltasar';
```
Para las condiciones se utilizan operadores relacionales([Operadores Relacionales](https://github.com/balta15torres/Mis-Notas/blob/master/MySQL/OperadoresCondicionales.md)).

#### Cláusula order by del select
Podemos ordenar el resultado de un "select" para que los registros se muestren ordenados por algún campo, para ello usamos la cláusula "order by".

Tenemos varias opciones en el ordenado:
- alfabéticamente: 
````
select codigo,titulo,autor,editorial,precio from libros order by titulo;
````
Aparecen los registros ordenados alfabéticamente por el campo especificado.

- orden del campo:  
````
select codigo,titulo,autor,editorial,precio from libros order by 5;
````
Podemos colocar el número de orden del campo por el que queremos que se ordene en lugar de su nombre. Por ejemplo, 
queremos el resultado del "select" ordenado por "precio":
 
- ordenar por varios campos:
````
select codigo,titulo,autor,editorial,precio from libros order by titulo, editorial;
````
 Incluso, podemos ordenar en distintos sentidos, por ejemplo, por "titulo" en sentido ascendente y "editorial" en sentido 
 descendente:
 ````
select codigo,titulo,autor,editorial,precio from libros order by titulo asc, editorial desc;
 ````
Debe aclararse al lado de cada campo, pues estas palabras claves afectan al campo inmediatamente anterior.
 
**¡¡Por defecto ordena de manera ascendente (de menor a mayor)!!**
- de mayor a menor:
````
select codigo,titulo,autor,editorial,precio from libros order by editorial desc;

````
Para ello agregamos la palabra clave "desc".

#### Cláusula limit del select
Para restringir los registros que se retornan en una consulta "select". Puede recibir 1 ó 2 argumentos numéricos enteros 
positivos; el primero indica el número del primer registro a retornar, el segundo, el número máximo de registros a retornar. 
El número de registro inicial es 0 (no 1).

Si el segundo argumento supera la cantidad de registros de la tabla, se limita hasta el último registro.
````
select * from libros limit 8;

select * from libros limit 5,4;
````
"limit" puede combinarse con más comandos, por ejemplo "delete" y a su vez con mas cláusulas por ejemplo "order by".
````
delete from libros order by precio limit 2;
````

[Ir al indice](#top)

### Mostrar registros en forma aleatoria de una tabla:
Para recuperar de una tabla registros aleatorios se puede utilizar la función "rand()" combinada con "order by" y "limit":
````
select * from libros order by rand() limit 5;
````

[Ir al indice](#top)

### Eliminar registros de una tabla:
````
delete from nombre_tabla;
````
La ejecución del comando indicado en la línea anterior borra TODOS los registros de la tabla.

Si queremos eliminar uno o varios registros debemos indicar cuál o cuáles, para ello utilizamos el comando "delete" 
junto con la clausula "where" con la cual establecemos la condición que deben cumplir los registros a borrar.
````
delete from nombre_tabla where nombre='Leonardo';
````
Para evitar borrados masivos por equivocación en MySQL hay una variable de configuración llamada SQL_SAFE_UPDATES que 
puede almacenar los valores 1 (activa) y 0 (desactiva). Cuando tiene el valor 1 no permite ejecutar comandos delete y se 
produce un error debido a que la variable 'SQL_SAFE_UPDATES' tiene el valor 1.

Para resolver este problema debemos encerrar todo el bloque donde ejecutamos los comandos delete cambiando el esta de la 
variable 'SQL_SAFE_UPDATES' ó que la clausula "where" se relacione a una [clave primaria](https://github.com/balta15torres/Mis-Notas/blob/master/MySQL/Introduccion.md#que-es-una-clave-primaria) :
````
set SQL_SAFE_UPDATES=0;

delete from nombre_tabla;

set SQL_SAFE_UPDATES=1;
````
Podemos saber el estado global de la variable 'SQL_SAFE_UPDATES' mediante la consulta:
````
select @@sql_safe_updates;
````
También podemos eliminar todos los registros de una tabla con "truncate table".
````
truncate table nombre_tabla;
````
La diferencia con "delete" es la velocidad, es más rápido "truncate table" ya que "delete" borra los registros uno a uno.
Otra diferencia es cuando la tabla tiene un campo "auto_increment", al borrar con "delete" y luego ingresar un registro, 
al cargarse el valor en el campo autoincrementable, continúa con la secuencia; si usamos "truncate table", al ingresar 
otra vez un registro, la secuencia del campo autoincrementable vuelve a iniciarse en 1.

[Ir al indice](#top)

### Modificar registros de una tabla:
Para modificar uno o varios datos de uno o varios registros utilizamos "update" (actualizar).
````
update nombre_tabla set clave='todosIguales';
````
Utilizamos "update" junto al nombre de la tabla y "set" junto con el campo a modificar y su nuevo valor.

El cambio afectará a todos los registros.Podemos modificar algunos registros, para ello debemos establecer condiciones 
de selección con "where".
````
update nombre_tabla set clave='esteDiferente' where nombre='Baltasar';
````
También se puede actualizar varios campos en una sola instrucción:
````
update nombre_tabla set nombre='Balta', clave='esteDiferente2' where nombre='Baltasar';
````
Igual al concepto de borrado cuando utilizamos el comando 'update' la varible 'SQL_SAFE_UPDATES' debe encontrarse con 
valor 1 (activa) ó ó que la clausula "where" se relacione a una [clave primaria](https://github.com/balta15torres/Mis-Notas/blob/master/MySQL/Introduccion.md#que-es-una-clave-primaria).

[Ir al indice](#top)

### Alias 
Un "alias" se usa como nombre de un campo o de una expresión o para referenciar una tabla cuando se utilizan más de una 
tabla. Los alias serán de suma importancia cuando rescate datos desde el lenguaje PHP.

Cuando usamos una [función de agrupamiento](#funciones-de-agrupamiento), la columna en la salida tiene como encabezado 
dicha funcion,para que el resultado sea más claro podemos utilizar un alias:
````
select count(*) as librosdeborges from libros where autor like '%Borges%';
````
La columna de la salida ahora tiene como encabezado el alias, lo que hace más comprensible el resultado.

Un alias puede tener hasta 255 caracteres, acepta todos los caracteres. La palabra clave "as" es opcional en algunos casos, 
pero es conveniente usarla. Si el alias consta de una sola cadena las comillas no son necesarias, pero si contiene más de 
una palabra, es necesario colocarla entre comillas.

Se pueden utilizar alias en las clásulas "group by", "order by", "having" (siempre y cuando el alias no tenga espacios en 
blanco), pero no está permitido utilizar alias de campos en las cláusulas "where".
````
select editorial, count(*) as cantidad from libros group by editorial having cantidad>2;
````

[Ir al indice](#top)

## Registros

### Funciones de agrupamiento
Existen en MySQL funciones que nos permiten contar registros, calcular sumas, promedios, obtener valores máximos y mínimos.
Estas funciones se denominan "funciones de agrupamiento" porque operan sobre conjuntos de registros, no con datos individuales.

También podemos utilizar esta función junto con la clausula "where" para una consulta más específica.

Tenga en cuenta que no debe haber espacio entre el nombre de la función y el paréntesis, porque puede confundirse con una 
referencia a una tabla o campo.

- count(): Nos permiten contar registros, cuenta la cantidad de registros de una tabla, incluyendo los que tienen valor nulo. 
````
select count(*) from libros;

select count(*) from libros where autor like '%Borges%';
````
"count(*)" retorna la cantidad de registros de una tabla (incluyendo los que tienen valor "null").

- sum(): Retorna la suma de los valores que contiene el campo especificado.
````
select sum(cantidad) from libros;

select sum(cantidad) from libros where editorial ='Planeta';
````

- max() y min(): Para averiguar el valor máximo o mínimo de un campo.
````
 select max(precio) from libros;

 select min(precio) from libros where autor like '%Rowling%';
````

- avg(): retorna el valor promedio de los valores del campo especificado.
````
select avg(precio) from libros where titulo like '%PHP%';
````

#### Clausula group by 
Para operar con datos individuales, podemos combinar las [funciones de agrupamiento](#funciones-de-agrupamiento) con la 
cláusula "group by", que agrupa registros para consultas detalladas.
````
select ciudad, count(*) from visitantes group by ciudad;
````

[Ir al indice](#top)

### Selecionar grupo registros (having)
Así como la cláusula ["where"](#cláusula-where-del-select) permite seleccionar (o rechazar) registros individuales; 
la cláusula "having" permite seleccionar (o rechazar) un grupo de registros.

Generalmente se usa la cláusula "having" con funciones de agrupamiento, esto no puede hacerlo la cláusula "where".
````
select editorial, count(*) from libros group by editorial having count(*)>2;
````
Se utiliza "having", seguido de la condición de búsqueda, para seleccionar ciertas filas retornadas por la cláusula "group by".

**No debemos confundir** la cláusula "where" que establece condiciones para la selección de registros de un "select" con la 
cláusula "having" que establece condiciones para la selección de registros de una salida "group by".

[Ir al indice](#top)

### Obviar registros duplicados (distinct)
Con la cláusula "distinct" se especifica que los registros con ciertos datos duplicados sean obviadas en el resultado. 
También podemos combinarla con "where" ó "group by".
````
select distinct autor from libros;

select distinct autor from libros where editorial='Planeta';

select editorial, count(distinct autor) from libros group by editorial;
````

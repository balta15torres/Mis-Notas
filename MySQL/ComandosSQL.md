# Instrucciones para el servidor MySQL
<a name="top"></a>
## Índice de contenidos
|Base de datos                                     |Tablas                                                                   |Registros                                                                     |
|--------------------------------------------------|-------------------------------------------------------------------------|--------------------------------------------------------------------|
|[Mostrar(show)](#mostrar-base-de-datos-existentes)|[Mostrar tabla(show)](#mostrar-las-tablas-existentes-de-la-base-de-datos)|[Funciones de agrupamiento](#funciones-de-agrupamiento)             |
|[Crear(create)](#crear-una-base-de-datos)         |[Crear(create)](#crear-una-tabla)                                        |[Selecionar grupo(having)](#selecionar-grupo-registros-having)     |
|[Eliminar(drop)](#eliminar-una-base-de-datos)     |[Eliminar(drop)](#eliminar-una-tabla)                                    |[Obviar duplicados(distinct)](#obviar-registros-duplicados-distinct)|
|                                                  |[Mostrar estructura(describe)](#mostrar-la-estructura-de-una-tabla)      ||
|                                                  |[Agregar(insert)](#agregar-un-registro-a-la-tabla)                       ||
|                                                  |[Mostrar registro(select)](#mostrar-registros-de-una-tabla)              ||
|                                                  |[Cláusula order by](#cláusula-order-by-del-select)                       ||
|                                                  |[Eliminar registro(delete ó truncate)](#eliminar-registros-de-una-tabla) ||
|                                                  |[Modificar registros(update)](#modificar-registros-de-una-tabla)         ||
|                                                  |[Alias](#alias)                                                          ||
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

### Agregar un registro a la tabla:                           
```
insert into nombre_tabla (nombre, clave) values ('Baltasar','Balta');
```
Es importante ingresar los valores en el mismo orden en que se nombran los campos.Los campos de cadenas de caracteres se
 colocan entre comillas simples.

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

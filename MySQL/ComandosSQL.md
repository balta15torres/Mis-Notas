# Instrucciones para el servidor MySQL
<a name="top"></a>
## Índice de contenidos
|Base de datos      |Tablas|
|-------------------|------|
|[Mostrar](#item1)  |[Mostrar tabla](#item4)|
|[Crear](#item2)    |[Crear](#item5)|
|[Eliminar](#item3) |[Eliminar](#item6)|
|                   |[Mostrar estructura](#item7)|
|                   |[Agregar](#item8)|
|                   |[Mostrar registro](#item9)|
|                   |[Eliminar registro](#item10)|
|                   |[Modificar registros](#item11)|
---
## Base de datos
<a name="item1"></a>
### Mostrar base de datos existentes: 
```
show databases;
```
<a name="item2"></a>
### Crear una base de datos:
```
create database nombre_db;
```
<a name="item3"></a>
### Eliminar una base de datos:
```
drop database nombre_db;
```

## Tablas
<a name="item4"></a>
### Mostrar las tablas existentes de la base de datos:
```
show tables;    
```
[Ir al indice](#top)
<a name="item5"></a>
### Crear una tabla: 
Debemos resolver qué campos (columnas) tendrá y que tipo de datos almacenarán cada uno de ellos, es 
decir, su estructura.La tabla debe ser definida con un nombre que la identifique y con el cual accederemos a ella.
Al ingresar los datos de cada registro debe tenerse en cuenta la cantidad y el orden de los campos.
```
create table nombre_tabla (
    nombre varchar(30),
    clave varchar(10)
);
```
[Ir al indice](#top)
<a name="item6"></a>
### Eliminar una tabla:
```
drop table nombre_tabla;
```
Podemos pordemos especificar que elimine la tabla si existe:
```
drop table if exists nombre_tabla;
```
[Ir al indice](#top)
<a name="item7"></a>
### Mostrar la estructura de una tabla:
```
describe nombre_tabla;
```
Muestra cada campo, su tipo, lo que ocupa en bytes y otros datos como la aceptación de valores nulos etc...

[Ir al indice](#top)
<a name="item8"></a>
### Agregar un registro a la tabla:                           
```
insert into nombre_tabla (nombre, clave) values ('Baltasar','Balta');
```
Es importante ingresar los valores en el mismo orden en que se nombran los campos.Los campos de cadenas de caracteres se
 colocan entre comillas simples.

[Ir al indice](#top)
 <a name="item9"></a>
### Mostrar registros de una tabla:
```
select nombre,clave from nombre_tabla;
```
Al comando select le indicamos los nombres de los campos a mostrar y el nombre de la tabla.

Con el asterisco (*) indicamos que seleccione todos los campos de la tabla que nombramos.
```
select * from nombre_tabla;
```
Existe una cláusula, "where" que es opcional, con ella podemos recuperar algunos registros, sólo los que cumplan con 
ciertas condiciones indicadas con la cláusula "where".
```
select nombre, clave from nombre_tabla where nombre='Baltasar';
```

Para las condiciones se utilizan operadores relacionales (Operadores Relacionales).

Para las condiciones se utilizan operadores relacionales([Operadores Relacionales](https://github.com/balta15torres/Mis-Notas/blob/master/MySQL/OperadoresRelacionales.md)).

[Ir al indice](#top)

<a name="item10"></a>
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
variable 'SQL_SAFE_UPDATES' ó que la clausula "where" se relacione a una [clave primaria](https://github.com/balta15torres/Mis-Notas/blob/master/MySQL/Introduccion.md#primaryKey) :
````
set SQL_SAFE_UPDATES=0;

delete from nombre_tabla;

set SQL_SAFE_UPDATES=1;
````
Podemos saber el estado global de la variable 'SQL_SAFE_UPDATES' mediante la consulta:
````
select @@sql_safe_updates;
````
[Ir al indice](#top)

<a name="item11"></a>
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
valor 1 (activa) ó ó que la clausula "where" se relacione a una [clave primaria](https://github.com/balta15torres/Mis-Notas/blob/master/MySQL/Introduccion.md#primaryKey).

[Ir al indice](#top)

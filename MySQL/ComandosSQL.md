# Instrucciones para el servidor MySQL

## Índice de contenidos
Base de datos
* [Mostrar](#item1)
* [Crear](#item2)
* [Borrar](#item3)

Tablas
* [Mostrar tabla](#item4)
* [Crear](#item5)
* [Eliminar](#item6)
* [Mostrar estructura](#item7)
* [Agregar](#item8)
* [Mostrar registro](#item9)

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
### Borrar una base de datos:
```
drop database nombre_db;
```

## Tablas
<a name="item4"></a>
### Mostrar las tablas existentes de la base de datos:
```
show tables;    
```

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

<a name="item6"></a>
### Eliminar una tabla:
```
drop table nombre_tabla;
```
Podemos pordemos especificar que elimine la tabla si existe:
```
drop table if exists nombre_tabla;
```
<a name="item7"></a>
### Mostrar la estructura de una tabla:
```
describe nombre_tabla;
```
Muestra cada campo, su tipo, lo que ocupa en bytes y otros datos como la aceptación de valores nulos etc...

<a name="item8"></a>
### Agregar un registro a la tabla:                           
```
insert into nombre_tabla (nombre, clave) values ('Baltasar','Balta');
```
Es importante ingresar los valores en el mismo orden en que se nombran los campos.Los campos de cadenas de caracteres se
 colocan entre comillas simples.

 <a name="item9"></a>
### Mostrar Registros de una tabla:
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


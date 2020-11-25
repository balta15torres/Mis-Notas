# Instrucciones para el servidor MySQL

## Base de datos
### Mostrar base de datos existentes: 
```
show databases;
```
### Crear una base de datos:
```
create database nombre_db;
```
### Borrar una base de datos:
```
drop database nombre_db;
```

## Tablas
### Mostrar las tablas existentes de la base de datos:
```
show tables;    
```
###Crear una tabla: 
Debemos resolver qué campos (columnas) tendrá y que tipo de datos almacenarán cada uno de ellos, es 
decir, su estructura.La tabla debe ser definida con un nombre que la identifique y con el cual accederemos a ella.
Al ingresar los datos de cada registro debe tenerse en cuenta la cantidad y el orden de los campos.
```
create table nombre_tabla (
    nombre varchar(30),
    clave varchar(10)
);
```
### Eliminar una tabla:
```
drop table nombre_tabla;
```
Podemos pordemos especificar que elimine la tabla si existe:
```
drop table if exists nombre_tabla;
```
### Mostrar la estructura de una tabla:
```
describe nombre_tabla;
```
Muestra cada campo, su tipo, lo que ocupa en bytes y otros datos como la aceptación de valores nulos etc...

### Agregar un registro a la tabla:                           
```
insert into nombre_tabla (nombre, clave) values ('Baltasar','Balta');
```
Es importante ingresar los valores en el mismo orden en que se nombran los campos.Los campos de cadenas de caracteres se
 colocan entre comillas simples.
 
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

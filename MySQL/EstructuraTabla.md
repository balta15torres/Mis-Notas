# Estructura de una tabla

Una tabla organiza los datos en columnas y filas; cada columna es un campo (o atributo) y cada fila, un registro. 

## Tipos de datos de un campo (columna)

### Tipo de dato Texto
Se usa para almacenar cadenas de caracteres. Una cadena es una secuencia de caracteres . Se coloca entre comillas (simples).
Determinamos el máximo de caracteres con el argumento "x" que va entre paréntesis.

Si la cadena ingresada es menor a la longitud definida, , almacena espacios en blanco a la derecha, tales espacios se 
eliminan al recuperarse el dato.Conveniente utilizar el tipo correcto ya que ocupara tantos bytes como se definen con el 
argumento "x".

Si asignamos una cadena de caracteres de mayor longitud que la permitida o definida, la cadena se corta.

Tenemos los siguientes tipos: varchar, char y text.

#### varchar(x): 
Su rango va de 1 a 65535 caracteres.

#### char(x):
Su rango es de 1 a 255 caracteres.

#### blob o text:
Su rango es de bloque de datos de 60000 caracteres de longitud aprox.

### Tipo de dato Numeros
Existe variedad de tipos numéricos para representar enteros, negativos, decimales. Determinamos el máximo con el argumento 
"x" que va entre paréntesis.

Antes de crear una tabla debemos pensar en sus campos y optar por el tipo de dato adecuado para cada uno de ellos.

Tenemos los siguientes tipos: integer, float y decimal.

#### integer(x) ó int(x): 
Se usa para guardar valores numéricos enteros, de -2000000000 a 2000000000 aprox.Un campo de tipo integer puede tener 
atributos extras 'auto_increment' y 'unsigned'. Este tipo támbien tiene [subtipos](#subtipos):
    
- auto_increment: se inician en 1 y se incrementan en 1 automáticamente.Sólo puede haber un campo "auto_increment" y 
debe ser [clave primaria](https://github.com/balta15torres/Mis-Notas/blob/master/MySQL/Introduccion.md#que-es-una-clave-primaria) 
(o estar indexado).
```
create table libros(
  codigo int auto_increment,
  titulo varchar(50),
  autor varchar(50),
  editorial varchar(25),
  primary key (codigo)
 );
```
Un campo "auto_increment" funciona correctamente sólo cuando contiene únicamente valores positivos.

- unsigned: permite sólo valores positivos.En los tipos enteros, "unsigned" duplica el rango, es decir, el tipo "integer" 
permite valores de -2000000000 a 2000000000 aprox., si se define "integer unsigned" el rango va de 0 a 4000000000 aprox.
```
create table niño(
  id int auto_increment,
  edad integer unsigned;
 );
```
También podriamos enlazar atributos extras.
```
create table libros(
  codigo int unsigned auto_increment,
  titulo varchar(50),
  autor varchar(50),
  editorial varchar(25),
  primary key (codigo)
 );
```
##### Subtipos:

- mediumint(x): Su rango es de –8000000 a 8000000 aprox. Con atributo 'unsigned' de 0 a 16000000 aprox.

- smallint(x): Su rango es de –30000 a 30000 aprox.Con atributo 'unsigned' de 0 a 60000 aprox.

- tinyint(x): define un valor entero pequeño, cuyo rango es de -128 a 127.Con atributo 'unsigned' de 0 a 255.

- bool o boolean: sinónimos de tinyint(1). Un valor cero se considera falso, los valores distintos de cero, verdadero.

- bigint(x): es un entero largo, cuyo rango es de –9000000000000000000 a 9000000000000000000 aprox.Con atributo 'unsigned' 
de 0 a 10000000000000000000.

#### float: 
Se usa para almacenar valores numéricos decimales. Se utiliza como separador el punto (.).
```
create table libros(
	titulo varchar(40),
	autor varchar(20),
	editorial varchar(15),
	precio float,
	cantidad integer
);
```

#### decimal(t,d) ó numeric(t,d):
Se usa para almacenar valores numéricos decimales.El primer argumento indica el total de dígitos y el segundo, la 
cantidad de decimales. El rango depende de los argumentos, también los bytes que ocupa.Si no se indica el valor del 
segundo argumento, por defecto es 0. 
````
create table libros(
  codigo int unsigned auto_increment,
  autor varchar(30),
  precio decimal(5,2),
  primary key (codigo)
 );
````
---
#### Tabla de espacio de almacenamiento para Tipo de dato Numeros
```
Tipo		Bytes de almacenamiento
_______________________________________
tinyint		1
smallint	2
mediumint	3
int		4
bigint		8

float		4
decimal(t,d)	t+2 si d>0, t+1 si d=0 y d+2 si t<d 
```
### Tipo de dato Fechas y horas
Para guardar fechas y horas dispone de varios tipos: date (fecha), datetime (fecha y hora), time (hora), year (año) y timestamp.

### Otros tipos de datos:
enum y set representan una enumeración y un conjunto respectivamente.

### Tipo de dato null 
En una tabla la columna "Null" especifica si el campo permite valores nulos;
````
create table libros(
  codigo int auto_increment,
  titulo varchar(50) not null
  autor varchar(50),
  editorial varchar(25),
  precio float,
  primary key (codigo)
 );
````

Los campos establecidos como [clave primaria](https://github.com/balta15torres/Mis-Notas/blob/master/MySQL/Introduccion.md#que-es-una-clave-primaria) 
no aceptan valores nulos. 

Para que un campo no permita valores nulos debemos especificarlo luego de definir el campo, agregando "not null". Por 
defecto, los campos permiten valores nulos.Para recuperar los registros que contengan el valor "null" en el campo no 
podemos utilizar los [Operadores Relacionales](https://github.com/balta15torres/Mis-Notas/blob/master/MySQL/OperadoresRelacionales.md), 
utilizar los operadores "is null" (es igual a null) y "is not null" (no es null):
````
select * from libros where precio is null;
select * from libros where precio is not null;
````




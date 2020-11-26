# Estructura de una tabla

Una tabla organiza los datos en columnas y filas; cada columna es un campo (o atributo) y cada fila, un registro. 

<a name="top"></a>
## Índice de contenidos
|Tipo de dato Texto         |Tipo de dato Numeros                       |Tipo de dato Fechas y horas                       |Otros tipos de datos                |Tipo de dato null|
|---------------------------|-------------------------------------------|--------------------------------------------------|------------------------------------|--------------------------|
|[varchar](#varcharx)       |[integer ó int](#integerx-ó-intx)          |[date](#date)                                     |[otros datos](#otros-tipos-de-datos)|[null](#tipo-de-dato-null)|
|[char](#charx)             |[Subtipos integer](#subtipos)              |[datetime](#datetime)                             |                                    |                          |
|[blob o text](#blob-o-text)|[float](#float)                            |[time](#time)                                     |                                    |                          |
|                           |[decimal ó numeric](#decimaltd-ó-numerictd)|[year](#year2-y-year4)                            |                                    |                          |

|Valores por defecto                                        |Valores inválidos                                  |
|-----------------------------------------------------------|---------------------------------------------------|
|[por defecto](#valores-por-defecto-en-un-campo-columna)    |[inválidos](#valores-inválidos-en-un-campo-columna)|
|[atributo default](#atributo-default-en-un-campo-columna)  |                                                   |
|[atributo zerofill](#atributo-zerofill-en-un-campo-columna)|                                                  |

|Calculos en columna                      |
|-----------------------------------------|
|[calculos](#calculos-en-un-campo-columna)|

---

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

[Ir al indice](#índice-de-contenidos)
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
[Ir al indice](#índice-de-contenidos)

##### Subtipos:

- mediumint(x): Su rango es de –8000000 a 8000000 aprox. Con atributo 'unsigned' de 0 a 16000000 aprox.

- smallint(x): Su rango es de –30000 a 30000 aprox.Con atributo 'unsigned' de 0 a 60000 aprox.

- tinyint(x): define un valor entero pequeño, cuyo rango es de -128 a 127.Con atributo 'unsigned' de 0 a 255.

- bool o boolean: sinónimos de tinyint(1). Un valor cero se considera falso, los valores distintos de cero, verdadero.

- bigint(x): es un entero largo, cuyo rango es de –9000000000000000000 a 9000000000000000000 aprox.Con atributo 'unsigned' 
de 0 a 10000000000000000000.

[Ir al indice](#índice-de-contenidos)

---
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
[Ir al indice](#índice-de-contenidos)

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
[Ir al indice](#índice-de-contenidos)

### Tipo de dato Fechas y horas
Para guardar fechas y horas dispone de varios tipos: date (fecha), datetime (fecha y hora), time (hora), year (año) y 
timestamp.Es importante elegir el tipo de dato adecuado según el caso, el más preciso.

#### date: 
Representa una fecha con formato "YYYY-MM-DD". El rango va de "1000-01-01" a "9999-12-31".

#### datetime: 
Almacena fecha y hora, su formato es "YYYY-MM-DD HH:MM:SS". El rango es de "1000-01-01 00:00:00" a "9999-12-31 23:59:59".

#### time: 
Una hora. Su formato es "HH:MM:SS". El rango va de "-838:59:59" a "838:59:59".

#### year(2) y year(4): 
Un año. Su formato es "YYYY" o "YY". Permite valores desde 1901 a 2155 (en formato de 4 dígitos) y desde 1970 a 2069 (en formato de 2 dígitos).

---
#### Tabla de espacio de almacenamiento para Tipos de datos Fechas y horas
```
Tipo		Bytes de almacenamiento
_______________________________________
date		3
datetime	8
time		3
year		1
```
[Ir al indice](#índice-de-contenidos)

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
podemos utilizar los [Operadores Relacionales](https://github.com/balta15torres/Mis-Notas/blob/master/MySQL/OperadoresCondicionales.md), 
utilizar los operadores "is null" (es igual a null) y "is not null" (no es null):
````
select * from libros where precio is null;
select * from libros where precio is not null;
````
[Ir al indice](#índice-de-contenidos)

## Valores por defecto en un campo (columna)
Un valor por defecto se inserta cuando no está presente al ingresar un registro y en algunos casos en que el dato 
ingresado es inválido que lo veremos en el siguiente punto([valores inválidos](#valores-inválidos-en-un-campo-columna)).

Para campos de cualquier tipo no declarados "not null" el valor por defecto es "null" (excepto para tipos "timestamp").

Para campos declarados "not null", el valor por defecto depende del tipo de dato.Aquí una tabla con los valores por 
defecto para cada tipo segun este caso:
````
Tipo				Valor por defecto		   Cláusula "default"
_____________________________________________________________________________________
caracter not null		cadena vacía			   permite
numerico not null		0				   permite
fecha not null			0000-00-00			   permite
hora not null			00:00:00			   permite
auto_increment			siguiente de la sec., empieza en 1 no permite
carac.,numer.,fecha,hora null	null				   permite
````

En la última versión de MySQL 8.0.x cuando declaramos un campo con la restricción not null luego debemos ingresar el dato 
en el insert, en caso contrario genera un error. Podemos solucionar este problema cambiando la variable 'sql_mode':
````
SET sql_mode = '';
````

### Atributo default en un campo (columna)
Podemos establecer valores por defecto para los campos cuando creamos la tabla, esta es una muy buena decisión para evitar 
incompatibilidades entre distintas versiones de MySQL. Para ello utilizamos "default" al definir el campo.

Al definir el campo explicitamos un valor mediante la cláusula "default", ése será el valor por defecto; sino insertará 
el valor por defecto implícito según el tipo de dato del campo.
````
 create table libros(
  codigo int unsigned auto_increment,
  titulo varchar(40) not null,
  autor varchar(30) default 'Desconocido', 
  precio decimal(5,2) unsigned default 1.11,
  cantidad int unsigned not null,
  primary key (codigo)
 );
````
Los campos definidos "auto_increment" no pueden explicitar un valor con "default", tampoco los de tipo "blob" y "text".

También se puede utilizar "default" para dar el valor por defecto a los campos en sentencias "insert".
````
 insert into libros (titulo,autor,precio,cantidad) values ('El gato con botas',default,default,100);
````
[Ir al indice](#índice-de-contenidos)

### Atributo zerofill en un campo (columna)
Cualquier campo numérico puede tener otro atributo extra "zerofill" y este atributo rellena con ceros los espacios 
disponibles a la izquierda.

Al ingresar un valor con menos cifras que el argumento especificado en el tipo de campo, aparecerán ceros a la izquierda 
rellenando los espacios; por ejemplo, si ingresamos int(33), aparecerá "000033". 
````
create table libros(
  codigo int(6) zerofill auto_increment,
  titulo varchar(40) not null,
  autor varchar(30),
  editorial varchar(15),
  precio decimal(5,2) unsigned,
  cantidad smallint zerofill,
  primary key (codigo)
 );
````
Si especificamos "zerofill" a un campo numérico, se coloca automáticamente el atributo "unsigned".Por lo que cualquier 
valor negativo ingresado en un campo definido "zerofill" es un valor inválido.

[Ir al indice](#índice-de-contenidos)

## Valores inválidos en un campo (columna)
Un valor es inválido por tener un tipo de dato incorrecto para el campo o por estar fuera de rango.

Veamos los distintos tipos de datos inválidos.

**Tipo caracter:**
- valor numérico: si en un campo definido de tipo caracter ingresamos un valor numérico, lo convierte automáticamente a cadena. 
- mayor longitud: si intentamos guardar una cadena de caracteres mayor a la longitud definida, la cadena se corta guardando 
sólo la cantidad de caracteres que quepa.

**Tipo numéricos:**
- cadenas: si en un campo numérico ingresamos una cadena, lo pasa por alto y coloca 0.
- valores fuera de rango: si en un campo numérico intentamos guardar un valor fuera de rango, se almacena el valor límite 
del rango más cercano (menor o mayor).
- valores incorrectos: si cargamos en un campo definido de tipo decimal un valor con más decimales que los permitidos en 
la definición, el valor es redondeado al más cercano.

**Tipos definidos auto_increment**
- Pasa por alto los valores fuera del rango, 0 en caso de no ser "unsigned" y todos los menores a 1 en caso de ser "unsigned".
- Si ingresamos un valor fuera de rango continúa la secuencia.
- Si ingresamos un valor existente, aparece un mensaje de error indicando que el valor ya existe.

**Tipos fecha y hora**
- valores incorrectos: si intentamos almacenar un valor que MySql no reconoce como:
    - de tipo fecha: (sea fuera de rango o un valor inválido), convierte el valor en ceros (según el tipo y formato).
    - de tipo date: se almacena '0000-00-00'.
    - de tipo datetime: se almacena '0000-00-00 00:00:00'.
    - de tipo time: se guarda ceros y si intentamos cargar un valor fuera de rango, se guarda el menor o mayor valor 
    permitido (según sea uno u otro el más cercano).

Aquí una tabla con los valores inválidos en cada tipo segun los casos mencionados anteriormente:
````
Tipo					Valor inválido				Resultado
__________________________________________________________________________________________
caracter null/ not null			123					'123'
caracter null/ not null			mayor longitud				se corta
caracter not null			null					error
numérico null/ not null			'123'					0
numérico null/ not null			fuera de rango				límite más cercano
numérico not null			null					error
numérico decimal null/ not null		más decimales que los definidos		redondea al más cercano
num. auto_incr. c/signo null/not null	0					siguiente de la secuencia
num. auto_incr. s/signo	null/not null	todos los menores a 1			siguiente de la secuencia
num. auto_incr. c/s signo null		null					siguiente de la secuencia
num. auto_incr. c/s signo null/not null	valor existente				error
fecha					fuera de rango				0000-00-00
fecha					'20-07-2006' (otro orden)		0000-00-00
hora					fuera de rango				límite más cercano
fecha y hora not null			null					error
````

[Ir al indice](#índice-de-contenidos)

## Calculos en un campo (columna)
Es posible obtener salidas en las cuales una columna sea el resultado de un cálculo y no un campo de una tabla.

Tendremos que añadir la operación en la sentencia y MySQL realiza el cálculo y lo incluye en una columna extra en la 
salida.Esta columna extra no se guarda en la tabla será provisional.
````
 select titulo, precio,cantidad,precio*cantidad from libros;
````
También podemos enlazar operaciones en la sentencia.
````
 select titulo, precio,precio*0.1,precio-(precio*0.1) from libros;
````

[Ir al indice](#índice-de-contenidos)

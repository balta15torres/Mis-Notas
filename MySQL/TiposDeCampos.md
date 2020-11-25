# Tipos de datos básicos de un campo (columna)
<a name="tipoCampos"></a>
- varchar: se usa para almacenar cadenas de caracteres. Una cadena es una secuencia de caracteres. Se coloca entre 
comillas (simples).El tipo "varchar" define una cadena de longitud variable en la cual determinamos el máximo de 
caracteres. Puede guardar hasta 65535 caracteres.
- integer: se usa para guardar valores numéricos enteros, de -2000000000 a 2000000000 aprox.
- float: se usa para almacenar valores numéricos decimales. Se utiliza como separador el punto (.).
Antes de crear una tabla debemos pensar en sus campos y optar por el tipo de dato adecuado para cada uno de ellos.

Ejemplo:
```
create table libros(
	titulo varchar(40),
	autor varchar(20),
	editorial varchar(15),
	precio float,
	cantidad integer
);
```

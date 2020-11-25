# Operadores Relacionales

Los operadores relacionales vinculan un campo con un valor para que MySQL compare cada registro (el campo especificado) 
con el valor dado.

## Los operadores relacionales son los siguientes:
- =	igual
- <> distinto
- \> mayor
- <	menor
- \>= mayor o igual
- <= menor o igual

Ejemplo:
```
select titulo,autor,editorial,precio from libros where precio<=30;
```

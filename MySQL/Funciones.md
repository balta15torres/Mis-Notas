# Manejo de datos con funciones 
**RECUERDE** que NO debe haber espacios entre un nombre de función y los paréntesis porque MySQL puede confundir una llamada 
a una función con una referencia a una tabla o campo que tenga el mismo nombre de una función.

## Funciones para el manejo de cadenas
MySQL tiene algunas funciones para trabajar con cadenas de caracteres.

Dejo el link de la lista de funciones en la 
[Documentación oficial de MySQL](https://dev.mysql.com/doc/refman/8.0/en/string-functions.html)  

## Funciones matemáticas
Los operadores aritméticos son "+","-","*" y "/". Todas las operaciones matemáticas retornan "null" en caso de error.
MySQL tiene algunas funciones para trabajar con números. Aquí presentamos algunas.

Dejo el link de la lista de funciones en la 
[Documentación oficial de MySQL](https://dev.mysql.com/doc/refman/8.0/en/mathematical-functions.html)  

## Funciones para el uso de fecha y hora
MySQL tiene algunas funciones para trabajar con fechas y horas.

Dejo el link de la lista de funciones en la 
[Documentación oficial de MySQL](https://dev.mysql.com/doc/refman/8.0/en/date-and-time-functions.html)  

## Funciones de control de flujo

### if
Es una función a la cual se le envían 3 argumentos: el segundo y tercer argumento corresponden a los valores que retornará 
en caso que el primer argumento (una expresión de comparación) sea "verdadero" o "falso"; es decir, si el primer argumento 
es verdadero, retorna el segundo argumento, sino retorna el tercero.
````
select titulo,
  if (precio>50,'caro','economico')
  from libros;
````

### case
Similar a la función "if", sólo que se pueden establecer varias condiciones a cumplir y toma valores puntuales, no expresiones.
````
 select editorial,
  case count(*)
   when 1 then 1
   when 2 then 2
   when 3 then 3
  else 'Más de 3' end as 'cantidad'
  from libros
  group by editorial
  order by cantidad;
````
Por cada valor hay un "when" y un "then"; si encuentra un valor coincidente en algún "when" ejecuta el "then" correspondiente 
a ese "when", si no encuentra ninguna coincidencia, se ejecuta el "else", si no hay parte "else" retorna "null". Finalmente 
se coloca "end" para indicar que el "case" ha finalizado.

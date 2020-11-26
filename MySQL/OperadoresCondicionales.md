## Operadores Condicionales

## Operadores Lógicos
Los operadores lógicos se usan para combinar condiciones.

Son los siguientes:

- and, significa "y",
- or, significa "y/o",
- xor, significa "o",
- not, significa "no", invierte el resultado
- (), paréntesis
````
 select * from libros
  where (autor='Borges') and
  (precio<=20);
````

## Operadores Relacionales
Los operadores relacionales vinculan un campo con un valor para que MySQL compare cada registro (el campo especificado) 
con el valor dado.

Son los siguientes:
- =	igual
- <> distinto
- \> mayor
- <	menor
- \>= mayor o igual
- <= menor o igual
```
select titulo,autor,editorial,precio from libros where precio<=30;
```
Existen otros que simplifican algunas consultas:
- between: significa "entre". Averiguamos si el valor de un campo dado está entre los valores mínimo y máximo especificados.
 ````
where precio>=20 and precio<=40;
 ````
Este caso es igual que este otro:
````
select * from libros where precio>=20 and precio<=40;
````

- in: Con "in" averiguamos si el valor de un campo dado está incluido en la lista de valores especificada.
````           
select * from libros where autor in('Borges','Paenza');
````           
Este caso es igual que este otro:
````
select * from libros where autor='Borges' or autor='Paenza';
````
Tambien con "in" averiguamos si el valor del campo está incluido en la lista, con "not" antecediendo la condición, 
invertimos el resultado.
````
select * from libros where autor not in ('Borges','Paenza');
````
Este caso es igual que este otro:
````
select * from libros where autor<>'Borges' and autor<>'Paenza';
````

## Operadores para cadenas de caracteres  
Los operadores relacionales nos permiten comparar valores numéricos y cadenas de caracteres. Pero al realizar la comparación 
de cadenas, busca coincidencias de cadenas completas.

Esto sucede porque el operador "=" (igual), también el operador "<>" (distinto) comparan cadenas de caracteres completas.
 
Para comparar porciones de cadenas utilizamos los operadores "like" y "not lik:
````
select * from libros where autor like "%Borges%";
````
El símbolo "%" (porcentaje) reemplaza cualquier cantidad de caracteres (incluyendo ningún caracter). Es un caracter comodín. 
"like" y "not like" son operadores de comparación que señalan igualdad o diferencia.

Para indicar que la busqueda empiece por un valor determinado quitando el signo % al principio:
````
 select * from libros where titulo like 'A%';
````
Para indicar que la busqueda no empiece por un valor determinado:
````
select * from libros where titulo not like 'A%';
````

Así como "%" reemplaza cualquier cantidad de caracteres, el guión bajo "_" reemplaza solo un caracter.
````
 select * from libros where autor like "%Carrol_";
````

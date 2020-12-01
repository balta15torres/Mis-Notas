# Procedimientos almacenados

## Índice de contenidos
|Procedimientos almacenados
|---------
|[Crear - Ejecutar](#procedimientos-almacenados-crear---ejecutar)
|[Cláusula 'delimiter'](#cláusula-delimiter)
|[Operadores para cadenas de caracteres](#operadores-para-cadenas-de-caracteres)

---

Definicion de [Procedimientos almacenados](https://github.com/balta15torres/Mis-Notas/blob/master/MySQL/Introduccion.md#que-son-los-procedimientos-almacenados)

**Ventajas**

Comparten la lógica de la aplicación con las otras aplicaciones, con lo cual el acceso y las modificaciones de los datos 
se hacen en un solo sitio.

- Permiten realizar todas las operaciones que los usuarios necesitan evitando que tengan acceso directo a las tablas.

- Reducen el tráfico de red; en vez de enviar muchas instrucciones, los usuarios realizan operaciones enviando una única 
instrucción, lo cual disminuye el número de solicitudes entre el cliente y el servidor.

**Desventajas**

- Las instrucciones que podemos utilizar dentro de un procedimiento almacenado no están preparadas para implementar lógicas 
de negocios muy complejas.

- Son difíciles de depurar.

Conociendo las ventajas y desventajas de los procedimientos almacenados debemos identificar los casos donde nos pueden 
facilitar la implementación de nuestras aplicaciones.

## Procedimientos almacenados (crear - ejecutar)
Se crean en la base de datos seleccionada.
 
En primer lugar se deben tipear y probar las instrucciones que se incluyen en el procedimiento almacenado, luego, si se 
obtiene el resultado esperado, se crea el procedimiento.

Los procedimientos almacenados pueden hacer referencia a tablas, vistas, otros procedimientos almacenados y pueden incluir 
cualquier cantidad y tipo de instrucciones.

La sintaxis básica parcial es:
````
create procedure NOMBREPROCEDIMIENTO()
begin
 INSTRUCCIONES;
end
````
Para crear un procedimiento almacenado empleamos la instrucción "create procedure".

Para llamar luego al procedimiento almacenado debemos utilizar la cláusula 'call' y seguidamente el nombre del procedimiento almacenado:
````
 call NOMBREPROCEDIMIENTO();
````

### Cláusula 'delimiter'
Como un procedimiento almacenado puede tener muchos comandos SQL entre las palabras claves 'begin' y 'end' debemos informar 
de alguna manera a MySQL que no ejecute dichos comandos. Para ello utilizamos el comando 'delimiter' cambiando el caracter 
';' como fin de instrucción. Luego debemos codificar el procedimiento almacenado cambiando el delimitador con la siguiente 
sintaxis:
````
 delimiter //
 create procedure pa_libros_limite_stock()
 begin
   select * from libros
   where stock<=10;
 end //
 delimiter ;
 
 call pa_libros_limite_stock();
````
Utilizamos el deliminador '//' como podría ser cualquier otro.


[Ir al indice](#índice-de-contenidos)

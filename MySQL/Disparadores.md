# Disparadores (trigger)
Es un bloque de algoritmo que se ejecuta cuando se intenta modificar los datos de una tabla y se definen para una tabla 
específica. Se crean para conservar la integridad referencial y la coherencia entre los datos entre distintas tablas.

Si se intenta modificar (agregar, actualizar o eliminar) datos de una tabla en la que se definió un disparador para alguna 
de estas acciones (insert, update o delete), el disparador se ejecuta (se dispara) en forma automática.

La sintaxis básica:
````
create trigger nombre-del-trigger
  [before / after] [insert / delete / update] 
  on nombre-de-la-tabla
  for each row
begin
 instrucciones-sql;
end
````
## Partes de un trigger (disparador)  
Mediante las palabras claves before, after indicamos en que momento se ejecutará el bloque del trigger.

Luego indicamos para cual comando SQL se invocará el trigger, pudiendo ser cualquiera de los tres comandos SQL: INSERT, 
UPDATE o DELETE.

Después de la palabra clave 'on' indicamos el nombre de la tabla a la que se asocia el trigger.

Finalmente, colocamos la lógica del trigger dentro del bloque 'begin' 'end', podemos utilizar uno o más comandos SQL 
válidos.

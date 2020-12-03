# Procedimientos almacenados

## Índice de contenidos
|Procedimientos almacenados
|---------
|[Crear - Ejecutar](#procedimientos-almacenados-crear---ejecutar)
|[Cláusula 'delimiter'](#cláusula-delimiter)
|[Procedimientos almacenados (parámetros de entrada y salida)](#procedimientos-almacenados-parámetros-de-entrada-y-salida)
|[Procedimientos almacenados (definición de variables locales)](#procedimientos-almacenados-definición-de-variables-locales)
|[Procedimientos almacenados (estructura if)](#procedimientos-almacenados-estructura-condicional-if)
|[Procedimientos almacenados (estructura case)](#procedimientos-almacenados-estructura-condicional-case)
|[Procedimientos almacenados (estructuras repetitivas)](#procedimientos-almacenados-estructuras-repetitivas)
|[Llamar a otro procedimiento almacenado desde un procedimiento](#llamar-a-otro-procedimiento-almacenado-desde-un-procedimiento)
|[Procedimientos almacenados (llamadas recursivas)](#procedimientos-almacenados-llamadas recursivas)

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

## Procedimientos almacenados (parámetros de entrada y salida)
Los procedimientos almacenados pueden recibir y devolver información; para ello se emplean parámetros, de entrada y salida, 
respectivamente.

#### Parámetros de entrada: 
Posibilitan pasar información a un procedimiento. Para que un procedimiento almacenado admita parámetros de entrada se 
deben declarar variables como parámetros al crearlo. La sintaxis es:
````
create procedure NOMBREPROCEDIMIENTO (in NOMBREPARAMETRO TIPODEDATO)
 begin
 end
````
Pueden ser de cualquier tipo de dato. Se definen luego del nombre del procedimiento, se le antecede la palabra clave 'in'. 
Los parámetros son locales al procedimiento, es decir, existen solamente dentro del mismo. Pueden declararse varios parámetros 
por procedimiento, se separan por comas. 
````
 delimiter //
 create procedure pa_libros_autor(in p_autor varchar(30))
 begin
   select titulo, editorial,precio
     from libros
     where autor= p_autor;
 end //
 delimiter ;
````
Luego para llamar al procedimiento almacenado debemos pasar un valor para el parámetro:
````
 call pa_libros_autor('Richard Bach');
````

#### Parámetros de salida: 
Pueden devolver información. El valor se retorna a quien realizó la llamada con parámetros de salida. Para que un procedimiento 
almacenado devuelva un valor se debe declarar una variable con la palabra clave "out" al crear el procedimiento. La sintaxis es:
````
 create procedure NOMBREPROCEDIMIENTO (out NOMBREPARAMETRO TIPODEDATO)
 begin
 end
````
Ejemplo mas real:
````
 delimiter //
 create procedure pa_promedio(
   in n1 float,
   in n2 float,
   out resultado float)
 begin
   select (n1+n2)/2 into resultado;
 end //
 delimiter ;
 
 call pa_promedio(10, 5, @resu);
 
 select @resu;
````
El procedimiento almacenado tiene tres parámetros, los dos primeros son de entrada y el último es de salida. Mediante un 
select calculamos el promedio de los parámetros n1 y n2, guardamos en el parámetro 'resultado' el promedio de los dos 
primeros parámetros.

Cuando llamamos al procedimiento almacenado debemos pasar los dos primeros valores y como último dato nombre de la variable 
donde se almacene el resultado (en este caso del select):
````
 call pa_promedio(10, 5, @resu);
````
Luego podremos imprimir el valor almacenado en la variable @resu:
````
select @resu;
````

#### Parámetros de entrada y salida de forma simultanea:
Definimos un parámetro de entrada y salida mediante la palabra clave inout:
````
 create procedure NOMBREPROCEDIMIENTO (inout NOMBREPARAMETRO TIPODEDATO)
 begin
 end
````
Ejemplo mas real:
````
delimiter //
 create procedure pa_incrementar(
   inout contador int)
 begin
   set contador = contador + 1;
 end //
 delimiter ;
 
 set @conta=1;
 select @conta; -- se imprime un 1
 call pa_incrementar(@conta);
 select @conta; -- se imprime un 2
 call pa_incrementar(@conta);
 select @conta; -- se imprime un 3
 call pa_incrementar(@conta);
 select @conta; -- se imprime un 4
 call pa_incrementar(@conta);
 select @conta; -- se imprime un 5
````
Cuando se llama al procedimiento almacenado pasar una variable ya inicializada:
````
 set @conta=1;
 select @conta;
 call pa_incrementar(@conta);
 select @conta; 
````

[Ir al indice](#índice-de-contenidos)

## Procedimientos almacenados (definición de variables locales)
MySQL nos brinda la posibilidad de definir variables para almacenar valores temporales y efectuar operaciones con los mismos.

Utilizamos la palabra clave 'declare' seguida del nombre de la variable, el tipo de dato que almacena y el valor por defecto 
que almacena:
````
declare [nombre de la variable] [tipo de dato] default [valor por defecto];
````
Una variable que no define la sección del 'default' almacena por defecto null.
````
delimiter //
create procedure pa_sumar(
  in v1 int,
  in v2 int)
begin
  declare suma int;
  set suma=v1+v2;
  select suma;  
end //
delimiter ;

call pa_sumar(4,5);
````
Para modificar una variable utilizamos la palabra clave set:
````
  set suma=v1+v2;
````

[Ir al indice](#índice-de-contenidos)

## Procedimientos almacenados (estructura condicional if)
MySQL dispone la estructura condicional if para tomar decisiones dentro de un procedimiento almacenado.

- Sintaxis simple:
````
if [condición] then
   [instrucciones]
end if;
````
- Sintaxis compuesta:
````
if [condición] then
   [instrucciones]
else
   [instrucciones]
end if;
````
- Sintaxis anidada:
````
if [condición] then
   [instrucciones]
elseif [condición] then
   [instrucciones]
elseif [condición] then
   [instrucciones]
elseif [condición] then
   [instrucciones]
......
else
   [instrucciones]
end if;
````

[Ir al indice](#índice-de-contenidos)

## Procedimientos almacenados (estructura condicional case)
Se utiliza cuando hay múltiples condiciones y remplaza a la estructuras if/elseif.

Hay dos variantes con la estructura case.

- case simple: 
````
case [variable] 
  when [valor1] then
    [instrucciones1]
  when [valor2] then
    [instrucciones2]
  when [valor3] then
    [instrucciones3]
  ....
  else
    [instrucciones]
end case;
````
Analiza el contenido de una variable y lo compara con una serie de valores posibles, en caso que coincida con alguno de 
ellos ejecuta el bloque de instrucciones. Si los valores no coincide con los valores indicados en los when, dispone de 
una sección else que se ejecuta

- La segunda variante permite disponer condiciones para cada when:
````
  case 
    when [condición1] then
      [instrucciones1]
    when [condición2] then
      [instrucciones2]
    when [condición3] then
      [instrucciones3]
    ....
    else
      [instrucciones]
  end case;
````

[Ir al indice](#índice-de-contenidos)

## Procedimientos almacenados (estructuras repetitivas)
Para repetir bloques de instrucciones disponemos: 
- while
````
  while [condición] do
    [instrucciones]
  end while;
````
El bloque de instrucciones encerrado entre while y end while se repite mientras la condición se verifique verdadera.

- repeat
````
  repeat
    [instrucciones]
  until [condición]
  end repeat;
````
El bloque de instrucciones encerrado entre repeat y end repeat se ejecuta hasta que la condición del until se verifica 
verdadera.Es conveniente utilizarla cuando el bloque a repetir se debe ejecutar por lo menos una vez.

- loop
````
  [etiqueta]:loop
    [instrucciones]
  end loop;
````
El bloque de instrucciones encerrado un bloque de instrucciones entre los comandos 'loop' y 'end loop'. Para finalizar 
debemos ejecutar el comando 'leave' e indicar una etiqueta definida previa al comando 'loop'.

[Ir al indice](#índice-de-contenidos)
  
## Llamar a otro procedimiento almacenado desde un procedimiento 
El procedimiento que es invocado por otro debe existir cuando creamos el procedimiento que lo llama.
````
delimiter // 
create procedure pa_multiplicar(
  in numero1 int,
  in numero2 int,
  out producto int)
begin
  set producto=numero1*numero2;
end // 
delimiter ;


delimiter // 
create procedure pa_factorial(
  in numero int,
  out resultado int)
begin  
  declare num int;
  set resultado=1;
  set num=numero;
  while num>1 do
     call pa_multiplicar(resultado,num,resultado);
     set num=num-1;
  end while;
end //    
delimiter ;

call pa_factorial(5, @resu);
select @resu;
````

[Ir al indice](#índice-de-contenidos)

## Procedimientos almacenados (llamadas recursivas)
Es una característica que hay que usar con cuidado ya que puede afectar la eficiencia de nuestros algoritmos. Por defecto 
MySQL tiene desactiva la posibilidad de hacer llamadas recursivas.

Para activar la posibilidad de hacer llamadas recursivas debemos modificar la variable del sistema 'max_sp_recursion_depth' 
indicando la cantidad de llamadas recursivas posibles:
````
SET @@session.max_sp_recursion_depth = 10;
````
 
[Ir al indice](#índice-de-contenidos)


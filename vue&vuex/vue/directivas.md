# Directivas Vue.js
Son atributos especiales, que agregan comportamiento reactivo al DOM y contienen el prefijo ("v-"). 

## v-model
Se utiliza en la parte del html(<'template'>) para enlazar un campo de un input, con el contenido inicializado en nuestra instancia de vue.js, en la propiedad ('data:{}').

Ejemplo: 
```
v-model="mismo nombre del dato que esta inicializado en ('data:{}')".
```
## v-bind == (':')
Para vincular a un atributo del html(<'template'>) medotos con un valor dinamico o ('prop') de un componente. En este caso el metodo sera un parametro de la directiva. 

Ejemplo:
```
 :disabled="invocamos el metodo que queremos pasarle".
```
## v-on == ('@')
Para escuchar eventos en el Dom y enlazar un metodo que sera ejecutado.

Ejemplo: 
```
@submit('submit es nombre del evento')="nombre del metodo a ejecutar".
```
Tambien podremos pasar al metodo que se ejecutara tras el evento argumentos.

Ejemplo:
```
@submit('submit es nombre del evento')="nombre del metodo a ejecutar(argumento)".
```

### Modificadores de eventos para la directiva v-on == ('@')*
En estos ejemplos::@nombreDelEvento(por ejemplo:: click,submit,keyup,etc) y los modificadores pueden encadenarse.

- @nombre.STOP="nombre del metodo a ejecutar(argumento)"::La propagación del evento será detenida.
- @nombre.PREVENT="nombre del metodo a ejecutar(argumento)"::El evento no recargarála página.
- @nombre.CAPTURE="nombre del metodo a ejecutar(argumento)"::Usa el modo captura cuando agregas _listener_ de eventos.
- @nombre.SELF="nombre del metodo a ejecutar(argumento)"::Solo dispara la función controladora si event.target es este elemento quiere decir, no un elemento hijo.
- @nombre.ONCE="nombre del metodo a ejecutar(argumento)"::El evento 'click' será disparado una vez como máximo. 

## v-show
Se utiliza en la parte del html(<'template'>) para el renderizado del componente o de un elemento,que queremos mostrar despues de una condicion.Pero con una diferencia entre(v-if) ya que con (v-show) en el momento que no este renderizado solo se ocultara en el Dom, le agrega en CSS el ('display:none') y no podremos utilizar acontinuacion (v-else).

Ejemplo:
```
v-show="nombre del metodo que contiene el condional".
```
## v-if
Se utiliza en la parte del html(<'template'>) para el renderizado del componente o de un elemento,que queremos mostrar despues de una condicion y en el momento que no se esta renderizando lo elimina del Dom.

Ejemplo:
``` 
v-if="nombre del metodo que contiene el condional".
```
## v-else
Se utiliza en la parte del html(<'template'>) para el renderizado del componente o de un elemento,que queremos mostrar si no se cumple la condicion.
Ejemplo:
``` 
v-else 
```
## v-once
Se utiliza en la parte del html(<'template'>) para mostrar solo una sola vez un elemento y permanecera de forma estatica en la ejecucion de la pag.

Ejemplo: 
```
v-text="nombre del dato que queremos mostrar"
```
## v-text
Se en las etiquetas de en la parte del html(<'template'>) y actualiza los elementos que contienen texto,como los caracteres {{Moustache}}.

## v-for 
Se utiliza en la parte del html(<'template'>) para iterar y renderizar un elemento('array o obj.') de la propiedad (data(){}) una cantidad de veces de forma dinamica y reactiva.

Ejemplo:
```
v-for="('alias que le vamos a dar a cada elemento')in('nombre del elemento a iterar')".
```
Tambien le podemos pasar aparte del 'alias' varios parametros antes del ('in'), por ejemplo el 'index' para acceder a el y tambien podemos pasarle despues del('in')el ('nombre del elemento a iterar') o una propiedad computada que por ejemplo esta filtrando dicho elemento.

Ejemplo:
```
v-for="('alias','index')in('nombre del elemento a iterar o propiedad computada')".
```

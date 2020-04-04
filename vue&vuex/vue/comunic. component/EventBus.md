# EventBus
Es un eventos incorporado de Vue para comunicar eventos entre componentes(hijos) o que no estan relacionados entre si.

## Inicializando
Lo primero que hay que hacer es crear el "EventBus" evento, importar "vue" y exportar "EventBus" a algún lugar para que otros módulos y componentes puedan usarlo.Todo lo que existe en este archivo, son sus métodos de instancia, por lo que es bastante ligero.

Ejemplo:
```		
import Vue from 'vue';
		
export const EventBus = new Vue();
```
## Usando EventBus
Todo lo que necesita hacer para usarlo es importarlo en sus componentes y llamar a los mismos métodos que usaría si estuviera pasando mensajes entre los componentes principales y secundarios.

### Emitiendo el evento
Para enviar algun tipo de evento utiliza "EventBus.$emit()",como primer parametro se le pasa el nombre del evento("llamado CANAL") y se podrian enviar como argumento la function "callback"que queremos ejecutar en la recepcion del evento.

Ejemplo:
```
EventBus.$emit('editing',this.clickCount)
```

## Recibiendo el evento
Para recibir("escuchar") eventos en cualquier parte de la aplicacion, hay que importar "EventBus" y agregar un metodo"hook"que normalmelte es"mounted()" y dentro utilizamos"EventBus.$on()",como 			primer parametro se le pasa el mismo nombre del evento("CANAL")	que se le paso en el("EventBus.$emit()") y como segundo parametro vamos a ejecutar el "callback" que estamos recibiendo.
		
Ejemplo:
```
import { EventBus } from './event-bus.js';
mounted() {
    EventBus.$on('editing', clickCount => {
        console.log(`Oh, that's nice. It's gotten ${clickCount} clicks! :)`)
});
```
> Si solo desea escuchar la primera emisión de un evento, puede usar("EventBus.$()")

## Eliminar oyentes del evento
Podemos eliminar todos los oyentes para un evento en particular usando ("EventBus.$Off()") y solo se le pasa el parametro;nombre del evento("CANAL").
		
Ejemplo:
```
destroyed() {
    EventBus.$off('editing')
}
```
Tambien podemos eliminar todos los oyentes de EventBus,independientemente del canal, puede llamar a ("EventBus.$Off()") sin ningún argumento.

Ejemplo:
```
destroyed() {
    EventBus.$off()
}
```

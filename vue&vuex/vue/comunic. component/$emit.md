# $emit

## Comunicación de un componente hijo con un componente padre:

Utilizamos desde el componente hijo un metodo($emit())con el nombre del evento que queremos pasar al padre.

> *IMPORTANTE:* el nombre que le pasamos en el metodo($emit()) tendremos que recibirlo exactamente con el mismo nombre en el padre.

### Componente hijo:
```
<script>
<template>
  <div>
    <div class="hijo">{{message}} {{nombre}}</div>
  </div>
</template>
<script>
export default {
  name: "Hijo",
  data() {
    return {
      message: "componente hijo",
      nombre: "Maria"
    };
  },
  mounted() {
    this.$emit("nombreHijo", this.nombre);
  }
};
</script>
```
El metodo(mounted())se ejecuta cuando este listo el(DOM), vamos a emitir con $emit("nombreHijo", this.nombre) los datos que va a recibir el padre.

> *IMPORTANTE:* el nombre que le pasamos en el metodo($emit()) tendremos que recibirlo exactamente con el mismo nombre en el padre.

### Componente padre:
En este componente es donde vamos a recibir la informacion en este caso un evento del hijo, con la directiva(v-on = @) y para guardar los datos creamos en (data()) un valor que en el ejemplo es(nombrePadre).
```
<script>
  <template>
  <div>
    <div class="padre">
      {{ message }}
      {{nombrePadre}}
      //En esta linea recibimos el evento que lo guardamos en nuestro valor creado
      //en(data()) y seria con la sintaxis que vemos en el ejemplo.
      //(=$event) seria el el evento del hijo.
      <hijo @nombreHijo="nombrePadre = $event"></hijo>
    </div>
  </div>
</template>
<script>
import Hijo from "./Hijo";

export default {
  name: "Padre",
  components: {
    Hijo
  },
  data() {
    return {
      message: "componente padre",
      //Aqui guardamos la informacion que viene del componente hijo.
      nombrePadre: ""
    };
  }
};
</script>
```

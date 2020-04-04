# Props

Son atributos personalizados que se pueden registrar en un componente y mantendra la comunicacion entre componentes.

Cuando se pasa un valor(prop) a un componente se convierte en una propiedad de ese componente.

## Comunicación de un componente hijo con un componente padre:

### Componente padre:
```
<script>
<template>
  <div>
    <div class="padre">
      {{ message }}
      {{numero}}
      <button @click="numero++">+</button>
      <button @click="numero--">-</button>
      <hijo :numero="numero"></hijo>
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
      numero: 5
    };
  }
};
<script>
```
### Componente hijo:
```
<template>
  <div>
  //({{numero}})son los datos del padre que guardamos como una propiedad(props)
  //para poder hacer uso de ella.
    <div class="hijo">{{message}} {{numero}}</div>
  </div>
</template>
<script>
export default {
  name: "Hijo",
  data() {
    return {
      message: "componente hijo"
    };
  },
    numero: {
      type: Number
    }
  }
};
</script>
```
Utilizando los props(Objectos) permiten mayor control sobre las props, ya que defines el type(tipos):Number,Array,Object,String,Boolean,... y establecer un valor por defecto(default),indicar si son obligatorias(required) o no,y puedes añadir validadores(validator) para validar si existe un valor.

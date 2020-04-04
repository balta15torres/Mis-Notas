# Slot
Digamos que es un hueco disponible en un componente en el que le pasamos otro componente y se pinta.

### Hay 2 tipos de Slot:

- Sin atributo(name).
- Con atributo(name) para cuando tenemos varios Slot.

Para darle contenido a un slot con atributo(name) usamos la directiva(v-slot) en el <template> proporcionando el nombre del slot.

Podemos simplificar el argumento(v-slot) con el simbolo especial(#).

Ejemplo de un componente con varios Slot con(name=header,main,footer) y accediendo a datos que estan disponibles en componentes secuandarios(user) usando la desestructuracion::
```
<nombreDelComponente>
        <template #header>
          <h1>Here might be a page title</h1>
        </template>
        <template #main="{user}">
          <p>{{ user.firstName }}</p>
        </template>
        <template #footer>
          <p>Here some contact info</p>
        </template>
</nombreDelComponente>
```
Para poder pasarle contenido de hijo a padre hay que enlazar como atributo al slot el contenido; en este ejemplo seria(user) con el(v-bind) que recordamos que podemos simplificarlo sustituyendo(v-bind) por(:).
```
<template>
  <div class="container">
    <main>
      <slot name="main" :user="user"></slot>
    </main>
  </div>
</template>
```

## Eventos personalizados:
El nombre del evento ("onClick") tiene que ser exactamente el mismo que el utilizado para escuchar ese evento (@click="onClick")
```
<template>
  <div>
    <btn @onClick="decrementCount">- count</btn>
    <p>COUNT:: {{ count }}</p>
    <btn @onClick="incrementCount">+ count</btn>
  </div>
</template>
```
Este seria el componente padre y le pasamos al componente (Button):
```
<script>
import Button from "./Button";
export default {
  name: "padre",
  components: {
    btn: Button
  },
  data() {
    return {
      count: 0
    };
  },
  methods: {
    incrementCount() {
      this.count = this.count + 1;
    },
    decrementCount() {
      this.count = this.count - 1;
    }
  }
};
</script>
```

Este seria el componente(hijo = Button):
```
<template>
  <button @click="onClick"><slot></slot></button>
</template>
<script>

//Para emitir al padre dicho evento tendremos que utilizar ($emit("nombreEvento"))

export default {
  name: "Button",
  methods: {
    onClick() {
      this.$emit("onClick");
    }
  }
};
</script>
```

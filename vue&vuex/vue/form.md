# Form 

### Cotrol de input
- 1. Usando v-model: Evitas tener que manejar tú el valor del input a mano como en el ejem siguiente. Asocias a v-model una variable:
```
<template>
  <div>
    <input v-model="message" />
    <p>{{ message }}</p>
  </div>
</template>
<script>
export default {
  name: "Form",
  data() {
    return {
      message: ""
    };
  }
};
</script>
```
- 2. Usando value y una función para el cambio: Actualizar de forma manual el cambio de valor del input.
```
<template>
  <div>
    <input :value="message" @input="handleChange" />
    <p>{{ message }}</p>
  </div>
</template>
<script>
export default {
  name: "Form",
  data() {
    return {
      message: ""
    };
  },
  methods: {
    handleChange(event) {
      // Si necesitas hacer cosas con el evento,
      //pues también. Tipo: stopPropagation (para parar los siguientes eventos).
      // *IMPORTANTE* Si el input es puro Html necesitaremos (event.target.value).
      this.message = event.target.value;
    }
  }
};
</script>
```
- 3. Usando una variable computada para manejar el valor del input. Se combina con v-model. De esta forma se hace una imitación de v-model manual. Utilizada cuando el valor input es externo al componente.
```
<template>
  <div class>
    <input v-model="message" />
    <p>{{ message }}</p>
  </div>
</template>
<script>
export default {
  name: "Form",
  data() {
    return {
      message: ""
    };
  },
  //Variable computada siempre como funcion
  computed: {
    input: {
      get() {
        return this.message;
      },
      set(value) {
        this.message = value;
      }
    }
  }
};
</script>
```
- 4. Ejemplo de un input para crear una lista de personajes, un contador y un par de botones para añadir a la lista y otro para borrar el ultimo personaje de la lista. El disabled atributo booleano deshabilita el boton asta que se cumpla la condicion (variable computada). Dentro de computed iran todas las variables computadas.
```
<template>
  <div>
    <p>Añadir un nuevo personaje</p>
    <input v-model="newCharacter" @keyup.enter="addCharacter" />
    {{ this.characters.length }} <br />
    <br />
    <button @click="addCharacter" :disabled="conditionAdd" :class="buttonAdd">
      +Add
    </button>
    <ul>
      <li v-for="character in characters" :key="character.id">
        <span v-if="characters.lenght === 0">No existen personajes</span>
        {{ character.name }}
      </li>
    </ul>
    <button
      @click="deleteCharacter"
      :disabled="conditionDelete"
      :class="buttonDelete"
    >
      -Delete
    </button>
  </div>
</template>
<script>
export default {
  name: "Form",
  data() {
    return {
      newCharacter: "",
      characters: []
    };
  },
  computed: {
    conditionAdd() {
      return this.newCharacter.length < 3;
    },
    conditionDelete() {
      return this.characters.length === 0;
    },
    buttonAdd() {
      //Estas seran las formas de retornar el condicional

      //return { red: this.condition };
      //return this.condition && "red"

      //Esta seria con un condicional ternario para que se de una condicion o otra
      return this.conditionAdd ? "red" : "green";
    },
    buttonDelete() {
      return this.conditionDelete ? "red" : "green";
    }
  },
  methods: {
    addCharacter() {
      this.characters.push({ name: this.newCharacter });
      //La siguiente linea es para limpiar el input una vez añadido el personaje.
      this.newCharacter = "";
    },
    deleteCharacter() {
      this.characters.pop(this.character);
    }
  }
};
</script>
<style>
.red {
  border: 2px solid red;
  color: red;
}
.green {
  background-color: green;
}
</style>
```

# Componentes Dinamicos:
Es util para cambiar dinamicamente entre componentes.En un componente(padre) importamos los componentes(hijos) que queremos renderizar.

En este ejemplo utilizamos 3 componentes(hijos) igual a este

### Componente hijo
```
<script>
<template>
  <div class="manzana">
    <p>{{ manzana.description }}</p>
  </div>
</template>
<script>
export default {
  name: "Manzana",
  data() {
    return {
      manzana: {
        name: "manzana",
        description:
          "Una manzana, descrita objetivamente, es una fruta sumamente popular, de forma “amanzanada”, con unos 10 centímetros de diámetro y 20 gramos de peso. Los sabios en la materia la conocen como pomácea comestible, obtenida del manzano doméstico, malus doméstica para los aún más sabios"
      }
    };
  }
};
</script>
```
> En el ejemplo lo renderizaremos todo en el componente(padre)

### Componente padre
```
<script>
<template>
  <div class="currentComponents">
    <button
      v-for="fruit in fruits"
      :key="fruit"
      @click="currentFruit = fruit"
      :class="getButtonClass(fruit)"
    >{{ fruit }}</button>
    //(<keep-alive>)para guarde en cache el ultimo componente
    <keep-alive>
    //el(component :is="...") es para navegar entre componentes.
      <component :is="currentFruit"></component>
    </keep-alive>
  </div>
</template>
import Manzana from "./Manzana";
import Pera from "./Pera";
import Platano from "./Platano";
export default {
  name: "CurrentComponents",
  components: {
    Manzana,
    Pera,
    Platano
  },
  data() {
    return {
      //(currentFruit) este sera el valor por defecto.
      currentFruit: "Manzana",
      fruits: ["Manzana", "Pera", "Platano"]
    };
  },
//Variables compoutadas.
  computed: {
    currentFruits() {
      return this.currentFruit;
    }
  },
  methods: {
    //Mapeos de los colores para evitar demasiados (if)
    getColor(key) {
      const colorMapping = {
        Manzana: "red",
        Pera: "green",
        Platano: "yellow"
      };
      return colorMapping[key];
    },
    getButtonClass(key) {
      return `Button--${this.getColor(key)}`;
    }
  }
};
</script>
//El (lang) para enlazar el (Sass)
<style lang="scss">
.CurrentTabComponent {
  display: flex;
  justify-content: center;
}
.CurrentTabComponent div {
  margin: 15px;
}
.Button {
  &--red {
    color: red;
    background-color: rgb(255, 147, 147);
  }
  &--green {
    color: green;
    background-color: rgb(122, 211, 122);
  }
  &--yellow {
    color: rgb(156, 156, 0);
    background-color: rgb(255, 255, 143);
  }
}
</style>
</script>
```

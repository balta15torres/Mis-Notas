# Ciclo de vidaa
Estos metodos nos devuelven con los console.log en el ciclo de vida que esta el componente que contiene dichos metodos
```
<template>
  <div>

    </div>
  </div>
</template>

<script>
export default {
  name: "App",
  components: {

  },

  methods: {
    created() {
      console.log("Created");
    },
    mounted() {
      console.log("Mounted");
    },
    updated() {
      console.log("Update");
    },
    destroyed() {
      console.log("Destroyed");
    }
  }
};
</script>
```

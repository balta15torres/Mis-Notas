# MapState y MapActions

- Para pasar una propiedad del state del store entre componentes camos a utilizar un metodo llamando a (mapState) en nuestras (computed propety).
- Para pasar acciones en componentes usaremos (mapActions) en nuestros (methods)
```
<template>
  <div>
    {{ count }}{{ name }} <button @click="increment">+</button>

    (decrement) es un metodo que le pasamos al componente con(...mapActions)
    <button @click="decrement">-</button>

    (incrementAsyn) es un metodo que le pasamos al componente con(...mapActions)
    <button @click="incrementAsyn">----</button>

    (decrementar) es un metodo que le pasamos al componente con(...mapMutations)
    <button @click="decrementar">-</button>

    (incrementCourse) es un metodo que le pasamos al componente
    con(...mapActions) <button @click="incrementCourse">añadir cursos</button>

    estamos recorriendo con(v-for)los cursos y pintando el nombre de cada uno.
    <ul v-for="(course, id) in courses" :key="id">
      <li>{{ course.name }}</li>
    </ul>
  </div>
</template>
<script>
//En la siguiente linea estamos importando con lo que vamos a trabajar acontinucion.
import { mapState, mapActions } from "vuex";
export default {
  name: "Counter",
  store,
//para acceder al(state) del (Store) tiene que ser desde(computed property) y lo podemos hacer de varias formas::
  computed: {
//- 1.EL SIGUIENTE CASO LO UTILIZAMOS SOLO PARA ACCEDER A UNA PROPIEDAD DEL(STATE)
count() {
//para acceder al(Store) en cualquier componente secundario, tendremos que acceder a el de la siguiente forma(this.$store)
return this.$store.state.count;
},
//En los 2 siguientes casos vamos a tener que utilizar el(object Spread Operator)sobre (...mapState), ya que este metodo nos devuelve un objeto y estamos dentro de otro objeto(computed) daria error.
//- 2.EL SIGUIENTE CASO UTILIZAMOS(...mapState([""])) para acceder(mapear)el (state)sus multiples propiedades (["count","name"])estas seran las propiedades a las que queremos acceder.
...mapState(["count", "name"]),
//- 3.EL SIGUIENTE CASO UTILIZAMOS(...mapState({ })) para acceder a multiples propiedades del(state)
    ...mapState({
      //y acontinuacion le asignamos a una propiedad(count:),(name:),(courses:)
      //un valor que sera la propiedad del (state) que queremos.
      count: state => state.count,
      name: state => state.name,
      courses: state => state.courses
    })
  },
//Dentro de(methods:) van a ir los metodos que llamamos del(Store) para cambiar el(state)
  methods: {
//(...mapMutations) lo utilizamos para (mapear) los metodos de los componentes y (commitear) las mutaciones en componentes.(["decrementar",....]) podriamos pasarle mas parametros que serian(metodos) en la (array) MEJOR UTILIZAR (...mapActions)*
    ...mapMutations(["decrementar"]),
//(...mapActions) lo utilizamos para (mapear) y enviar acciones en componentes y mapear todos los metodos de los componentes a la(Store.dispatch).
    ...mapActions([
      "incrementAsync",
      "getNumber",
      "getSubtractNumber",
      "getCourses"
    ]),
METODOS::(mapeados) con (...mapActions)::
    incrementAsyn() {
      this.incrementAsync({ amount: 10 });
    },
    increment() {
      this.getNumber({ amount: 2 });
    },
    decrement() {
      this.getSubtractNumber({ amount: 2 });
    },
    incrementCourse() {
      this.getCourses();
    }
  }
};
</script>
```

# index.js
Siempre hay que importar tanto ("vue") como ("vuex")
```
import Vue from "vue";
import Vuex from "vuex";
```
Estamos importando el(courses.json) por que vamos a acceder a ellos en unas de las (actions:)acciones (getCourses()).
```
import courses from "./courses.json";
```
este es el mecanismo que nos permite inyectar el(Store) dentro de los componentes secundarios y estar disponible para todos ellos. Vue.use(Vuex);
```
export default new Vuex.Store({
  state: {
    count: 1,
    name: "Balta"
  },
```
### Las mutaciones en Vuex.js son transanciones sincronas: 

Dentro de(mutations) van a estar todos los metodos que van a cambiar el(state) del(Store),estos metodos van a recibir como primer argumento el(state) actual del(Store) y pueden recibir como argumento adicional(payload) que debe ser un objeto para que puedan tener varios campos.
```
mutations: {
  decrementar(state) {
    state.count--;
  },
  //Aqui en este metodo estamos pasando como segundo argumento(n) que sera el cantidad que queremos restar
  INCREMENT(state, n) {
    state.count += n;
  },
  DECREMENT(state, n) {
    state.count -= n;
  },
  FILL_COURSES(state, coursesAction) {
    state.courses = coursesAction;
  }
},
```
Para ejecutar las funciones creadas dentro de(mutations) tiene que ser ejecutadas dentro de(actions:) y el metodo(commit("nombreFuncion"))es el encargado de ejecutar la (mutations:).

Como segundo parametro({amount}) en este ejemplo, es el segundo parametro(n) del metodo de mutations que se da el valor en el componente dentro de(methods:).
```
actions: {
  incrementAsync({ commit }, { amount }) {
    setTimeout(() => {
      commit("INCREMENT", amount);
    }, 1000);
  },
  getNumber({ commit }, { amount }) {
    commit("INCREMENT", amount);
  },
  getSubtractNumber({ commit }, { amount }) {
    commit("DECREMENT", amount);
  },
  getCourses({ commit }) {
    commit("FILL_COURSES", courses);
  }
}
```

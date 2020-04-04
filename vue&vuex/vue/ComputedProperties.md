# Propiedades computadas
Es una propiedad como los(Methods) pero la diferencia es que las PROPIEDADES compuetadas se almacenan en la cache y asi reducira la velocidad de carga.
```
<script>
  <template>
  <div id="example">
    <p>
      Original message:
      //En esta linea con(v-model) actualiza el(data(){message:""}) con los datos
      // de entrada en el input.
      <input type="text" v-model="message">
    </p>
    <p>Computed reversed message: {{ reversedMessage }}</p>
    <p>
      Name:
      //En esta linea con(v-model) actualiza el(data(){name:""}) con los datos
      // de entrada en el input.
      <input type="text" v-model="name">
    </p>
    <p>
      lastName:
      //En esta linea con(v-model) actualiza el(data(){lastName:""}) con los datos
      // de entrada en el input.
      <input type="text" v-model="lastName">
    </p>
    <p>
      fullName:
      {{ fullName }}
    </p>
    <label>Count is: {{count}}</label>
    <button @click="count++">Increment</button>
  </div>
</template>
<script>
export default {
  name: "ComputedWhatchers",
  data() {
    return {
      message: "",
      name: "",
      lastName: "",
      count: 0
    };
  },
  computed: {
    // a computed getter
    reversedMessage() {
      //console.log(this.message);
      // `this` points to the vm instance
      return this.message
        .split("")
        .reverse()
        .join("");
    },
    fullName() {
      return `${this.name} ${this.lastName}`;
    }
  }
};
</script>
```

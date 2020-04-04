# Provide & Inject

¿Para que sirve?

En caso de que queramos pasar alguna propiedad del componente padre a un componente mas profundo, por ejemplo a un componente nieto; Esto nos servira para pasar dicha propiedad al componente nieto sin que el componente hijo sepa de dicha propiedad.
 	
Ejemplo:

Componente Padre
```
<script>
<template>
  <div>
    <h1>Padre</h1>
    <Child/>
  </div>
</template>			
import Child from "./Child.vue";

export default {
    name: "Father",
//inyectaremos la propiedad a pasar
    provide() {
        return {
		    inject: "herencia"
        };
    },
    components: {
	    Child
	}
};
</script>
```
Componente Hijo	
```
<script>
<template>
  <div>
    <h2>Hijo</h2>
    <Grandchild/>
  </div>
</template>
import Grandchild from "./Grandchild.vue";
export default {
    name: "Child",
    components: {
        Grandchild
    }
};
</script>
```

componente Nieto//
```
<template>
  <div>
    <h3>Nieto y {{inject}}</h3>
  </div>
</template>
<script>
export default {
    name: "Grandchild",
//aqui le recibimos la propiedad
    inject: ["inject"]
};
</script>
```

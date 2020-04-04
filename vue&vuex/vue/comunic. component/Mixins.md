# MIXINS
Son objetos que usaremos para distribuir de forma flexible funcionalidades reutilizables para otros componentes y puede tener cualquier opcion de un componente.Por lo que si un componente utiliza un "Mixin" todas las opciones del "Mixin" seran fusionadas con las opciones propias del componente. 
	
#### Opciones de fusionado 
Cuando se fusionan las opciones del "Mixin" y del propio componente, las funciones"hook" ("funciones"hook":
- created()
- mounted()
- updated()
- destroyed() 

seran ejecutadas antes y las opciones del componente tendrán mayor precedencia cuando haya conflicto con el "mixin" requerido. Tambien todos los "mixins" seran añadidos en un Array para que todos ellos sean ejecutados.

## Mixins Globales
Puedes aplicar globalmente un "mixin", pero afectará a cada instancia de Vue que crees luego, inclusive los componentes de terceros.

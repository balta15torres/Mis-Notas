# Conceptos Básicos ES6

### El operador de propagación ( SPREAD ):
- Seria la alternativa del metodo contac() de ES5.
- Permite que una expresión sea expandida en situaciones como en el ejemplo donde se esperan multiples elementos de una array ó también multiples argumentos de una funcion.

Ejemplo:
```
const arreglo1 = [1, 2];
const arreglo2 = [3, 4, 5];

console.log([...arreglo1, ...arreglo2, ...[6, 7]]);
```
Otro ejemplo:
```
var parts = ["shoulder", "knees"];
var lyrics = ["head", ...parts, "and", "toes"];

console.log(lyrics);
```
- En este ejemplo le estamos pasando como argumentos todos los elementos declarados en la array (values) y también en la llamada de la funcion le podemos pasamos con este operador todos los argumentos.

Ejemplo:
```
var findMaxValueIn = (...numbers) => {
  return Math.max(values);
};
var values = [20, 40, 10, 30];
var max = Math.max(values);
console.info(findMaxValueIn(...values)); // 40
```

- En este ejemplo como argumento le pasaremos la key(name) que vamos a modificar y le pasamos como siguiente argumento el resto del objeto(...other) y le reasignamos (newUser) como el nuevo (name).
```
const updateUser = ({ name, ...other }) => {
  const pre = Math.random();
  const newUser = `${pre}-name`;

  return {
    ...other,
    name: newUser
  };
};
```
### Diferencia entre (for of loop) y (for  in loop)

- for..of itera una Array y devuelve los elementos uno por uno, no su índice.
```
let arr = [2, 3, 4, 1];
for (let value of arr) {
  console.log(value); //2,3,4,1
}
```
- for..in iterra una Array y devuelve el índice de cada elemento.
```
let arra = [2, 3, 4, 1];
for (let value in arra) {
  console.log(value); //0,1,2,3
}
```

### Parametros por defecto en Funciones.

- En este ejemplo estamos pasando solo un parámetro.La función hace uso del parámetro predeterminado y ejecuta la función. Si en algun caso pasamos 2 parametros, el segundo parametro reemplazara al parametro predeterminado.
```
let NotWorkingFunction = (a, b = 10) => {
  return a + b;
};
console.info(NotWorkingFunction(20)); // 30
```
- En este ejemplo nos devuelve (NAN) el motivo es que cuando se llama a la funcion con parametros, se asigna en orden.
```
let NotWorkingFunction = (a = 10, b) => {
  return a + b;
};
NotWorkingFunction(20); // NAN. Not gonna work.
```

# Metodos importantes::

Ejemplo::
```
const fruits = [
  {
    name: "platano",
    description:
      "Su sabor es más o menos dulce según la variedad. El plátano es rico en fibra, potasio y algunas vitaminas beneficiosas para la salud."
  },
  {
    name: "manzana",
    description:
      "Una manzana, descrita objetivamente, es una fruta sumamente popular, de forma “amanzanada”, con unos 10 centímetros de diámetro y 20 gramos de peso."
  },
  {
    name: "pera",
    description:
      "La pera es una fruta comestible que procede del Pyrus communis, un árbol que se conoce coloquialmente como peral común. Existen, de todas maneras, muchas clases de peras, que son producidas por otros árboles del género Pyrus."
  }
];
```
- 1. Metodo find() devuelve el primer elemento que cumple la funcion y en cualquier otro caso devuelve (undefined).
```
const selectFruit = fruits.find(fruit => fruit.name === "pera");
console.log(selectFruit); //devuelve todo el objeto de pera.
```
- 2. Metodo filter() crea una nueva array con los elementos que cumpla la condicion implementada en la funcion.
```
const selectFruit = fruits.filter(fruit => fruit.name.length > 4);
console.log(selectFruit); //devuelve todo el objeto platano y manzana.
```
- 3. Metodo map() crea una nueva array con los resultados de la funcion indicada aplicados a cada uno de sus elementos.
```
const selectFruit = fruits.map(fruit => {
  let newFormat = {};
  //en esta linea al nuevo objeto (newFormat) seguira con el(fruit.name) y
  //modificamos la propiedad (description) de cada objeto,
  //a un string nuevo ("here the description")
  newFormat[fruit.name] = "here the description";
  return newFormat;
});
console.log(selectFruit);
```
- 4. Metodo reduce() aplica una función a un acumulador (carry) y a cada valor (fruit) de un array (de izquierda a derecha) para reducirlo a un único valor ({}) en este ejemplo a un objeto y el (index) indica el indice actual que esta siendo procesado en el array.
```
const selectFruit = fruits.reduce((carry, fruit, index) => {
    console.log('fruit:',fruit,index,carry)
  return {
    ...carry,
    [index]: {
      name: fruit.name,
      description: fruit.description,
      origen: "france"
    }
  };
}, {});
console.log(selectFruit);
```

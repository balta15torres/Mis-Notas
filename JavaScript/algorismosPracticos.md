# Algorismos prácticos

### Encontrar la palabra más larga en un string
```
const findLongestWordLength = str => {
  var text = [];
  str.split(/\s/).forEach(item => text.push(item.length));
  return Math.max(...text);
};
findLongestWordLength("The quick brown fox jumped over the lazy dog");
```
### Devolver los números más grandes en array "2D"
```
const largestOfFour = arr => {
  const array = [];
  arr.forEach(item => array.push(Math.max(...item)));
  return array;
};
largestOfFour([[4, 5, 1, 3], [13, 27, 18, 26], [32, 35, 37, 39]]);
```
### Confirmar si el final de un string es igual que...
```
const confirmEnding = (str, target) => str.endsWith(target);
```
**También se podría**
```
const confirmEnding = (str, target) =>
  str.slice(str.length - target.length) === target;
confirmEnding("Bastian", "n");
```
### Repetir una string
```
const repeatStringNumTimes = (str, num) => (num <= 0 ? "" : str.repeat(num));
```
**También se podría**
```
const repeatStringNumTimes = (str, num) => {
  let accumulatedStr = "";
  while (num > 0) {
    accumulatedStr += str;
    num--;
  }
  return accumulatedStr;
};
repeatStringNumTimes("abc", 3);
```
### Truncar un string si es más larga que la longitud máxima
```
const truncateString = (str, num) =>
  str.length > num ? `${str.slice(0, num)} ${"..."}` : str;
truncateString("A-tisket a-tasket A green and yellow basket", 8);
```
### Comprobar si es un tipo de dato o no
```
const booWho = bool => typeof bool === "boolean";
booWho(null);
```
### Cambiar la primera letra de cada string a mayúscula y el resto minúscula
```
const titleCase = str =>
  str
    .split(" ")
    .map(
      item => `${item.charAt(0).toUpperCase()}${item.slice(1).toLowerCase()}`
    )
    .join(" ");
titleCase("I'm a little tea pot");
```
### Insertar en una array elementos en el índice "n"
```
const frankenSplice = (arr1, arr2, n) => {
  const arrayNew = [...arr2];
  arrayNew.splice(n, 0, arr1);
  return [].concat(...arrayNew);
};
frankenSplice([1, 2, 3], [4, 5, 6], 1);
```
### Eliminar todos los valores falsos de una array
```
const bouncer = arr => arr.filter(Boolean);
bouncer([7, "ate", "", false, 9]);
```
### Devolver el indice que le pertenece estar según su valor
```
const getIndexToIns = (arr, num) =>
  arr
    .concat(num)
    .sort((a, b) => a - b)
    .indexOf(num);
getIndexToIns([10, 20, 30, 40, 50], 40);
```
### Comprueba si el primer elemento del array contiene las letras del segundo elemento
```
const mutation = arr => {
  let test = arr[1].toLowerCase();
  let target = arr[0].toLowerCase();
  for (let i = 0; i < test.length; i++) {
    if (target.indexOf(test[i]) < 0) return false;
  }
  return true;
};
mutation(["hello", "ehj"]);
```
### Dividir un array en grupos de una longitud predefinidad en un array 2d
```
const chunkArrayInGroups = (arr, size) => {
  var arr2 = [];
  for (var i = 0; i < arr.length; i += size) {
    arr2.push(arr.slice(i, `${i}${size}`));
  }
  return arr2;
};
chunkArrayInGroups([0, 1, 2, 3, 4, 5, 6], 3);
```
### Encuentra el elemento diferente entre 2 arrays
```
const diffArray = (arr1, arr2) =>
  arr1
    .filter(item => !arr2.includes(item))
    .concat(arr2.filter(item => !arr1.includes(item)));
diffArray(
  ["andesite", "grass", "dirt", "pink wool", "dead shrub"],
  ["diorite", "andesite", "grass", "dirt", "dead shrub"]
);
```
### Busca en los argumentos de la function el array y el parametro para comparar,devuelve los elementos diferentes(accede a los argumentos de la function, por ese motivo no podemos usar las arrow function ("no vincula sus propios this,arguments,super o new.target";
**¡¡SON SIEMPRE ANÓNIMAS!!)**
```
function destroyer(arr) {
  const compare = [...arguments].slice(1, arguments.length);
  return arr
    .filter(item => !compare.includes(item))
    .concat(compare.filter(item => !arr.includes(item)));
}
destroyer([1, 2, 3, 1, 2, 3], 2, 3);
```
### Encuentra en un array los objetos que contengan los pares de nombre,valor especificados en el segundo argumento de la function
```
const whatIsInAName = (collection, source) =>
  collection.filter(item =>
    Object.keys(source)
      .map(key => item.hasOwnProperty(key) && item[key] === source[key])
      .reduce((a, b) => a && b)
  );
whatIsInAName(
  [
    { first: "Romeo", last: "Montague" },
    { first: "Mercutio", last: null },
    { first: "Tybalt", last: "Capulet" }
  ],
  { last: "Capulet" }
);
```
### Convertir un string en un modelo concreto en este caso ('the-andy-griffith-show')
```
const spinalCase = str =>
  str
    .split(/\s|_|(?=[A-Z])/)
    .join("-")
    .toLowerCase();
spinalCase("This Is Spinal Tap");
```
### Modificar un string segun su orden de entrada
```
const translatePigLatin = str => {
  let result = "";
  const exr = /[aeiou]/;

  if (str.match(/^[aeiou]/)) result = `${str}${"way"}`;
  else if (str.match(exr) === null) result = `${str}${"ay"}`;
  else
    result = `${str.substr(str.indexOf(str.match(exr)))}${str.substr(
      0,
      str.indexOf(str.match(exr))
    )}${"ay"}`;

  return result;
};
translatePigLatin("california")
```
### Realice una búsqueda y reemplace en el String, el segundo argumento proporcionado por el tercer argumento y devuelva el nuevo String modificado
```
const myReplace = (str, before, after) => {
  const exr = /^[A-Z]/
  const testing = exr.test(before) ?
    `${after[0].toUpperCase()}${after.slice(1, after.length)}` : after
  const lengthToDivide = str.indexOf(before) + before.length
  const firstPart = str.slice(0, lengthToDivide - before.length)
  const secondPart = `${testing}${str.slice(lengthToDivide)}`
  return `${firstPart}${secondPart}`
}
myReplace("Let us get back to more Coding", "Coding", "algorithms");
```

### Al String de ADN le falta el emparejamiento. Tome cada caracter,obtenga su par y devuelva los resultados como una matriz 2d.Los pares deben ser::'AT' y 'CG'
```
const pairElement = str => {
  const result = []
  str.split("").forEach(x => {
    if (x == 'G') result.push([x, "C"])
    else if (x == 'C') result.push([x, "G"])
    else if (x == 'A') result.push([x, "T"])
    else result.push([x, "A"])
  })
  return result
}
pairElement("GCG");
```
### Encuentra la letra que falta en el rango de letras que te proporcionan y devuelvela
```
const fearNotLetter = str => {
  const alphabet = "abcdefghijklmnopqrstuvwxyz";
  const firstLetter = str[0]
  const index = alphabet.indexOf(firstLetter)
  const model = alphabet.slice(index, str.length + index).split("")
  const searchRange = str.split("")

  return searchRange.length === 26 ? undefined : searchRange
    .filter(item => !searchRange.includes(item))
    .concat(model.filter(item => !searchRange.includes(item) ? item : undefined)).join()

}
fearNotLetter("stvwx")
```
### Toma dos o más arrays y devuelva una nueva array de valores únicos en el orden de las arrays proporcionadas originales
```
function uniteUnique(arr) {
  const result = [].concat(...arguments)
  return [...new Set(result)]
}
uniteUnique([1, 3, 2], [1, [5]], [2, [4]]);

const convertHTML = str => str.replace(/&/g, '&amp;').replace(/</g, '&lt;')
  .replace(/>/g, '&gt;').replace(/"/g, '&quot;').replace(/'/g, "&apos;");
convertHTML("Dolce & Gabbana");
```
### Suma los numeros de la secuencia de fibonacci 
```
const sumFibs = num => {
  let a = 0;
  let b = 1;
  for (i = 0; i < num; i++) {
    numeroTemporal = a;
    a = b;
    b = numeroTemporal + b;
  }
  return b
}
sumFibs(9);
```
### La secuencia de fibonacci en una array y la suma de toda la secuencia
```
const sumFibs = num => {
  const arrFib = [1, 1];
  let nextFib = 0;
  while ((nextFib = arrFib[0] + arrFib[1]) <= num) {
    arrFib.unshift(nextFib);
  }
  //arrFib contiene toda la secuencia
  return arrFib.reduce((a, b) => a + b)
}
sumFibs(8);
```
### Toma un string y modifica el valor segun condiciones:
- si el elemento se repite = '('
- si no =')'
```
const duplicateEncode = word => {
  let result = ''
  word = word.toLowerCase();
  for(i=0; i<word.length; i++)
  word.lastIndexOf(word[i]) == word.indexOf(word[i])? result += '(':result += ')'
      return result
}
duplicateEncode("recedder")
```














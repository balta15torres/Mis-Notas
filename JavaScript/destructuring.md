# Destructuración Array
### Cambiando orden de las variables;
```
var a = 1;
var b = 3;
[a, b] = [b, a];
console.log(a) = 3
console.log(a) = 1
```
#### Destructura una funcion retornando varios valores y ignorando uno de ellos
```
function f() {
  return [1, 2, 3];
}
var [a, , b] = f();
//console.log(a) = 1
//console.log(b) = 3
```
Podemos tomar todos los valores de retornos en una array;
```
var c = f();
console.log(c) = [1,2,3]
```

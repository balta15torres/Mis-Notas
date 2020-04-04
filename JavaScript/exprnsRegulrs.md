# Expresiones Regulares
Es el patron que debe cumplir un "String" para satisfacer con una necesidad del lado de la programacion.

### Patrón literal
- Patron literal; dentro de /<-->/ pondremos la expresion regular que buscamos y la coincidencia tendra que ser literal("exacta");
```
let waldoIsHiding = "Somewhere Waldo is hiding in this text.";
let waldoRegex = /Waldo/;
let result = waldoRegex.test(waldoIsHiding);
```
### Métodos
- Metodo de prueba (".test()") te devuelve un booleano ("true o false") si se cumple la coincidencia del patron.
```
let myString = "Hello, World!";
let myRegex = /Hello/;
let result = myRegex.test(myString);
```
- Método de extracion (".match()") te devuelve un array con la coincidencia que cumplen la expresion regular; a diferencia del metodo de prueba (".test()") dentro de los parentesis del metodo va la expresion regular.
```
let extractStr = "Extract the word 'coding' from this string.";
let codingRegex = /coding/i;
let result = extractStr.match(codingRegex);
```
- Método de reemplazar (".replace()") te devuelve la coincidencia que cumplen la expresion regular, reemplazando el texto que coincide; a este metodo se le pasa 2 argumentos: primero sera la expresion regular que desea buscar y segundo lo que vamos a reemplazar tras la coincidencia que puede ser cualquier cosa, por ejemplo: un "String", "Number", "Function", ect...
```
let fixRegex = /good/gi;
let replaceText = "okey-dokey";
let result = huhText.replace(fixRegex, replaceText);
```
## Metacaracteres

### Metacaracteres de sustitución
**Los que definen que esperamos en un determinado lugar ("del patron").**

Si queremos unir varias posibilidades de busqueda, utiliza el operador ("| OR").
```
let waldoIsHiding = "Somewhere Waldo is hiding in this text.";
let waldoRegex = /Waldo|in|text/;
let result = waldoRegex.test(waldoIsHiding);
```
Si no necesitas saber en el patron algun caracter exacto podemos usar el "MetaCaracter" comodin (".") y coincidirá con cualquier caracter/simbolo buscado.
```
let exampleStr = "Let's have fun with regular expressions!";
let unRegex = /.un/;
let result = unRegex.test(exampleStr);
```
#### Patron literal con flexibilidad; 
- dentro del patron literal añadir "MetaCaracter" [<-->] y dentro podemos definir un grupo de caracteres que buscamos que coincidan;
- para cuando queremos hacer coincidir un rango de caracteres se utiliza dentro de [<-->] el "MetaCaracter" ("-") y se puede usar tanto para letras como para numeros.
```
let quoteSample = "Be careful of the 6 errors in the previous code; I've only tried it correctly 4 times";
let vowelRegex = /[aeu1-9]/gi;
let result = quoteSample.match(vowelRegex);
```
- para cuando ¡NO! queremos hacer coincidir caracteres se utiliza dentro de [<-->] el caracter ("^"); hay que tener encuenta que encontrara todos los caracteres como por ejemplo: ("., !, [ ], @, /, "espacio" ").
```
let quoteSample = "3 blind mice.";
let myRegex = /[^3 aou.]/gi;
let result = quoteSample.match(myRegex);
```
### Metacaracteres de cantidad
**Los que definen cuantas veces aparece un determinado caracter.**

- Para cuando queremos saber si se repite el mismo caracter buscado, que esta delante de el "MetaCaracter" ("+"), una vez como minimo o repetidas veces; utiliza dentro de /<-->/ el "MetaCaracter" ("+") y podriamos extraer las veces que se repite; otra opcion seria utilizar el "MetaCaracter" ("*") si queremos saber si coincide cero o mas veces con el caracter que esta delante de el "MetaCaracter" ("*").
```
let crowd = "P1P2P3P4P5P6CCCP7P8P9";
let reCriminals = /[c]+/gi;
let reCriminals = /[c]*/gi;
let matchedCriminals = crowd.match(reCriminals);
```
- Para buscar una parte del patron que puede existir o no y si existe que solo sea una sola vez, utiliza dentro de /<-->/ el "MetaCaracter" ("?").En este ejemplo en los 2 casos devuelve "true".
```
let favWordAmerican = "favorite";
let favWordBritish = "favourite";
let favRegex = /favo.?rite/;
let result = favRegex.test(favWord);
```
- Para cuando queremos hacer coincidir un cierto numero de veces especifico el patron que esta delante del "MetaCaracteres" ("{<-->}"),podriamos hacerlo de 3 formas diferentes; utilizando dentro de /<-->/ los "MetaCaracteres" ("{<-->}") y dentro de estos caracteres especificar el:
    - 1.número inferior y superior de veces que queremos hacer coincidir el patron;
    - 2.podrias especificar solo el numero inferior de veces, seguido de una (",");
    - 3.también podrias especificar un cierto número exacto de veces;
```
let ohStr = "Ohhhhhhh no";
let ohRegex = /Oh{3,6}\s/i;
let ohRegex = /Oh{3,}\s/i;
let ohRegex = /Oh{3}\s/i;
let result = ohRegex.test(ohStr);
```
### Metacaracteres Delimitadores
**Los que definen los limites de la expresion regular.**

- Para buscar patrones en posiciones especificas en "String", utilizar dentro de /<-->/ el "MetaCaracteres" ("^") al principio de la expresion regular y te devuelve si coincide con el principio de la "String" y si queremos buscar al final de la "String" utilizar dentro de /<-->/ el caracter ("$") al final de la expresion regular.
```
let rickyAndCal = "Cal and Ricky both like racing";
let calRegex = /^Cal|racing$/;
let result = calRegex.test(rickyAndCal);
```
## Atajos
### Patrones, usando "characer Class" = ("clases de caracteres")
Digamos que son "atajos" o accesos directos de algunos patrones ya definidos y que su uso es muy comun; 

Por ejemplo:

- Buscan la coincidencia("alfanumérica")con mayusculas,minúsculas,numeros y ("_").

Estos 2 ejemplos son iguales;
```
let patronComun = /[A-Za-z0-9_]/gi;
let characterClass = /\w/gi;
```
- En es te caso seria la busqueda opuesta al anterior. La diferencia en la "characterClass" es la "W" en mayuscula.

Estos 2 ejemplos son iguales;
```
let patronComun = /[^A-Za-z0-9_]/gi;
let characterClass = /\W/gi;
```
- Buscan la coincidencia("numérica").

Estos 2 ejemplos son iguales;
```
let patronComun = /[0-9]/g;
let characterClass = /\d/g;
```
- En es te caso seria la busqueda opuesta al anterior. La diferencia en la

Estos 2 ejemplos son iguales;
    - "characterClass" es la "D" en mayuscula.
```
let patronComun = /[^0-9]/g;
let characterClass = /\D/g;
```
- Buscan la coincidencia con espacios en blanco,tabulacion,retorno de carro,

Estos 2 ejemplos son iguales;
    - avance de pag,nueva linea,tabulacion vertical.
```
let patronComun = /[ \r\t\f\n\v]/g;
let characterClass = /\s/g;
```
- En es te caso seria la busqueda opuesta al anterior. La diferencia en la

Estos 2 ejemplos son iguales;
    - "characterClass" es la "S" en mayuscula.
```
let patronComun = /[^ \r\t\f\n\v]/g;
let characterClass = /\S/g;
```
## FLAG("banderas")
**Puedes tener múltiples ("FLAG") en tu expresion regular**

- Para ignorar la coincidencias de la expresiones regulares entre mayúsculas y minúsculas utiliza la "FLAG" ("i") añadiendola despues del patron literal /<-->/.
```
let myString = "freeCodeCamp";
let fccRegex = /FrEeCoDeCamp/i;
let result = fccRegex.test(myString);
```
- Para una busqueda global de un patron que se puede repetir mas de una vez utiliza la "FLAG" ("g"); y con el metodo de extracion (".match()") te devuelve todas las coincidencias que se cumplen.
```
let twinkleStar = "Twinkle, twinkle, little star";
let starRegex = /Twinkle/gi;
let result = twinkleStar.match(starRegex);
```

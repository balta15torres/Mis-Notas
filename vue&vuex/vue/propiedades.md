# Propiedades Vue.js
Dado que los componentes son reutilizables de Vue, aceptanlas siguientes opciones::

### DATA(){return{}}
Debe ser una funcion en la instancia de Vue, que contendra la mayoria de datos que pueden ser pasados a un constructor de Vue y a si ser utilizados en cualquier componente.
 
### COMPUTED:{}
Propiedades computadas que debe de ser un objeto dentro de la instancia de Vue
que contendra las variables dinamicas que seran funciones que modificaran en
algun caso los datos renderizados por el Dom y almacenados en la propiedad
(data()). 
### METHODS
Metodos que debe de ser un objeto dentro de la instancia de Vue que contendra los metodos que seran funciones que modificaran en algun caso los datos renderizados por el Dom y almacenados en la propiedad (data()), similares a lasPropiedades computadas con la gran diferencia que las computadas son cacheadas basándose en sus dependencias.Esto significa que una computada solo se reevaluará cuando alguna de sus dependencias haya cambiado. 

### WATCH
Propiedades observadoras que debe de ser un objeto dentro de la instancia de Vue que contendra los metodos que seran funciones que modificaran en algun caso los datos renderizados por el Dom y almacenados en la propiedad (data()), lo utilizaremos a diferencia de las computadas o metodos, cuando quieres realizar operaciones asíncronas o costosas en respuesta a los cambios de los datos como por ejemplo(acceder a una API). 

### FILTER:{}
Filtros que debe de ser un objeto que contendra las funciones para cambiar los valores de los datos que vamos a imprimir en las interpolaciones, separando nuestra expresión con el carácter('|') y luego el nombre del filtro ('funcion') que queremos usar.

Podemos definir los filtros de forma global ('fuera de la instancia de Vue') o de forma local('dentro de la instancia Vue'). Es posible utilizar varios filtros a la vez, teniendo en cuenta el orden de los filtros, dependiendo del resultado que busquemos.

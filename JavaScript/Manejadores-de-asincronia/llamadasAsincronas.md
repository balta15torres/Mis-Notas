# Asincronia

## Callback("ES5")

Ejemplo con Callback, se utiliza o mejor dicho se utilizaba para manejar codigo asincrono; 

En este ejemplo estamos simulando una consulta a una base de datos con 'NodeJS'.Como vemos en la primera function,se hace la consulta;la respuesta de esta consulta tardara un tiempo("asincrono");para manejar esa asincronia se pasa en el metodo de'NodeJS'(.findById()) como parametro,la funcion que sera el CALLBACK;por lo que podemos observar en el ejemplo es una consulta relativamente facil(hacer una busqueda de un Usuario por ID) y la verdad que se hace algo dificil de leer y no seria muy mantenible.
```
function requestHandler(request, response) {
  User.findById(request.userId, function (err, user) {
    if (err) {
      response.send(err);
    } else {
      Tasks.findById(user.tasksId, function (err, tasks) {
        if (err) {
          return response.send(err);
        } else {
          tasks.completed = true;
          tasks.save(function (err) {
            if (err) {
              return response.send(err);
            } else {
              response.send('Task Completed')
            }
          })
        }
      })
    }
  })
}
```
## Promise
Vamos a pasar el ejemplo de 'CALLBACK' a 'PROMISE';Como hemos comentado antes sera una consulta sencilla a una base de datos con 'NodeJS'; En este caso vamos a manejar esta asincronia con los metodos de dichas promesas:(.then() & .catch()); con '.then()' vamos a manejar los datos de la consulta en el caso que todo haya ido bien y en el caso contrario usaremos'.catch()'para retornar algun error;lo bueno de usar 'PROMISE':codigo mas facil de enteder y solo tendremos un'.catch()' para manejar cualquier error, en el caso de que la consulta realizada en el'.then()'no haya sido  resuelta. 
```
function requestHandler(request, response) {
  User.findById(request.userId)
    .then(user => Tasks.findById(user.tasksId))
    .then(tasks => {
      tasks.completed = true;
      return tasks.save()
    })
    .then(() => response.send('Task Completed'))
    .catch(erros => response.send(erros))
}
```
## ASYNC-AWAIT 
Vamos a realizar los ejemplos anteriores, pero ahora la consulta la manejaremos con'ASYNC-AWAIT';

Utiliza la palabra clave 'AWAIT' para manejar la consulta asincrona, añadiendola al principio de dicha consulta y esperaremos la respuesta si todo salio bien; Una de las ventajas es que podemos  almacenar la respuesta de la consulta en una variable. Para que la palabra clave 'AWAIT' este  disponible tenemos que añadir la palabra clave 'ASYNC' al principio de la 'function';

En este caso vamos a manejar el error con los metodos de JS(try{} & catch(){}), con 'try{}' vamos a manejar los datos de la consulta en el caso que todo haya ido bien y en el caso contrario usaremos 'catch(){}' para retornar algun error.
```
async function requestHandler(request, response) {
  try{
    const user = await User.findById(request.userId)
    const tasks = await Tasks.findById(user.tasksId)
    await tasks.save()
    response.send('Task Completed')
  }
  catch(err) {
    response.send(err)
  }
}
```

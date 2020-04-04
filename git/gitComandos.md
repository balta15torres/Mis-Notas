# TUTORIAL GIT
### 1.¿Que es "Git"?
- Es un sistema de control de versiones(herramienta de almacenamiento de codigo fuente)
### 2.¿Que es "Commit"?
- La palabra que utiliza "Git" para referirse a los cambios que registramos en un repositorio.
### 3.¿Que es ramificar el trabajo?
- Para trabajar en paralelo a la linea de desarrollo principal("codigo limpio"); trabajar en varias cosas a la vez("multitasking") y una vez terminado fusionar todos los trabajos.
## COMANDOS DE GIT PARA DEJAR CAMBIOS Y RECUPERARLOS EN LA RAMA AL CAMBIAR ENTRE RAMAS 
- git stash: Para dejar los cambios ocultos en la rama y poder cambiar de a otra rama, podremos dejar ocultos todos los cambios deseados.
- git stash list: Para enumerar los cambios que estan ocultos en la rama.
- git stash aply: Para recuperar todos los cambios que estan ocultos en la rama.
- git stash pop: Para recuperar los ultimos cambios ocultos que teniamos en la rama antes de cambiar.

## COMANDOS DE GIT PARA "COMMIT"
- git add <nombre del archivo>: Para cuando queremos decirle a "Git" que hemos realizado un cambio en algun archivo.
- git status: Para ver una lista con el estado de los cambios que hemos realizado en alguno de nuestros archivos.Hay 2 estados:
    - 1.Si no hemos realizado un "git add", "Git" sabe que hemos realizado un cambio, pero no esta registrado en el "stage","aparece en color rojo".
	- 2.Despues de realizar un "git add", "aparece en color verde" y ya estara registrado el cambio en el "stage" y preparado para ser enviado en el siguiente "commit".
> *"stage":Es un area temporal en el que estan los archivos modificados y previamente registrados con "git add" asta que realizamos el "commit".*
- git commit: Para subir a nuestro repositorio nuestro cambios que estan registrados en el "stage" y deberia ir con un brebe comentario sobre el cambio que hemos realizado.
	 - git commit --amend: podemos volver al ultimo "commit"; por si se a olvidado registrar algun cambio y queremos revertilo.*
- git log: Para ver un historial sobre todos los "commit" realizados
	 - 1. git log --oneline --decorate: podemos ver el historial sobre todos los "commit" realizados, pero solo en una linea con el nombre, el codigo del "commit" y y el nombre de la rama. 
	 - 2. git log --oneline --decorate --all: para ver todos los "commit".
	 - 3. git log --oneline --decorate --all --graph: para ver todos los "commit" y visualizar mediante un "arbol" las ramificaciones.	
- git diff: Para ver en detalle una lista de cambios que he hecho en mis archivos y todavia no estan registrados en el "stage".
    - git diff <codigo del "commit"> <codigo del "commit">: Para comparar en detalle entre dos "commit".
- git checkout -- <nombre del archivo>: Para cuando queremos descartar alguna modificacion de algun archivo y queremos recuperar el archivo antes de la modificacion, pero sin estar registrado el cambio en el "stage".
- git reset HEAD <nombre del archivo>: Para cuando queremos descartar alguna modificacion de algun archivo y  en este caso el cambio esta registrado en el "stage";Seguido el cambio ya no estara registrado en el "stage" y podremos hacer "git checkout -- <nombre del archivo>".
- git reset <codigo del "commit">: Para eliminar el "commit" correspondiente a ese codigo y volver un paso antes del "commit"; cuando fue registrado el cambio en el "stage" con el "git add" hecho.
	 - 1. git reset --hard <codigo del "commit"> : Para eliminar el "commit", tambien del "stage" y no aparecera en el "git status".*
	 - 2. git reset --soft <codigo del "commit"> : Para eliminar el "commit", pero en este caso lo mantiene en el "state".*
- git revert <codigo del "commit"> ó HEAD: Para descartar completamente los cambios realizados por un "commit" y dejarlo en el estado anterior a el.
	 - git revert --no-commit <codigo del "commit"> ó HEAD:Con este comando le estamos diciendo a "Git" que desaga los cambios, pero que no haga despues un "commit" y dejara los cambios en el "stage", acontinuacion hay que hacer -git revert --continue: para terminar de hacer mi reversion y tendremos un unico "commit".*

## COMANDOS DE GIT PARA MANIPULAR "RAMAS"
- git branch -h: Para ver todos los comandos que se puede hacer con "git branch".	
- git branch: Para ver una lista de ramas creadas.
- git branch -a: Para ver una lista de las ramas "remotes y locales".
- git branch -r: Para ver una lista de las ramas "remotes".
- git branch -v: Para ver una lista de las ramas "locales".
- git branch <nombre de la nueva rama>: Para crear una nueva rama.
	- git checkout -b <nombre de la nueva rama>: Para crear una nueva rama y cambiar a ella.
- git checkout <nombre de la rama>: Para cambiar entre ramas.
- git branch -m <nombre antiguo de la rama> <nuevo nombre de la rama>: Para modificar el nombre de una rama anteriormente creada.
- git branch -d <nombre de la rama>: Para eliminar una rama.
- git push <nombre rama remote> :<nombre rama local>
- git merge <nombre rama origen>: Para realizar un fusion entre ramas "merge"; Tendremos una rama de origen con una serie de cambios y una rama de destino a la que le queremos implementar los cambios de  rama de origen. Tendremos que realizar los siguientes pasos:
    - 1. Ir a la rama de destino.
    - 2.En ella ejecutamos el camando -git merge <nombre rama origen>.
- git merge --abort: Para volver un paso antes del "merge" ò -git checkout.
> *Los repositorios remotos son versiones de tu proyecto que se encuentran alojados en Internet o en algún punto de la red.*
- git remote: Para ver una lista de los "remotos" que estan especificados.
- git remote -v: Muestra la URL asociada a cada repositorio remoto.
- git remote rm <nombre repositorio remote>: Para borrar repositorio remoto.
- git remote update origin --prune: Para borrar todos los repositorios remotos.

## COMO USAR "TAGS"
Podemos gestionar las distintas versiones del codigo de un proyecto con "tags"; con otras palabras para marcar y identificar algun "commit" en particular.
	
## CREAR,VER Y ELIMINAR "ALIAS" PARA "GIT"
Podemos crear "alias" globales para algunos de los comandos de "Git" que son bastantes extensos, con el comando;
- git config --global alias.<nombre del "alias"> '<comando git que vamos asignar al alias>'

#### Para todos los "alias" creados para "Git", con el comando;
- git config --global --get-regexp alias

#### Para borrar "alias" creados para "Git", con el comando;
- git config --global --unset alias.<nombre del "alias">











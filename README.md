# EditorTextual

## Descripción de la actividad
Aprenderás a guardar información de forma persistente a una unidad de disco para
posteriormente recuperarla. Aprenderás los modos de acceso a los ficheros textuales
(comprensibles por humanos).

- Se deberá entregar con la nomenclatura y formato correcto.
- Todas las variables deberán comenzar por minúscula. (-0.5 puntos por cada variable con
un nombre erróneo )
- Todas las funciones deberán comenzar por minúscula (-0.5 puntos por cada nombre de
función erróneo).
- El ejercicio deberá poder ejecutarse sin problema, es decir, no deben existir errores en la
compilación (en caso de tener errores el código el ejercicio evaluable será suspenso).
- Nota: Es mejor entregar pocos apartados que estén bien, que muchos y no compile.

## Desarrollo de la actividad
La empresa EDITORTEXTUAL nos pide que implementemos un editor de texto para los
ordenadores más antiguos de su empresa.
Nos indican que debe ser implementado mediante el lenguaje de programación Java.

En primer lugar, se mostrará el siguiente menú:

*********************************
EDITOR DE TEXTO
*********************************
Seleccione una opción:
1) Crear un fichero
2) Editar un fichero
3) Borrar un fichero
4) Crear una carpeta
5) Borrar una carpeta
0) Salir
Opción:_
(El Sistema esperará a que el usuario introduzca un int con la opción deseada).

Nota: TODOS LOS FICHEROS Y CARPETAS SE CREARÁN DENTRO DEL PROPIO PROYECTO DE
JAVA

1) Crear un fichero (2 puntos).
El sistema mostrará lo siguiente:
Introduzca el nombre del nuevo fichero:
(El usuario introducirá la ruta de un fichero).
A. En caso de que el fichero NO exista creará un fichero nuevo vacío.
B. En el caso de que el fichero exista el sistema le preguntará al usuario
Fichero existente ¿Desea sobrescribirlo?
(El usuario escribirá en un String el texto Si o No)
a. En caso de escribir que NO el programa mostrará de nuevo el menú.
b. En el caso de escribir SI sobrescribirá el fichero (Abrirlo en modo
escritura y machacará el contenido con el String vacío “”).

2) Editar un fichero (2 puntos)
El sistema mostrará lo siguiente:
Introduzca el nombre del fichero a editar:
(El usuario introducirá la ruta de un fichero).
A. En el caso de que el fichero NO exista, el programa indicará “Fichero
inexistente” y mostrará de nuevo el menú.
B. En caso de que el fichero exista, el sistema mostrará lo siguiente:
Introduzca el texto que desea añadir al fichero:
(El usuario introducirá un texto y lo almacenará en una variable de tipo String).
El pulsar Enter el programa AÑADIRÁ al final del fichero el texto introducido.
Posteriormente mostrará el texto “Documento editado correctamente” y tras
esto mostrará el menú principal.

3) Borrar un fichero (2 puntos)
El sistema mostrará lo siguiente:
Introduzca el nombre del fichero a borrar:
(El usuario introducirá la ruta de un fichero).
A. En el caso de que el fichero NO exista, el programa le indicará “Fichero
inexistente” y mostrará de nuevo el menú.
B. En caso de que el fichero exista, el sistema mostrará lo siguiente:
¿Está seguro de que desea borrarlo (Afirmación S)?
(El usuario introducirá un texto y lo almacenará en una variable de tipo String).
a. Si el usuario escribe S el fichero se borrará del sistema y mostrará el
texto “Fichero eliminado correctamente“ y volverá al menú
b. Si el usuario escribe cualquier otra cosa el sistema no borrara el fichero,
mostrar el texto “El fichero no se borró del sistema” y mostrará el
menú.

4) Crear una carpeta (1.5 punto)
El sistema mostrará lo siguiente:
Introduzca el nombre de la carpeta a crear:
(El usuario introducirá la ruta de una carpeta).
A. En el caso de que la carpeta exista, el programa le indicará “Carpeta ya
existente” y mostrará de nuevo el menú.
B. En caso de que en la carpeta NO exista el programa creará la carpeta en el
sistema y mostrará el mensaje “Carpeta creada correctamente” y volverá al
menú.
5) Borrar una carpeta (1.5 punto)
El sistema mostrará lo siguiente:
Introduzca el nombre de la carpeta a borrar:
(El usuario introducirá la ruta de una carpeta).
A. En el caso de que la carpeta NO exista, el programa le indicará “La carpeta no
existe” y mostrará de nuevo el menú.
B. En caso de que la carpeta exista, el sistema mostrará lo siguiente:
¿Está seguro de que desea borrar la carpeta (Afirmación S)?
(El usuario introducirá un texto y lo almacenará en una variable de tipo String).
a. Si el usuario escribe S la carpeta se borrará del sistema, y mostrará el
texto “Carpeta borrada correctamente” y volverá al menú
b. Si el usuario escribe cualquier otra cosa, se escribirá “La carpeta no se
borró del sistema” y posteriormente se mostrará el menú.

0) Salir (1 punto)
El programa mostrará indefinidamente el menú hasta que el usuario escribe la opción
0. Cuando la opción del usuario es 0, el programa mostrará el mensaje “Programa
finalizado” y el programa se acabará.

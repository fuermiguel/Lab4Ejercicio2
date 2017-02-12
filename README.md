# Lab4Ejercicio2
Almacenamiento en fichero

Vamos a leer y escribir en un archivo de texto. La escritura la haremos añadiendo 
al final del archivo, mientras que la lectura la haremos leyendo línea a línea, de 
manera similar a como se indica en el siguiente enlace.

    Crea un proyecto con una única actividad que mostrará un EditText cuyo texto 
    será recogido cada vez que se pulse un Button que habrá debajo. Dicho texto 
    será añadido a un archivo de texto llamado mytextfile.txt. 
    Para añadir texto a un archivo primero lo abriremos con 
    openFileOutput(FILENAME,Context.MODE_APPEND)) y después utilizaremos 
    el método append(...) de OutputStreamWriter.
    ¿Cuándo abrimos el archivo? Recordemos que la actividad puede pasar a
    inactiva en cualquier momento y que puede no volver a recuperarse. 
    ¿Cuándo nos conviene cerrar el archivo?
    Debajo del campo de texto y del botón, vamos a añadir un TextEdit que ocupe 
    el resto de la pantalla. Lo haremos pulsable con el método setClickable(true)
    y cada vez que se haga click sobre él, leeremos el archivo línea a línea y lo
    mostraremos entero.
    El archivo debe almacenarse en la tarjeta externa del dispositivo, de manera 
    similar a como se indica en el siguiente enlace.

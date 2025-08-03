
# Cambios realizados a la PruebaAudioVisual





## Documentation

[Documentation](https://linktodocumentation)

1. Aplicación del patron MVC
Cree 5 paquetes por separados que realizaban lo siguiente: 
controller: Aqui se encuentra la logica del programa, ademas es un puente para conectar la vista y el modelo
main: Aquí se encuentra el metodo main para ejecutar el programa
model: Contiene todas las clases de dominio, es decir, contiene los datos y contenidos.
útil: Este se encarga del manejo separado de la entrada y salida de archivos CSV
view: Este se encarga del manejo de la interaccion entre el usuario y la consola

2. Codigo limpio y principios de solid
Creee clases independientes para quitar las clases internas innecesarias
Realice la encapsulacion de la manera adecuada
Cree metodos pequeños para definirlos de mejor manera
Use la herencia y polimorfismo para la clase abstrata ContenidoAudiovisual

3. Manejo de archivos
Implemente meodos para guardar y leer los contenidos desde y hacia archivos CSV
Implemente un manejo basico de las excepciones

4. La interaccion con el usuario
La impresión de error al ingresar datos invalidos
Impresión de un menu para que el usuario elija la opcion que desea realizar

5. Pruebas unitarias con JUnit 5
Pruebas con la clase Pelicula, ControladorContenido y ArchivoContenidoAV
Prueba para el manejo de archivos, la verificacion de este y la lectur correcta de los datos.



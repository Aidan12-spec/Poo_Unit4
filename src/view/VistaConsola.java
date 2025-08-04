package view;

import controller.ControladorContenido;
import model.*;
import java.util.List;
import java.util.Scanner;

public class VistaConsola {
    private ControladorContenido controlador;
    private Scanner scanner;

    public VistaConsola(ControladorContenido controlador){
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = -1;
        do {
            System.out.println("-------------------- MENÚ AUDIOVISUAL --------------------");
            System.out.println("1. Cargar contenidos desde archivo");
            System.out.println("2. Guardar contenidos en archivo");
            System.out.println("3. Mostrar todos los contenidos");
            System.out.println("4. Agregar nuevo contenido");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                	System.out.println();
                    System.out.print("Ingrese la ruta del archivo para cargar: ");
                    String ruta = scanner.nextLine();
                    controlador.cargarContenidosDesdeArchivo(ruta);
                    break;
                case 2:
                	System.out.println();
                    System.out.print("Ingrese la ruta del archivo para guardar: ");
                    String rutaGuardar = scanner.nextLine();
                    controlador.guardarContenidosEnArchivo(rutaGuardar);
                    break;
                case 3:
                	System.out.println();
                    controlador.mostrarContenidos();
                    break;
                case 4:
                	System.out.println();
                    agregarNuevoContenido();
                    break;
                case 0:
                	System.out.println();
                    System.out.println("		     Saliendo...");
                    System.out.println("-------------------- Usted ha salido del programa --------------------");
                    break;
                default:
                    System.out.println("La opción seleccionada es inválida, intente de nuevo.");
            }
        } while (opcion != 0);
    }

    public void mostrarContenidos(List<ContenidoAudioVisual> lista) {
        for (ContenidoAudioVisual contenido : lista) {
            contenido.mostrarDetalles();
        }
    }

    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    private void agregarNuevoContenido(){
    	System.out.println();
        System.out.println("Seleccione tipo de contenido a agregar:");
        System.out.println("1. Película");
        System.out.println("2. Serie de TV");
        System.out.println("3. Documental");
        System.out.println("4. Video Youtube");
        System.out.println("5. Publicacion Instagram");
        System.out.print("Seleccione la opción a ejecutar: ");

        int tipo = Integer.parseInt(scanner.nextLine());

        try {
            switch(tipo){
                case 1:
                	System.out.println();
                    System.out.print("Título: ");
                    String tituloP = scanner.nextLine();
                    System.out.print("Duración (minutos): ");
                    int duracionP = Integer.parseInt(scanner.nextLine());
                    System.out.print("Género: ");
                    String generoP = scanner.nextLine();
                    System.out.print("Estudio: ");
                    String estudio = scanner.nextLine();
                    System.out.print("Nombre del actor principal: ");
                    String actor = scanner.nextLine();
                    controlador.agregarContenido(new Pelicula(tituloP, duracionP, generoP, estudio, actor));
                    break;

                case 2:
                	System.out.println();
                    System.out.print("Título: ");
                    String tituloS = scanner.nextLine();
                    System.out.print("Duración (minutos): ");
                    int duracionS = Integer.parseInt(scanner.nextLine());
                    System.out.print("Género: ");
                    String generoS = scanner.nextLine();
                    System.out.print("Número de temporadas: ");
                    int temporadas = Integer.parseInt(scanner.nextLine());
                    controlador.agregarContenido(new SerieDeTV(tituloS, duracionS, generoS, temporadas));
                    break;

                case 3:
                	System.out.println();
                    System.out.print("Título: ");
                    String tituloD = scanner.nextLine();
                    System.out.print("Duración (minutos): ");
                    int duracionD = Integer.parseInt(scanner.nextLine());
                    System.out.print("Género: ");
                    String generoD = scanner.nextLine();
                    System.out.print("Tema: ");
                    String temaD = scanner.nextLine();
                    System.out.print("Nombre del investigador: ");
                    String investigador = scanner.nextLine();
                    controlador.agregarContenido(new Documental(tituloD, duracionD, generoD, temaD, investigador));
                    break;

                case 4:
                	System.out.println();
                    System.out.print("Título: ");
                    String tituloY = scanner.nextLine();
                    System.out.print("Duración (minutos): ");
                    int duracionY = Integer.parseInt(scanner.nextLine());
                    System.out.print("Género: ");
                    String generoY = scanner.nextLine();
                    System.out.print("Nombre del autor: ");
                    String autorY = scanner.nextLine();
                    System.out.print("Fecha (dd/mm/aaaa): ");
                    String fechaY = scanner.nextLine();
                    System.out.print("Tema: ");
                    String temaY = scanner.nextLine();
                    controlador.agregarContenido(new Youtube(tituloY, duracionY, generoY, autorY, fechaY, temaY));
                    break;

                case 5:
                	System.out.println();
                    System.out.print("Título: ");
                    String tituloI = scanner.nextLine();
                    System.out.print("Duración (minutos): ");
                    int duracionI = Integer.parseInt(scanner.nextLine());
                    System.out.print("Género: ");
                    String generoI = scanner.nextLine();
                    System.out.print("Nombre del autor: ");
                    String autorI = scanner.nextLine();
                    System.out.print("Fecha (dd/mm/aaaa): ");
                    String fechaI = scanner.nextLine();
                    System.out.print("Tema: ");
                    String temaI = scanner.nextLine();
                    controlador.agregarContenido(new Instagram(tituloI, duracionI, generoI, autorI, fechaI, temaI));
                    break;

                default:
                	System.out.println();
                    System.out.println("La opción seleccionada no es válida. Intentelo de nuevo.");
            }
        } catch (Exception e) {
            System.out.println("Hay un error al ingresar datos: " + e.getMessage());
        }
    }
}

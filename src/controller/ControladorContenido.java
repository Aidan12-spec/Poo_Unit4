package controller;

import model.*;
import util.ArchivoContenidoAV;
import view.VistaConsola;
import java.util.ArrayList;
import java.util.List;

public class ControladorContenido {
    private List<ContenidoAudioVisual> listaContenidos;
    private VistaConsola vista;

    public ControladorContenido() {
        this.listaContenidos = new ArrayList<>();
        this.vista = new VistaConsola(this);
    }

    public void iniciar() {
        vista.mostrarMenu();
    }

    public void cargarContenidosDesdeArchivo(String ruta) {
        List<ContenidoAudioVisual> contenidosCargados = ArchivoContenidoAV.leerContenidosDesdeArchivo(ruta);
        if (contenidosCargados.isEmpty()) {
            vista.mostrarMensaje("No se pudo cargar el contenidos o el archivo está vacío.");
        } else {
            listaContenidos.clear();
            listaContenidos.addAll(contenidosCargados);
            vista.mostrarMensaje("El contenidos se ha cargado exitosamente.");
        }
    }

    public void guardarContenidosEnArchivo(String ruta) {
        ArchivoContenidoAV.guardarContenidosEnArchivo(listaContenidos, ruta);
        vista.mostrarMensaje("El contenidos se ha guardado exitosamente.");
    }

    public void mostrarContenidos() {
        if (listaContenidos.isEmpty()) {
            vista.mostrarMensaje("No hay contenidos para mostrar.");
        } else {
            vista.mostrarContenidos(listaContenidos);
        }
    }

    public void agregarContenido(ContenidoAudioVisual contenido){
        listaContenidos.add(contenido);
        vista.mostrarMensaje("El contenido ha sido agregado correctamente.");
    }

}
  

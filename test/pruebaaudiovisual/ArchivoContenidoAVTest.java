package pruebaaudiovisual;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import model.*;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import model.ContenidoAudioVisual;
import model.Pelicula;
import model.SerieDeTV;
import util.ArchivoContenidoAV;

class ArchivoContenidoAVTest {

    private final String RUTA_PRUEBA = "prueba_contenidos.csv";

    @Test
    void testGuardarYLeerContenidos() throws Exception {
        
        Pelicula pelicula = new Pelicula("Avatar", 125, "Accion", "20th Century Studios", "Giovanni Ribisi");
        SerieDeTV serie = new SerieDeTV("Friends", 22, "Comedia", 10);
        List<ContenidoAudioVisual> lista = List.of(pelicula, serie);

        
        ArchivoContenidoAV.guardarContenidosEnArchivo(lista, RUTA_PRUEBA);

        
        File archivo = new File(RUTA_PRUEBA);
        assertTrue(archivo.exists());

        List<ContenidoAudioVisual> leidos = ArchivoContenidoAV.leerContenidosDesdeArchivo(RUTA_PRUEBA);

        assertEquals(2, leidos.size());
        assertTrue(leidos.get(0) instanceof Pelicula);
        assertEquals("Avatar", leidos.get(0).getTitulo());
        assertTrue(leidos.get(1) instanceof SerieDeTV);
        assertEquals("Friends", leidos.get(1).getTitulo());

        Files.deleteIfExists(archivo.toPath());
    }
}

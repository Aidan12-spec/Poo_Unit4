package pruebaaudiovisual;

import model.Pelicula;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PeliculaTest {

    @Test
    void testConstructorYGetters() {
        Pelicula pelicula = new Pelicula("Avatar", 125, "Accion", "20th Century Studios", "Giovanni Ribisi");

        // Test valores correctos asignados en constructor
        assertEquals("Avatar", pelicula.getTitulo());
        assertEquals(125, pelicula.getDuracionEnMinutos());
        assertEquals("Accion", pelicula.getGenero());
        assertEquals("20th Century Studios", pelicula.getEstudio());
        assertEquals("Giovanni Ribisi", pelicula.getActor().getNombre());
    }

    @Test
    void testSetters() {
        Pelicula pelicula = new Pelicula("Avatar", 125, "Accion", "20th Century Studios", "Giovanni Ribisi");

        pelicula.setTitulo("Titanic");
        pelicula.setDuracionEnMinutos(195);
        pelicula.setGenero("Drama");
        pelicula.setEstudio("Paramount");
        pelicula.getActor().setNombre("Leonardo DiCaprio");

        assertEquals("Titanic", pelicula.getTitulo());
        assertEquals(195, pelicula.getDuracionEnMinutos());
        assertEquals("Drama", pelicula.getGenero());
        assertEquals("Paramount", pelicula.getEstudio());
        assertEquals("Leonardo DiCaprio", pelicula.getActor().getNombre());
    }

    @Test
    void testMostrarDetalles() {
        Pelicula pelicula = new Pelicula("Avatar", 125, "Accion", "20th Century Studios", "Giovanni Ribisi");

        assertDoesNotThrow(() -> pelicula.mostrarDetalles());
    }
}

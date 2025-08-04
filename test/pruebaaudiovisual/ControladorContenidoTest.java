package pruebaaudiovisual;

import controller.ControladorContenido;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Pelicula;

class ControladorContenidoTest {

    private ControladorContenido controlador;

    @BeforeEach
    void setUp() {
        controlador = new ControladorContenido();
    }

    @Test
    void testAgregarYMostrarContenidos() {
        Pelicula p = new Pelicula("Avatar", 125, "Accion", "20th Century Studios", "Giovanni Ribisi");
        controlador.agregarContenido(p);

        assertDoesNotThrow(() -> controlador.mostrarContenidos());
    }
}

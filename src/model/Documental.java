package model;

public class Documental extends ContenidoAudioVisual {
    private String tema;
    private Persona investigador;

    public Documental(String titulo, int duracion, String genero, String tema, String nombreInvestigador) {
        super(titulo, duracion, genero);
        this.tema = tema;
        this.investigador = new Persona(nombreInvestigador);
    }

    public String getTema() { return tema; }
    public void setTema(String tema) { this.tema = tema; }
    public Persona getInvestigador() { return investigador; }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + tema);
        System.out.println("Investigador: " + investigador.getNombre());
        System.out.println();
    }
}

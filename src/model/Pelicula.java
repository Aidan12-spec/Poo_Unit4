package model;

public class Pelicula extends ContenidoAudioVisual {
    private String estudio;
    private Persona actor;

    public Pelicula(String titulo, int duracion, String genero, String estudio, String nombreActor) {
        super(titulo, duracion, genero);
        this.estudio = estudio;
        this.actor = new Persona(nombreActor);
    }

    public String getEstudio() { return estudio; }
    public void setEstudio(String estudio) { this.estudio = estudio; }
    public Persona getActor() { return actor; }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + estudio);
        System.out.println("Actor: " + actor.getNombre());
        System.out.println();
    }
}

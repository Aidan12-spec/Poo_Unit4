package model;

public class Instagram extends ContenidoAudioVisual {
    private Persona autor;
    private Fecha fecha;
    private String tema;

    public Instagram(String titulo, int duracion, String genero, String nombreAutor, String diaFecha, String tema) {
        super(titulo, duracion, genero);
        this.autor = new Persona(nombreAutor);
        this.fecha = new Fecha(diaFecha);
        this.tema = tema;
    }

    public Persona getAutor() { return autor; }
    public Fecha getFecha() { return fecha; }
    public String getTema() { return tema; }
    public void setTema(String tema) { this.tema = tema; }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la publicación:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + autor.getNombre());
        System.out.println("Tema: " + tema);
        System.out.println("Fecha: " + fecha.getDia());
        System.out.println();
    }
}

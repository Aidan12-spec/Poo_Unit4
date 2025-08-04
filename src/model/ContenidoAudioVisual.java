package model;

public abstract class ContenidoAudioVisual {
    private static int contar = 0;
    private final int id;
    private String titulo;
    private int duracionEnMinutos;
    private String genero;

    public ContenidoAudioVisual(String titulo, int duracionEnMinutos, String genero){
        this.id = contar++;
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.genero = genero;
    }
    // Getters y setters
    public int getId() {return id;}
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public int getDuracionEnMinutos() {return duracionEnMinutos;}
    public void setDuracionEnMinutos(int duracionEnMinutos) {this.duracionEnMinutos = duracionEnMinutos;}
    public String getGenero() {return genero;}
    public void setGenero(String genero) {this.genero = genero;}
     public abstract void mostrarDetalles();
}

package model;

public class SerieDeTV extends ContenidoAudioVisual {
    private int temporadas;

    public SerieDeTV(String titulo, int duracion, String genero, int temporadas) {
        super(titulo, duracion, genero);
        this.temporadas = temporadas;
    }

    public int getTemporadas() { return temporadas; }
    public void setTemporadas(int temporadas) { this.temporadas = temporadas; }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la serie:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Temporadas: " + temporadas);
        System.out.println();
    }
}

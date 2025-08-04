package util;

import model.*;
import java.io.*;
import java.util.*;

public class ArchivoContenidoAV {

    public static List<ContenidoAudioVisual> leerContenidosDesdeArchivo(String rutaArchivo) {
        List<ContenidoAudioVisual> contenidos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                ContenidoAudioVisual contenido = crearContenidoDesdeLinea(linea);
                if (contenido != null) {
                    contenidos.add(contenido);
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
        return contenidos;
    }

    private static ContenidoAudioVisual crearContenidoDesdeLinea(String linea) {
        String[] campos = linea.split(",");
        String tipo = campos[0];
        try {
            switch (tipo) {
                case "Pelicula":
                    return new Pelicula(campos[1], Integer.parseInt(campos[2]), campos[3], campos[4], campos[5]);
                case "SerieDeTV":
                    return new SerieDeTV(campos[1], Integer.parseInt(campos[2]), campos[3], Integer.parseInt(campos[4]));
                case "Documental":
                    return new Documental(campos[1], Integer.parseInt(campos[2]), campos[3], campos[4], campos[5]);
                case "Youtube":
                    return new Youtube(campos[1], Integer.parseInt(campos[2]), campos[3], campos[4], campos[5], campos[6]);
                case "Instagram":
                    return new Instagram(campos[1], Integer.parseInt(campos[2]), campos[3], campos[4], campos[5], campos[6]);
                default:
                    System.out.println("Tipo desconocido: " + tipo);
                    return null;
            }
        } catch (Exception e) {
            System.out.println("Error parseando linea: " + linea + " -> " + e.getMessage());
            return null;
        }
    }

    public static void guardarContenidosEnArchivo(List<ContenidoAudioVisual> contenidos, String rutaArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (ContenidoAudioVisual c : contenidos) {
                bw.write(convertirContenidoACSV(c));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error escribiendo archivo: " + e.getMessage());
        }
    }

    private static String convertirContenidoACSV(ContenidoAudioVisual contenido) {
        if (contenido instanceof Pelicula) {
            Pelicula p = (Pelicula) contenido;
            return String.format("Pelicula,%s,%d,%s,%s,%s",
                    p.getTitulo(), p.getDuracionEnMinutos(), p.getGenero(), p.getEstudio(), p.getActor().getNombre());
        } else if (contenido instanceof SerieDeTV) {
            SerieDeTV s = (SerieDeTV) contenido;
            return String.format("SerieDeTV,%s,%d,%s,%d",
                    s.getTitulo(), s.getDuracionEnMinutos(), s.getGenero(), s.getTemporadas());
        } else if (contenido instanceof Documental) {
            Documental d = (Documental) contenido;
            return String.format("Documental,%s,%d,%s,%s,%s",
                    d.getTitulo(), d.getDuracionEnMinutos(), d.getGenero(), d.getTema(), d.getInvestigador().getNombre());
        } else if (contenido instanceof Youtube) {
            Youtube y = (Youtube) contenido;
            return String.format("Youtube,%s,%d,%s,%s,%s,%s",
                    y.getTitulo(), y.getDuracionEnMinutos(), y.getGenero(), y.getAutor().getNombre(), y.getFecha().getDia(), y.getTema());
        } else if (contenido instanceof Instagram) {
            Instagram i = (Instagram) contenido;
            return String.format("Instagram,%s,%d,%s,%s,%s,%s",
                    i.getTitulo(), i.getDuracionEnMinutos(), i.getGenero(), i.getAutor().getNombre(), i.getFecha().getDia(), i.getTema());
        }
        return "";
    }
}

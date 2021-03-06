package Contenido;

import java.util.ArrayList;
import java.util.List;

public class Cancion implements Contenido {

    private String titulo;
    private int duracion;

    public Cancion(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String obtenerTitulo() {
        return titulo;
    }

    public int obtenerDuracion() {
        return duracion;
    }

    public List<Contenido> obtenerListaReproduccion() {
        List<Contenido> listaResultado = new ArrayList<Contenido>();
        listaResultado.add(this);

        return listaResultado;
    }

    public List<Contenido> buscar(String subcadena) {
        List<Contenido> listaResultado = new ArrayList<Contenido>();
        if (titulo.toLowerCase().contains(subcadena.toLowerCase())) {
            listaResultado.add(this);
        }
        return listaResultado;
    }

    /*
	 * Método no implementado por Cancion.
     */
    public void agregar(Contenido contenido, Contenido predecesor) {
        return;
    }

    /*
	 * Método no implementado por Cancion.
     */
    public void eliminar(Contenido contenido) {
        return;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

}

package Contenido;

import java.util.ArrayList;
import java.util.List;

public class Anuncio implements Contenido {

    private static final String TITULO = "PUBLICIDAD";
    private int duracion = 5;
    
    /**
     * Constructor de Anuncio 
     */
    public Anuncio() {
    }

    public String obtenerTitulo() {
        return TITULO;
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
        if (TITULO.toLowerCase().contains(subcadena.toLowerCase())) {
            listaResultado.add(this);
        }
        return listaResultado;
    }


    /*
	 * Método no implementado por Anuncio.
     */
    public void agregar(Contenido contenido, Contenido predecesor) {
    }

    /*
	 * Método no implementado por Anuncio.
     */
    public void eliminar(Contenido contenido) {
    }

}

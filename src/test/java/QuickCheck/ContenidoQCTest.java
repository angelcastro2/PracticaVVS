
package QuickCheck;

import Contenido.Cancion;
import Contenido.Contenido;
import Contenido.Emisora;
import QuickCheck.Generadores.IntegerGenerator;
import QuickCheck.Generadores.StringGenerator;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test de contenido utilizando Quickcheck
 */
public class ContenidoQCTest {
    
    // StringGenerator para nombres
    private final StringGenerator nameGenerator = new StringGenerator();

    // IntegerGenerator para duraciones
    private final IntegerGenerator duracionGen = new IntegerGenerator();
    
    
    //Test de obtenerTitulo

    /**
     *
     */
    @Test
    public void obtenerTituloQCTest(){
        String titulo = nameGenerator.next();
        int duracion = duracionGen.next();
        Cancion c = new Cancion(titulo, duracion);
        assertEquals(c.obtenerTitulo(), titulo);
        
        String tituloEmisora = nameGenerator.next();
        Emisora e = new Emisora(tituloEmisora);
        assertEquals(e.obtenerTitulo(), tituloEmisora);
        
    }
    
    //Test de obtenerDuracion

    /**
     *
     */
    @Test
    public void obtenerDuracionQCTest(){
        String titulo = nameGenerator.next();
        int duracion = duracionGen.next();
        Cancion c = new Cancion(titulo, duracion);
        assertEquals(c.obtenerDuracion(), duracion);
        
        
    }
    
    // Test de obtenerListaReproduccion
    @Test
    public final void obtenerListaReproduccionQCTest(){
        Cancion c = new Cancion(nameGenerator.next(),duracionGen.next());
        List<Contenido> listaEsperada = new ArrayList<Contenido>();
        listaEsperada.add(c);
        assertEquals(listaEsperada, c.obtenerListaReproduccion());
        
        String tituloEmisora = nameGenerator.next();
        Emisora e = new Emisora(tituloEmisora);
        e.agregar(c, null);
        assertEquals(listaEsperada, e.obtenerListaReproduccion());
    }
 
    
    // Test de buscar
    @Test
    public final void buscarQCTest(){
        String titulo = nameGenerator.next();
        int duracion = duracionGen.next();
        Cancion c = new Cancion(titulo, duracion);
        List<Contenido> listaEsperada = new ArrayList<Contenido>();
        listaEsperada.add(c);
        assertEquals(listaEsperada,c.buscar(titulo));
        
        
        String tituloEmisora = nameGenerator.next();
        Emisora e = new Emisora(tituloEmisora);
        e.agregar(c, null);
        assertEquals(listaEsperada, e.buscar(titulo));
        
        
        
        
    }
    
    
    
}

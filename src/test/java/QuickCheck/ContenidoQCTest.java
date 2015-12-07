
package QuickCheck;

import Contenido.Cancion;
import Generadores.IntegerGenerator;
import Generadores.StringGenerator;
import static org.junit.Assert.assertTrue;
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
    @Test
    public void obtenerTituloQCTest(){
        String titulo = nameGenerator.next();
        int duracion = duracionGen.next();
        Cancion c = new Cancion(titulo, duracion);
        assertTrue(c.obtenerTitulo().equals(titulo));
    }
    
    //Test de obtenerDuracion
    @Test
    public void obtenerDuracionQCTest(){
        String titulo = nameGenerator.next();
        int duracion = duracionGen.next();
        Cancion c = new Cancion(titulo, duracion);
        assertTrue(c.obtenerDuracion() == duracion);
    }
    
    
}

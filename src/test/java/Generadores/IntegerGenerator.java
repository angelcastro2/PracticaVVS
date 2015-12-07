package Generadores;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.PrimitiveGenerators;

/** Generador de Integers para test, solo devuelve valores positivos
 * @see <a href=”https://quickcheck.java.net/nonav/javadoc/net/java/quickcheck/generator/PrimitiveGenerators.html”>QuickCheck Documentation</a>
 **/
public class IntegerGenerator implements Generator<Integer>{
    
    
    private final Generator<Integer> gen = PrimitiveGenerators.integers();
    
    public Integer next() {
        return new Integer(gen.next());
    }
    
}

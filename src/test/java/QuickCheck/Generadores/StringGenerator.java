package QuickCheck.Generadores;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.PrimitiveGenerators;

/** Generador de strings para test 
 * @see <a href=”https://quickcheck.java.net/nonav/javadoc/net/java/quickcheck/generator/PrimitiveGenerators.html”>QuickCheck Documentation</a>
 **/
public class StringGenerator implements Generator<String>{
    
    private String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ1234567890";
    
    private final Generator<String> gen = PrimitiveGenerators.strings(allowedCharacters,1,30);
    
    /**
     *
     * @return String generado
     */
    public String next() {
        return new String(gen.next());
    }
    
}

package Generadores;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.PrimitiveGenerators;

/** Generador de strings para test  **/
public class StringGenerator implements Generator<String>{
    
    private String allowedCharacters = "abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ234567890";
    
    private final Generator<String> gen = PrimitiveGenerators.strings(allowedCharacters,1,30);
    
    public String next() {
        return new String(gen.next());
    }
    
}

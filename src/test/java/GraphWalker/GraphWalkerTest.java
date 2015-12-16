package GraphWalker;

import Contenido.Cancion;
import Contenido.Contenido;
import Servidor.Servidor;
import Servidor.ServidorBasico;
import Servidor.ServidorConRespaldo;
import Servidor.Token;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.test.TestBuilder;
import org.junit.Test;

public class GraphWalkerTest extends ExecutionContext implements grafica {

    public final static Path GRAFICA_PATH = Paths.get("main/resources/model/grafica.graphml");

    Servidor basico;
    Servidor conRespaldo1;

    @Override
    public void inicializarServidor() {
        System.out.println("Inicializar");

        // Creamos un servidor básico con la lista de anuncios y contenidos
        basico = new ServidorBasico("Server 1", null, null);

        // Creamos un servidor con respaldo sin anuncios ni contenidos
        // Ponemos de respaldo el servidor básico
        conRespaldo1 = new ServidorConRespaldo("Server respaldo 1", new ArrayList<Contenido>(), new ArrayList<Contenido>(), basico);

    }

    @Override
    public void borrar() {
        System.out.println("Borrar");
        Contenido c1 = new Cancion("c1", 2);
        //try catch por culpa de pit
        try {
            String token = Token.tokenEspecial();
            basico.eliminar(c1, token);
        } catch (Exception ex) {
            Logger.getLogger(GraphWalkerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Inicio() {
        System.out.println("Inicio");
    }

    @Override
    public void buscar() {
        System.out.println("Buscar");
        //try catch por culpa de pit
        try {
            String token = Token.tokenEspecial();
            basico.buscar("c1", token);
        } catch (Exception ex) {
            Logger.getLogger(GraphWalkerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void agregar() {
        System.out.println("Agregar");
        Contenido c1 = new Cancion("c1", 2);
        //try catch por culpa de pit
        try {
            String token = Token.tokenEspecial();
            basico.agregar(c1, token);
        } catch (Exception ex) {
            Logger.getLogger(GraphWalkerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void ServidorConContenidos() {
        System.out.println("Servidor con contenidos");
    }

    /*Test*/
  
    @Test
    public void runSmokeTest() {
        new TestBuilder()
            .setModel(GRAFICA_PATH)
            .setContext(new GraphWalkerTest())
            .setPathGenerator(new AStarPath(new ReachedVertex("ServidorConContenidos"))) // xeramos un test que chegue a este estado
            .setStart("inicializarServidor") // primeira chamada
            .execute();
    }

    @Test
    public void runFunctionalTest() {
        new TestBuilder()
            .setModel(GRAFICA_PATH)
            .setContext(new GraphWalkerTest())
            .setPathGenerator(new RandomPath(new EdgeCoverage(100))) // xera tantos test como sexan necesarios para pasar alomenos unha vez por cada transición
            .setStart("inicializarServidor") // primeira chamada
            .execute();
    }

    @Test
    public void runStabilityTest() {
        new TestBuilder()
            .setModel(GRAFICA_PATH)
            .setContext(new GraphWalkerTest())
            .setPathGenerator(new RandomPath(new TimeDuration(3, TimeUnit.MINUTES))) // atravesamos aleatoriamente o grafo durante 3 minutos
            .setStart("inicializarServidor") // primeira chamada
            .execute();
    }

}

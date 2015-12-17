package QuickCheck;

import Contenido.Anuncio;
import Contenido.Cancion;
import Contenido.Contenido;
import Contenido.Emisora;
import QuickCheck.Generadores.IntegerGenerator;
import QuickCheck.Generadores.StringGenerator;
import Servidor.ContenidoDuplicadoException;
import Servidor.Servidor;
import Servidor.ServidorBasico;
import Servidor.ServidorConRespaldo;
import Servidor.Token;
import Servidor.TokenNotFoundException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


public class ServidoresQCTest {
    
        // StringGenerator para nombres
        private final StringGenerator nameGenerator = new StringGenerator();

        // IntegerGenerator para numeros
        private final IntegerGenerator numberGen = new IntegerGenerator();
    
	// Variables estáticas de pruebas
	private static String nombreBasico = "Servidor Básico";

	// Declaración de contenidos
	Contenido c1;
	Contenido c2;
	Contenido c3;
	Contenido c4;
	Contenido c5;
	Contenido c6;
	Contenido c7;
	Contenido c8;
	Contenido c9;
	Contenido c10;
	Contenido c11;
	Contenido c12;
	Contenido c13;
	Contenido c14;
	Contenido c15;
	Contenido e1;
	Contenido e2;

	// Declaración de anuncios
	Contenido a1;

	// Listas de contenidos y anuncios
	List<Contenido> contenidos;
	List<Contenido> anuncios;

	// Servidores para pruebas
	Servidor basico;
	Servidor conRespaldo1;
	Servidor conRespaldo2;

	// Inicializamos datos para realizar las pruebas
	@Before
	public void inicializar() {

		// Creamos contenidos
		c1 = new Cancion("c1", 2);
		c2 = new Cancion("c2", 2);
		c3 = new Cancion("c3", 2);
		c4 = new Cancion("c4", 2);
		c5 = new Cancion("c5", 2);
		c6 = new Cancion("c6", 2);
		c7 = new Cancion("c7", 2);
		c8 = new Cancion("c8", 2);
		c9 = new Cancion("c9", 2);
		c10 = new Emisora("c10");
		c11 = new Cancion("c11", 2);
		c12 = new Emisora("c12");
		c13 = new Cancion("c13", 2);
		c14 = new Cancion("c14", 2);
		c15 = new Cancion("c15", 2);
		e1 = new Cancion("e1", 2);
		e2 = new Cancion("e2", 2);

		// Creamos Anuncios
		a1 = new Anuncio();



		// Creamos una lista con todos los contenidos
		contenidos = new ArrayList<Contenido>();
		contenidos.add(c1);
		contenidos.add(c2);
		contenidos.add(c3);
		contenidos.add(c4);
		contenidos.add(c5);
		contenidos.add(c6);
		contenidos.add(c7);
		contenidos.add(c8);
		contenidos.add(c9);
		c10.agregar(c11,null);
		c10.agregar(c12, c11);
		c10.agregar(c13, c12);
		c10.agregar(c14, c13);
		c10.agregar(c15, c14);
		contenidos.add(c10);
		contenidos.add(e1);
		contenidos.add(e2);

		// Creamos una lista con todos los anuncios
		anuncios = new ArrayList<Contenido>();
		anuncios.add(a1);


		// Creamos un servidor básico con la lista de anuncios y contenidos
		basico = new ServidorBasico(nombreBasico, contenidos, anuncios);

		// Creamos un servidor con respaldo sin anuncios ni contenidos
		// Ponemos de respaldo el servidor básico
		conRespaldo1 = new ServidorConRespaldo("Server respaldo 1", new ArrayList<Contenido>(),
				new ArrayList<Contenido>(), basico);

		// Creamos un servidor con respaldo sin anuncios ni contenidos
		// Ponemos de respaldo el servidor de respaldo 1
		conRespaldo2 = new ServidorConRespaldo("Server respaldo 2", new ArrayList<Contenido>(),
				new ArrayList<Contenido>(), conRespaldo1);

	}

        
        
        // Prueba la funcion de agregar contenido a un servidor
	@Test
	public void AgregarEliminarContenidoTest() throws Exception {
		String nombre = nameGenerator.next();
		Contenido c16 = new Cancion(nombre, 2);
		
		List<Contenido> lista = new ArrayList<Contenido>();
		
		String tokenEspecial = Token.tokenEspecial();
		String tokenBusqueda = Token.anadirToken();
		
		basico.agregar(c16, tokenEspecial);
		lista = basico.buscar(nombre, tokenBusqueda);
		assertTrue (lista.contains(c16));
		
		basico.eliminar(c16, tokenEspecial);
		lista = basico.buscar(nombre, tokenBusqueda);
		assertTrue(!lista.contains(c16));
	}
        
        // Prueba la busqueda en un servidor básico con lista vacia y token valido
        @Test
	public void buscarBasicoVacioTokenValidoTest() throws Exception {
		// Obtenemos la lista de contenidos de la funcion a probar
		List<Contenido> obtenido = basico.buscar(nameGenerator.next(), Token.anadirToken());
		
		assertTrue (obtenido.isEmpty());
	}
        
        // Prueba la busqueda en un servidor básico con lista vacia y token invalido
		@Test
		public void buscarBasicoVacioTokenInvalidoTest() {
			// Obtenemos la lista de contenidos de la funcion a probar
			List<Contenido> obtenido = basico.buscar(nameGenerator.next(), "");
			
			assertTrue (obtenido.isEmpty());
		}
                
    // Prueba la busqueda en un servidor con respaldo y devuelve el contenido sin acceder
	// al servidor de respaldo
	@Test
	public void buscarConRespaldoContenidoDirectoTest() throws Exception {
                String titulo = nameGenerator.next();
            
                Contenido c = new Cancion(titulo, 5);
		
		conRespaldo2.agregar(c, Token.tokenEspecial());
		List<Contenido> obtenido = conRespaldo2.buscar(titulo, Token.anadirToken());
		assertEquals(1, obtenido.size());
		assertTrue(obtenido.contains(c));
	
	}
}

package Servidor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Contenido.Anuncio;
import Contenido.Cancion;
import Contenido.Contenido;
import Contenido.Emisora;

//Tests de las funcionalidades de los servidores de contenidos
public class ServidoresTest {

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
		
		c10.agregar(c11,null);
		c10.agregar(c12, c11);
		c10.agregar(c13, c12);
		c10.agregar(c14, c13);
		c10.agregar(c15, c14);
		
		contenidos.add(c1);
		contenidos.add(c2);
		contenidos.add(c3);
		contenidos.add(c4);
		contenidos.add(c5);
		contenidos.add(c6);
		contenidos.add(c10);
		contenidos.add(c8);
		contenidos.add(c9);
		contenidos.add(c7);
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

	// Prueba que la funcion obtener nombre devuelve el nombre correctamente
	@Test
	public void obtenerNombreTest() {
		assertEquals(basico.obtenerNombre(), nombreBasico);
	}

	// Prueba que la funcion alta devueve un token
	@Test
	public void altaTest() {
		assertTrue(!Token.anadirToken().equals(""));
		assertTrue(Token.anadirToken() != null);
	}

	// Prueba que la funcion baja elimina un token dado
	@Test
	public void bajaTest() {
		String token = Token.anadirToken();
		Token.eliminarToken(token);
		try {
			Token.validarToken(token);
			assertTrue(false);
		} catch (TokenNotFoundException e) {
			assertTrue(true);
		}
	}

	@Test
	public void especialTest(){
		String token = Token.tokenEspecial();
		assertTrue(Token.esEspecial(token));
	}
	
	// Prueba la funcion de agregar contenido a un servidor
	@Test
	public void agregarContenidoTest() throws TokenNotFoundException, ContenidoDuplicadoException {
		Contenido c16 = new Cancion("c16", 2);
		basico.agregar(c16, Token.tokenEspecial);
	}
	
	// Prueba la funcion de agregar contenido a un servidor con un token invalido
	@Test(expected = TokenNotFoundException.class)
	public void agregarContenidoTokenNotFoundTest() throws TokenNotFoundException, ContenidoDuplicadoException {
		Contenido c16 = new Cancion("c16", 2);
		basico.agregar(c16, "");
	}

	// Prueba que la funcion agregar lanza la excepción
	// ContenidoDuplicadoException
	// cuando se intenta agregar un contenido existente en el servidor
	@Test(expected = ContenidoDuplicadoException.class)
	public void agregarContenidoDuplicadoTest() throws TokenNotFoundException, ContenidoDuplicadoException {
		String token = Token.tokenEspecial();
		Contenido c16 = new Cancion("c16", 2);

		basico.agregar(c16, token);
		basico.agregar(c16, token);
	}

	
	// Prueba la funcion de agregar contenido a un servidor
	@Test
	public void eliminarContenidoTest() throws TokenNotFoundException, ContenidoDuplicadoException {
		String nombre = "nombreContenido";
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
	
	// Prueba la funcion de eliminar contenido a un servidor con un token invalido
	@Test(expected = TokenNotFoundException.class)
	public void eliminarContenidoTokenNotFoundTest() throws TokenNotFoundException, ContenidoDuplicadoException {
		Contenido c16 = new Cancion("c16", 2);
		basico.agregar(c16, Token.tokenEspecial());
		basico.eliminar(c16, "");
	}
	
	// Prueba la busqueda en un servidor básico
	@Test
	public void buscarBasicoTest() {
		// Obtenemos la lista de contenidos de la funcion a probar
		String token = Token.anadirToken();
		List<Contenido> obtenido = basico.buscar("c", token);

		// Creamos la lista que esperamos que devuelva la funcionalidad
		// Todos los contenidos menos e1 y e2 junto con los anuncios
		// correspondientes
		List<Contenido> esperado = new ArrayList<Contenido>();
		esperado.add(c1);
		esperado.add(c2);
		esperado.add(c3);
		esperado.add(c4);
		esperado.add(c5);
		esperado.add(c6);
		esperado.add(c7);
		esperado.add(c8);
		esperado.add(c9);
		esperado.add(c11);
		esperado.add(a1);
		esperado.add(c12);
		esperado.add(c13);
		esperado.add(c14);
		esperado.add(a1);
		esperado.add(c15);

		// Comprobamos que tienen el mismo tamaño
		assertEquals(esperado.size(), obtenido.size());

		// Comprobamos que todos los contenidos esperados están en los obtenidos
		for (Contenido c : esperado) {
			assertTrue(obtenido.contains(c));
		}
		
		assertEquals(obtenido.get(10), a1);	
		assertEquals(obtenido.get(14), a1);
		
	}
	
	// Prueba la busqueda en un servidor básico sin token
	@Test
	public void buscarBasicoSinTokenTest() {
		// Obtenemos la lista de contenidos de la funcion a probar
		List<Contenido> obtenido = basico.buscar("c", "");

		// Creamos la lista que esperamos que devuelva la funcionalidad
		// Todos los contenidos menos e1 y e2 junto con los anuncios
		// correspondientes
		List<Contenido> esperado = new ArrayList<Contenido>();
		esperado.add(a1);
		esperado.add(c1);
		esperado.add(c2);
		esperado.add(c3);
		esperado.add(a1);		
		esperado.add(c4);
		esperado.add(c5);
		esperado.add(c6);
		esperado.add(a1);		
		esperado.add(c7);
		esperado.add(c8);
		esperado.add(c9);
		esperado.add(a1);		
		esperado.add(c11);
		esperado.add(c12);
		esperado.add(c13);
		esperado.add(a1);
		esperado.add(c14);
		esperado.add(c15);

		// Comprobamos que tienen el mismo tamaño
		assertEquals(esperado.size(), obtenido.size());

		// Comprobamos que todos los contenidos esperados están en los obtenidos
		for (Contenido c : esperado) {
			assertTrue(obtenido.contains(c));
		}
		
		assertEquals(obtenido.get(0), a1);
		assertEquals(obtenido.get(4), a1);
		assertEquals(obtenido.get(8), a1);
		assertEquals(obtenido.get(12), a1);	
		assertEquals(obtenido.get(16), a1);
		
	}
	
	// Prueba la creacion de un token valido
	@Test
	public void servidorGenericoAltaTokenTest() throws TokenNotFoundException {
		Token.validarToken(basico.alta());
	}
			
	// Prueba la eliminacion de un token valido
	@Test(expected = TokenNotFoundException.class)
	public void servidorGenericoBajaTokenTest() throws TokenNotFoundException {
		String token = basico.alta();
		assertTrue(!token.equals(""));
		basico.baja(token);
		Token.validarToken(token);
	}
	
	// Prueba la busqueda en un servidor básico con lista vacia y token valido
	@Test
	public void buscarBasicoVacioTokenValidoTest() {
		// Obtenemos la lista de contenidos de la funcion a probar
		List<Contenido> obtenido = basico.buscar("vacio", Token.anadirToken());
		
		assertTrue (obtenido.isEmpty());
	}

	// Prueba la busqueda en un servidor básico con lista vacia y token invalido
		@Test
		public void buscarBasicoVacioTokenInvalidoTest() {
			// Obtenemos la lista de contenidos de la funcion a probar
			List<Contenido> obtenido = basico.buscar("vacio", "");
			
			assertTrue (obtenido.isEmpty());
		}
	// Prueba la busqueda en un servidor con respaldo
	@Test
	public void buscarConRespaldoTest() {
		// Obtenemos la lista de contenidos de la funcion a probar
		List<Contenido> obtenido = conRespaldo2.buscar("c", Token.anadirToken());

		// Creamos la lista que esperamos que devuelva la funcionalidad
		// Todos los contenidos menos e1 y e2 junto con los anuncios
		// correspondientes
		List<Contenido> esperado = new ArrayList<Contenido>();
		esperado.add(c1);
		esperado.add(c2);
		esperado.add(c3);
		esperado.add(c4);
		esperado.add(c5);
		esperado.add(c6);
		esperado.add(c7);
		esperado.add(c8);
		esperado.add(c9);
		esperado.add(c11);
		esperado.add(a1);		
		esperado.add(c12);
		esperado.add(c13);
		esperado.add(c14);
		esperado.add(a1);
		esperado.add(c15);

		// Creamos la lista que esperamos que devuelva la funcionalidad
		assertEquals(esperado.size(), obtenido.size());

		// Comprobamos que todos los contenidos esperados están en los obtenidos
		for (Contenido c : esperado) {
			assertTrue(obtenido.contains(c));
		}
		assertEquals(obtenido.get(10), a1);
		assertEquals(obtenido.get(14), a1);
	}
	
	// Prueba la busqueda en un servidor con respaldo y devuelve el contenido sin acceder
	// al servidor de respaldo
	@Test
	public void buscarConRespaldoContenidoDirectoTest() throws TokenNotFoundException, ContenidoDuplicadoException {
		Contenido c = new Cancion("Cancion", 5);
		
		conRespaldo2.agregar(c, Token.tokenEspecial());
		List<Contenido> obtenido = conRespaldo2.buscar("Cancion", Token.anadirToken());
		assertEquals(1, obtenido.size());
		assertTrue(obtenido.contains(c));
	
	}

}

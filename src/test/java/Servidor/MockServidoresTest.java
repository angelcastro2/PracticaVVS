package Servidor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import Contenido.Anuncio;
import Contenido.Cancion;
import Contenido.Contenido;
import Contenido.Emisora;
import java.util.logging.Level;
import java.util.logging.Logger;

//Tests de las funcionalidades de los servidores de contenidos
@RunWith(PowerMockRunner.class)
@PrepareForTest(Token.class)
public class MockServidoresTest {

	// Prueba que la funcion obtener nombre devuelve el nombre correctamente
	@Test
	public void obtenerNombreTest() {
		Servidor basico = new ServidorBasico("nombreServidor", null, null);
		assertEquals(basico.obtenerNombre(), "nombreServidor");
	}

	@Test
	public void prueba(){
		Cancion c = mock(Cancion.class);
		when(c.obtenerDuracion()).thenReturn(19);
		assertTrue(c.obtenerDuracion()==19);
		
	}
	
	// Prueba la funcion de agregar contenido a un servidor
	@Test
	public void agregarContenidoTest() throws TokenNotFoundException, ContenidoDuplicadoException {
		Servidor basico = new ServidorBasico("nombreServidor", null, null);
		Cancion c = mock(Cancion.class);

        PowerMockito.mockStatic(Token.class);
        PowerMockito.when(Token.tokenEspecial()).thenReturn("TokenEspecial");
        PowerMockito.when(Token.esEspecial("TokenEspecial")).thenReturn(true);
            try {
                PowerMockito.when(Token.anadirToken()).thenReturn("TokenValido");
            } catch (Exception ex) {
                Logger.getLogger(MockServidoresTest.class.getName()).log(Level.SEVERE, null, ex);
            }
		when(c.obtenerTitulo()).thenReturn("Cancion");
		when(c.obtenerDuracion()).thenReturn(10);
		List<Contenido> lista = new ArrayList<Contenido>();		
		lista.add(c);
		when(c.buscar(c.obtenerTitulo())).thenReturn(lista);
		
		basico.agregar(c, Token.tokenEspecial() );
            try {
                assertTrue(basico.buscar(c.obtenerTitulo(), Token.anadirToken()).get(0).equals(c));
            } catch (Exception ex) {
                Logger.getLogger(MockServidoresTest.class.getName()).log(Level.SEVERE, null, ex);
            }
		
	}
	

	// Prueba la funcion de agregar contenido a un servidor con un token invalido
	@Test(expected = TokenNotFoundException.class)
	public void agregarContenidoTokenNotFoundTest() throws TokenNotFoundException, ContenidoDuplicadoException {
		Servidor basico = new ServidorBasico("nombreServidor", null, null);
		Cancion c = mock(Cancion.class);
		PowerMockito.mockStatic(Token.class);
	    PowerMockito.when(Token.tokenEspecial()).thenReturn("TokenEspecial");
	    PowerMockito.when(Token.esEspecial("TokenEspecial")).thenReturn(true);
            try {
                PowerMockito.when(Token.anadirToken()).thenReturn("TokenValido");
            } catch (Exception ex) {
                Logger.getLogger(MockServidoresTest.class.getName()).log(Level.SEVERE, null, ex);
            }
	        
		basico.agregar(c, " " );
	}
	
	
	// Prueba que la funcion agregar lanza la excepción
	// ContenidoDuplicadoException
	// cuando se intenta agregar un contenido existente en el servidor
	@Test(expected = ContenidoDuplicadoException.class)
	public void agregarContenidoDuplicadoTest() throws TokenNotFoundException, ContenidoDuplicadoException {
		Servidor basico = new ServidorBasico("nombreServidor", null, null);
		Cancion c = mock(Cancion.class);

		PowerMockito.mockStatic(Token.class);
	    PowerMockito.when(Token.tokenEspecial()).thenReturn("TokenEspecial");
	    PowerMockito.when(Token.esEspecial("TokenEspecial")).thenReturn(true);
            try {
                PowerMockito.when(Token.anadirToken()).thenReturn("TokenValido");
            } catch (Exception ex) {
                Logger.getLogger(MockServidoresTest.class.getName()).log(Level.SEVERE, null, ex);
            }
	    
		basico.agregar(c, Token.tokenEspecial());
		basico.agregar(c, Token.tokenEspecial());
	}

	
	// Prueba la funcion de eliminar contenido a un servidor
	@Test
	public void eliminarContenidoTest() throws TokenNotFoundException, ContenidoDuplicadoException {
		Servidor basico = new ServidorBasico("nombreServidor", null, null);
		Cancion c = mock(Cancion.class);

        PowerMockito.mockStatic(Token.class);
        PowerMockito.when(Token.tokenEspecial()).thenReturn("TokenEspecial");
        PowerMockito.when(Token.esEspecial("TokenEspecial")).thenReturn(true);
            try {
                PowerMockito.when(Token.anadirToken()).thenReturn("TokenValido");
            } catch (Exception ex) {
                Logger.getLogger(MockServidoresTest.class.getName()).log(Level.SEVERE, null, ex);
            }
		when(c.obtenerTitulo()).thenReturn("Cancion");
		when(c.obtenerDuracion()).thenReturn(10);
		List<Contenido> lista = new ArrayList<Contenido>();		
		lista.add(c);
		when(c.buscar(c.obtenerTitulo())).thenReturn(lista);
		
		basico.agregar(c, Token.tokenEspecial() );
            try {
                assertTrue(basico.buscar(c.obtenerTitulo(), Token.anadirToken()).get(0).equals(c));
            } catch (Exception ex) {
                Logger.getLogger(MockServidoresTest.class.getName()).log(Level.SEVERE, null, ex);
            }
		
		basico.eliminar(c, Token.tokenEspecial() );

            try {
                assertTrue(basico.buscar(c.obtenerTitulo(), Token.anadirToken()).isEmpty());
            } catch (Exception ex) {
                Logger.getLogger(MockServidoresTest.class.getName()).log(Level.SEVERE, null, ex);
            }

	}
	
	// Prueba la funcion de eliminar contenido a un servidor con un token invalido
	@Test(expected = TokenNotFoundException.class)
	public void eliminarContenidoTokenNotFoundTest() throws TokenNotFoundException, ContenidoDuplicadoException {
		Servidor basico = new ServidorBasico("nombreServidor", null, null);
		Cancion c = mock(Cancion.class);
		
		when(c.obtenerTitulo()).thenReturn("Cancion");
		when(c.obtenerDuracion()).thenReturn(10);
		List<Contenido> lista = new ArrayList<Contenido>();		
		lista.add(c);
		when(c.buscar(c.obtenerTitulo())).thenReturn(lista);
		
		basico.agregar(c, Token.tokenEspecial());
		basico.eliminar(c, "");
	}
	
	
	// Prueba la busqueda en un servidor con respaldo y devuelve el contenido sin acceder
	// al servidor de respaldo
	@Test
	public void buscarConRespaldoContenidoDirectoTest() throws TokenNotFoundException, ContenidoDuplicadoException {
            try {
                Servidor servidor = new ServidorConRespaldo("nombreServidor", null, null, null);
                Cancion c = mock(Cancion.class);
                
                PowerMockito.mockStatic(Token.class);
                PowerMockito.when(Token.tokenEspecial()).thenReturn("TokenEspecial");
                PowerMockito.when(Token.esEspecial("TokenEspecial")).thenReturn(true);
                PowerMockito.when(Token.anadirToken()).thenReturn("TokenValido");
                when(c.obtenerTitulo()).thenReturn("Cancion");
                when(c.obtenerDuracion()).thenReturn(10);
                List<Contenido> lista = new ArrayList<Contenido>();
                lista.add(c);
                when(c.buscar(c.obtenerTitulo())).thenReturn(lista);
                
                
                servidor.agregar(c, Token.tokenEspecial());
                List<Contenido> listaObtenida = servidor.buscar(c.obtenerTitulo(), Token.anadirToken());
                assertTrue(listaObtenida.get(0).equals(c));
                assertEquals(1, listaObtenida.size());
            } catch (Exception ex) {
                Logger.getLogger(MockServidoresTest.class.getName()).log(Level.SEVERE, null, ex);
            }
	
	}

	
	// Prueba la busqueda en un servidor básico
	@Test
	public void buscarBasicoTest() throws TokenNotFoundException, ContenidoDuplicadoException {
            try {
                Cancion c = mock(Cancion.class);
                Emisora e = mock(Emisora.class);
                Anuncio a = mock(Anuncio.class);
                
                PowerMockito.mockStatic(Token.class);
                PowerMockito.when(Token.tokenEspecial()).thenReturn("TokenEspecial");
                PowerMockito.when(Token.esEspecial("TokenEspecial")).thenReturn(true);
                PowerMockito.when(Token.anadirToken()).thenReturn("TokenValido");
                
                when(c.obtenerTitulo()).thenReturn("Cancion");
                when(c.obtenerDuracion()).thenReturn(10);
                List<Contenido> lista = new ArrayList<Contenido>();
                lista.add(c);
                when(c.buscar(c.obtenerTitulo())).thenReturn(lista);
                
                when(e.obtenerTitulo()).thenReturn("Emisora");
                when(e.obtenerDuracion()).thenReturn(10);
                List<Contenido> listaEmisora = new ArrayList<Contenido>();
                listaEmisora.add(e);
                when(e.buscar(e.obtenerTitulo())).thenReturn(lista);
                
                
                List<Contenido> anuncios = new ArrayList<Contenido>();
                anuncios.add(a);
                Servidor servidor = new ServidorConRespaldo("nombreServidor", null, anuncios, null);
                
                servidor.agregar(c, Token.tokenEspecial());
                servidor.agregar(e, Token.tokenEspecial());
                
                
                List<Contenido> listaObtenida = servidor.buscar(c.obtenerTitulo(), Token.anadirToken());
                assertTrue(listaObtenida.get(0).equals(c));
                
                assertEquals(1, listaObtenida.size());
            } catch (Exception ex) {
                Logger.getLogger(MockServidoresTest.class.getName()).log(Level.SEVERE, null, ex);
            }
		

	}
	

	// Prueba la busqueda en un servidor con respaldo
	@Test
	public void buscarConRespaldoTest() throws TokenNotFoundException, ContenidoDuplicadoException {
            try {
                Cancion c = mock(Cancion.class);
                Emisora e = mock(Emisora.class);
                Anuncio a = mock(Anuncio.class);
                
                PowerMockito.mockStatic(Token.class);
                PowerMockito.when(Token.tokenEspecial()).thenReturn("TokenEspecial");
                PowerMockito.when(Token.esEspecial("TokenEspecial")).thenReturn(true);
                PowerMockito.when(Token.anadirToken()).thenReturn("TokenValido");
                
                when(c.obtenerTitulo()).thenReturn("Cancion");
                when(c.obtenerDuracion()).thenReturn(10);
                List<Contenido> lista = new ArrayList<Contenido>();
                lista.add(c);
                when(c.buscar(c.obtenerTitulo())).thenReturn(lista);
                
                when(e.obtenerTitulo()).thenReturn("Emisora");
                when(e.obtenerDuracion()).thenReturn(10);
                List<Contenido> listaEmisora = new ArrayList<Contenido>();
                listaEmisora.add(e);
                when(e.buscar(e.obtenerTitulo())).thenReturn(lista);
                
                
                List<Contenido> anuncios = new ArrayList<Contenido>();
                anuncios.add(a);
                Servidor basico = new ServidorBasico("nombreServidorBasico", null, anuncios);
                
                basico.agregar(c, Token.tokenEspecial());
                basico.agregar(e, Token.tokenEspecial());
                
                Servidor respaldo = new ServidorConRespaldo("nombreServidorRespaldo", null, anuncios, basico);
                
                List<Contenido> listaObtenida = respaldo.buscar(c.obtenerTitulo(), Token.anadirToken());
                assertTrue(listaObtenida.get(0).equals(c));
                
                assertEquals(1, listaObtenida.size());
            } catch (Exception ex) {
                Logger.getLogger(MockServidoresTest.class.getName()).log(Level.SEVERE, null, ex);
            }
	}


}

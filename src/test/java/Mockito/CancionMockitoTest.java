package Mockito;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
	
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import Contenido.Contenido;
import Contenido.MockDeCancion;

/**
 * Test para la clase Canción con Mockito
 */
public class CancionMockitoTest {

	/**
	 * Primero creamos el mock de cancion.
	 */
	MockDeCancion mockDeCancion = Mockito.mock(MockDeCancion.class);
	
	/* Ahora comenzamos con los test de los métodos de la clase Cancion */
	
	/**
	 * Test de prueba del método obtenerTitulo.
	 */
	@Test
	public void obtenerTituloCancionMockitoTest(){
		when(mockDeCancion.obtenerTitulo()).thenReturn("ProbandoMockCancion");
		assertEquals(mockDeCancion.obtenerTitulo(), "ProbandoMockCancion");
	}
	
	/**
	 * Test de prueba del método obtenerDuracion.
	 */
	@Test
	public void obtenerDuracionCancionMockitoTest(){
		when(mockDeCancion.obtenerDuracion()).thenReturn(50);
		assertEquals(mockDeCancion.obtenerDuracion(), 50);
	}
	
	/**
	 * Test de prueba del método obtenerListaReproduccion.
	 */
	@Test
	public void obtenerListaReproduccionCancionMockitoTest(){
		List<Contenido> lista = new ArrayList<Contenido>();
		lista.add(mockDeCancion);
		when(mockDeCancion.obtenerListaReproduccion()).thenReturn(lista);
		assertEquals(mockDeCancion.obtenerListaReproduccion(), lista);
	}
	
	/**
	 * Test de prueba del método buscar.
	 */
	@Test
	public void buscarCancionMockitoTest(){
		List<Contenido> lista = new ArrayList<Contenido>();
		lista.add(mockDeCancion);
		when(mockDeCancion.buscar(Mockito.anyString())).thenReturn(lista);
		assertEquals(mockDeCancion.buscar("ProbandoMockCancion"), lista);
	}
	
	
	
}

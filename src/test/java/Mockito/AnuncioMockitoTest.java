package Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.management.InstanceNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Contenido.Contenido;
import Contenido.MockDeAnuncio;

public class AnuncioMockitoTest {

	/**
	 * Primero creamos el mock de anuncio.
	 */
	MockDeAnuncio mockDeAnuncio = Mockito.mock(MockDeAnuncio.class);
	
	/* Ahora comenzamos con los test de los métodos de la clase Anuncio */
	
	/**
	 * Test de prueba del método obtenerTitulo.
	 */
	@Test
	public void obtenerTituloAnuncioMockitoTest(){
		when(mockDeAnuncio.obtenerTitulo()).thenReturn("PUBLICIDAD");
		assertEquals(mockDeAnuncio.obtenerTitulo(), "PUBLICIDAD");
	}
	
	/**
	 * Test de prueba del método obtenerDuracion.
	 */
	@Test
	public void obtenerDuracionAnuncioMockitoTest(){
		when(mockDeAnuncio.obtenerDuracion()).thenReturn(5);
		assertEquals(mockDeAnuncio.obtenerDuracion(), 5);
	}
	
	/**
	 * Test de prueba del método obtenerListaReproduccion.
	 */
	@Test
	public void obtenerListaReproduccionAnuncioMockitoTest(){
		List<Contenido> lista = new ArrayList<Contenido>();
		lista.add(mockDeAnuncio);
		when(mockDeAnuncio.obtenerListaReproduccion()).thenReturn(lista);
		assertEquals(mockDeAnuncio.obtenerListaReproduccion(), lista);
	}
	
	/**
	 * Test de prueba del método buscar.
	 */
	@Test
	public void buscarAnuncioMockitoTest(){
		List<Contenido> lista = new ArrayList<Contenido>();
		lista.add(mockDeAnuncio);
		when(mockDeAnuncio.buscar(Mockito.anyString())).thenReturn(lista);
		assertEquals(mockDeAnuncio.buscar("PUBLICIDAD"), lista);
	}
}

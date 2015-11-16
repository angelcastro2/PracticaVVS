package Contenido;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.management.InstanceNotFoundException;

import org.junit.Before;
import org.junit.Test;

import Servidor.Token;

public class ContenidoTest {

		// Declaración de contenidos
		Contenido cancion1;
		Contenido cancion2;
		Contenido cancion3;
		Contenido cancion100;
		
		// Declaración de anuncios
		Contenido anuncio1;
		Contenido anuncio2;
		Contenido anuncio3;
		
		// Declaracion de emisora
		Contenido emisora;
		
		// Listas de contenidos y anuncios
		List<Contenido> contenidos;
		List<Contenido> anuncios;
		
		// Inicializamos datos para realizar las pruebas
		@Before
		public void inicializar() {

			// Creamos canciones
			cancion1 = new Cancion("c1", 100);
			cancion2 = new Cancion("c2", 120);
			cancion3 = new Cancion("c3", 90);
			
			// Creamos Anuncios
			anuncio1 = new Anuncio();
			anuncio2 = new Anuncio();
			anuncio3 = new Anuncio();

			// Creamos la Emisora
			emisora = new Emisora("Emisora");
			
			//Agregamos contenidos a emisora
			emisora.agregar(cancion1, null);
			emisora.agregar(cancion2, cancion1);

			// Creamos una lista con los contenidos
			contenidos = new ArrayList<Contenido>();
			contenidos.add(cancion1);
			contenidos.add(cancion2);
			contenidos.add(cancion3);
			
			// Creamos una lista con todos los anuncios
			anuncios = new ArrayList<Contenido>();
			anuncios.add(anuncio1);
			anuncios.add(anuncio2);
			anuncios.add(anuncio3);
		}
		/*----------------------------------------------------------------------------*/
		// Prueba que la funcion obtener titulo devuelve el titulo correctamente
		@Test
		public void obtenerTituloTest() {
			assertEquals(cancion1.obtenerTitulo(), "c1");
			assertEquals(anuncio1.obtenerTitulo(), "PUBLICIDAD");
			assertEquals(emisora.obtenerTitulo(), "Emisora");
		}
		
		/*----------------------------------------------------------------------------*/
		// Prueba que la funcion obtener duracion devuelve el tiempo correctamente
		@Test
		public void obtenerDuracionTest() {
			assertEquals(cancion1.obtenerDuracion(), 100);
			assertEquals(anuncio1.obtenerDuracion(), 5);
			assertEquals(emisora.obtenerDuracion(), 220);
		}
		
		
		/*----------------------------------------------------------------------------*/
		// Prueba que la funcion obtener titulo devuelve el titulo correctamente
		@Test
		public void obtenerListaReproduccionTest() {
			//Inicializo una lista vacia para las pruebas
			List<Contenido> listaCancion1 = new ArrayList<Contenido>();
                        listaCancion1.add(cancion1);
                        List<Contenido> listaAnuncio1 = new ArrayList<Contenido>();
			listaAnuncio1.add(anuncio1);
                        
			assertEquals(cancion1.obtenerListaReproduccion(), listaCancion1);
			assertEquals(anuncio1.obtenerListaReproduccion(), listaAnuncio1);
			
			//Creo una lista con los resultados esperados
			//Con este Test tambien comprobamos que funciona el método Agregar
			List<Contenido> listaEsperada = new ArrayList<Contenido>();
			listaEsperada.add(cancion1);
			listaEsperada.add(cancion2);
			//Probamos
			assertEquals(emisora.obtenerListaReproduccion(), listaEsperada);
		}
		
		
		/*----------------------------------------------------------------------------*/

		// Prueba la busqueda 
		@Test
		public void buscarBasicoTest() {
			// Obtenemos la lista de contenidos de la funcion a probar
			List<Contenido> obtenido = cancion1.buscar("c1");

			// Creamos la lista que esperamos que devuelva la funcionalidad
			// Todos los contenidos menos e1 y e2 junto con los anuncios
			// correspondientes
			List<Contenido> esperado = new ArrayList<Contenido>();
			esperado.add(cancion1);
			
			
			

			// Comprobamos que tienen el mismo tamaño
			assertEquals(esperado.size(), obtenido.size());

			// Comprobamos que todos los contenidos esperados están en los obtenidos
			for (Contenido c : esperado) {
				assertTrue(obtenido.contains(c));
			}
		}
		/*----------------------------------------------------------------------------*/
		// Prueba eliminar funciona correctamente
		@Test
		public void eliminarContenidoTest() throws InstanceNotFoundException {
			//Compruebo el tamaño de la lista de reproduccion antes de eliminar
			List<Contenido> listaEmisoraAntes = emisora.obtenerListaReproduccion();
			assertEquals(listaEmisoraAntes.size(), 2);
			
			emisora.eliminar(cancion1);
			List<Contenido> listaEmisoraDespues = emisora.obtenerListaReproduccion();
		
			//Probamos
			assertEquals(listaEmisoraDespues.size(), 1);
		}
		
		
		/*----------------------------------------------------------------------------*/
		// Pruebar que suelta correctamente la excepción
		@Test(expected=InstanceNotFoundException.class)
		public void eliminarContenidoTest2() throws InstanceNotFoundException {
			//Compruebo el tamaño de la lista de reproduccion antes de eliminar
			List<Contenido> listaEmisoraAntes = emisora.obtenerListaReproduccion();
			assertEquals(listaEmisoraAntes.size(), 2);
			
			emisora.eliminar(cancion100);
			List<Contenido> listaEmisoraDespues = emisora.obtenerListaReproduccion();
				
			
		}
		
		
		/*----------------------------------------------------------------------------*/

		
		
		/*----------------------------------------------------------------------------*/

}

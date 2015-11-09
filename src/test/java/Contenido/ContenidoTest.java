package Contenido;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ContenidoTest {

		// Declaración de contenidos
		Contenido cancion1;
		Contenido cancion2;
		Contenido cancion3;
		
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
			assertEquals(emisora.obtenerDuracion(), 0);
		}
		
		
		/*----------------------------------------------------------------------------*/
		// Prueba que la funcion obtener titulo devuelve el titulo correctamente
		@Test
		public void obtenerListaReproduccionTest() {
			//Inicializo una lista vacia para las pruebas
			List<Contenido> listaVacia = new ArrayList<Contenido>();
			
			assertEquals(cancion1.obtenerListaReproduccion(), listaVacia);
			assertEquals(anuncio1.obtenerListaReproduccion(), listaVacia);
			
			//Creo una lista con los resultados esperados
			//Con este Test tambien comprobamos que funciona el método Agregar
			List<Contenido> listaEsperada = new ArrayList<Contenido>();
			listaEsperada.add(cancion1);
			listaEsperada.add(cancion2);
			//Probamos
			assertEquals(emisora.obtenerListaReproduccion(), listaEsperada);
		}
		
		
		/*----------------------------------------------------------------------------*/

		
		
		/*----------------------------------------------------------------------------*/

		
		
		/*----------------------------------------------------------------------------*/

		
		
		/*----------------------------------------------------------------------------*/

		
		
		/*----------------------------------------------------------------------------*/

}

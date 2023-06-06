package com.example.ParcialMartin.demo;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.ParcialMartin.demo.repository.BookRepository;
import com.example.ParcialMartin.demo.model.Book;


@SpringBootTest
public class BookTest {
	
	@Autowired
	BookRepository BookRepository;
	
	@Test
//	@Transactional
	public void pruebaInsercionBook() {
		try {
			Iterator<Book> Books = BookRepository.findAll().iterator();
			int cantidad = 0;
			while(Books.hasNext() ) {
				Books.next();
				cantidad ++;
			}

			Book Book = new Book();
			Book.setBook("La Odisea", "ISBN 978-9978-18-216-1", "Homer", 50000.00, "Bogota");
			BookRepository.save( Book );

			Book = new Book();
			Book.setBook("Pepito y Juanda", "ISBN 912-1358-18-217-1", "Martin", 23000.00, "Neiva");
			BookRepository.save( Book );

			Book = new Book();
			Book.setBook("El juego infinito", "ISBN 923-9293-15-216-1", "Chen", 85000.00, "Huila");
			BookRepository.save( Book );

			Books = BookRepository.findAll().iterator();
			int nuevaCantidad = 0;
			while( Books.hasNext() ) {
				Books.next();
				nuevaCantidad ++;
			}
			assertTrue( cantidad + 3 == nuevaCantidad, "Cantidad de Books ingresado correctamente!" );
			
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue( false, "Error en la aplicación" );
			
		}
	}

	@Test
	public void pruebaModificarBook() {
		try {
            Book Book1 = BookRepository.findById((long) 1).get();

            Book1.setBook("Pepito", "ISBN 978-9978-18-216-1", "Homer", 50000.00, "Bogota");
            BookRepository.save(Book1);

            Iterator<Book> Bookes = BookRepository.findAll().iterator();
            int cantidad = 0;
            while (Bookes.hasNext()) {
                Bookes.next();
                cantidad++;
            }
            assertTrue(cantidad == 3, "Book modificado correctamente!");

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false, "Error en la aplicación");

        }
    }

	@Test
	public void pruebaEliminarBook() {
		try {
			Iterator<Book> Bookes = BookRepository.findAll().iterator();
			int cantidad = 0;
			while( Bookes.hasNext() ) {
				Bookes.next();
				cantidad ++;
			}

            BookRepository.deleteById((long)1);

            Bookes = BookRepository.findAll().iterator();
			int nuevaCantidad = 0;
			while( Bookes.hasNext() ) {
				Bookes.next();
				nuevaCantidad ++;
			}
            assertTrue(cantidad - 1 == nuevaCantidad, "Book eliminado correctamente!");

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false, "Error en la aplicación");

        }
    }
}
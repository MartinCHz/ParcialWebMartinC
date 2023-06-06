import { Component, OnInit } from '@angular/core';
import { Book } from '../model/Book';
import { BookService } from '../shared/Book.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-modificar',
  templateUrl: './modificar.component.html',
  styleUrls: ['./modificar.component.css']
})
export class ModificarComponent implements OnInit {
  bookId: number = 0;
  book: Book = new Book();

  constructor(private bookService: BookService, private route: ActivatedRoute,  private router: Router) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.bookId = params['id'];
      this.buscarLibro();
    });
  }

  buscarLibro() {
    this.bookService.findBook(this.bookId).subscribe(
      (book: Book) => {
        this.book = book;
      },
      (error) => {
        console.log('Error al buscar el libro:', error);
      }
    );
  }

  modificarLibro() {
    this.bookService.update(this.book).subscribe(
      (updatedBook: Book) => {
        console.log('Libro modificado correctamente!:');
        this.router.navigate(['/listalibro']);
        // Aquí puedes agregar la lógica adicional después de modificar el libro
      },
      (error) => {
        console.log('Error al modificar el libro:', error);
      }
    );
  }
}

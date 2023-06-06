import { Component } from '@angular/core';
import { Book } from '../model/Book';
import { BookService } from '../shared/Book.service'; 
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-libro',
  templateUrl: './lista-libro.component.html',
  styleUrls: ['./lista-libro.component.css']
})
export class ListaLibroComponent {

  book: Book = new Book();
  books: Book[] = [];  

  constructor(private BookService: BookService, private router: Router) { }

  ngOnInit(): void {
    this.BookService.read().subscribe(books => this.books = books) 
  }

  editBook(id: number):void{
    this.router.navigate(['/modificar'], { queryParams: {id:id} })
  }
}

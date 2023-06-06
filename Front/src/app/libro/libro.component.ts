import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { BookService } from '../shared/Book.service'; 
import { Book } from '../model/Book';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-libro',
  templateUrl: './libro.component.html',
  styleUrls: ['./libro.component.css']
})


export class LibroComponent {
  
  book: Book = new Book();

  constructor(private bookService: BookService, private actRouter:ActivatedRoute,private router: Router) {}

  ngOnInit() {
  }

  btnRegistrar():void{
    this.bookService.create(this.book).subscribe(res => this.router.navigate(['/listalibro']))
    console.log(this.book.title)
    console.log(this.book.reference)
    console.log(this.book.author)
    console.log(this.book.price)
    console.log(this.book.location)
  }

  viewBookList():void{
    this.router.navigate(['/listalibro'] )
  }

}

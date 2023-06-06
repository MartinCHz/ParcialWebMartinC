import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../model/Book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  findBook(id: number) : Observable<Book> {
    return this.http.get<Book> ("http://localhost:8080/crudB/" + id);
  }

  read(): Observable<Book[]>{
    return this.http.get<Book[]> ("http://localhost:8080/crudB/read");
  }

  create(Book:Book): Observable<Book>{
    return this.http.post<Book> ("http://localhost:8080/crudB/create",Book);
  }

  update(Book:Book): Observable<Book>{
    return this.http.put<Book> ("http://localhost:8080/crudB/update",Book)
  }

  delete(id: number) : Observable<Book> {
    return this.http.delete<Book> ("http://localhost:8080/crud/delete/" + id);
  }


}

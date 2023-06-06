import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LibroComponent } from './libro/libro.component';
import { ListaLibroComponent } from './lista-libro/lista-libro.component';
import { ModificarComponent } from './modificar/modificar.component';

const routes: Routes = [
  {path: '', component:LibroComponent},
  {path: 'listalibro',component:ListaLibroComponent},
  {path: 'modificar',component:ModificarComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

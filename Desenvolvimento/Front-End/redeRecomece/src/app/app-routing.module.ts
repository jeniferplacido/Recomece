import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { PostagemComponent } from './postagem/postagem.component';
import { TemaComponent } from './tema/tema.component';

const routes: Routes = [
  {path: '', redirectTo: 'menu', pathMatch: 'full'},
  {path: 'menu', component: MenuComponent},
  {path: 'tema', component: TemaComponent},

  {path: 'postagem', component: PostagemComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

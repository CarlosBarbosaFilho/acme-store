import { CardsAvailableComponent } from './components/cards-available/cards-available.component';
import { ClientCreateComponent } from './components/client/client-create/client-create-component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavComponent } from './components/nav/nav.component';
import { HomeComponent } from './components/home/home.component';
import { ClientListComponent } from './components/client/client-list/client-list.component';
import { LoginComponent } from './components/login/login.component';
import { ClientEditComponent } from './components/client/client-edit/client-edit.component';
import { ClientDeleteComponent } from './components/client/client-delete/client-delete.component';
import { CreditEvaluateComponent } from './components/credit-evaluate/credit-evaluate.component';

const routes: Routes = [
  {path:'login', component: LoginComponent},
  
  {
    path:'',component: NavComponent, children: [
      {path: 'home', component: HomeComponent},
      {path: 'clients', component: ClientListComponent},
      {path:'clients/create', component: ClientCreateComponent},
      {path:'clients/edit/:id', component: ClientEditComponent},
      {path:'clients/delete/:id', component: ClientDeleteComponent},
      {path:'clients/send-proposal/:id', component: CreditEvaluateComponent},
      {path:'cards-available', component: CardsAvailableComponent},
    ]
  },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

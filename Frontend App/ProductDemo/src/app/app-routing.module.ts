import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddComponent } from './add/add.component';
import { ProductTableComponent } from './product-table/product-table.component';
import { UpdateComponent } from './update/update.component';

const routes: Routes = [
  {path:"", component:ProductTableComponent, pathMatch:"full"},
  {path:"update/:id", component:UpdateComponent, pathMatch:"full"},
  {path:"add", component:AddComponent, pathMatch:"full"},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

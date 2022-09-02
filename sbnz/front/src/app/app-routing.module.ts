import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { LoginGuard } from './guards/login.guard';
import { BaseLayoutComponent } from './pages/base-layout/base-layout.component';

const routes: Routes = [
  {
    path:"login",
    component: LoginComponent
  },
  {
    path:"",
    component: BaseLayoutComponent,
    canActivate: [LoginGuard],
    children:[
      // {
      //   path: "admin",
      //   loadChildren: () =>
      //     import("../admin/admin.module").then((a) => a.AdminModule),
      // }
    ]
  },
  {
    path: "**",
    component: NotFoundComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

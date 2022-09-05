import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { LoginGuard } from './guards/login.guard';
import { BaseLayoutComponent } from './pages/base-layout/base-layout.component';
import { CommonModule } from '@angular/common';

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
      {
        path: "worker",
        loadChildren: () =>
          import("./modules/worker/worker.module").then((w) => w.WorkerModule),
      },
      {
        path: "guest",
        loadChildren: () =>
          import("./modules/guest/guest.module").then((g) => g.GuestModule),
      }
    ]
  },
  {
    path: "**",
    component: NotFoundComponent,
  }
];

@NgModule({
  imports: [CommonModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

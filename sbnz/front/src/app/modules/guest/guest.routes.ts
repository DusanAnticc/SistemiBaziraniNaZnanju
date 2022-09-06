import { Routes } from "@angular/router";
import { RoleGuard } from "src/app/guards/role.guard";
import { PayComponent } from "./components/pay/pay.component";

export const GuestRoutes: Routes = [
    {
        path: "pay",
        pathMatch: "full",
        component: PayComponent,
        canActivate: [RoleGuard],
        data: { expectedRoles: "Guest" },
      }
];
import { Routes } from "@angular/router";
import { RoleGuard } from "src/app/guards/role.guard";
import { MachinesComponent } from "./components/machines/machines.component";

export const WorkerRoutes: Routes = [
    {
        path: "machines",
        pathMatch: "full",
        component: MachinesComponent,
        canActivate: [RoleGuard],
        data: { expectedRoles: "Worker" },
      }
];
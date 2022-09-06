import { Routes } from "@angular/router";
import { RoleGuard } from "src/app/guards/role.guard";
import { MachinesComponent } from "./components/machines/machines.component";
import { CheckMachinesComponent } from "./components/check-machines/check-machines.component";

export const WorkerRoutes: Routes = [
    {
      path: "machines",
      pathMatch: "full",
      component: MachinesComponent,
      canActivate: [RoleGuard],
      data: { expectedRoles: "Worker" },
    },
    {
      path: "check-machines",
      pathMatch: "full",
      component: CheckMachinesComponent,
      canActivate: [RoleGuard],
      data: { expectedRoles: "Worker" },
    }
];
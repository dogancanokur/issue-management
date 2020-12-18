import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {DashboardComponent} from "./pages/dashboard/dashboard.component";
import {ProjectComponent} from "./pages/project/project.component";
import {IssueComponent} from "./pages/issue/issue.component";

const routes: Routes = [{
  path: '',
  children: [
    {path: '', pathMatch: 'full', redirectTo: 'dashboard'},
    {path: 'dashboard', component: DashboardComponent},
    {path: 'project', component: ProjectComponent},
    {path: 'issue', component: IssueComponent},
  ]
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

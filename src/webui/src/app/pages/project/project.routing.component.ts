import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProjectComponent} from './project.component';
import {IssueComponent} from "../issue/issue.component";
import {Router, RouterModule, Routes} from "@angular/router";


const routes: Routes = [
  {
    path: '',
    component: ProjectComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class ProjectRoutingComponent {
}

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IssueComponent } from './issue.component';
import {IssueRoutingComponent} from "./issue.routing.component";



@NgModule({
  declarations: [IssueComponent],
  imports: [
    CommonModule,
    IssueRoutingComponent
  ]
})
export class IssueModule { }

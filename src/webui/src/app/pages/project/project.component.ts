import {Component, OnInit, TemplateRef} from '@angular/core';
import {ProjectService} from "../../services/shared/project.service";
import {Page} from "../../common/page";
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {

  page = new Page();
  cols = [
    {prop: 'id', name: 'No'},
    {prop: 'projectName', name: 'Project Name', sortable: false},
    {prop: 'projectCode', name: 'Project Code', sortable: false}
  ];
  rows = [];
  modalRef!: BsModalRef;

  constructor(private projectService: ProjectService, private modalService: BsModalService) {
  }

  ngOnInit(): void {
    this.setPage({offset: 0, limit: 10})
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  setPage(pageInfo: any) {
    this.page.page = pageInfo.offset;
    this.page.size = pageInfo.limit;
    this.projectService.getAll(this.page).subscribe(pageData => {
        this.page.totalElements = pageData.totalElements;
        this.page.totalPages = pageData.totalPages;
        this.rows = pageData.content;
      }
    )
  }
}

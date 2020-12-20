import {Component, OnInit, TemplateRef} from '@angular/core';
import {ProjectService} from "../../services/shared/project.service";
import {Page} from "../../common/page";
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

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
  projectForm!: FormGroup;

  constructor(private projectService: ProjectService,
              private modalService: BsModalService,
              private formBuilder: FormBuilder) {
  }

  get f() {
    return this.projectForm.controls;
  }

  ngOnInit(): void {
    this.setPage({offset: 0, limit: 10});

    this.projectForm = this.formBuilder.group({
      "projectCode": [null, [Validators.required, Validators.minLength(2)]],
      "projectName": [null, [Validators.required, Validators.minLength(2), Validators.maxLength(50)]],
    });
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

  closeAndResetModal() {
    this.projectForm.reset();
    this.modalRef.hide();
  }

  saveProject() {
    if (!this.projectForm.valid) {
      return;
    }
    this.projectService.createProject(this.projectForm.value).subscribe(
      response => {
        this.closeAndResetModal();
        this.setPage(this.page);
      });
  }
}

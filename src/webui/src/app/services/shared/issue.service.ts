import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class IssueService {
  private ISSUE_PATH = "/issue"

  constructor(private apiService: ApiService) {
  }

  getAll(): Observable<any> {
    return this.apiService.get(this.ISSUE_PATH).pipe(map(
      response => {
        if (response) {
          return response;
        } else {
          console.log(response);
          return {};
        }
      }
    ));
  }

  getById(id: any): Observable<any> {
    return this.apiService.get(this.ISSUE_PATH, id).pipe(map(
      response => {
        if (response) {
          return response;
        } else {
          console.log(response);
          return {};
        }
      }
    ));
  }

  create(project: any): Observable<any> {
    return this.apiService.post(this.ISSUE_PATH, project).pipe(map(
      response => {
        if (response) {
          return response;
        } else {
          console.log(response);
          return {};
        }
      }
    ));
  }

  delete(id: any): Observable<any> {
    return this.apiService.delete(this.ISSUE_PATH, id).pipe(map(
      response => {
        if (response) {
          return response;
        } else {
          console.log(response);
          return {};
        }
      }
    ));
  }
}

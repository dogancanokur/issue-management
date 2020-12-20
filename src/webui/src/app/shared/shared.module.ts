import {NgModule} from '@angular/core';
import {TranslateModule} from "@ngx-translate/core";
import {ModalModule} from "ngx-bootstrap/modal";


@NgModule({
  exports: [
    TranslateModule,
  ],
  imports: [
    ModalModule.forRoot()
  ]
})
export class SharedModule {
}

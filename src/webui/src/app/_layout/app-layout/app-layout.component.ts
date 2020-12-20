import {Component, OnInit} from "@angular/core";
import {TranslateService} from "@ngx-translate/core";

@Component({
  selector: 'app-app-layout',
  templateUrl: './app-layout.component.html',
  styleUrls: ['./app-layout.component.scss']
})
export class AppLayoutComponent implements OnInit {
  private langs: Array<string> = ['tr', 'en'];

  constructor(private translateService: TranslateService) {
    this.translateService.addLangs(this.langs);
    const browserLang: string = this.translateService.getBrowserLang();
    this.translateService.use(browserLang.match(/en|tr/) ? browserLang : 'en');
  }

  ngOnInit() {

  }

}

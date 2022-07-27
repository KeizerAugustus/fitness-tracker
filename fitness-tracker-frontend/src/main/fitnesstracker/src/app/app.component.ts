import {Component, OnInit} from '@angular/core';
import {RestService} from "./service/rest.service";
import {Endpoints} from "./endpoints";
import {HalloWereld} from "../../../../../target/generated-sources/openapi/model/halloWereld";
import {MenuItem, PrimeNGConfig} from "primeng/api";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title;
  items: MenuItem[];

  constructor(private readonly rest: RestService, private primengConfig: PrimeNGConfig) {
  }

  ngOnInit(): void {
    this.items = [
      {label: 'Home', icon: 'pi pi-fw pi-home'},
      {label: 'Beschikbare oefeningen', icon: 'pi pi-fw pi-database'},
      {label: 'Workout templates', icon: 'pi pi-fw pi-book'},
      {label: 'Doe een workout', icon: 'pi pi-fw pi-save'}
    ];
    this.primengConfig.ripple = true;
    this.rest.setEndpoint(Endpoints.halloworld);
    this.rest.doGet<HalloWereld>().subscribe(result => this.title = result.bericht)
  }


}

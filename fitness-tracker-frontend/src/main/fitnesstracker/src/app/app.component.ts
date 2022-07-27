import { Component, OnInit } from '@angular/core';
import {RestService} from "./service/rest.service";
import {Endpoints} from "./endpoints";
import {HalloWereld} from "../../../../../target/generated-sources/openapi/model/halloWereld";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title;

  constructor(private readonly rest: RestService) {
  }

  ngOnInit(): void {
        this.rest.setEndpoint(Endpoints.halloworld);
        this.rest.doGet<HalloWereld>().subscribe(result => this.title = result.bericht)
    }


}

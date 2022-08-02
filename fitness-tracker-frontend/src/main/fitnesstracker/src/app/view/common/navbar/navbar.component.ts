import { Component, OnInit } from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  items: MenuItem[];

  constructor() { }

  ngOnInit(): void {
    this.items = [
      {label: 'Home', icon: 'pi pi-fw pi-home', routerLink: 'home'},
      {label: 'Beschikbare oefeningen', icon: 'pi pi-fw pi-database', routerLink: 'movements'},
      {label: 'Workout templates', icon: 'pi pi-fw pi-book', routerLink: 'workout-templates'},
      {label: 'Doe een workout', icon: 'pi pi-fw pi-save'}
    ];
  }

}

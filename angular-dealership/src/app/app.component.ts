import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from "./components/header/header.component";
import { NavComponent } from './components/nav/nav.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [HeaderComponent, NavComponent, RouterOutlet],
  template: `
    <app-header/>
    <main>
    <app-nav/>
    <router-outlet/>
    </main>
  `,
  styles: [],
})
export class AppComponent {
  title = 'angular-dealership';
}

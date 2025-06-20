import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: "dealerships",
        pathMatch: 'full',
        loadComponent: () => {
            return import('./dealerships/view/dealership-list/dealership-list.component').then((m) => m.DealershipListComponent)
        }
    },
    {
        path: "dealerships/:dealershipID",
        loadComponent: () => {
            return import('./dealerships/view/dealership-view/dealership-view.component').then((m) => m.DealershipViewComponent)
        },
        children: [
            {
                path: "cars",
                loadComponent: () => {
                    return import ('./cars/view/cars-list/cars-list.component').then((m) => m.CarsListComponent)
                }
            },
            {
                path: "cars/:carID",
                loadComponent: () => {
                    return import ('./cars/view/cars-view/cars-view.component').then((m) => m.CarsViewComponent)
                }
            },
            {
                path: "cars/:carID/create",
                loadComponent: () => {
                    return import ('./cars/view/cars-add/cars-add.component').then((m) => m.CarsAddComponent)
                }
            },
            {
                path: "cars/:carID/edit",
                loadComponent: () => {
                    return import ('./cars/view/cars-edit/cars-edit.component').then((m) => m.CarsEditComponent)
                }
            }
        ]
    },
    {
        path: "dealerships/:dealershipID/edit",
        loadComponent: () => {
            return import('./dealerships/view/dealership-edit/dealership-edit.component').then((m) => m.DealershipEditComponent)
        }
    },
    {
        path: "dealerships/:dealershipID/create",
        loadComponent: () => {
            return import ('./dealerships/view/dealership-add/dealership-add.component').then((m) => m.DealershipAddComponent)
        }
    }
];

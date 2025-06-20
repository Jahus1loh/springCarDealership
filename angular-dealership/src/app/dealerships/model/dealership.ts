import { Cars } from "../../cars/model/cars";

export interface Dealership {
    id: string,
    name: string,
    location: string,
    cars: Cars;
}
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CarForm } from '../model/car-form';
import { Cars } from '../model/cars';
import { CarDetails } from '../model/car-details';

@Injectable({
  providedIn: 'root'
})
export class CarService {
  private baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8084/api/dealerships';
  }

  getCars(dealershipUuid: string): Observable<Cars> {
    return this.http.get<Cars>(`${this.baseUrl}/${dealershipUuid}/cars`);
  }

  getCar(dealershipUuid: string, carUuid: string): Observable<CarDetails> {
    return this.http.get<CarDetails>(`${this.baseUrl}/${dealershipUuid}/cars/${carUuid}`);
  }

  deleteCar(dealershipUuid: string, carUuid: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${dealershipUuid}/cars/${carUuid}`);
  }

  putCar(
    dealershipUuid: string,
    carUuid: string,
    request: CarForm
  ): Observable<any> {
    return this.http.put(
      `${this.baseUrl}/${dealershipUuid}/cars/${carUuid}`,
      request
    );
  }

  addCar(
    dealershipUuid: string,
    carUuid: string,
    brandName: string,
    modelName: string,
    country: string,
    price: number,
    productionYear: number
  ): Observable<any> {
    return this.http.put(
      `${this.baseUrl}/${dealershipUuid}/cars/${carUuid}`,
      {
        uuid: carUuid,
        brandName,
        modelName,
        country,
        price,
        productionYear,
      }
    );
  }
}

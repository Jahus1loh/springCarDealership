import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Dealerships } from '../model/dealerships';
import { DealershipDetails } from '../model/dealership-details';
import { DealershipForm } from '../model/dealership-form';

@Injectable({
  providedIn: 'root'
})
export class DealershipService {

  private dealershipUrl: string;

  constructor(private http: HttpClient) {
    this.dealershipUrl = 'http://localhost:8084/api/dealerships'
  }

  getDealerships(): Observable<Dealerships> {
    return this.http.get<Dealerships>(this.dealershipUrl);
  }

  getDealership(uuid: string): Observable<DealershipDetails> {
    return this.http.get<DealershipDetails>(this.dealershipUrl + '/' + uuid)
  }

  deleteDealership(uuid: string): Observable<any> {
    return this.http.delete(this.dealershipUrl + "/" + uuid);
  }

  putDealership(uuid: string, request: DealershipForm): Observable<any> {
    return this.http.put(this.dealershipUrl + "/" + uuid, request)
  }

  addDealership(uuid: string, name: string, location: string): Observable<any> {
    return this.http.put(this.dealershipUrl + "/" + uuid, {uuid, name, location})
  }
}

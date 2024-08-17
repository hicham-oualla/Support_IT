import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Jwt} from "./classes/jwt";

@Injectable({
  providedIn: 'root'
})
export class JwtService {

  private url="http://localhost:9095/api/v1/auth/"

  constructor(private http: HttpClient) { }

  login(loginRequest: any):Observable<Jwt>{
    return this.http.post<Jwt>(this.url+"authenticate", loginRequest)
  }
}

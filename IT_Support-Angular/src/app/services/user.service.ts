import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Observable } from 'rxjs';
import {User} from "../classes/user";


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = 'http://localhost:9095/api/v1/auth';  // Update with your backend API URL
  private UserUrl = 'http://localhost:9095/api/v1/auth/';
  constructor(private http: HttpClient) { }

  registerUser(request: User): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/Admin/register`, request);
  }
  getUsers():Observable<User[]>{
    return this.http.get<User[]>(`${this.UserUrl}utilisateurs/getAll`);
  }
  registertech(request: User): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/Admin/registerTechnicien`, request);
  }
  getTechs():Observable<User[]>{
    return this.http.get<User[]>(`${this.UserUrl}tech/getAll`);
  }
}

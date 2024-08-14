import {Roles} from "../roles";


export class User {
  id?: number;          // Optional, if you have an ID for the user
  username: string;
  email?: string;       // Optional, if you want to include email
  role?: Roles;          // Use the Role enum here
  // Add other properties if needed

  constructor(username: string, email?: string, role?: Roles, id?: number) {
    this.username = username;
    this.email = email;
    this.role = role;
    this.id = id;
  }
}



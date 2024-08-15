import {Roles} from "../roles";


export class User {
  id?: number;          // Optional, if you have an ID for the user
  nom?: string;
  email?: string;
  password?: String; // Optional, if you want to include email
  role?: Roles;          // Use the Role enum here
  // Add other properties if needed

}



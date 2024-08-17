import {Component, OnInit} from '@angular/core';
import {JwtService} from "../../jwt.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {Jwt} from "../../classes/jwt";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  loginForm!: FormGroup;

  constructor(private service: JwtService,
              private fb: FormBuilder,
              private router: Router) {
  }
  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email:['', [Validators.required, Validators.email]],
      password:['', [Validators.required]]
    });
  }

  submitFom():void{
    console.log(this.loginForm.value);
    this.service.login(this.loginForm.value).subscribe(
      (response:Jwt) =>{
        const token = response.token;
        localStorage.setItem('token', token);
        this.router.navigate(['equipements'])
      }
    )
  }

}

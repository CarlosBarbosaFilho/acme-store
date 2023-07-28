import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Credentials } from 'src/app/model/credentials';
import { AuthService } from 'src/app/services/auth.service';


@Component({
  selector: 'app-login',
  templateUrl:'./login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  cred: Credentials = {
    email: '',
    password:''
  }

  email = new FormControl(null, Validators.email);
  password = new FormControl(null, Validators.minLength(4));

  constructor(private toast:ToastrService, private _service: AuthService){}

  ngOnInit(): void {

  }

  validateFields(): boolean {
    return this.email.valid && this.password.valid
  }

  login() {
    this._service.loingIn(this.cred).subscribe(response => {
      localStorage.setItem("login", response.body)
        if (localStorage.getItem("login") == "success") {
          return this.toast.success("User logged with success")
        }else {
          return this.toast.error("E-mail or password invalid")
        }
    })
  }

}

import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-client-create',
  templateUrl:'./client-create-component.html',
  styleUrls: ['./client-create-component.css']
})
export class ClientCreateComponent implements OnInit {

  client: Client = {
    id:'',
    name:'',
    email:'',
    document:'',
    phone:'',
    income:'',
    password:''
  }

  clientForm: FormGroup;
  hide = true;

  name: FormControl = new FormControl(null, Validators.minLength(5));
  email: FormControl = new FormControl(null, Validators.email);
  document: FormControl = new FormControl(null, Validators.minLength(11));
  phone: FormControl = new FormControl(null, Validators.minLength(11));
  income: FormControl = new FormControl(null, Validators.minLength(3));
  password: FormControl = new FormControl(null, Validators.minLength(5));

  constructor(private _service: ClientService,
              private _toast: ToastrService,
              private _router: Router){}


  validateFormClient(): boolean {
    return this.name.valid &&
           this.email.valid && this.document.valid &&
          this.phone.valid && this.income.valid && this.password.valid;
  }

  createClient(): void{
    this._service.create(this.client).subscribe(() => {
      this._toast.success('Client created with success', 'Created')
      this._router.navigate(["clients"])
    },ex => {
      this._toast.error(ex.error.details.message);
    })
    
  }

  ngOnInit(): void {
    
   }

}

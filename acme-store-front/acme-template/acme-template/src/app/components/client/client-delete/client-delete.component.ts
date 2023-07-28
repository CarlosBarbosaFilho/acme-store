import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";
import { Client } from "src/app/model/client";
import { ClientService } from "src/app/services/client.service";

@Component({
  selector: "app-client-delete",
  templateUrl: "./client-delete.component.html",
  styleUrls: ["./client-delete.component.css"],
})
export class ClientDeleteComponent implements OnInit {
  
  idClient: any;

  client: Client = {
    id: "",
    name: "",
    email: "",
    document: "",
    phone: "",
    income: "",
    password: "",
  };

  clientForm: FormGroup;
  hide = true;

  name: FormControl = new FormControl(null, Validators.minLength(5));
  email: FormControl = new FormControl(null, Validators.email);
  document: FormControl = new FormControl(null, Validators.minLength(11));
  phone: FormControl = new FormControl(null, Validators.minLength(11));
  income: FormControl = new FormControl(null, Validators.minLength(3));
  password: FormControl = new FormControl(null, Validators.minLength(5));

  constructor(
    private _service: ClientService,
    private _toast: ToastrService,
    private _router: Router,
    private _route: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.idClient = this._route.snapshot.paramMap.get("id");
    this.getClientById();
  }

  validateFormClient(): boolean {
    return (
      this.name.valid &&
      this.email.valid &&
      this.document.valid &&
      this.phone.valid &&
      this.income.valid &&
      this.password.valid
    );
  }

  getClientById(): void {
    this._service.findById(this.idClient).subscribe((response) => {
      this.client = response;
      console.log(response);
    });
  }

  deleteClient(): void {
    this._service.deleteClient(this.idClient).subscribe(
      () => {
        this._toast.success("Client removed with success", "Delete");
        this._router.navigate(["clients"]);
      },
      (ex) => {
        this._toast.error(ex.error.details.message);
      }
    );
  }
}

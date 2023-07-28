import { ClientService } from './../../../services/client.service';
import { Client } from './../../../model/client';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ClientCreateComponent } from '../client-create/client-create-component';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})

export class ClientListComponent implements OnInit {

  idClient: any

  ELEMENT_DATA: Client[];

  displayedColumns: string[] = ['id','name', 'email', 'document', 'phone','income','actions'];
  dataSource = new MatTableDataSource<Client>()
  
  @ViewChild(MatPaginator) paginator: MatPaginator;
  constructor( private _service: ClientService,
               private _dialog: MatDialog,
               private _toast: ToastrService,
               private _router: Router,
               private _route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.getClients()
    this.idClient = this._route.snapshot.paramMap.get("id");
  }
  

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  addClient(){
    const dialogRef = this._dialog.open(ClientCreateComponent);
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getClients();
        }
      },
    });
  }

  delete(){
    this._service.deleteClient(this.idClient).subscribe(response => {
      this._toast.success("Client removed with success", "Delete")
      this._router.navigate(["clients"])
    })
  }

  getClients() {
    return this._service.getClients().subscribe({
        next: (response) => {
          this.ELEMENT_DATA = response
          this.dataSource = new MatTableDataSource<Client>(this.ELEMENT_DATA);
          this.dataSource.paginator = this.paginator;
        },
        error: (err) => {
          console.log(err);
        }
      });
  }

}

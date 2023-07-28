import { ClientRequestCardComponent } from './client-request-card/client-request-card.component';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { ClientCreateAndUpdateComponent } from './client-create-and-update/client-create-and-update.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  opened=false;

  displayedColumns: string[] = ['id', 'name', 'document', 'income','action'];
  dataSource! : MatTableDataSource<any>;

  constructor(private _dialog: MatDialog){

  }

  ngOnInit(): void {

  }

  getClients(){}

  openAddAndEditClient(){
    console.log("calling open form")
    const dialogRef = this._dialog.open(ClientCreateAndUpdateComponent);
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getClients();
        }
      },
    });
  }

  openRequestCardClient(){
    console.log("calling open form")
    const dialogRef = this._dialog.open(ClientRequestCardComponent);
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getClients();
        }
      },
    });
  }

  openEditForm(data: any){}

  delete(id: number){}
}

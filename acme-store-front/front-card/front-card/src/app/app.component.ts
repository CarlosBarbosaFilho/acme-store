import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CardCreateAndUpdateComponent } from './card-create-and-update/card-create-and-update.component';
import { MatTableDataSource } from '@angular/material/table';
import { ServiceCardService } from './service/service-card.service';
import {MatSelectModule} from '@angular/material/select';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {


  displayedColumns: string[] = ['id', 'card_name', 'card_flag', 'card_limit', 'income','action'];
  dataSource! : MatTableDataSource<any>;
  cards: any;


  constructor(private _dialog: MatDialog, private _service: ServiceCardService){

  }

  ngOnInit(): void {
    this.getCards();
  }

  getCards() {
      this._service.list().subscribe({
        next: (response) => {
          console.log(response)
          this.dataSource = new MatTableDataSource(response);
        },
        error: (err) => {
          console.log(err);
        }
      });
  }

  openAddAndEditCard() {
    console.log("calling open form")
    const dialogRef = this._dialog.open(CardCreateAndUpdateComponent);
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getCards();
        }
      },
    });
  }

  delete(id: number){
      this._service.delete(id).subscribe({
        next: (res) => {
          this.getCards();
        },
        error: console.log,
      });  }

  openEditForm(data: any){
    const dialogRef = this._dialog.open(CardCreateAndUpdateComponent, {
      data,
    });
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getCards();
        }
      },
    });

  }
}

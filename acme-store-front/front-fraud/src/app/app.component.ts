import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { FraudCreateAndUpdateComponent } from './fraud-create-and-update/fraud-create-and-update.component';
import { FraudService } from './services/fraud.service';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {


  displayedColumns: string[] = ['id', 'document', 'active', 'create_at', 'update_at','action'];
  dataSource! : MatTableDataSource<any>;

  constructor(private _dialog: MatDialog, private _service: FraudService) {

  }

  ngOnInit(): void {
    this.getFrauds();
  }

  openAddAndEditFraud() {
    const dialogRef = this._dialog.open(FraudCreateAndUpdateComponent);
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getFrauds();
        }
      },
    });
  }

  getFrauds() {
    this._service.list().subscribe({
      next: (response) => {
        this.dataSource = new MatTableDataSource(response);
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  check(id: number) {
    this._service.active_inactive(id).subscribe({
      next: (res) => {
        this.getFrauds();
      },
      error: console.log,
    });
  }

  openEditForm(data: any) {
    console.log('calling update method');
    const dialogRef = this._dialog.open(FraudCreateAndUpdateComponent, {
      data,
    });
    console.log(data)
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getFrauds();
        }
      },
    });

  }
}

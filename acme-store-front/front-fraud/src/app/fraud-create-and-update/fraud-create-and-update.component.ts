import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

import { FraudService } from '../services/fraud.service';

@Component({
  selector: 'app-fraud-create-and-update',
  templateUrl: './fraud-create-and-update.component.html',
  styleUrls: ['./fraud-create-and-update.component.scss']
})
export class FraudCreateAndUpdateComponent implements OnInit{

  fraudForm: FormGroup;
  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
     private _dialog: MatDialogRef<FraudCreateAndUpdateComponent>,
     private _formBuilder: FormBuilder,
     private _service: FraudService) {
    this.fraudForm = _formBuilder.group({
      document : ''
    })
  }
  ngOnInit(): void {
   this.fraudForm.patchValue(this.data)
  }

  close() {
    this._dialog.close(true);
  }

  createFraud(){
    if(this.fraudForm.valid) {
      if (this.data) {
        this._service
          .update(this.data.id, this.fraudForm.value)
          .subscribe({
            next: (val: any) => {
              this._dialog.close(true);
            },
            error: (err: any) => {
              console.error(err);
            },
          });
      }else {
        console.log(this.fraudForm.value);
        this._service.create(this.fraudForm.value).subscribe({
          next: (val: any) => {
            this._dialog.close(true);
          },
          error: (err: any) => {
            console.log(err);
          }
        });
      }
    }
  }
}

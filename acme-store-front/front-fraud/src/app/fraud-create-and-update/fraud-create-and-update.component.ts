import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';

import { FraudService } from '../services/fraud.service';

@Component({
  selector: 'app-fraud-create-and-update',
  templateUrl: './fraud-create-and-update.component.html',
  styleUrls: ['./fraud-create-and-update.component.scss']
})
export class FraudCreateAndUpdateComponent {

  fraudForm: FormGroup;
  constructor(
     private _dialog: MatDialogRef<FraudCreateAndUpdateComponent>,
     private _formBuilder: FormBuilder,
     private _service: FraudService) {
    this.fraudForm = _formBuilder.group({
      document : ''
    })
  }

  close() {
    this._dialog.close(true);
  }

  createFraud(){
    if(this.fraudForm.valid) {
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

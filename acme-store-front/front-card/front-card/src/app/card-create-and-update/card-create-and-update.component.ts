import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

import { ServiceCardService } from '../service/service-card.service';

@Component({
  selector: 'app-card-create-and-update',
  templateUrl: './card-create-and-update.component.html',
  styleUrls: ['./card-create-and-update.component.scss']
})
export class CardCreateAndUpdateComponent implements OnInit {

  cardForm: FormGroup;

  cards: string[] = [
    'VISA',
    'MASTER',
    'ELLO',
    'HIPER',
  ];

  constructor(
    private _formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private _service: ServiceCardService,
    private _dialog: MatDialogRef<CardCreateAndUpdateComponent>
    ) {

    this.cardForm = _formBuilder.group({
      card_name : '',
      card_flag : '',
      income: '',
      card_limit: ''
    })

  }
  ngOnInit(): void {
    this.cardForm.patchValue(this.data)
   }

   close() {
     this._dialog.close(true);
   }


  createCard(){
    console.log('calling in here')
    if(this.cardForm.valid) {
      if (this.data) {
        console.log('calling after validate')
        this._service
          .update(this.data.id, this.cardForm.value)
          .subscribe({
            next: (val: any) => {
              this._dialog.close(true);
            },
            error: (err: any) => {
              console.error(err);
            },
          });
      }else {
        console.log(this.cardForm.value);
        this._service.create(this.cardForm.value).subscribe({
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

import { CardsAvailable } from './../../model/cards_available';
import { PerformCreditAssessmentService } from './../../services/perform-credit-assessment.service';
import { Component, EventEmitter, OnInit, Output } from "@angular/core";
import { ActivatedRoute, NavigationExtras, Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";
import { ClientData } from 'src/app/model/client-data';
import { ClientDataRequest } from 'src/app/model/client_data';
import { ClientService } from "src/app/services/client.service";
import { CreditEvaluateService } from "src/app/services/credit-evaluate.service";

@Component({
  selector: "app-credit-evaluate",
  templateUrl: "./credit-evaluate.component.html",
  styleUrls: ["./credit-evaluate.component.css"],
})
export class CreditEvaluateComponent implements OnInit {

  idClient: any;
  cards_approved: CardsAvailable[] = [];
  client: ClientData = {
    id: "",
    name: "",
    document: "",
    income: "",
  };

  clientDataRequest: ClientDataRequest = {
    document: this.client.document,
    income: this.client.income,
  }

  constructor(
    private _perform_credit_assessment_service: PerformCreditAssessmentService,
    private _evaluate_service: CreditEvaluateService,
    private _service: ClientService,
    private _toast: ToastrService,
    private _router: Router,
    private _route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.idClient = this._route.snapshot.paramMap.get("id");
    this.getClientById();
  }

  getClientById(): void {
    this._service.findById(this.idClient).subscribe((response) => {
      this.client.id = response.id;
      this.client.name = response.name;
      this.client.document = response.document;
      this.client.income = response.income;

      this.clientDataRequest.document = response.document;
      this.clientDataRequest.income = response.income;
    });
  }



  send() {

    this._perform_credit_assessment_service.carryOutEvaluation(this.clientDataRequest).subscribe({
      next: (response) => {
        this._router.navigate(["/cards-available"], {queryParams: {cards_approved: response}});
        // let cards_approved: NavigationExtras = {
        //   queryParams: {"data": JSON.stringify(response)}
        // };
       // this._router.navigate(["/cards-available"],  cards_approved);
      }
    })

  }
}

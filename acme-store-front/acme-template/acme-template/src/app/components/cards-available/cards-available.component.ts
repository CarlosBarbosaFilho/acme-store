import { Component, OnInit } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { ActivatedRoute, Router } from "@angular/router";
import { CardsClient } from "src/app/model/cards_client";

@Component({
  selector: "app-cards-available",
  templateUrl: "./cards-available.component.html",
  styleUrls: ["./cards-available.component.css"],
})
export class CardsAvailableComponent implements OnInit {

  data: CardsClient[]
  ELEMENT_DATA: CardsClient[] = [];
  displayedColumns: string[] = ['id','name_card','flag_card','card_limit_customer'];

  dataSource = new MatTableDataSource<CardsClient>(this.ELEMENT_DATA);
  activatedRoute: any;

  constructor(private _route: ActivatedRoute) {
  }

  getCardsAvailable() {
   const cards_approved = this.activatedRoute.snapshot.queryParams.cards_approved
   console.log("<><><><><><><><><><><><><><>", cards_approved);
  }

  ngOnInit(): void {
   this.getCardsAvailable();
  }
}

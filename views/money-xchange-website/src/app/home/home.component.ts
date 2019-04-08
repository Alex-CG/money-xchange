import { Component, OnInit } from '@angular/core';
import { RateService } from './../services/rate.service';

import { ResponseModel } from './../dto/responsemodel.dto';
import { RateResume } from './../dto/rateresume.dto';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  rates: any;
  baseAmount: number;
  calculated: number;

  constructor(private rateService: RateService) { }

  ngOnInit() {
  }

}

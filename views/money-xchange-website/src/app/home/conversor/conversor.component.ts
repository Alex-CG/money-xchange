import { Component, OnInit } from '@angular/core';
import { RateService } from 'src/app/services/rate.service';

import { ResponseModel } from 'src/app/dto/responsemodel.dto';
import { RateResume } from 'src/app/dto/rateresume.dto';

@Component({
  selector: 'conversor',
  templateUrl: './conversor.component.html',
  styleUrls: ['./conversor.component.scss']
})
export class ConversorComponent implements OnInit {

  rates: any;
  baseAmount: number;
  calculated: number;

  constructor(private rateService: RateService) { }

  ngOnInit() {
  }

  getRates() {
    let base = 'USD';
    let curr = 'EUR';
  	this.rateService.getRates(base, curr).subscribe(data => {
      let resp = <ResponseModel> data;
  		if (resp && resp.code === '00') {
			  console.log(JSON.stringify(resp));
        let rateResume = <RateResume> resp.data;
        this.rates = rateResume.rates;
        this.calculated = this.rates[curr] * this.baseAmount;
  		} else {
  			console.log('error');
  		}
  	});
  }

}

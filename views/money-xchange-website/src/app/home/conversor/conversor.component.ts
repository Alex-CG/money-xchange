import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { RateService } from 'src/app/services/rate.service';

import { ResponseModel } from 'src/app/dto/responsemodel.dto';
import { RateResume } from 'src/app/dto/rateresume.dto';

@Component({
  selector: 'conversor',
  templateUrl: './conversor.component.html',
  styleUrls: ['./conversor.component.scss']
})
export class ConversorComponent implements OnInit {

  @Input() rates: any;
  @Input() baseAmount: number;
  @Input() calculated: number;

  @Output() ratesChange = new EventEmitter<any>();
  @Output() baseAmountChange = new EventEmitter<number>();
  @Output() calculatedChange = new EventEmitter<number>();

  setRates(ratesIn: any) { 
    this.rates = ratesIn;
    this.ratesChange.emit(ratesIn);
  }

  setBaseAmount(baseAmountIn: any) { 
    this.baseAmount = baseAmountIn;
    this.baseAmountChange.emit(baseAmountIn);
  }

  setCalculated(calculatedIn: any) { 
    this.calculated = calculatedIn;
    this.calculatedChange.emit(calculatedIn);
  }

  constructor(private rateService: RateService) { }

  ngOnInit() {
  }

  getRates() {
    let base = 'USD';
    let curr = 'EUR';

    this.setBaseAmount(this.baseAmount);

  	this.rateService.getRates(base, curr).subscribe(data => {
      let resp = <ResponseModel> data;
  		if (resp && resp.code === '00') {

        let rateResume = <RateResume> resp.data;

        this.setRates(rateResume.rates);

        const calculated = this.rates[curr] * this.baseAmount;
        this.setCalculated(calculated);

  		} else {
  			console.log('error');
  		}
  	});
  }

}

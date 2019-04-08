import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RateService {

	readonly restapi: string = '/moneyxchangeapi';
	readonly latest: string = '/latest';

	constructor(private http: HttpClient) { 
	}

	getRates(base: string, currency: string) {
		let url = this.restapi + this.latest + '?base=' + base;
		if (currency) { url += ('&symbols=' + currency); }
		return this.http.get(url);
	}

}

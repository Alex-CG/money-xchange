import { Directive, ElementRef } from '@angular/core';
import { BaseDirective } from './base.directive';

@Directive({ selector: '[decimalFormat]' })
export class DecimalFormatDirective extends BaseDirective {
	constructor(public elementRef: ElementRef) {
		super(elementRef);
		this.regExpr = new RegExp(/^[0-9]+(\.[0-9]{1,4})?$/);
	}
}
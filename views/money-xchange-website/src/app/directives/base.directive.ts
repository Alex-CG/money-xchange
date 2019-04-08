import { ElementRef, HostListener } from '@angular/core';

export class BaseDirective {

	public regExpr: RegExp;
	public specialKeys: Array<string> = ['Backspace', 'Tab', 'End', 'Home'];

	constructor(public elementRef: ElementRef) { }

	@HostListener('keydown', ['$event'])
	public onKeyDown(event: KeyboardEvent): void {

		if (this.specialKeys.indexOf(event.key) !== -1)  return;

		const current: string = this.elementRef.nativeElement.value;
		const next: string = current.concat(event.key);

		if (next && !String(next).match(this.regExpr)) event.preventDefault();
		
	}
}
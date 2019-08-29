/** A hero's name can't match the given regular expression */
import { ValidatorFn, AbstractControl } from '@angular/forms';
export function forbiddenNameValidator(nameRe: RegExp): ValidatorFn {
  return (control: AbstractControl): {[key: string]: any} | null => {
    const forbidden = nameRe.test(control.value);
    console.log('control.value'+control.value+"ddd"+forbidden);
    return forbidden ? {' ': {value: 'kkkkkkkkk'}} : {value: 'fff'};
  };
}

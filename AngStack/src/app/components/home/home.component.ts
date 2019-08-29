import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, FormBuilder, ValidatorFn, AbstractControl } from '@angular/forms';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

    profileForm = new FormGroup({
        firstName: new FormControl('firstName'),
        lastName: new FormControl('lastName'),
        address: new FormGroup({
            city: new FormControl('city')
        })

    });

    name = new FormControl('hi', [Validators.required, Validators.minLength(4), forbiddenNameValidator(/bob/i)]);
    contactForm = this.fb.group({
        mobile: [''],
        land: this.fb.control('w2222')
    });
    constructor(private fb: FormBuilder) { }

    ngOnInit() { }
    onClickMe() {
        console.log('key' + JSON.stringify(this.profileForm.getRawValue()));
        console.log('contactForm' + JSON.stringify(this.contactForm.getRawValue()));
        console.log(this.profileForm.get('firstName').value);
    }
}
export function forbiddenNameValidator(nameRe: RegExp): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } | null => {

        const forbidden = nameRe.test(control.value);
        return forbidden ? { 'forbiddenName': { value: control.value } } : null;
    };
}

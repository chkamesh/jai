import { forbiddenNameValidator } from '../forbiddenvalidator';
import {Component, OnInit} from '@angular/core';
import {LogService} from '../log.service';
import {FormControl, Validators, FormGroup, ValidatorFn, AbstractControl} from '@angular/forms';


@Component({
    selector: 'app-example-app',
    templateUrl: './example-app.component.html',
    styleUrls: ['./example-app.component.css']
})
export class ExampleAppComponent implements OnInit {
    form: FormGroup;
    private service: LogService;

    constructor() { }
    ngOnInit(): void {
        this.service = new LogService();

        this.form = new FormGroup({
            first: new FormControl('Nancy', [Validators.required, Validators.minLength(4), forbiddenNameValidator(/bob/i)]),
            last: new FormControl('Drew'),
        });
    }

    get first(): any {
        return this.form.get('first');
    }

    onSubmit(): void {
        console.log('ssssssssssss' + this.form.value);
        this.service.display();
        // {first: 'Nancy', last: 'Drew'}
    }

    setValue() {
        this.form.setValue({ first: 'Carson', last: 'Drew' });
    }
}

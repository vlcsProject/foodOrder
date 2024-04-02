import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {

  formgroup: FormGroup | undefined;

  constructor(private fb: FormBuilder) {
   
  }

  ngOnInit(): void {
    this.formgroup = this.fb.group({
      ProductName: ['', Validators.required], // corrected names
      CategoryId: ['', Validators.required],
      SubCategoryId: ['', Validators.required],
      Price: ['', Validators.required],
      image: [null, Validators.required]
    });
  }

  onFileChange(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.formgroup?.patchValue({
        image: file
      });
    }
  }

  register() {
    if (this.formgroup?.valid) {
      // Handle form submission here, e.g., send data to server
      console.log(this.formgroup.value);
    }
  }   
}

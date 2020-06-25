import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';


export interface DialogData {
  animal: string;
  name: string;
}
@Component({
  selector: 'app-home-register',
  templateUrl: './home-register.page.html',
  styleUrls: ['./home-register.page.scss'],
})
export class HomeRegisterPage implements OnInit {

  constructor( public dialogRef: MatDialogRef<HomeRegisterPage>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) { }

  ngOnInit() {
  }


  onNoClick(): void {
    this.dialogRef.close();
  }
}

import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

export interface DialogData {
  data : any;
}

@Component({
  selector: 'app-professor-details',
  templateUrl: './professor-details.page.html',
  styleUrls: ['./professor-details.page.scss'],
})
export class ProfessorDetailsPage implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<ProfessorDetailsPage>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) { }

  ngOnInit() {
    console.log(this.data.data);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}

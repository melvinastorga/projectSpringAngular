import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

import { MatTableDataSource } from "@angular/material/table";
import { MatPaginator } from "@angular/material/paginator";
import { RestService } from "../rest.service";
import { MatDialog } from '@angular/material/dialog';
import { AlertController } from '@ionic/angular';
import { Router } from '@angular/router';

export interface DialogData {
  data : any;
}

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.page.html',
  styleUrls: ['./student-details.page.scss'],
})
export class StudentDetailsPage implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<StudentDetailsPage>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) { }

  ngOnInit() {
    
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  

}

import { Component, OnInit, Inject } from "@angular/core";
import {
  MAT_DIALOG_DATA,
  MatDialogRef,
  MatDialog,
} from "@angular/material/dialog";

export interface DialogData {
  animal: string;
  name: string;
}
@Component({
  selector: "app-home-login",
  templateUrl: "./home-login.page.html",
  styleUrls: ["./home-login.page.scss"],
})
export class HomeLoginPage implements OnInit {
  constructor(
    public dialogRef: MatDialogRef<HomeLoginPage>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) {}

  ngOnInit() {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}

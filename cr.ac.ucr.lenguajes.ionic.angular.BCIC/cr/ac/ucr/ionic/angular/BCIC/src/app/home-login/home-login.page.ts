import { Component, OnInit, Inject } from "@angular/core";
import {
  MAT_DIALOG_DATA,
  MatDialogRef,
  MatDialog,
} from "@angular/material/dialog";
import { RestService } from '../rest.service';

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
    public rest:RestService,
    public dialogRef: MatDialogRef<HomeLoginPage>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) {}

  email=''
  password=''

  ngOnInit() {}


  login(): void {

    var loginModel = {
      "email": this.email,
      "password": this.password
    }
    
    console.log(this.email, this.password)
    this.rest.login(loginModel).subscribe((data:{})=>{
      console.log(data)
  });
  }

  setUserId(userId):void{
    this.rest.setUserId(userId)
  }

  setUser(username):void{
    this.rest.setUser(username)
  }

  setRole(userRole):void{
    this.rest.setRole(userRole)
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}

import { Component, OnInit, Inject } from "@angular/core";
import {
  MAT_DIALOG_DATA,
  MatDialogRef,
  MatDialog,
} from "@angular/material/dialog";
import { RestService } from '../rest.service';
import { DialogData } from '../professor-details/professor-details.page';



@Component({
  selector: "app-home-login",
  templateUrl: "./home-login.page.html",
  styleUrls: ["./home-login.page.scss"],
})
export class HomeLoginPage implements OnInit {
  constructor(
    public rest:RestService,
    public dialogRef: MatDialogRef<HomeLoginPage>,
    public dialog: MatDialog,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) {}

  email=''
  password=''
  userId: any
  userName:any
  userRole:any

  ngOnInit() {
  }

  login(): void {

    var loginModel = {
      "email": this.email,
      "password": this.password
    }

    this.rest.login(loginModel).subscribe((data1)=>{ 

      var contentData = data1;
      console.log(contentData);


      if (contentData.student != null) {

        console.log(contentData.student.personId)
        this.rest.setUserId(contentData.student.personId)

        this.rest.setRole(contentData.student.userRole)

        this.rest.setUser(contentData.student.email)

      console.log(this.userId)

      }else if(contentData.professor!=null){

      this.rest.setUserId(contentData.professor.personId) 

      this.rest.setRole(contentData.professor.userRole)

      this.rest.setUser(contentData.professor.email)

      }})}


  onNoClick(): void {
    this.dialogRef.close();
  }
}

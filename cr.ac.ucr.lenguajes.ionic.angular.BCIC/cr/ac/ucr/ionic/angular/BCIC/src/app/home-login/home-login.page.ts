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
  hideMe:any

  ngOnInit() {
  }

  hide() {
    this.hideMe = false;
  }

  login(): void {

    var loginModel = {
      "email": this.email,
      "password": this.password
    }

    this.rest.login(loginModel).subscribe((data1)=>{ 

      var contentData = data1;

      console.log(data1)

      if (contentData.student != null) {

        this.rest.setUserId(contentData.student.personId)

        this.rest.setRole(contentData.student.role)

        this.rest.setUser(contentData.student.email)

        this.rest.setSuperUser(contentData.student.isPresident)
 
        console.log(contentData.student.userRole)

      }else if(contentData.professor!=null){

      this.rest.setUserId(contentData.professor.personId) 

      this.rest.setRole(contentData.professor.role)

      this.rest.setUser(contentData.professor.email)

      this.rest.setSuperUser(contentData.professor.isAdmin)

      console.log(contentData.professor.isAdmin)
      console.log(contentData.professor.userRole)

      }})}


      

  onNoClick(): void {
    this.dialogRef.close();
  }
}

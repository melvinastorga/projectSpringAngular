import { Component } from "@angular/core";
import { Platform, MenuController } from "@ionic/angular";
import { SplashScreen } from "@ionic-native/splash-screen/ngx";
import { StatusBar } from "@ionic-native/status-bar/ngx";
import { HomeLoginPage } from "./home-login/home-login.page";
import { MatDialog } from "@angular/material/dialog";
import { ProfessorsPage } from "./professors/professors.page";
import { StudentsPage } from "./students/students.page";
import { HomeRegisterPage } from "./home-register/home-register.page";
import { CoursesPage } from "./courses/courses.page";
import { MyCoursesPage } from "./my-courses/my-courses.page";
import { Router } from "@angular/router";
import { CommentsPage } from './comments/comments.page';
import { RestService } from './rest.service';
import { ProfessorCreateUpdatePage } from './professor-create-update/professor-create-update.page';
import { PdfViewerModule } from 'ng2-pdf-viewer';



@Component({
  selector: "app-root",
  templateUrl: "app.component.html",
  styleUrls: ["app.component.scss"],
})
export class AppComponent {
  animal: string;
  name: string;

  constructor(
    private platform: Platform,
    private splashScreen: SplashScreen,
    private statusBar: StatusBar,
    private menu: MenuController,
    public dialog: MatDialog,
    public router: Router, 
    public rest:RestService
  ) {
    this.initializeApp();
  }

  userId:any
  userRole:any
  superUser:any
  dataResult:any
  hide:any 

  permissons(){

    this.rest.getCurrentRole()
    this.rest.currentRole.subscribe( (message) => (this.userRole = message) );

    this.rest.getCurrentSuperUser()
    this.rest.currentsuperUser.subscribe( (message) => (this.superUser = message) );

    console.log(this.userRole)
    console.log(this.superUser)

    if(this.userRole=="Student" && this.superUser==true){
      this.hide="president"
      console.log("president")
    }if(this.userRole=="Professor" && this.superUser==true){
      this.hide="admin"
      console.log("admin")
    }if(this.userRole=="Professor" && this.superUser==false){
      this.hide="professor"
      console.log("professor")
    }else if(this.userRole=="Student" && this.superUser==false){
      this.hide="student"
      console.log("student")
    }
    
  }

  openCustom() {
    this.menu.close("custom");
    this.menu.enable(true, "custom");
    this.menu.open("custom");
  }

  openLoginDialog(): void {
    const dialogRef = this.dialog.open(HomeLoginPage, {
      width: "50%",
      height: "50%",
      data: {},
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log("The dialog was closed");
      this.animal = result;
    });


  }

  openRegisterDialog(): void {

      this.dataResult = null

      const dialogRef = this.dialog.open(HomeRegisterPage, {
        width: "50%",
        height: "70%",
        data: null,
  
      });

      dialogRef.afterClosed().subscribe((result) => {
      });
    
  }

  openSUpdateDialog(): void {

    this.rest.getCurrentUserId()
    this.rest.currentUserId.subscribe( (message) => (this.userId = message) );

    
    if (this.userId != 'error user id null') {
      this.rest.getStudentById(this.userId).subscribe((data) => {
        
        console.log("get" + data)

        const dialogRef = this.dialog.open(HomeRegisterPage, {
          width: "50%",
          height: "70%",
          data: { data }
        });

        dialogRef.afterClosed().subscribe((result) => {
        });
      });
    }
  }

  openPUpdateDialog(): void {

    this.rest.getCurrentUserId()
    this.rest.currentUserId.subscribe( (message) => (this.userId = message) );

    this.rest.getProfessorById(this.userId).subscribe((data) => {
      const dialogRef = this.dialog.open(ProfessorCreateUpdatePage, {
        width: "500px",
        height: "80%",
        data: { data },
      });
  
      dialogRef.afterClosed().subscribe((result) => {
        console.log("The dialog was closed");
      });
    });
  }


  openProfessorsDialog(): void {
    this.openCustom();
    this.router.navigate(["professors"]);
  }

  logout(): void {
    this.openCustom();
    this.router.navigate(["home"]);
  }

  home(): void {
    this.openCustom();
    this.router.navigate(["home"]);
  }

  openStudentsDialog(): void {
    this.openCustom();
    this.router.navigate(["students"]);
  }

  openCoursesDialog(): void {
    this.openCustom();
    this.router.navigate(["courses"]);
  }

  openMyCoursesDialog(): void {
    this.openCustom();
    this.router.navigate(["my-courses"]);
  }

  openNewsDialog(): void {
    this.openCustom();
    this.router.navigate(["news"]);
  }

  initializeApp() {
    this.platform.ready().then(() => {
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }
}

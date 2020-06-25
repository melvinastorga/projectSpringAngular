import { Component } from '@angular/core';
import { Platform, MenuController } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';
import { HomeLoginPage } from './home-login/home-login.page';
import { HomeRegisterPage } from './home-register/home-register.page';
import { MatDialog } from '@angular/material/dialog';
import { ProfessorsPage } from './professors/professors.page';
import { StudentsPage } from './students/students.page';



@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss']
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
  ) {
    this.initializeApp();
  }


  openCustom(){
    this.menu.close('custom');
    this.menu.enable(true, 'custom');
    this.menu.open('custom');
  
  }

  openLoginDialog(): void {
    const dialogRef = this.dialog.open(HomeLoginPage, {
      width: '50%',
      height: '50%',
      data: {name: this.name, animal: this.animal},
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.animal = result;
    });
  }

  openRegisterDialog(): void {
    const dialogRef = this.dialog.open(HomeRegisterPage, {
      width: '50%',
      height: '50%',
      data: {name: this.name, animal: this.animal},
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.animal = result;
    });
  }


  openProfessorsDialog(): void {
    const dialogRef = this.dialog.open(ProfessorsPage, {
      width: '130%',
      height: '95%',
      data: {name: this.name, animal: this.animal},
    });

    

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.animal = result;
    });
  }



  openStudentsDialog(): void {
    const dialogRef = this.dialog.open(StudentsPage, {
      width: '130%',
      height: '95%',
      data: {name: this.name, animal: this.animal},
    });

    

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.animal = result;
    });
  }


  initializeApp() {
    this.platform.ready().then(() => {
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }
}

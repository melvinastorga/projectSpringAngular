import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { RestService } from '../rest.service';
import { Router } from '@angular/router';
import { AlertController } from '@ionic/angular';

export interface DialogData {
  data: any;
  action1:any
}
@Component({
  selector: 'app-create-update-news',
  templateUrl: './create-update-news.page.html',
  styleUrls: ['./create-update-news.page.scss'],
})
export class CreateUpdateNewsPage implements OnInit {

  action = "";
  noticeString = "";
  title = "";
  message=""
  userId="";
  isDisable:any;

  constructor(

    public dialogRef: MatDialogRef<CreateUpdateNewsPage>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
    public rest: RestService,
    public router: Router,
    public alertController: AlertController
  ) { }

  ngOnInit() {

    this.isDisable=false;
    if (this.data != null) {
     
      var contentData = this.data.data;
      this.action = this.data.action1.action
   
      this.noticeString = contentData.noticeString;
      this.title = contentData.title;
      if(this.action=='details'){

        this.action="Detalles"
        this.isDisable=true;
      }else{

        this.action="Actualizar"
      }

    } else {
      this.action = "Crear";
    }
  }

  post() {
    if (
      this.noticeString == "" ||
      this.title == ""  ) {
      this.message="Ingrese los datos correspondientes";
      this.onNoClick();
      this.presentAlert();
    } else {
      if (this.action == "Crear") {
       
        this.rest.getCurrentUserId()
        this.rest.currentUserId.subscribe( (message) => (this.userId = message) );
    
        var notice = {
          "noticeId": 0,
          "personId": this.userId,
          "title": this.title,
          "noticeString": this.noticeString
    
        }
    
        this.rest.postNews(notice).subscribe(() => {
          this.message="La noticia sea ha creado con exito";
          this.onNoClick();
          this.presentAlert();
          this.router.navigate(["news"]);
        });
    
      } else {
        this.data.data.title = this.title;
        this.data.data.noticeString = this.noticeString;
        this.rest.putCourses(this.data.data).subscribe(() => {
          this.message="La noticia sea ha actualizado con exito";
          this.onNoClick();
          this.presentAlert();
          this.router.navigate(["news"]);
        });
      }
    }
  }
  onNoClick(): void {
    this.dialogRef.close();
  }

  async presentAlert() {
    const alert = await this.alertController.create({
      cssClass: "my-custom-class",
      header: "Aviso",
      message: this.message,
      buttons: ["OK"],
    });

    await alert.present();
  }
}

import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DialogData } from '../professor-details/professor-details.page';
import { RestService } from '../rest.service';
import { Router } from '@angular/router';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-create-update-news',
  templateUrl: './create-update-news.page.html',
  styleUrls: ['./create-update-news.page.scss'],
})
export class CreateUpdateNewsPage implements OnInit {

  action = "";
  news = "";
  title = "";
  message=""

  constructor(

    public dialogRef: MatDialogRef<CreateUpdateNewsPage>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
    public rest: RestService,
    public router: Router,
    public alertController: AlertController
  ) { }

  ngOnInit() {
    if (this.data != null) {
      var contentData = this.data.data;
      this.action = "Actualizar";
      this.news = contentData.notice;
      this.title = contentData.title;

    } else {
      this.action = "Crear";

    }
  }

  post() {
    if (
      this.news == "" ||
      this.title == "" 
    ) {
      this.message="Ingrese los datos correspondientes";
      this.onNoClick();
      this.presentAlert();
    } else {
      if (this.action == "Crear") {
        var news = {
          title: this.title,
          news: this.news,     
        };

        this.rest.postCourses(news).subscribe(() => {
          this.message="El curso sea ha creado con exito";
          this.onNoClick();
          this.presentAlert();
          this.router.navigate(["courses"]);
        });
      } else {
       /* this.data.data.course = this.course;
        this.data.data.term = this.term;
        this.data.data.code = this.code;
        this.data.data.description = this.description;
        this.data.data.credits = this.credits;*/

        this.rest.putCourses(this.data.data).subscribe(() => {
          this.message="El curso sea ha actualizado con exito";
          this.onNoClick();
          this.presentAlert();
          this.router.navigate(["courses"]);
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

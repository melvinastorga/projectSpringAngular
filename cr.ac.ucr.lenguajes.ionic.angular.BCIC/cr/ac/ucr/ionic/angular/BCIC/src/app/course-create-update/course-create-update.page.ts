import { Component, OnInit, Inject, AfterViewInit } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { RestService } from "../rest.service";
import { Router } from "@angular/router";
import { AlertController } from "@ionic/angular";
export interface DialogData {
  data: any;
}
@Component({
  selector: "app-course-create-update",
  templateUrl: "./course-create-update.page.html",
  styleUrls: ["./course-create-update.page.scss"],
})
export class CourseCreateUpdatePage implements OnInit {
  action = "";
  course = "";
  term = "";
  code = "";
  description = "";
  credits = "";
  message="";

  constructor(
    public dialogRef: MatDialogRef<CourseCreateUpdatePage>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
    public rest: RestService,
    public router: Router,
    public alertController: AlertController
  ) {}

  ngOnInit() {
    if (this.data != null) {
      var contentData = this.data.data;
      this.action = "Actualizar";
      this.course = contentData.name;
      this.term = contentData.term;
      this.code = contentData.code;
      this.description = contentData.description;
      this.credits = contentData.credits;
    } else {
      this.action = "Crear";
      this.course = "";
      this.term = "";
      this.code = "";
      this.description = "";
      this.credits = "";
    }
  }

  post() {
    if (
      this.course == "" ||
      this.term == "" ||
      this.code == "" ||
      this.description == "" ||
      this.credits == ""
    ) {
      this.message="Ingrese los datos correspondientes";
      this.onNoClick();
      this.presentAlert();
    } else {
      if (this.action == "Crear") {
        var newCourse = {
          name: this.course,
          credits: this.credits,
          description: this.description,
          code: this.code,
          term: this.term,
        };

        this.rest.postCourses(newCourse).subscribe(() => {
          this.message="El curso sea ha creado con exito";
          this.onNoClick();
          this.presentAlert();
          this.router.navigate(["courses"]);
        });
      } else {
        this.data.data.course = this.course;
        this.data.data.term = this.term;
        this.data.data.code = this.code;
        this.data.data.description = this.description;
        this.data.data.credits = this.credits;

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

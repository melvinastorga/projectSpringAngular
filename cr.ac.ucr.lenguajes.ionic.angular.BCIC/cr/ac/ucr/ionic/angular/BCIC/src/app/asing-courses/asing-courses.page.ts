import { Component, OnInit, Inject } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { RestService } from "../rest.service";
import { AlertController } from '@ionic/angular';
import { Router } from '@angular/router';

export interface DialogData {
  data: any;
}

@Component({
  selector: "app-asing-courses",
  templateUrl: "./asing-courses.page.html",
  styleUrls: ["./asing-courses.page.scss"],
})
export class AsingCoursesPage implements OnInit {
  courseid: any;
  professors: any;
  id: any;
  constructor(
    public dialogRef: MatDialogRef<AsingCoursesPage>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
    public rest: RestService,
    public alertController: AlertController,
    public router: Router
  ) {}

  ngOnInit() {
    this.rest.getProfessor().subscribe((data) => {
      this.professors = data;
    });
  }

  asing() {
    
    console.log(this.id)    

    var courseProfessor = {
      courseId: this.data,
      professorId: this.id,
    };

    this.rest.postProfessorCourse(courseProfessor).subscribe((data)=>{
      this.presentAlert();
    })
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  
  async presentAlert() {
    const alert = await this.alertController.create({
      cssClass: "my-custom-class",
      header: "Exito",
      message: "El curso se ha asignado con exito",
      buttons: ["OK"],
    });

    await alert.present();
  }
}

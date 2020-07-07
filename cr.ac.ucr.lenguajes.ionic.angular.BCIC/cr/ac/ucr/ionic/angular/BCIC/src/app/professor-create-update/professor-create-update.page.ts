import { Component, OnInit, Inject, AfterViewInit } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { RestService } from "../rest.service";
import { Router } from "@angular/router";
import { AlertController } from "@ionic/angular";
export interface DialogData {
  data: any;
}

@Component({
  selector: 'app-professor-create-update',
  templateUrl: './professor-create-update.page.html',
  styleUrls: ['./professor-create-update.page.scss'],
})


export class ProfessorCreateUpdatePage implements OnInit {
  action = "";
  name = "";
  lastName = "";
  mail = "";
  specialty = "";
  province = "";
  canton = "";
  district = "";
  interests = "";
  message = "";
  var 
  

  constructor(
    public dialogRef: MatDialogRef<ProfessorCreateUpdatePage>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
    public rest: RestService,
    public router: Router,
    public alertController: AlertController
  ) {}


  foods  = [
    {value: 'steak-0', viewValue: 'Steak'},
    {value: 'pizza-1', viewValue: 'Pizza'},
    {value: 'tacos-2', viewValue: 'Tacos'}
  ]

  ngOnInit() {
    if (this.data != null) {
      var contentData = this.data.data;
      this.action = "Actualizar";
      this.name = contentData.name;
      this.lastName = contentData.lastName;
      this.mail = contentData.mail;
      this.specialty = contentData.specialty;
      this.province = contentData.province;
      this.canton = contentData.canton;
      this.district = contentData.district;
      this.interests = contentData.interests;

    } else {
      this.action = "Crear";
      this.name = "";
      this.lastName = "";
      this.mail = "";
      this.specialty = "";
      this.province = "";
      this.canton = "";
      this.district = "";
      this.interests = "";
    }
  }

  post() {
    if (
      this.name == "" ||
      this.lastName == "" ||
      this.mail == "" ||
      this.specialty == "" ||
      this.province == "" ||
      this.canton == "" ||
      this.district == "" ||
      this.interests == "" 
    ) {
      this.message="Ingrese los datos correspondientes";
      this.onNoClick();
      this.presentAlert();
    } else {
      if (this.action == "Crear") {
        var newProfessor = {
          name: this.name,
          lastName: this.lastName,
          mail: this.mail,
          specialty: this.specialty,
          province: this.province,
          canton: this.canton,
          district: this.district,
          interests: this.interests,
        };

        this.rest.postProfessor(newProfessor).subscribe(() => {
          this.message="El profesor sea ha creado con exito";
          this.onNoClick();
          this.presentAlert();
          this.router.navigate(["professors"]);
        });
      } else {
        this.data.data.name = this.name;
        this.data.data.lastName = this.lastName;
        this.data.data.mail = this.mail;
        this.data.data.specialty = this.specialty;
        this.data.data.province = this.province;
        this.data.data.canton = this.canton;
        this.data.data.district = this.district;
        this.data.data.interests = this.interests;

        this.rest.putProfessor(this.data.data).subscribe(() => {
          this.message="El profesor sea ha actualizado con exito";
          this.onNoClick();
          this.presentAlert();
          this.router.navigate(["professors"]);
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
import { Component, OnInit, Inject, Input, Output, EventEmitter, AfterViewInit } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from "@angular/material/dialog";
import { RestService } from "../rest.service";
import { ActivatedRoute, Router } from '@angular/router';
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

  @Output() onChange: EventEmitter<File> = new EventEmitter<File>();

  constructor(
    public dialogRef: MatDialogRef<ProfessorCreateUpdatePage>,
    public dialog: MatDialog, 
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
    public rest: RestService,
    private route:ActivatedRoute, 
    public router: Router,
    public alertController: AlertController
  ) {}

  action = ""

  personId = 0
  name= ""
  lastName = ""
  password = ""
  email = ""
  especiality = ""

  provinces: any=[]
  cantons: any=[]
  districts: any=[]
  provinceId:0
  cantonId:0
  districId:0

  profilePic: [71,107,98]
  
  interests = ""

  date: Date = new Date();
  updatedBy: 0
  updatedAt :Date = new Date();
  imgString: ''
  imageElement:any
  role: ''

  adminName: ''


  message = ""

  ngOnInit() {
    this.getProvince();

    this.getAdmin();

    if (this.data != null) {
      var contentData = this.data.data;
      this.action = "Actualizar";
      this.name = contentData.name;
      this.lastName = contentData.lastName;
      this.password = contentData.password;
      this.email = contentData.email;
      this.especiality = contentData.especiality;
      this.provinceId = contentData.provinceId;
      this.cantonId = contentData.cantonId;
      this.getCanton(contentData.provinceId)
      this.getDistrict()
      this.districId = contentData.districId;
      this.interests = contentData.interests;
      this.profilePic = contentData.student.profilePic
      this.date = new Date();
      this.updatedBy = 0
      this.updatedAt = new Date();
      this.role = contentData.student.role

      this.source = this.imgString
      this.imageElement = document.createElement("img");
      this.imageElement.setAttribute('src', this.imgString);

    } else {
      this.action = "Crear";
      this.name = "";
      this.lastName = "";
      this.password = "";
      this.email = "";
      this.especiality = "";
      this.provinceId = 0;
      this.cantonId = 0;
      this.districId = 0;
      this.interests = "";
      this.profilePic = [71, 107, 98];
      this.date = new Date();
      this.updatedBy = 0
      this.updatedAt = new Date();
      this.role = ''
      this.imgString = ''
    }

  }

  getAdmin(){
    this.rest.getAdmin().subscribe((data)=>{
      this.adminName = data
    });
  }

  getProvince(){
    this.rest.getProvince().subscribe((data)=>{
      this.provinces = data
    });
  }

getCanton(provinceId){
    this.rest.getCanton(provinceId).subscribe((data)=>{
      this.cantons = data
  });
  }

  getDistrict(){
    console.log(this.provinceId, this.cantonId)
  this.rest.getDistric(this.provinceId, this.cantonId).subscribe((data)=>{
    this.districts = data
});
}

  post() {
    if (
      this.name == "" ||
      this.lastName == "" ||
      this.password == "" ||
      this.email == "" ||
      this.especiality == "" ||
      this.provinces == "" ||
      this.cantons == "" ||
      this.districts == "" ||
      this.interests == "" 
    ) {
      this.message="Ingrese los datos correspondientes";
      this.onNoClick();
      this.presentAlert();
    } else {
      if (this.action == "Crear") {
        var newProfessor = {
          personId: 0,
          name: this.name,
          lastName: this.lastName,
          password: this.password,
          email: this.email,
          especiality: this.especiality,
          provinceId: this.provinceId,
          cantonId: this.cantonId,
          districId:this.districId,
          interests: this.interests,
          createAt: this.date,
          status: 0,
          createdBy: 0,
          updatedBy: 0,
          updatedAt:this.date,
          imgString: this.imgString,
          profilePic: [71,107,98],
          role: "professor"
        };

        this.rest.postProfessor(newProfessor).subscribe(() => {
          this.message="El profesor se ha creado con exito";
          this.onNoClick();
          this.presentAlert();
          this.router.navigate(["professors"]);
        });
      } else {
        this.data.data.name = this.name;
        this.data.data.lastName = this.lastName;
        this.data.data.password = this.password;
        this.data.data.email = this.email;
        this.data.data.especiality = this.especiality;
        this.data.data.province = this.provinces;
        this.data.data.canton = this.cantons;
        this.data.data.distric = this.districts;
        this.data.data.interests = this.interests;
        this.data.data.imgString = this.imgString;

        this.rest.putProfessor(this.data.data).subscribe(() => {
          this.message="El profesor sea ha actualizado con exito";
          this.onNoClick();
          this.presentAlert();
          this.router.navigate(["professors"]);
        });
      }
    }
  }

  updateSource($event: Event) {
    // We access he file with $event.target['files'][0]
    this.projectImage($event.target['files'][0]);
  }

  // Uses FileReader to read the file from the input
source:string = '';
projectImage(file: File) {
  let reader = new FileReader;
  // TODO: Define type of 'e'
  reader.onload = (e: any) => {
      // Simply set e.target.result as our <img> src in the layout
      this.source = e.target.result;
      this.onChange.emit(file);

 
       //Create a canvas and draw image on Client Side to get the byte[] equivalent
       var canvas = document.createElement("canvas");
       var imageElement = document.createElement("img");

       imageElement.setAttribute('src', e.target.result);
       canvas.width = imageElement.width;
       canvas.height = imageElement.height;
       var context = canvas.getContext("2d");
       context.drawImage(imageElement, 0, 0);
       var base64Image = e.target.result
       this.imgString = e.target.result

       console.log(base64Image)

  };
  // This will process our file and get it's attributes/data
  reader.readAsDataURL(file);
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
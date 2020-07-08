import { Component, OnInit, Inject, Input, Output, EventEmitter } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from "@angular/material/dialog";
import { RestService } from '../rest.service';
import { AlertController } from '@ionic/angular';
import { ActivatedRoute, Router } from '@angular/router';

export interface DialogData {
  data: any;
}

@Component({
  selector: "app-home-register",
  templateUrl: "./home-register.page.html",
  styleUrls: ["./home-register.page.scss"],
})

export class HomeRegisterPage implements OnInit {


  @Output() onChange: EventEmitter<File> = new EventEmitter<File>();

  constructor(public rest: RestService,
    public dialog: MatDialog,
    public alertController: AlertController,
    private route: ActivatedRoute,
    private router: Router,
    public dialogRef: MatDialogRef<HomeRegisterPage>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) { }


  personId = 0
  provinces: any = []
  cantons: any = []
  districts: any = []
  provinceId: 0
  cantonId: 0
  email: ''
  password: ''
  name: ''
  lastName: ''
  interests: ''
  profilePic: [71, 107, 98]
  status: 0
  districtId: 0
  date: Date = new Date();
  updatedBy: 0
  updatedAt: Date = new Date();
  role: ''
  carne: ''
  imgString: ''
  action = ""


  ngOnInit() {

    this.getProvince();

    if (this.data != null) {
      var contentData = this.data.data;
      this.action = "Actualizar";
      this.action = "Crear";
      this.provinceId = contentData.provinceId
      this.cantonId = contentData.cantonId
      this.email = contentData.email
      this.password = contentData.password
      this.name = contentData.name
      this.lastName = contentData.lastName
      this.interests = contentData.interests
      this.profilePic = [71, 107, 98]
      this.status = contentData.status
      this.districtId = contentData.districId
      this.date = new Date();
      this.updatedBy = 0
      this.updatedAt = new Date();
      this.role = ''
      this.carne = contentData.carne
      this.imgString = ''
    } else {
      this.action = "Crear";
      this.cantonId = 0
      this.email = ''
      this.password = ''
      this.name = ''
      this.lastName = ''
      this.interests = ''
      this.profilePic = [71, 107, 98]
      this.status = 0
      this.districtId = 0
      this.date = new Date();
      this.updatedBy = 0
      this.updatedAt = new Date();
      this.role = ''
      this.carne = ''
      this.imgString = ''
    }

  }


  getProvince() {
    this.rest.getProvince().subscribe((data) => {
      this.provinces = data
    });
  }

  getCanton(provinceId) {
    this.rest.getCanton(provinceId).subscribe((data) => {
      this.cantons = data
      this.ngOnInit();
    });
  }

  getDistrict() {
    console.log(this.provinceId, this.cantonId)
    this.rest.getDistric(this.provinceId, this.cantonId).subscribe((data) => {
      this.districts = data
      this.ngOnInit();
    });
  }


  postStudent() {

    var student = {
      "personId": 0,
      "email": this.email,
      "password": this.password,
      "name": this.name,
      "lastName": this.lastName,
      "interests": this.interests,
      "profilePic": [71, 107, 98],
      "status": 0,
      "districId": this.districtId,
      "cantonId": this.cantonId,
      "provinceId": this.provinceId,
      "createAt": this.date,
      "updatedBy": 0,
      "updatedAt": this.date,
      "role": "student",
      "carne": this.carne,
      "imgString": this.imgString

    }


    this.rest.postStudent(student).subscribe(() => {
      console.log(student)
    });

  }

  updateSource($event: Event) {
    // We access he file with $event.target['files'][0]
    this.projectImage($event.target['files'][0]);
  }

  // Uses FileReader to read the file from the input
  source: string = '';
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
  


}

import { Component, OnInit, Inject, Input } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA, MatDialog } from "@angular/material/dialog";
import { RestService } from '../rest.service';
import { AlertController } from '@ionic/angular';
import { ActivatedRoute, Router } from '@angular/router';



@Component({
  selector: "app-home-register",
  templateUrl: "./home-register.page.html",
  styleUrls: ["./home-register.page.scss"],
})
export class HomeRegisterPage implements OnInit {
  @Input() studentData = { provinceId :0, cantonId:0 };


  constructor( public rest:RestService, public dialog: MatDialog, public alertController: AlertController, private route:ActivatedRoute, private router:Router,
    public dialogRef: MatDialogRef<HomeRegisterPage>,
    
  ) {}
  provinces: any=[]
  cantons: any=[]
  districts: any=[]
  provinceId:0
  cantonId:0

  ngOnInit() {
    this.getProvince();
  }


  getProvince(){
    this.rest.getProvince().subscribe((data)=>{
      this.provinces = data
    });
  }

getCanton(provinceId){
    this.rest.getCanton(provinceId).subscribe((data)=>{
      this.cantons = data
      this.ngOnInit();
  });
  }

  getDistrict(){
    console.log(this.provinceId, this.cantonId)
  this.rest.getDistric(this.provinceId, this.cantonId).subscribe((data)=>{
    this.districts = data
    this.ngOnInit();
});
}

  /*
  $scope.getCanton = function() {
    this.rest.getCanton(provinceId).subscribe((data)=>{
      this.canton = data
      this.ngOnInit();
      console.log(data)
    });
  }
  */

}

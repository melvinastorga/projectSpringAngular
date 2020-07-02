import { Component, OnInit, Inject, ViewChild } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { MatPaginator } from "@angular/material/paginator";
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AlertController } from '@ionic/angular';

import { MatDialog } from "@angular/material/dialog";
import { ProfessorDetailsPage } from '../professor-details/professor-details.page';
import { ProfessorCreateUpdatePage } from '../professor-create-update/professor-create-update.page';



@Component({
  selector: "app-professors",
  templateUrl: "./professors.page.html",
  styleUrls: ["./professors.page.scss"],
})
export class ProfessorsPage implements OnInit {

  constructor(public rest: RestService, private route: ActivatedRoute, private router: Router,
    public dialog: MatDialog, public alertController: AlertController, 
  ) {

  }

  professors: any = [];
  professorsOff: any = [];


  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  displayedColumns: string[] = ["name", "lastName", "professorId"];
  displayedColumns2: string[] = ["name", "lastName", "professorId"];
  dataSource = new MatTableDataSource();
  dataSource2 = new MatTableDataSource();

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    this.dataSource2.filter = filterValue.trim().toLowerCase();
  }

  ngOnInit() {

    this.rest.getProfessor().subscribe((data) => {
      console.log(data);
      this.professors = data;
      this.dataSource = new MatTableDataSource(this.professors);
      this.dataSource.paginator = this.paginator;

    });

    this.rest.getProfessorsOff().subscribe((data) => {
      this.professorsOff = data;
      this.dataSource2 = new MatTableDataSource(this.professorsOff);
      this.dataSource2.paginator = this.paginator;

    });
  }

  
getProfessorDetailsId(id){

  this.rest.getProfessorById(id).subscribe((data)=>{

    const dialogRef = this.dialog.open(ProfessorDetailsPage, {
    
      width: "500px",
      height: "80%",
      data:{data}
    });
  
    dialogRef.afterClosed().subscribe((result) => {
      console.log("The dialog was closed");
    }); 

  });
}

create(){
 
  const dialogRef = this.dialog.open(ProfessorCreateUpdatePage, {
  
    width: "500px",
    height: "80%",
    data: null,
  });

  dialogRef.afterClosed().subscribe((result) => {
    console.log("The dialog was closed");
  }); 

}

delete(id){

  this.rest.deleteProfessor(id).subscribe((data)=>{

    this.presentAlert();
    this.ngOnInit();

  });
}

async presentAlert() {
  const alert = await this.alertController.create({
    cssClass: "my-custom-class",
    header: "Aviso",
    message: "El profesor se ha eliminado con exito",
    buttons: ["OK"],
  });

  await alert.present();
}
}
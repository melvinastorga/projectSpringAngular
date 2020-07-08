import { Component, OnInit, Inject, ViewChild } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { MatPaginator } from "@angular/material/paginator";
import { RestService } from "../rest.service";
import { CourseDetailsPage } from '../course-details/course-details.page';
import { MatDialog } from '@angular/material/dialog';
import { CourseCreateUpdatePage } from '../course-create-update/course-create-update.page';
import { AlertController } from '@ionic/angular';
import { Router } from '@angular/router';
import { AsingCoursesPage } from '../asing-courses/asing-courses.page';

@Component({
  selector: "app-courses",
  templateUrl: "./courses.page.html",
  styleUrls: ["./courses.page.scss"],
})
export class CoursesPage implements OnInit {
  activeCourses: [];
  inactiveCourses: [];
  dataSource: any;
  dataSource2: any;

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  displayedColumns: string[] = ["Code", "Name", "Term", "actions"];
  displayedColumns2: string[] = ["Code", "Name", "Term", "actions"];
  

  constructor(public rest: RestService,  public dialog: MatDialog, public alertController: AlertController,    public router: Router ,) {

  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    this.dataSource2.filter = filterValue.trim().toLowerCase();
  }

  async ngOnInit() {

   this.rest.getCourses().subscribe((data) => {
      this.activeCourses=data;
      this.dataSource = new MatTableDataSource(this.activeCourses);
      this.dataSource.paginator = this.paginator;
    });

    this.rest.getInactiveCourses().subscribe((data) => {
      this.inactiveCourses=data;
      this.dataSource2 = new MatTableDataSource(this.inactiveCourses);
      this.dataSource2.paginator = this.paginator;
    });

   
 
  }

delete(id){

  this.rest.deleteCourses(id).subscribe((data)=>{

    this.presentAlert();
    this.ngOnInit();

  });
}


put(id){

  this.rest.getCourse(id).subscribe((data)=>{

    const dialogRef = this.dialog.open(CourseCreateUpdatePage, {
    
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
 
    const dialogRef = this.dialog.open(CourseCreateUpdatePage, {
    
      width: "500px",
      height: "80%",
      data: null,
    });
  
    dialogRef.afterClosed().subscribe((result) => {
      console.log("The dialog was closed");
    }); 

}

Asing(id){
 
 
  console.log(id);
  const dialogRef = this.dialog.open(AsingCoursesPage, {
    width: "500px",
    height: "50%",
    data:id,
  });

  dialogRef.afterClosed().subscribe((result) => {
    console.log("The dialog was closed");
  }); 

}



get(id): void {

  this.rest.getCourse(id).subscribe((data)=>{

    const dialogRef = this.dialog.open(CourseDetailsPage, {
    
      width: "500px",
      height: "80%",
      data: data,
    });
  
    dialogRef.afterClosed().subscribe((result) => {
      console.log("The dialog was closed");
    });
  

  });

}

async presentAlert() {
  const alert = await this.alertController.create({
    cssClass: "my-custom-class",
    header: "Aviso",
    message: "El curso se ha eliminado con exito",
    buttons: ["OK"],
  });

  await alert.present();
}

}

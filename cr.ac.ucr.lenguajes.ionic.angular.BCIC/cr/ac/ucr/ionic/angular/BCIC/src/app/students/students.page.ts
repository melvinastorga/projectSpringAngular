import { Component, OnInit, Inject, ViewChild } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { MatPaginator } from "@angular/material/paginator";
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentDetailsPage } from '../student-details/student-details.page';
import { MatDialog } from '@angular/material/dialog';
import { AlertController } from '@ionic/angular';


@Component({
  selector: "app-students",
  templateUrl: "./students.page.html",
  styleUrls: ["./students.page.scss"],
})
export class StudentsPage implements OnInit {

  constructor(public rest:RestService, public dialog: MatDialog, public alertController: AlertController, private route:ActivatedRoute, private router:Router) {  
  }

  students:any=[];
  studentsToAttend:any=[];
  studentsOff:any=[];
  president:any
  userId:any
  presidentName:any


  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  displayedColumns: string[] = ["name", "lastName", "studentId"];
  displayedColumns2: string[] = ["name", "lastName", "studentId"];
  displayedColumns3: string[] = ["name", "lastName", "studentId"];
  
  dataSource = new MatTableDataSource();
  dataSource2 = new MatTableDataSource();
  dataSource3 = new MatTableDataSource();
  

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    this.dataSource2.filter = filterValue.trim().toLowerCase();
    this.dataSource3.filter = filterValue.trim().toLowerCase();
  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource2.paginator = this.paginator;
    this.dataSource3.paginator = this.paginator;
    this.getStudents();
    this.getStudentsToAttend();
    this.getStudentsOff();
    this.getPresident();
  }


  getStudents(){
    this.students = [];
    this.rest.getStudents().subscribe((data:{})=>{
      this.students = data
      this.dataSource = new MatTableDataSource(this.students);
      
    });
  }

  getStudentsToAttend(){
    this.studentsToAttend = [];
    this.rest.getStudentToAttend().subscribe((data:{})=>{
      this.studentsToAttend = data
      this.dataSource2 = new MatTableDataSource(this.studentsToAttend);
      
    });
  }

  getStudentsOff(){
    this.studentsOff = [];
    this.rest.getStudentsOff().subscribe((data:{})=>{
      this.studentsOff = data
      this.dataSource3 = new MatTableDataSource(this.studentsOff);
      
    });
  }

  serveAccount(studentId, action){
    this.studentsToAttend = [];
    
      if(action == "Accept")
      this.rest.acceptStudentAccount(studentId, 14).subscribe((data:{})=>{
      this.presentAlert("La cuenta del estudiante ha sido aceptada");
      
    this.ngOnInit();
    });
      else 
      this.rest.rejectStudentAccount(studentId, 14).subscribe((data:{})=>{
      this.presentAlert("La cuenta del estudiante ha sido rechazada");
      
    this.ngOnInit();
    });
       
  }

  getStudentById(id): void {

    this.rest.getStudentById(id).subscribe((data)=>{
  
      const dialogRef = this.dialog.open(StudentDetailsPage, {
      
        width: "500px",
        height: "80%",
        data: data,
      });
    
      dialogRef.afterClosed().subscribe((result) => {
        console.log("The dialog was closed");
      });
    
  
    });
  
  }

  deleteStudent(studentId){

    this.rest.deleteStudent(studentId, 14).subscribe((data)=>{
  
      this.presentAlert("La cuenta del estudiante ha sido eliminada con éxito");
      this.ngOnInit();
  
    });
  }

  activateStudentAccount(studentId){
    this.rest.activateStudentAccount(studentId, 14).subscribe((data)=>{

      this.presentAlert("La cuenta del estudiante ha sido activada con éxito");
      this.ngOnInit();
  
    });
  }

  promoteStudent(studentId){
    this.rest.getCurrentUserId()
    this.rest.currentRole.subscribe( (message) => (this.userId = message) );

      this.rest.promoteStudentToPresident(studentId, this.userId).subscribe((data)=>{

      this.presentAlert("El estudiante ha sido promovido con éxito");
      this.ngOnInit()
  
    });
  }

  getPresident(){

      this.rest.getPresident().subscribe((data)=>{
        console.log(data)

      this.presidentName = data.name + " " + data.lastName
          
    });
  }

  async presentAlert(message) {
    const alert = await this.alertController.create({
      cssClass: "my-custom-class",
      header: "Aviso",
      message: message,
      buttons: ["OK"],
    });
  
    await alert.present();
  }

}

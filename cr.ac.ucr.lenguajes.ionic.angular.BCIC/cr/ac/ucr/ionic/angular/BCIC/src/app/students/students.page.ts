import { Component, OnInit, Inject, ViewChild } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { MatPaginator } from "@angular/material/paginator";
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: "app-students",
  templateUrl: "./students.page.html",
  styleUrls: ["./students.page.scss"],
})
export class StudentsPage implements OnInit {

  constructor(public rest:RestService, private route:ActivatedRoute, private router:Router) {  
  }

  students:any=[];
  studentsToAttend:any=[];
  studentsOff:any=[];


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

  serveAccount(){
    this.studentsToAttend = [];
    this.rest.getStudentToAttend().subscribe((data:{})=>{
      this.studentsToAttend = data
      this.dataSource2 = new MatTableDataSource(this.studentsToAttend);
      
    });
  }

}

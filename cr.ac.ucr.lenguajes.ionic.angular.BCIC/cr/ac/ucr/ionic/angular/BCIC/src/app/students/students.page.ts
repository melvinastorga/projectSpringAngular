import { Component, OnInit, Inject, ViewChild } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { MatPaginator } from "@angular/material/paginator";
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  { position: 1, name: "Hydrogen", weight: 1.0079, symbol: "H" },
  { position: 2, name: "Helium", weight: 4.0026, symbol: "He" },
  { position: 3, name: "Lithium", weight: 6.941, symbol: "Li" },
  { position: 4, name: "Beryllium", weight: 9.0122, symbol: "Be" },
  { position: 5, name: "Boron", weight: 10.811, symbol: "B" },
  { position: 6, name: "Carbon", weight: 12.0107, symbol: "C" },
  { position: 7, name: "Nitrogen", weight: 14.0067, symbol: "N" },
  { position: 8, name: "Oxygen", weight: 15.9994, symbol: "O" },
  { position: 9, name: "Fluorine", weight: 18.9984, symbol: "F" },
  { position: 10, name: "Neon", weight: 20.1797, symbol: "Ne" },
];

const ELEMENT_DATA2: PeriodicElement[] = [
  { position: 1, name: "Hydrogen", weight: 1.0079, symbol: "H" },
  { position: 2, name: "Helium", weight: 4.0026, symbol: "He" },
  { position: 3, name: "Lithium", weight: 6.941, symbol: "Li" },
  { position: 4, name: "Beryllium", weight: 9.0122, symbol: "Be" },
  { position: 5, name: "Boron", weight: 10.811, symbol: "B" },
  { position: 6, name: "Carbon", weight: 12.0107, symbol: "C" },
  { position: 7, name: "Nitrogen", weight: 14.0067, symbol: "N" },
  { position: 8, name: "Oxygen", weight: 15.9994, symbol: "O" },
  { position: 9, name: "Fluorine", weight: 18.9984, symbol: "F" },
  { position: 10, name: "Neon", weight: 20.1797, symbol: "Ne" },
];


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


  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  displayedColumns: string[] = ["name", "lastName", "actions"];
  displayedColumns2: string[] = ["name", "lastName", "studentId"];
  
  dataSource = new MatTableDataSource(ELEMENT_DATA2);
  dataSource2 = new MatTableDataSource(ELEMENT_DATA2);
  

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
    this.dataSource2.filter = filterValue.trim().toLowerCase();
  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource2.paginator = this.paginator;
    this.getStudents();
    this.getStudentsToAttend();
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

  serveAccount(){
    this.studentsToAttend = [];
    this.rest.getStudentToAttend().subscribe((data:{})=>{
      this.studentsToAttend = data
      this.dataSource2 = new MatTableDataSource(this.studentsToAttend);
      
    });
  }

}

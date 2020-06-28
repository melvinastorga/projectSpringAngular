import { Component, OnInit, Inject, ViewChild } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { MatPaginator } from "@angular/material/paginator";
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';



@Component({
  selector: "app-professors",
  templateUrl: "./professors.page.html",
  styleUrls: ["./professors.page.scss"],
})
export class ProfessorsPage implements OnInit {

  constructor(public rest:RestService, private route:ActivatedRoute, private router:Router) {  
  }

  professors:any=[];
  professorsOff:any=[];


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

    this.rest.getProfessor().subscribe((data)=>{
      console.log(data);
      this.professors = data;
      this.dataSource = new MatTableDataSource(this.professors);
      this.dataSource.paginator = this.paginator;
      
    });

    this.rest.getProfessorsOff().subscribe((data)=>{
      this.professorsOff = data;
      this.dataSource2 = new MatTableDataSource(this.professorsOff);
      this.dataSource2.paginator = this.paginator;
      
    });



  }


}

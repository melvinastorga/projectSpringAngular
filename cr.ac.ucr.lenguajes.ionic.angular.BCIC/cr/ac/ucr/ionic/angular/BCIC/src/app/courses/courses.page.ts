import { Component, OnInit, Inject, ViewChild } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { MatPaginator } from "@angular/material/paginator";
import { RestService } from "../rest.service";

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

  constructor(public rest: RestService) {

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

    console.log(data);

  });
}

get(id){

  this.rest.getCourse(id).subscribe((data)=>{

    console.log(data);

  });

}

put(){

}

create(){

}

}

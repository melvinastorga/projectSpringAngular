import { Component, OnInit, Inject, ViewChild } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { MatPaginator } from "@angular/material/paginator";
import { Router } from "@angular/router";
import { RestService } from "../rest.service";

@Component({
  selector: "app-my-courses",
  templateUrl: "./my-courses.page.html",
  styleUrls: ["./my-courses.page.scss"],
})
export class MyCoursesPage implements OnInit {
  dataSource: any;
  dataSource2: any;
  myCourses: [];

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  displayedColumns: string[] = ["Code", "Name", "Term", "actions"];

  constructor(public router: Router, public rest: RestService) {}

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  ngOnInit() {
    this.rest.getProfessorCourses(12).subscribe((data) => {
      this.myCourses = data;
      console.log(data);
      this.dataSource = new MatTableDataSource(this.myCourses);
      this.dataSource.paginator = this.paginator;
    });
  }

  goToOfficeHours() {
    this.router.navigate(["professors-office-hours"]);
  }
}

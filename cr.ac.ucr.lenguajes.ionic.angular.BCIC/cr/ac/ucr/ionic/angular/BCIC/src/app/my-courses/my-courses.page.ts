import { Component, OnInit, Inject, ViewChild } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { MatPaginator } from "@angular/material/paginator";
import { Router } from "@angular/router";
import { RestService } from "../rest.service";
import { MatDialog } from "@angular/material/dialog";
import { AlertController } from "@ionic/angular";
import { CourseDetailsPage } from "../course-details/course-details.page";

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

  constructor(
    public rest: RestService,
    public dialog: MatDialog,
    public alertController: AlertController,
    public router: Router
  ) {}

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

  get(id): void {
    this.rest.getCourse(id).subscribe((data) => {
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
}

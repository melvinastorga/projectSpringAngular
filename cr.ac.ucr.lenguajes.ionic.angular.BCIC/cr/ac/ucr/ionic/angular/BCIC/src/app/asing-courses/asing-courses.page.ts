import { Component, OnInit, Inject } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { RestService } from "../rest.service";

export interface DialogData {
  data: any;
}

@Component({
  selector: "app-asing-courses",
  templateUrl: "./asing-courses.page.html",
  styleUrls: ["./asing-courses.page.scss"],
})
export class AsingCoursesPage implements OnInit {
  courseid: any;
  professors: any;
  id: any;
  constructor(
    public dialogRef: MatDialogRef<AsingCoursesPage>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
    public rest: RestService
  ) {}

  ngOnInit() {
    this.rest.getProfessor().subscribe((data) => {
      this.professors = data;
      console.log(this.professors);
    });
  }

  asing() {
    
    

    var courseProfessor = {
      courseId: this.data,
      professorId: this.id,
    };
    
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}

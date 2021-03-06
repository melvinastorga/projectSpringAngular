import { Component, HostListener, OnInit } from "@angular/core";
import { Platform, MenuController } from "@ionic/angular";
import { SplashScreen } from "@ionic-native/splash-screen/ngx";
import { StatusBar } from "@ionic-native/status-bar/ngx";
import { MatDialog } from "@angular/material/dialog";
import { Router } from "@angular/router";
import { CommentsPage } from "../comments/comments.page";
import { RestService } from "../rest.service";

@Component({
  selector: "app-home",
  templateUrl: "home.page.html",
  styleUrls: ["home.page.scss"],
})
export class HomePage implements OnInit {
  constructor(
    private platform: Platform,
    private splashScreen: SplashScreen,
    private statusBar: StatusBar,
    private menu: MenuController,
    public dialog: MatDialog,
    public router: Router,
    public rest: RestService
  ) {}

  CAROUSEL_BREAKPOINT = 768;
  carouselDisplayMode = "multiple";
  newsCards = [];
  blockSelected: 1;

  coursesCards = [];
  professor:any;
  professor1:any;
  professorsCards = [];
  profesortest:any;

  slidesProfessors: any = [[]];
  slidesCourses: any = [[]];
  slidesNews: any = [[]];
  professors: any;
  courses: any;

  blocks = [
    { value: "1", viewValue: "1" },
    { value: "2", viewValue: "2" },
    { value: "3", viewValue: "3" },
    { value: "4", viewValue: "4" },
    { value: "5", viewValue: "5" },
    { value: "6", viewValue: "6" },
    { value: "7", viewValue: "7" },
    { value: "8", viewValue: "8" },
  ];

  chunk(arr, chunkSize) {
    let R = [];
    for (let i = 0, len = arr.length; i < len; i += chunkSize) {
      R.push(arr.slice(i, i + chunkSize));
    }
    return R;
  }

  async forTofillnews() {
    this.blockSelected = 1;
    return new Promise((response) => {
      this.rest.getNews().subscribe((data) => {


        for (let index = 0; index < data.length; index++) {
          var item = {
            id: data[index].noticeId,
            title: data[index].title,
            description: data[index].noticeString,
            name: data[index].personName,
            lastName: data[index].personLastName,
            buttonText: "Comentarios",
            img: "https://mdbootstrap.com/img/Photos/Slides/img%20(68).jpg",
          };

          this.newsCards.push(item);
        }
        response("");
      });
    });
  }

  async forTofillCourses(num) {
    this.blockSelected = num;
    this.slidesCourses = [[]];
    this.coursesCards = [];
    return new Promise((response) => {
      this.rest.getCourses().subscribe((data) => {

        for (let index = 0; index < data.length; index++) {
          if (data[index].term == num) {
            var item = {
              name: data[index].name,
              description: data[index].description,
              code: data[index].code,
              term: data[index].term,
              credits: data[index].credits,
              id: data[index].courseId,
            };

            this.coursesCards.push(item);
          }
        }
        response("");
      });
    });
  }

  async forTofillProfessors() {
    return new Promise((response) => {
      this.rest.getProfessor().subscribe((data) => {
        for (let index = 0; index < data.length; index++) {
          var item = {
            professorId: data[index].professorId,
            name: data[index].name,
            lastName: data[index].lastName,
            email: data[index].email,
            interests: data[index].interests,
            courseId:data[index].courseId,
            especiality: data[index].especiality,
            img: "https://mdbootstrap.com/img/Photos/Slides/img%20(68).jpg",
          };

          this.professorsCards.push(item);
        }
        response("");
      });
    });
  }

  getProfessors(courseId) {
    this.professors = [];

    this.rest.getProfessorByCourse(courseId).subscribe((data) => {
    
      this.professors = data;
    });
  }

  getCourses(professorId) {
    this.courses = [];

    console.log(professorId);
    this.rest.getCoursesByProfessor(professorId).subscribe((data) => {
      console.log(data);
      this.courses = data;
    });
  }
  async forTofillCourses2(num) {
    var fillCourses = await this.forTofillCourses(num);

    this.slidesNews = this.chunk(this.newsCards, 3);
    this.slidesProfessors = this.chunk(this.professorsCards, 3);
    this.slidesCourses = this.chunk(this.coursesCards, 5);

    if (window.innerWidth <= this.CAROUSEL_BREAKPOINT) {
      this.carouselDisplayMode = "single";
    } else {
      this.carouselDisplayMode = "multiple";
    }
  }

  async ngOnInit() {
    var fillNews = await this.forTofillnews();
    var fillCourses = await this.forTofillCourses(1);
    var forTofillProfessors = await this.forTofillProfessors();

    this.slidesNews = this.chunk(this.newsCards, 3);
    this.slidesProfessors = this.chunk(this.professorsCards, 3);
    this.slidesCourses = this.chunk(this.coursesCards, 5);

    if (window.innerWidth <= this.CAROUSEL_BREAKPOINT) {
      this.carouselDisplayMode = "single";
    } else {
      this.carouselDisplayMode = "multiple";
    }
  }

  openCommentsDialog(id): void {
    const dialogRef = this.dialog.open(CommentsPage, {
      width: "500px",
      height: "92%",
      data: id
    });

console.log(id)

    dialogRef.afterClosed().subscribe((result) => {
      console.log("The dialog was closed");
    });
  }

  @HostListener("window:resize")
  onWindowResize() {
    if (window.innerWidth <= this.CAROUSEL_BREAKPOINT) {
      this.carouselDisplayMode = "single";
    } else {
      this.carouselDisplayMode = "multiple";
    }
  }
}

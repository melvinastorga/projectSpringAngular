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

  newsCards = [
    {
      title: "Card Title 1",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img: "https://mdbootstrap.com/img/Photos/Slides/img%20(68).jpg",
    },
    {
      title: "Card Title 2",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 3",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 4",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 5",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content ",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 6",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 7",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 8",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 9",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
  ];

  coursesCards = [
    {
      title: "Card Title 1",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img: "https://mdbootstrap.com/img/Photos/Slides/img%20(68).jpg",
    },
    {
      title: "Card Title 2",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 3",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 4",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 5",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content ",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 6",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 7",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 8",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 9",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
  ];

  professorsCards = [
    {
      title: "Card Title 1",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img: "https://mdbootstrap.com/img/Photos/Slides/img%20(68).jpg",
    },
    {
      title: "Card Title 2",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 3",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 4",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 5",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content ",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 6",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 7",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 8",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
    {
      title: "Card Title 9",
      description:
        "Some quick example text to build on the card title and make up the bulk of the card content",
      buttonText: "Comentarios",
      img:
        "https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg",
    },
  ];

  slidesProfessors: any = [[]];
  slidesCourses: any = [[]];
  slidesNews: any = [[]];

  chunk(arr, chunkSize) {
    let R = [];
    for (let i = 0, len = arr.length; i < len; i += chunkSize) {
      R.push(arr.slice(i, i + chunkSize));
    }
    return R;
  }

  forTofillnews() {
    
    this.rest.getNews().subscribe((data) => {
      for (let index = 0; index < data.length; index++) {
        var item = {
          title: data.title,
          description: data.noticestring,
          buttonText: "Comentarios",
          img: "https://mdbootstrap.com/img/Photos/Slides/img%20(68).jpg",
        };

        this.newsCards.push(item);
      }
    });
  }

  ngOnInit() {
    this.slidesNews = this.chunk(this.newsCards, 3);
    this.slidesProfessors = this.chunk(this.coursesCards, 3);
    this.slidesCourses = this.chunk(this.professorsCards, 5);

    if (window.innerWidth <= this.CAROUSEL_BREAKPOINT) {
      this.carouselDisplayMode = "single";
    } else {
      this.carouselDisplayMode = "multiple";
    }
  }

  openCommentsDialog(): void {
    const dialogRef = this.dialog.open(CommentsPage, {
      width: "500px",
      height: "92%",
    });

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

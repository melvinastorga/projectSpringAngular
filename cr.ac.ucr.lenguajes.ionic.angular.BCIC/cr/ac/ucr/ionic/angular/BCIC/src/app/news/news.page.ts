import { Component, OnInit, ViewChild } from "@angular/core";
import { MatPaginator } from "@angular/material/paginator";
import { RestService } from "../rest.service";
import { MatDialog } from "@angular/material/dialog";
import { AlertController } from "@ionic/angular";
import { Router } from "@angular/router";
import { MatTableDataSource } from "@angular/material/table";
import { CreateUpdateNewsPage } from "../create-update-news/create-update-news.page";

export interface DialogData{
  data : any,
  action : any
}

@Component({
  selector: "app-news",
  templateUrl: "./news.page.html",
  styleUrls: ["./news.page.scss"],
})
export class NewsPage implements OnInit {
  news: [];
  dataSource: any;

  constructor(
    public rest: RestService,
    public dialog: MatDialog,
    public alertController: AlertController,
    public router: Router
  ) {}

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  displayedColumns: string[] = [
    "title",
    "personName",
    "personLastName",
    "actions",
  ];

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  async ngOnInit() {
    this.rest.getNews().subscribe((data) => {
      this.news = data;
      this.dataSource = new MatTableDataSource(this.news);
      this.dataSource.paginator = this.paginator;
    });
  }

  create() {
    const dialogRef = this.dialog.open(CreateUpdateNewsPage, {
      width: "500px",
      height: "80%",
      data: null,
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log("The dialog was closed");
    });
  }

  get(id): void {

    var action1={"action":"details"};
    this.rest.getNewsById(id).subscribe((data) => {
      const dialogRef = this.dialog.open(CreateUpdateNewsPage, {
        width: "500px",
        height: "80%",
        data: {data,action1},
        
      });

      dialogRef.afterClosed().subscribe((result) => {
        console.log("The dialog was closed");
      });
    });
  }

  async presentAlert() {
    const alert = await this.alertController.create({
      cssClass: "my-custom-class",
      header: "Aviso",
      message: "El curso se ha eliminado con exito",
      buttons: ["OK"],
    });

    await alert.present();
  }

  delete(id) {
    this.rest.deleteNews(id).subscribe((data) => {
      this.presentAlert();
      this.ngOnInit();
    });
  }

  put(id) {
    
    var action1={"action":"update"};
    this.rest.getNewsById(id).subscribe((data) => {
    

      const dialogRef = this.dialog.open(CreateUpdateNewsPage, {
        width: "500px",
        height: "80%",
        data: { data,action1},
      });

      dialogRef.afterClosed().subscribe((result) => {
        console.log("The dialog was closed");
      });
    });
  }
}

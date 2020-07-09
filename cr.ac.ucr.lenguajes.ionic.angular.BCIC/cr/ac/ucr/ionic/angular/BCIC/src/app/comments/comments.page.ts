import { Component, OnInit, Inject } from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialogRef,
  MatDialog,
} from "@angular/material/dialog";
import { Router, ActivatedRoute } from '@angular/router';
import { AlertController } from '@ionic/angular';
import { RestService } from '../rest.service';

export interface DialogData {

}
@Component({
  selector: 'app-comments',
  templateUrl: './comments.page.html',
  styleUrls: ['./comments.page.scss'],
})
export class CommentsPage implements OnInit {

  constructor(public rest:RestService, 
    public dialog: MatDialog, 
    public alertController: AlertController, 
    private route:ActivatedRoute, 
    private router:Router,
    public dialogRef: MatDialogRef<CommentsPage>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) { }

  id:any
  commentaryString:''
  userId:any
  commentaryId:0
  
  ngOnInit() {
    this.id = this.data
    
    this.rest.getCurrentUserId()
    this.rest.currentUserId.subscribe( (message) => (this.userId = message) );

  }

  onNoClick(): void {
    this.dialogRef.close();
    
  }

  postComment(): void {

    var comment={
      "commentaryId":this.commentaryId,
      "personId": this.userId ,
      "noticeId": this.id,
      "commentaryString": this.commentaryString
    }

    console.log(comment)

    this.rest.postCommentary(comment).subscribe((data)=>{
  
      this.dialogRef.afterClosed().subscribe((result) => {
        console.log("The dialog was closed");
      });
    
  
    });
  
  }

}

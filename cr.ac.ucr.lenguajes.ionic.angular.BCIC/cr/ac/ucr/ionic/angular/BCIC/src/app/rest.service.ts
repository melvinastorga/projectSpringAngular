import { Injectable } from "@angular/core";
import {
  HttpHeaders,
  HttpErrorResponse,
  HttpClient,
} from "@angular/common/http";
import { Observable, of, BehaviorSubject } from "rxjs";
import { map, catchError, tap } from "rxjs/operators";
import { Storage } from "@ionic/storage";

const httpOptions = {
  headers: new HttpHeaders({
    "Content-Type": "application/json",
  }),
};

@Injectable({
  providedIn: "root",
})
export class RestService {


  /*----------------------Index-----------------------
 
  1. Stored variables  - line  *
  2. Methods to set stored variables - line *
  3. Methods to get stored variables - line *
  4. Login Method - line *
  5. Logout Method - line *
  6. Student Methods - line *
  7. Professors Methods - line *
  8. Courses Methods - line *
  continue...

  N. Error handler - line *

  ----------------------------------------------------*/ 

  //--------------Stored variables in session-----------------
  private username = new BehaviorSubject("error username null");
  public currentUsername = this.username.asObservable();

  private role = new BehaviorSubject("error role null");
  public currentRole = this.role.asObservable();

  private userId = new BehaviorSubject("error user id null");
  public currentUserId = this.userId.asObservable();

  private endPoint = new BehaviorSubject("http://localhost:8080/api");
  public currentendPoint = this.endPoint.asObservable();

  private endPointNewsApi = "https://localhost:44358/api";

  //----------------------------------------------------------

  //----------change or set session variables values---------

  public setUser(username: string) {
    this.username.next(username);
    this.storage.set("name", username);
  }
  public setUserId(id: string) {
    this.userId.next(id);
    this.storage.set("userId", id);
  }
  public setRole(role: string) {
    this.role.next(role);
    this.storage.set("role", role);
  }

  public setEndPoint(endPoint: string) {
    this.endPoint.next(endPoint);
  }
  //----------------------------------------------------------

  //---------------Get session variables values---------------

  public async getCurrentUser() {
    return new Promise((response) => {
      this.storage.get("name").then((val) => {
        this.username.next(val);
        response(val);
      });
    });
  }

  public async getCurrentUserId() {
    return new Promise((response) => {
      this.storage.get("userId").then((val) => {
        this.userId.next(val);
        response(val);
      });
    });
  }

  public async getCurrentRole() {
    return new Promise((response) => {
      this.storage.get("role").then((val) => {
        this.role.next(val);
        response(val);
      });
    });
  }

  //----------------------------------------------------------

  //-------------------------Login----------------------------

  login(user): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(path + "guerrilla/" + user.name, user, httpOptions)
      .pipe(map(this.extractData), catchError(this.handleError<any>("login")));
  }
  //----------------------------------------------------------

  //-------------------------Logout---------------------------
  public async logout() {
    return new Promise((response) => {
      this.storage.remove("name");
      this.username.next("");

      response("ha cerrado session");
    });
  }
  //----------------------------------------------------------

  constructor(private http: HttpClient, private storage: Storage) {}

  private extractData(res: Response) {
    let body = res;
    return body || {};
  }

  //--------------------Student methods------------------------

  getStudentById(studentId){
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path +
        "/getStudentById/" +
        studentId, 
        httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getData"))
      );
  }

  deleteStudent(studentId, updatedBy){
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .delete(path +
        "/desactivateAccount/" +
        studentId
        + "/" +
        updatedBy,
        httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getData"))
      );
  }

  activateStudentAccount(studentId, updatedBy){
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(path +
        "/activateAccount/" +
        studentId
        + "/" +
        updatedBy,
        httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getData"))
      );
  }

  getStudents(): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path + "/getAllStudent")
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getData"))
      );
  }

  getStudentToAttend(): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path + "/getStudentToAttend")
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getData"))
      );
  }

  getStudentsOff(): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path + "/getStudentsOff")
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getData"))
      );
  }

  acceptStudentAccount(studentId, updatedBy) {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(
        path +
          "/acceptStudentAccount/" +
          studentId +
          "/" +
          updatedBy,
        httpOptions
      )
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("ranking"))
      );
  }

  rejectStudentAccount(studentId, updatedBy) {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(
        path +
          "/rejectStudentAccount/" +
          studentId +
          "/" +
          updatedBy,
        httpOptions
      )
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("ranking"))
      );
  }

  promoteStudentToPresident(studentId, updatedBy) {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(
        path +
          "/president/promoteStudent/" +
          studentId +
          "/" +
          updatedBy,
        httpOptions
      )
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("ranking"))
      );
  }
  
  //--------------------------------------------------------------

  //---------------------Professors methods-----------------------

  getProfessor(): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path + "/getAllProfessor")
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getData"))
      );
  }

  getProfessorsOff(): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path + "/getProfessorsOff")
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getData"))
      );
  }

  getProfessorById(professorId){
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path +
        "/getProfessorById/" +
        professorId, 
        httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getData"))
      );
  }

  putProfessor(professor): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(path + "/professor/updateProfessor",professor,httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("putProfessor"))
      );
  }

  postProfessor(professor): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(path + "/professor/postProfessor",professor,httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("postCourse"))
      );
  }

  deleteProfessor(studentId, updatedBy){
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .delete(path +
        "/desactivateAccount/" +
        studentId
        + "/" +
        updatedBy,
        httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getData"))
      );
  }
  //--------------------------------------------------------------

  //-----------------------Courses methods------------------------


  getCourses(): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path + "/course/getActivecourses")
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getCourses"))
      );
  }
  getInactiveCourses(): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path + "/course/getOffcourses")
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getInactiveCourses"))
      );
  }

  getProfessorCourses(professorId): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path + "/professorCourse/getCourseByProfessor/"+professorId)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getProfessorCourses"))
      );
  }

  
   getCourse(id): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path + "/course/getCourse/"+id)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getCourse"))
      );
  }

  deleteCourses(id): Observable<any> {

    var course = {
      "courseId":id
    }
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(path + "/course/deleteCourse",course,httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("deleteCourse"))
      );
  }


 putCourses(course): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(path + "/course/updateCourse",course,httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("putCourse"))
      );
  }

  postCourses(course): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(path + "/course/insertCourse",course,httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("postCourse"))
      );
  }



  //---------------------------------------------------------------

  //-------------------------News Methods------------------------

  getNews(){
    
    return this.http
      .get(this.endPointNewsApi+"/notice/GetAllNoticesSP",httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getNews"))
      );
  }

  postNews(news): Observable<any> {
    //https://localhost:44358/api/notice/PostNotice
    return this.http
      .post(this.endPointNewsApi + "/notice/PostNotice",news,httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("postNews"))
      );
  }

  //-------------------------Places Methods------------------------

  
  getDistric(provinceId, cantonId): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path + "/getDistric/"+provinceId+"/"+cantonId, httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getDistrict"))
      );
  }

  getCanton(provinceId): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path + "/getCanton/"+provinceId)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getCanton"))
      );
  }

  getProvince(): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path + "/getProvinces")
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getProvince"))
      );
  }

  //-------------------------Errors handler------------------------
  private handleError<T>(operation = "operation", result?: T) {
    return (error: any): Observable<T> => {
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
  //---------------------------------------------------------------
}



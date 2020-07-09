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

  private superUser = new BehaviorSubject("");
  public currentsuperUser = this.superUser.asObservable();

  private endPoint = new BehaviorSubject("http://localhost:8080/api");
  public currentendPoint = this.endPoint.asObservable();

  private endPointNewsApi = "https://localhost:44358/api";

  private professorCourseId = new BehaviorSubject("");
  public currentprofessorCourseId= this.professorCourseId.asObservable();

  //----------------------------------------------------------

  //----------change or set session variables values---------

  public setUser(username: string) {
    this.username.next(username);
    this.storage.set("name", username);
  }
  public setprofessorCourseId(professorCourseId: string) {

    this.professorCourseId.next(professorCourseId);
  
  }
  public setUserId(id: string) {
    this.userId.next(id);
    this.storage.set("userId", id);
  }

  public setSuperUser(id: string) {
    this.superUser.next(id);
    this.storage.set("superUser", id);
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
      this.storage.get("name").then((val) => {
        this.username.next(val);
      });
  }

  public async getCurrentUserId() {
      this.storage.get("userId").then((val) => {
        this.userId.next(val);
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


  login(loginModel): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(path + "/authenticateUser", loginModel, httpOptions)
      .pipe(
        map(this.extractData), 
      catchError(this.handleError<any>("login")));
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

  getImage(userId){
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path +
        "/imageString/" +
        userId, 
        httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getData"))
      );
  }

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
  postStudent(student): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(path + "/postStudent",student,httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("postStudent"))
      );
  }
  
  putStudent(student): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(path + "/updateStudent",student,httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("putStudent"))
      );
  }

  getPresident(studentId, updatedBy) {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(
        path +
          "/president/getPresident"
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
  promoteProfessorToAdmin(professorId, updatedBy) {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(
        path +
          "/promoteProfessor/" +
          professorId +
          "/" +
          updatedBy,
        httpOptions
      )
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("ranking"))
      );
  }
  getProfessorByCourse(courseId){
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path +
        "/courseProfessor/getProfessorByCourse/" +
        courseId, 
        httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getProfessorsByCourse"))
      );
     
  }

  
  

  putProfessor(professor): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(path + "/updateProfessor",professor,httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("putProfessor"))
      );
  }

  postProfessor(professor): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(path + "/postProfessor",professor,httpOptions)
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

 deleteProfessorCourses(id): Observable<any> {
  var professorCourse = {
      "professorCourseId":id
    }
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(path + "/professorCourse/deleteProfessorCourse",professorCourse,httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("deleteProfessorCourses"))
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

  postProfessorCourse(professorCourse): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(path + "/professorCourse/insertUpdateProfessorCourse",professorCourse,httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("postProfessorCourse"))
      );
  }

  getCoursesByProfessor(professorId){
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path +
        "/professorCourse/getCourseByProfessor/" +
        professorId, 
        httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getProfessorsByCourse"))
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
  
    return this.http
      .post(this.endPointNewsApi + "/notice/PostNotice",news,httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("postNews"))
      );
  }

  putNews(news): Observable<any> {

    return this.http
      .post(this.endPointNewsApi + "/notice/PutNotice",news,httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("postNews"))
      );
  }

  deleteNews(id): Observable<any> {

    return this.http
      .delete(this.endPointNewsApi+"/notice/DeleteNotice/"+id,httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("deleteNews"))
      );
  }

  getNewsById(id){
    
    return this.http
      .get(this.endPointNewsApi+"/notice/GetNotice/"+id,httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>(" getNewsById"))
      );
  }

  
  //-------------------------Comments Methods------------------------

  postCommentary(commentary): Observable<any> {

    return this.http
      .post(this.endPointNewsApi + "/commentary/PostCommentary",commentary,httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("postCommentary"))
      );
  }

  getCommentaries(id){
    
    return this.http
      .get(this.endPointNewsApi+"/commentary/GetCommentariesByNotice/id",httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getCommentaries"))
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



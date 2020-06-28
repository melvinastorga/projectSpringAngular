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
  private username = new BehaviorSubject("error");
  public currentUsername = this.username.asObservable();

  private endPoint = new BehaviorSubject(
    "http://localhost:8080/api"
  );
  public currentendPoint = this.endPoint.asObservable();

  public setUser(username: string) {
    this.username.next(username);
    this.storage.set("name", username);
  }

  public setEndPoint(endPoint: string) {
    this.endPoint.next(endPoint);
  }

  constructor(private http: HttpClient, private storage: Storage) {}

  private extractData(res: Response) {
    let body = res;
    return body || {};
  }

// Student methods

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

serveStudentAccount(studentId, updatedBy, action) {
  var path;
  this.currentendPoint.subscribe((result) => (path = result));
  return this.http
    .post(
      path +
        "serveStudentAccount?studentId=" +
        studentId +
        "&updatedBy=" +
        updatedBy +
        "&action=" +
        action,
      httpOptions
    )
    .pipe(
      map(this.extractData),
      catchError(this.handleError<any>("ranking"))
    );
}

//professor methods

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

  public async getCurrentUser() {
    return new Promise((response) => {
      this.storage.get("name").then((val) => {
        this.username.next(val);
        response(val);
      });
    });
  }

  public async logout() {
    return new Promise((response) => {
      this.storage.remove("name");
      this.username.next("");

      response("ha cerrado session");
    });
  }

  //login or create account
  login(user): Observable<any> {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(path + "guerrilla/" + user.name, user, httpOptions)
      .pipe(map(this.extractData), catchError(this.handleError<any>("login")));
  }

  //get the users data show it in their profile
  getUserData(name) {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(path + "guerrilla/" + name, httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("getData"))
      );
  }

  //buy the units and get the actual resources
  buyUnits(data) {
    console.log(data);
    var path;
    var name;
    this.currentUsername.subscribe((result) => (name = result));
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .put(path + "guerrilla/" + name + "/units", data, httpOptions)
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("buyUnits"))
      );
  }
  //start the battle and get the results
  attack(atacante, atacado) {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .post(
        path + "guerrilla/attack/" + atacado + "/?guerrillaSrc=" + atacante,
        httpOptions
      )
      .pipe(map(this.extractData), catchError(this.handleError<any>("attack")));
  }

  //get ranking filtered
  getRanking(name, email, faction) {
    var path;
    this.currentendPoint.subscribe((result) => (path = result));
    return this.http
      .get(
        path +
          "guerrilla?name=" +
          name +
          "&email=" +
          email +
          "&faction=" +
          faction,
        httpOptions
      )
      .pipe(
        map(this.extractData),
        catchError(this.handleError<any>("ranking"))
      );
  }
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
}

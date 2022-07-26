import {HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, map, Observable, throwError } from 'rxjs';

interface Header {
  [property: string]: any
}

@Injectable({
  providedIn: 'root'
})
export class RestService {

  private static readonly HEADER: Header = {
    headers: new HttpHeaders({
      Accept: 'application/json; charset=UTF-8',
      'Content-Type': 'application/json; charset=UTF-8',
    })
  };

  private endpoint;

  constructor(private readonly http: HttpClient) {
  }

  setEndpoint(endpoint: string, ...args: string[]) {
    let endpointWithParams = endpoint;

    for (let arg of args) {
      endpointWithParams = endpointWithParams.concat('/' + arg);
    }

    this.endpoint = endpointWithParams;
  }

  doGet<T>(): Observable<T>{
    return this.http.get(this.endpoint, RestService.HEADER).pipe(
      map((result: HttpResponse<T> | any) => {
        return result;
      }),
      catchError(err => this.handleError(err))
    );
  }

  doPost<T>(body: any): Observable<T>{
    return this.http.post(this.endpoint, body, RestService.HEADER).pipe(
      map((result: HttpResponse<T> | any) => {
        return result;
      }),
      catchError(err => this.handleError(err))
    );
  }

  doPut<T>(body: any): Observable<T>{
    return this.http.put(this.endpoint, body, RestService.HEADER).pipe(
      map((result: HttpResponse<T> | any) => {
        return result;
      }),
      catchError(err => this.handleError(err))
    );
  }

  doDelete<T>(): Observable<T>{
    return this.http.delete(this.endpoint, RestService.HEADER).pipe(
      map((result: HttpResponse<T> | any) => {
        return result;
      }),
      catchError(err => this.handleError(err))
    );
  }

  private handleError(err: HttpErrorResponse){
    console.log(err);
    return throwError(() => err)
  }
}

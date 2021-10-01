import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { User } from "../models/user";
import { recurso } from "./recurso";

@Injectable()
export class UserService{
    public url:string;

    constructor(public _http: HttpClient){
        this.url = recurso.url;
    }

    list(name?:string):Observable<any>{
        let headers = new HttpHeaders().set('Content-Type', 'application/json');
        let uri = name ? 'Usuario/list/' + name : 'Usuario/list';

        return this._http.get(this.url + uri, {headers:headers});
    }

    getUser(id: number):Observable<any>{
        let headers = new HttpHeaders().set('Content-Type', 'application/json');
        return this._http.get(this.url + 'Usuario/' + id, {headers: headers});
    }

    save(user:User): Observable<any>{
        let json = JSON.stringify(user);
        let headers = new HttpHeaders().set('Content-Type', 'application/json');

        return this._http.post(this.url + 'Usuario/save', json, {headers:headers});
    }

    update(user:any): Observable<any>{
        user['id'] = user.id_usuario;

        let json = JSON.stringify(user);
        let headers = new HttpHeaders().set('Content-Type', 'application/json');

        return this._http.put(this.url + 'Usuario/update', json, {headers:headers});
    }

    delete(id: number): Observable<any>{
        let headers = new HttpHeaders().set('Content-Type', 'application/json');

        return this._http.delete(this.url + 'Usuario/delete/' + id, {headers:headers});
    }
}

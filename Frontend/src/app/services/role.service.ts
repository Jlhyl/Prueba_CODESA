import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Role } from "../models/role";
import { recurso } from "./recurso";
import { stringify } from "@angular/compiler/src/util";

@Injectable()
export class RoleService{
    public url: string;

    constructor(public _http: HttpClient){
        this.url = recurso.url;
    }

    getRoles(){
        let headers = new HttpHeaders().set('Content-Type', 'application/json');
        return this._http.get(this.url + 'Rol/list', {headers:headers});
    }
}

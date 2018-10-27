import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';
import { share } from 'rxjs/operators/share';

import { DTOUser } from '../model';

/**
 *  Servicio usado para gestionar la seguridad del usuario
 */
@Injectable()
export class SecurityService { 

    private user: DTOUser;

    private authentication = new Subject<DTOUser>();
	
    private observerUser: Observable<any>; 

    /**
     * Constructor de la clase
     * @param HttpClient servicio para hacer peticiones http
     */
    constructor(private http: HttpClient) {
    }

    refreshUser() {
        if (this.observerUser == null) {
            this.observerUser = this.http.get('' + '');
        } 
        this.observerUser.subscribe(user => {
			this.authentication.next(user);
			this.user = user;
		});
    }

    getUser(): Observable<DTOUser> {
        const self = this;
        setTimeout(function() {
            self.refreshUser();
        }, 500);
        return this.authentication.asObservable();
    }

    getMenu(): Promise<string> {
        return new Promise(resolver => {
            if (this.user != null) {
                //resolver(this.user.menu);
            } else {
                this.getUser().subscribe(user => {
                   //resolver(user.menu);
                });
            }
        });
    }

    checkAuthentication(): Observable<string> { 
        return this.http.post<string>('' + '', {});
    }

    isLoggedIn(): boolean {
        return this.user != null;
    }

    isAuthorizedResource(resource: string): Observable<boolean> {
        return this.http.post<boolean>('' + '', resource);
    }

    fullLogout() {
        this.clearObserverForLogin();
    }

    clearObserverForLogin() {
        this.observerUser = null;
        this.user = null;
    }
}

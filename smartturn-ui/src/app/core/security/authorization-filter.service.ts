import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { CanActivate, CanActivateChild, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { SecurityService } from './security.service';

/**
 * Clase de filtro que permite el acceso a recursos dentro de la aplicacion
 */
@Injectable()
export class AuthorizationFilter implements CanActivate, CanActivateChild {

    /**
     * Constructor de la clase
     * @param router 			objeto para controlar el enrutamiento de la aplicación
     * @param securityService 	servicio que valida con la seguridad de la aplicacion
     */
    constructor(private router: Router,
                private securityService: SecurityService) {}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<boolean> {
        return this.doChecking(state);
    }

    canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<boolean> {
        return this.doChecking(state);
    }
	
    doChecking(state: RouterStateSnapshot): Promise<boolean> {
        return new Promise(resolver => {
            if (!this.securityService.isLoggedIn()) {
                this.securityService.checkAuthentication().subscribe( form => {
                      if (form === 'logged') {
                          this.checkResource(state.url, resolver);
                      } else {
                          this.router.navigate(['login']);
                      }
                   }, error => console.error(error));
            }
            this.checkResource(state.url.substring(1), resolver);
        });
    }

    checkResource(url: string, resolver: Function) {
        this.securityService.isAuthorizedResource(url).subscribe(res => {
            if (!res) {
              this.router.navigate(['access-denied']);
            }
            resolver(res);
        }, error => {
            this.router.navigate(['access-denied']);
            console.error(error);
            resolver(false);
        });
    }

}

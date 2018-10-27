import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse, HttpEventType } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';
import { throwError } from 'rxjs';
import 'rxjs/add/operator/do'; 

/**
 * Permite usar instrucciones jquery
 */
declare var $: any;

/**
 * Control para interceptar peticiones
 */
@Injectable()
export class HttpInterceptRequestService implements HttpInterceptor {

    /**
     * Constructor de la clase
     * @param {Router} Configuracion de rutas
     */
    constructor(private router: Router) {
    }

    showComponent(event: HttpEvent<any>, message: string): void {
        console.debug(message);
        if ($('body .loading-progress').length <= 0 && event.type !== HttpEventType.Response) {
            $('body').append(
               '<div class="loading-progress">' +
               '  <div class="loading">' +
               '  <i class="fa fa-circle-o-notch fa-spin" style="font-size:24px"></i>' +
               '  <span>Cargando componentes</span>' +
               '</div>' +
               '</div>');
        }
    }

    hideComponent(): void {
        if ($('body .loading-progress').length) {
            $('body .loading-progress').remove();
        }
    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        req.headers.append('X-APP-RELAYSTATE', this.router.url);
        return next.handle(req).do((event: HttpEvent<any>) => {
            this.hideComponent();
            switch (event.type) {
              case HttpEventType.Sent:
                 this.showComponent(event, 'Peticion enviada!'); 
                 break;
              case HttpEventType.ResponseHeader:
                 this.showComponent(event, 'Respuesta de encabezado recibida!');
                 break;
              case HttpEventType.Response:
                 this.showComponent(event, 'Realizado!');
                 break;
              default:
                 break;
            }
        }, (err: any) => {
            this.hideComponent();
            if (err instanceof HttpErrorResponse) {
                switch (err.status) {
                    case 403:
                        this.router.navigate(['/access-denied']);
                        return throwError(err);
                    default:
                        return throwError(err);
                }
            }
        });
    }
}

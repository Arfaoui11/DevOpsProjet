import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OperateurService {
  //readonly API_URL = 'http://192.168.1.15:8089/SpringMVC/operateur';

  constructor(private httpClient: HttpClient) { }

  getAllOperateurs() {
    return this.httpClient.get(`http://192.168.1.15:8089/SpringMVC/operateur/retrieve-all-operateurs`)
  }
  addOperateur(operateur : any) {
    return this.httpClient.post(`http://192.168.1.15:8089/SpringMVC/operateur/add-operateur`, operateur)
  }
  editOperateur(operateur : any){
    return this.httpClient.put(`http://192.168.1.15:8089/SpringMVC/operateur/modify-operateur`, operateur)
  }
  deleteOperateur(idOperateur : any){
    return  this.httpClient.delete(`http://192.168.1.15:8089/SpringMVC/operateur/remove-operateur/${idOperateur}`)
  }
}

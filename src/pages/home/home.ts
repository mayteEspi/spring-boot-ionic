import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { ProvidersUsersProvider } from '../../providers/providers-users/providers-users';
import { User } from '../../interfaces';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html',
  providers: [ProvidersUsersProvider]
})
export class HomePage {

  users: User[];

  constructor(public navCtrl: NavController, private userProvider: ProvidersUsersProvider) {

  }

  ngOnInit()  {
    this.getAllUsers();
  }

  getAllUsers() {
    console.log('entro');
    return this.userProvider.list()
     .subscribe(users => this.users = users)
  }
  
}



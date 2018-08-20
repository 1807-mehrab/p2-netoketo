import Controller from '@ember/controller';
import  { inject as service } from '@ember/service';
import AjaxService from 'ember-ajax/services/ajax';

export default Controller.extend({
    //ajax: service('ajax'),
    /*
    actions: {
        login(nkusername,nkpassword) {
            //var result = this.store.createRecord("login", {userid: 1, username: nkusername, 
            //    password: nkpassword, email: 'stuff', accounttype:0});
            var result = this.store.createRecord('login')
            var onSuccess = function(){
                console.log("success");
                
                self.transitionTo('home');
            }
            var onFail = function(){
                console.log("failure");
                console.log(nkusername);
                console.log(nkpassword);
            }
            var self = this;
            this.store.push
            result.save().then(onSuccess,onFail);
        
        }
       /*
        login(nkusername,nkpassword){
            let logindata = this.get('ajax').request('/login', {
                
                method: 'POST',
                data: {userid: 1, username: nkusername, password: nkpassword, email: 'stuff',accounttype:0}
            });
            console.log(logindata);
        }
        
    }
    */
});

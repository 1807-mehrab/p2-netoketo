import Controller from '@ember/controller';

export default Controller.extend({
  nkusername:'',
  nkpassword:'',
actions: {
    login() {
        var result = this.store.createRecord("login", {userid: 1, username: this.get('nkusername'), password: this.get('nkpassword'), email: 'stuff',accounttype:0});
        var onSuccess = function(){
            console.log("success");
            
            self.transitionTo('home');
        }
        var onFail = function(){
            console.log("failure");
            console.log(this.get('username'));
            console.log(nkpassword);
        }
        var self = this;
        result.save().then(onSuccess,onFail);
        /*
        this.store.pushPayload('login',{
            data: {
              id: '1',
              type: 'login',
              attributes: {
                userid: 1,
                username: 'joberholtzer',
                password: 'pass',
                email: 'stuff',
                accounttype: 1,
              }
            }
          });
        console.log('test');
        */
    }
}
});

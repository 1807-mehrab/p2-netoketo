import Route from '@ember/routing/route';

export default Route.extend({
    model() {
        return this.store.peekAll('login');
    },
    actions: {
        login(nkusername,nkpassword) {
            var self = this;
            this.store.queryRecord('login', { username: nkusername, password: nkpassword }).then(function(logins) {
                console.log(logins);
                self.transitionTo('home');
                return logins.get('firstObject');
            });
            /*OLD METHOD USING POST:
            //let result = this.store.createRecord("login")
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
            this.store.createRecord('login', {
                userid: '1', 
                username: nkusername, 
                password: nkpassword, 
                email: 'stuff', 
                accounttype:'0' 
            })
            .save().then(onSuccess,onFail);
            */
            
            
        }
    }
});

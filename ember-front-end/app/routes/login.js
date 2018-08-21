import Route from '@ember/routing/route';

export default Route.extend({
    model() {
        return this.store.peekAll('login');
    },
    init: function() {
        this.refresh;
    },
    actions: {
        login(nkusername,nkpassword) {
            /*OLD METHOD USING GET VIA QUERYRECORD
            this.store.unloadAll('login');
            var self = this;
            this.store.queryRecord('login', { username: nkusername, password: nkpassword }).then(function(logins) {
                console.log(logins);
                self.transitionTo('home');
                return logins.get('firstObject');
            });
            */
            
            //NEW METHOD USING POST:
            this.store.unloadAll('login');
            var onSuccess = function(){
                console.log("success");
                self.transitionTo('home');
            }
            var onFail = function(){
                console.log("failure");
                console.log(nkusername);
                console.log(nkpassword);
                self.store.unloadAll('login');
                self.refresh;
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
 
        }
    }
});

import Route from '@ember/routing/route';

export default Route.extend({
    model() {
        return this.store.findAll('user');
    },
    actions: {
        register(rgusername,rgpassword,rgemail) {
            var onSuccess = function(){
                console.log("success");
                self.refresh;
                self.transitionTo('login');
            }
            var onFail = function(){
                console.log("failure");
                console.log(rgusername);
                console.log(rgemail);
                console.log(rgpassword);
                self.refresh;
            }
            
            var self = this;
            this.store.createRecord('user', {
                userid: '1', 
                username: rgusername, 
                password: rgpassword, 
                email: rgemail, 
                accounttype:'0' 
            })
            .save().then(onSuccess,onFail);
 
        }
    }
});

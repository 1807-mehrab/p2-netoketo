import Route from '@ember/routing/route';
import RSVP from 'rsvp';

export default Route.extend({
    model() {
        return RSVP.hash({
            logins: this.store.peekAll('login'),
        });
    },
    actions: {
        update(uppassword,upemail) {
            console.log('attempt');
            console.log(uppassword);
            console.log(upemail);
            let logindata = this.store.peekAll('login');
            let currUser = logindata.get("firstObject");
            let usname = currUser.get('username')
            console.log(usname);
            currUser.set('password',uppassword);
            currUser.set('email',upemail);
            
            let userObj = this.store.findRecord('user',usname).then(function(RL){
                console.log('This: ' + RL.get('username'))
                RL.get('password');
                RL.set('password',uppassword);
                RL.get('email');
                RL.set('email',upemail);
                RL.save();
            })
            console.log(userObj);
            
 
        }
    }
});


import Component from '@ember/component';

export default Component.extend({
    isBanned: function(){
        return this.get('account.userType') === 0;
    }.property('account.userType'),
    actions: {
        unbanUser: function(user){
            console.log(user.userId);
        }
    }
});

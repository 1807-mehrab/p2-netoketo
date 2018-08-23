import Component from '@ember/component';

export default Component.extend({
    store: Ember.inject.service(),
    isBanned: function(){
        return this.get('account.userType') === 0;
    }.property('account.userType'),
    isAdmin: function(){
        return this.get('account.userType') === 2;
    }.property('account.userType'),
    actions: {
        unbanUser: function(user){
            let postReturn = this.get('store').findRecord('user', user.username)
                .then(function(RL){
                    RL.set('userType', 1);
                    RL.save();
                });
            console.log(postReturn);
        },
        banUser: function(user){
            let postReturn = this.get('store').findRecord('user', user.username)
                .then(function(RL){
                    RL.set('userType', 0);
                    RL.save();
                });
        },
        deleteUser: function(user){
            this.store.findRecord('user', user.username, { backgroundReload: true }).then(function(post) {
                console.log('This: ' + post.get('username'))
                post.destroyRecord();
              });
        }
    }
});

import Component from '@ember/component';

export default Component.extend({
    isAdmin: function(){
        return this.get('lgn.userType') === 2;
    }.property('lgn.userType')
});
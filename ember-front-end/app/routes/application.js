import Route from '@ember/routing/route';

export default Route.extend({
    model() {
        return this.store.peekAll('login');
    },
    actions: {
        logout(){
            this.store.unloadAll('login');
            this.transitionTo('login');
        }
    }
});

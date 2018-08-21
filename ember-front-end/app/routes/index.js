import Route from '@ember/routing/route';

export default Route.extend({
    //on page load up, go to the home page
    beforeModel() {
        this.replaceWith('home');
    }
});

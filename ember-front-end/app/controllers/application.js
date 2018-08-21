import Controller from '@ember/controller';

export default Controller.extend({
    isSearch: false,
    actions: {
        toggleSearch(){
            this.toggleProperty('isSearch');
        }
    }
});

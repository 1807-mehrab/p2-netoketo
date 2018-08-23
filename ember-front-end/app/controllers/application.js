import Controller from '@ember/controller';

export default Controller.extend({
    isSearch: false,
    actions: {
        toggleSearch(){
            this.toggleProperty('isSearch');
        },
        filterByIngredients(param){
            if(param !== ''){
                return this.store.query('recipe', { ingredients:param });
            } else {
                return this.store.findAll('recipe');
            }
        },
        filterByName(param){
            if(param !== ''){
                return this.store.query('recipe', { name: param });
            } else {
                return this.store.findAll('recipe');
            }
        }
    }
});

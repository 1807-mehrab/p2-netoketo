import Route from '@ember/routing/route';

export default Route.extend({
    model() {
        user :this.store.peekAll('login');
        recipe : this.store.findAll('recipe')
    },
    actions: {
        newRecipe(rname,rdescription,ringredients, ckinstructions) {
            let currUser = this.store.peekAll('login').then(function(logins){
                return logins.get("firstObject");
            })
            var onSuccess = function(){
                console.log("success");
                self.refresh;
                self.transitionTo('login');
            }
            var onFail = function(){
                console.log("failure");
                console.log(rname);
                console.log(rdescription);
                console.log(ringredients);
                console.log(ckinstructions);
                self.refresh;
            }
            
            var self = this;
            this.store.createRecord('recipe', {
                recipeId: '1', 
                recipeName: rgusername, 
                deleted: null,
                deletedBy: null,
                owner: currUser,
                flagged: null,
                dateCreated: new Date(),
                description: rdescription,
                ingredients: ringredients,
                cookingInstructions: ckinstructions,
                image: null 
            })
            .save().then(onSuccess,onFail);
 
        }
    }
});

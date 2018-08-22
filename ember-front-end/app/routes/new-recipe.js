import Route from '@ember/routing/route';
import RSVP from 'rsvp';

export default Route.extend({
    model() {
        return RSVP.hash({
            user :this.store.peekAll('login'),
            recipe : this.store.findAll('recipe')
        });
    },
    actions: {
        newRecipe(rname,rdescription,ringredients, ckinstructions) {
            let logindata = this.store.peekAll('login');
            let currUser = logindata.get("firstObject");
            
            let usname = currUser.get('username')
            console.log(usname);

            var self = this;
            this.store.findRecord('user',usname).then(function(RL){
                console.log('User Is: '+RL.get('username'));
                var onSuccess = function(){
                    console.log("success");
                    self.refresh;
                    self.transitionTo('recipe');
                }
                var onFail = function(){
                    console.log("failure");
                    console.log(rname);
                    console.log(rdescription);
                    console.log(ringredients);
                    console.log(ckinstructions);
                    self.refresh;
                }
                self.store.createRecord('recipe', {
                    recipeId: '1', 
                    recipeName: rname, 
                    deleted: false,
                    deletedBy: null,
                    owner: RL,
                    flagged: false,
                    dateCreated: new Date(),
                    description: rdescription,
                    ingredients: ringredients,
                    cookingInstructions: ckinstructions,
                    image: null 
                })
                .save().then(onSuccess,onFail);
            });    
 
        }
    }
});

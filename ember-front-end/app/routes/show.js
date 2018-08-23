import Route from '@ember/routing/route';
import RSVP from 'rsvp';

export default Route.extend({
  model(params) {
    return RSVP.hash({
      recipe: this.store.findRecord('recipe', params.recipeid),
      comments: this.store.findAll('comment', params.recipeid),
      ratings: this.store.query('rating', {id:params.recipeid}).then(function(ratings) {
        var sum = 0;
        ratings.forEach(function(element) { sum += element.valNum })
        return sum;
      }),
      login: this.store.peekAll('login')


    });
  },
  actions: {
      createComment(comment, recipeitem) {
          let logindata = this.store.peekAll('login');
          let currUser = logindata.get("firstObject");
          let usname = currUser.get('username');
          let self = this;
          this.store.findRecord('user',usname).then(function(RL){
            self.store.createRecord('comment', {
              commentId: 1,
              content: comment,
              flagged: 0,
              recipe: recipeitem,
              owner: RL,
              createdOn: new Date()
            }).save().then(function() { self.refresh;})
          })
      },

      createRating(number, recipeitem) {
        let logindata = this.store.peekAll('login');
        let currUser = logindata.get("firstObject");
        let usname = currUser.get('username');
        let self = this;
        this.store.findRecord('user', usname).then(function(RL){
          self.store.createRecord('rating', {
            ratingId: 1,
            owner: RL,
            recipe: recipeitem,
            valNum: number,
            dateCreated: new Date()
          }).save().then(function() { self.refresh; })
        })
      },

      flagComment(comment) {
        let logindata = this.store.peekAll('login');
        let currUser = logindata.get("firstObject");
        let usname = currUser.get('username');
        this.store.findRecord('user', usname).then(function(RL){
          if (RL) {
            comment.set('flagged',1);
            comment.save();
          }
        });
      },

      flagRecipe(recipe) {
        let logindata = this.store.peekAll('login');
        let currUser = logindata.get("firstObject");
        let usname = currUser.get('username');
        this.store.findRecord('user', usname).then(function(RL){
          if (RL) {
            recipe.set('flagged',1);
            recipe.save();
          }
        });
      }
  }
});

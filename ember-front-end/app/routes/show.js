import Route from '@ember/routing/route';
import RSVP from 'rsvp';

export default Route.extend({
  model(params) {
    return RSVP.hash({
      recipe: this.store.findRecord('recipe', params.recipeid),
      comments: this.store.findAll('comment', params.recipeid)

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
      }
  },

  checkValid (param1, param2) {
    if (param1 == param2) {
      return true;
    }
    else {
      return false;
    }
  }
});

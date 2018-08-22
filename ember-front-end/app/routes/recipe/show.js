import Route from '@ember/routing/route';
import RSVP from 'rsvp';

export default Route.extend({
  model(params) {
    return RSVP.hash({
      recipe: this.store.findRecord('recipe', params.recipeid),
      comments: this.store.findAll('comment')
    });
  }

});

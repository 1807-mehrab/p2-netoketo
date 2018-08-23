import Route from '@ember/routing/route';
import RSVP from 'rsvp';

export default Route.extend({
    model() {
        return RSVP.hash({
          popular: this.store.query('recipe', { ingredients:'POPULAR' }),
          recent: this.store.query('recipe', { ingredients:'RECENT' }),
        });
      },
});

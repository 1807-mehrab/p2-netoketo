import DS from 'ember-data';

export default DS.Model.extend({
  ratingId: DS.attr('number'),
  owner: DS.attr(),
  recipe: DS.attr(),
  valNum: DS.attr('number'),
  dateCreated: DS.attr('date')
});

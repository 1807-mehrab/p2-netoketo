import DS from 'ember-data';

export default DS.Model.extend({
  ratingId: DS.attr('number'),
  owner: DS.belongsTo('user'),
  recipe: DS.belongsTo('recipe'),
  valNum: DS.attr('number'),
  dateCreated: DS.attr('date')
});

import DS from 'ember-data';

export default DS.Model.extend({
  recipeId: DS.attr('number'),
  recipeName: DS.attr('string'),
  deleted: DS.attr('number'),
  deletedBy: DS.attr(),
  owner: DS.attr(),
  flagged: DS.attr('number'),
  dateCreated: DS.attr('date'),
  description: DS.attr('string'),
  ingredients: DS.attr('string'),
  cookingInstructions: DS.attr('string'),
  image: DS.attr(),
  comment: DS.hasMany('comment')
});

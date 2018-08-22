import DS from 'ember-data';

export default DS.Model.extend({
  recipeId: DS.attr(),
  recipeName: DS.attr(),
  deleted: DS.attr(),
  deletedBy: DS.attr(),
  owner: DS.attr(),
  flagged: DS.attr(),
  dateCreated: DS.attr(),
  description: DS.attr(),
  ingredients: DS.attr(),
  cookingInstructions: DS.attr(),
  image: DS.attr(),
  recipeRatings: DS.attr()
});

/** 
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
*/
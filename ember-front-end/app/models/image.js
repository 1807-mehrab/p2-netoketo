import DS from 'ember-data';

export default DS.Model.extend({
  imageId: DS.attr('number'),
  recipe: DS.belongsTo('recipe'),
  image: DS.attr()
});

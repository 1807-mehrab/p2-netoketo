import DS from 'ember-data';

export default DS.Model.extend({
  commentId: DS.attr('number'),
  content: DS.attr('string'),
  flagged: DS.attr('number'),
  recipe: DS.attr(),
  owner: DS.attr(),
  createdOn: DS.attr('date')
});

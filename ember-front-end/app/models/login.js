import DS from 'ember-data';

export default DS.Model.extend({
  userId: DS.attr('number'),
  username: DS.attr('string'),
  password: DS.attr('string'),
  email: DS.attr('string'),
  userType: DS.attr('boolean')
});

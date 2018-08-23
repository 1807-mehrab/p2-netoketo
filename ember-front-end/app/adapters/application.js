import DS from 'ember-data';

export default DS.RESTAdapter.extend({
  host:'http://localhost:8080/NetoKeto'
  //host:'http://localhost:8084/NetoKeto'
  // host:'http://18.223.68.115:8080/NetoKeto'
  //namespace: 'api'
});

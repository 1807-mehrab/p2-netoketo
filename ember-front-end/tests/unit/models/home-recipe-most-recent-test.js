import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Model | home recipe most recent', function(hooks) {
  setupTest(hooks);

  // Replace this with your real tests.
  test('it exists', function(assert) {
    let store = this.owner.lookup('service:store');
    let model = store.createRecord('home-recipe-most-recent', {});
    assert.ok(model);
  });
});

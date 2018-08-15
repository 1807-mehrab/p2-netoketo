import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | recipe', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:recipe');
    assert.ok(route);
  });
});

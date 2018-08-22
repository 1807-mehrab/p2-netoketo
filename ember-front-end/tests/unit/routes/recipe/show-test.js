import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | recipe/show', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:recipe/show');
    assert.ok(route);
  });
});

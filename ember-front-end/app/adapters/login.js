import ApplicationAdapter from './application';
import { computed } from '@ember/object';

export default ApplicationAdapter.extend({
    pathForType() {
        return 'login'
    },
    headers: computed(function() {
        return {
          'Access-Control-Allow-Origin':'*'
        };
    })
});

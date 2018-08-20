import DS from 'ember-data';

export default DS.RESTSerializer.extend({
    primaryKey: 'username',
    
    normalizeResponse(store, primaryModelClass, payload, id, requestType) {
        //console.log('This is a test');
        console.log(payload);
        //return this._super(...arguments);
        payload = {'login': payload };
        console.log(payload);
        return this._super(store, primaryModelClass, payload, id, requestType);
        
    }
});

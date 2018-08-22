import DS from 'ember-data';

export default DS.RESTSerializer.extend({
    primaryKey: 'recipeId',

    normalizeResponse(store, primaryModelClass, payload, id, requestType) {
        //console.log('This is a test');
        console.log(payload);
        //return this._super(...arguments);
        payload = { recipe: payload };
        return this._super(store, primaryModelClass, payload, id, requestType);
        
    }
});

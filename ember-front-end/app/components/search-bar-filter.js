import Component from '@ember/component';

export default Component.extend({
    classNames: ['search-bar-filter'],
    value: '',

    init(){
        this._super(...arguments);
        this.filter('').then((results) => this.set('results', results));
    },

    actions: {
        handleFilterEntry(){
            let filterInputValue = this.value;
            let filterAction = this.filter;
            filterAction(filterInputValue).then((filterResults) => this.set('results', filterResults));
        }
    }
});

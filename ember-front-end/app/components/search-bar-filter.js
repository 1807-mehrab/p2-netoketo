import Component from '@ember/component';

export default Component.extend({
    classNames: ['search-bar-filter'],
    value: '',

    init(){
        this._super(...arguments);
        this.filterName('').then((results) => this.set('results', results));
        this.set('searchFilter', 'name');
    },

    actions: {
        handleFilterEntry(){
            let filterInputValue = this.value;
            let filterIngrAction = this.filterIngr;
            let filterNameAction = this.filterName;
            
            if(this.get('searchFilter') === 'name'){
                filterNameAction(filterInputValue).then((filterResults) => this.set('results', filterResults));
            } else if (this.get('searchFilter') === 'ingredients'){
                filterIngrAction(filterInputValue).then((filterResults) => this.set('results', filterResults));
            }
        },
        filterToggle: function(choice){
            // console.log("changing filter choice", choice);
            this.set('searchFilter', choice);
        }
    }
});

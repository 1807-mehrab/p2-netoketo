import EmberRouter from '@ember/routing/router';
import config from './config/environment';

const Router = EmberRouter.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('home');
  this.route('login');
  this.route('register');
  this.route('recipe');
  this.route('makerecipe');
  this.route('profile');
  this.route('editprofile');
  this.route('searchresults');
  this.route('user');
  this.route('recipe-mostPopular');
  this.route('search');
  this.route('new-recipe');
  this.route('userlist');
});

export default Router;

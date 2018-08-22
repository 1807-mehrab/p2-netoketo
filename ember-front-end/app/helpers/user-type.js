import { helper } from '@ember/component/helper';

const userTypes = [
  'Banned',
  'User',
  'Admin'
];

export function userType([type]){
  return userTypes[type];
}

export default helper(userType);

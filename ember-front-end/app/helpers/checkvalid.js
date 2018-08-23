import { helper } from '@ember/component/helper';

export function checkvalid(prop1) {
  if (prop1[0] == prop1[1]) {
    return true;
  }
  else {
    return false;
  }
}

export default helper(checkvalid);

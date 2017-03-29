/**
 * Created by tangzhichao on 2017/3/9.
 */
import {action, observable, computed, useStrict} from 'mobx';
useStrict(true)

class app {
  constructor() {
  }

  @observable title = 'aaa'

  @observable user = {
    name: 'alvin'
  }

  @computed get titleValue() {
    return this.title;
  }

  @computed get userValue() {
    return this.user;
  }

  @action setTitle = (title) => {
    this.title = title;
  };

}
export default app;

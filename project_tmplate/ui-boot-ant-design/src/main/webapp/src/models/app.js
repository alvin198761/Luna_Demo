import {fetchApp} from '../services/app';
export default {

  namespace: 'app',

  state: {
    loading: true,
    collapse: true,
  },

  subscriptions: {
    setup({dispatch, history}) {
    },
  },

  effects: {
    *fetchRemote({payload}, {call, put}) {
      const data = yield call(fetchApp);
      if (data) {
        yield put({
          type: "fetch", payload: {
            loading: false
          }
        });
      }
    },
    *doCollapse({payload}, {call, put}){
      yield  put({type: 'collapseChange'});
    }
  },

  reducers: {
    fetch(state, action) {
      return {...state, ...action.payload};
    },
    collapseChange(state, action){
      return {collapse: !state.collapse};
    }
  },

}

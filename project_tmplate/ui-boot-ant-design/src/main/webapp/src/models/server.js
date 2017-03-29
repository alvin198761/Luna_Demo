import {queryList} from '../services/server';
export default {

  namespace: 'server',

  state: {
    data: [],
    page: {
      total: 0,
      size: 0
    },
    loading: true,
  },

  subscriptions: {
    setup({dispatch, history}) {
    },
  },

  effects: {
    *queryByPage({payload}, {call, put}) {
      const data = yield call(queryList, payload);
      if (data) {
        yield put({type: "fetch", payload: {
          data : data.data,
          page : data.page,
          loading:false,
        }});
      }
    },
  },

  reducers: {
    fetch(state, action) {
      return {...state, ...action.payload};
    },
  },

}

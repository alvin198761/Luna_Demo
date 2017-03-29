import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'mobx-react';
import {routingStore,CustomRouter} from './router';

import store from './mobx/store';
const stores = {
  ...store,
  routing: routingStore,
};

ReactDOM.render(
  <Provider {...stores}>
   <CustomRouter></CustomRouter>
  </Provider>,
  document.getElementById('root')
);

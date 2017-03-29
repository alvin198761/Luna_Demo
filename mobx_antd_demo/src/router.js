import React, {PropTypes} from 'react';
import {Router, Route, browserHistory} from 'react-router';
import {RouterStore, syncHistoryWithStore} from 'mobx-react-router';

import IndexPage from './routes/IndexPage';
import Overview from './components/Overview';
import List from './components/List';

export const routingStore = new RouterStore();

const history = syncHistoryWithStore(browserHistory, routingStore);

export const CustomRouter = () => (
  <Router history={history}>
    <Route path='/' component={IndexPage}>
      <Route path='/overview' component={Overview}/>
      <Route path='/list' component={List}/>
    </Route>
  </Router>
)




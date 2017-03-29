import React, {PropTypes} from 'react';
import {Router, Route, IndexRoute, Link} from 'dva/router';
import IndexPage from './routes/IndexPage';
import ServerPage from './routes/ServerPage';
import AccountPage from './routes/AccountPage';
import AddServerPage from './routes/server/AddServerPage';
import ServerList from './routes/server/ServerList';
import AppPage from './routes/AppPage';
import AppViewPage from './routes/app/AppViewPage';
import TestIndex from './routes/test/TestIndex';

export default function ({history}) {
  return (
    <Router history={history}>
      <Route path="/" component={IndexPage}>
        <Route path="server" component={ServerPage}>
          <Route path="list" component={ServerList}></Route>
          <Route path="add" component={AddServerPage}></Route>
        </Route>
        <Route path="app" component={AppPage}>
            <Route path="view" component={AppViewPage}></Route>
        </Route>
        <Route path="account" component={AccountPage}></Route>
        <IndexRoute component={ServerList}></IndexRoute>

        <Route path="test" component={TestIndex}></Route>
      </Route>
    </Router>
  );
};

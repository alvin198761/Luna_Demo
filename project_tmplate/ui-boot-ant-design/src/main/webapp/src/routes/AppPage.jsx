import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Link} from 'dva/router';

const AppPage = ({children}) => {

  return (<div>
    {children}
  </div>);
}

AppPage.propTypes = {};

export  default AppPage;

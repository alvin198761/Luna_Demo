/**
 * Created by tangzhichao on 2016/11/2.
 */
import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Link} from 'dva/router';

const ServerPage = ({children}) => {
  return (<div>
    {children}
  </div>);
}

ServerPage.propTypes = {};

export  default ServerPage;

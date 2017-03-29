/**
 * Created by tangzhichao on 2016/11/2.
 */
import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Link} from 'dva/router';
import {Menu, Breadcrumb, Icon, Row, Col} from 'antd';

class AccountPage extends  Component {

  constructor(props){
    super(props);
  }

  render (){
    return (<div>账号</div>);
  }

}

AccountPage.propTypes = {}

export default AccountPage;

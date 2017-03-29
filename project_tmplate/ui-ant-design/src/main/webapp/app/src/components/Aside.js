import React, {Component, PropTypes} from 'react';
import {Menu, Breadcrumb, Icon, Row, Col} from 'antd';
import {connect} from 'dva';
import {Link} from 'dva/router';

class Aside extends Component {

  constructor(porps) {
    super(porps);
  }

  componentWillMount() {

  }

  render() {
    return (  <aside className="ant-layout-sider">
      <div className="ant-layout-logo">
        <Icon type="android" spin="true"/> 远程管理系统
      </div>
      <Menu mode="inline" theme="dark" defaultSelectedKeys={['user']}>
        <Menu.Item key="user">
          <Link to="server/list"><Icon type="user"/><span className="nav-text">服务器</span></Link>
        </Menu.Item>
        <Menu.Item key="setting">
          <Link to="account"><Icon type="setting"/><span className="nav-text">账号</span></Link>
        </Menu.Item>
        <Menu.Item key="laptop">
          <Link to="app/view"> <Icon type="laptop"/><span className="nav-text">应用</span></Link>
        </Menu.Item>
        <Menu.Item key="notification">
          <Icon type="notification"/><span className="nav-text">权限</span>
        </Menu.Item>
        <Menu.Item key="folder">
          <Link to="test" ><Icon type="folder"/><span className="nav-text">测试界面</span></Link>
        </Menu.Item>
      </Menu>
      <div className="ant-aside-action" onClick={() => {
                           this.props.dispatch({type:'app/doCollapse',payload:{collapse:!this.props.collapse}});
                           }}>
        {this.props.collapse ? <Icon type="right"/> : <Icon type="left"/>}
      </div>
    </aside>)
  }
}

Aside.propTypes = {};

function mapStateToProps({app}) {
  return {collapse: app.collapse};
}

export default connect(mapStateToProps)(Aside);

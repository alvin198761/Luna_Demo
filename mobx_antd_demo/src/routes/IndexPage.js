import React, {Component, PropTypes} from 'react';
import {Menu, Breadcrumb, Icon} from 'antd';
import {inject, observer} from 'mobx-react';
import {Link} from 'react-router';

import  './IndexPage.css';
const SubMenu = Menu.SubMenu;

@inject('routing')
@observer
export default class IndexPage extends Component {

  render() {
    const {location, push, goBack} = this.props.routing;
    return (
      <div className="layout-aside">
        <aside className="layout-sider">
          <div className="layout-logo"></div>
          <Menu mode="inline" theme="dark"
                defaultSelectedKeys={['1']} defaultOpenKeys={['sub1']}>
            <SubMenu key="sub1" title={<span><Icon type="user"/>Navigation 1</span>}>
              <Menu.Item key="1"><Link to="/overview">主页</Link></Menu.Item>
              <Menu.Item key="2"><Link to="/list">列表</Link></Menu.Item>
              <Menu.Item key="3">item 3</Menu.Item>
              <Menu.Item key="4">item 4</Menu.Item>
            </SubMenu>
            <SubMenu key="sub2" title={<span><Icon type="laptop"/>Navigation 2</span>}>
              <Menu.Item key="5">item 5</Menu.Item>
              <Menu.Item key="6">item 6</Menu.Item>
              <Menu.Item key="7">item 7</Menu.Item>
              <Menu.Item key="8">item 8</Menu.Item>
            </SubMenu>
            <SubMenu key="sub3" title={<span><Icon type="notification"/>Navigation 3</span>}>
              <Menu.Item key="9">item 9</Menu.Item>
              <Menu.Item key="10">item 10</Menu.Item>
              <Menu.Item key="11">item 11</Menu.Item>
              <Menu.Item key="12">item 12</Menu.Item>
            </SubMenu>
          </Menu>
        </aside>
        <div className="layout-main">
          <div className="layout-header"></div>
          <div className="layout-container">
            <Breadcrumb>
              <Breadcrumb.Item>Home</Breadcrumb.Item>
              <Breadcrumb.Item>App list</Breadcrumb.Item>
              <Breadcrumb.Item>Any App</Breadcrumb.Item>
            </Breadcrumb>
            <div className="layout-content">
              <div style={{height: 590}}>
                {this.props.children}
              </div>
            </div>
          </div>
          <div className="layout-footer">
            Ant Design all rights reserved © 2015 Created by Ant UED
          </div>
        </div>
      </div>
    )
  }
}




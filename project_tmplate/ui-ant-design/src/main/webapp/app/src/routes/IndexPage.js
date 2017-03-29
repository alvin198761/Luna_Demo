import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Link} from 'dva/router';
import './IndexPage.css';
import {Menu, Breadcrumb, Icon, Row, Col,BackTop} from 'antd';
import Aside from '../components/Aside';
import Header from '../components/Header';
import BreadcrumbNav from '../components/BreadcrumbNav';


class IndexPage extends Component {

  constructor(props) {
    super(props);
  }

  render() {
   // console.log(this.props)
    return (
      <div className={this.props.collapse ? "ant-layout-aside ant-layout-aside-collapse" : "ant-layout-aside"}>
        <Aside></Aside>
        <div className="ant-layout-main">
          <Header></Header>
          <BreadcrumbNav pathname={this.props.location.pathname}></BreadcrumbNav>
          <div className="ant-layout-container">
            <div className="ant-layout-content">
              <div style={{ height: 550 }}>
                {this.props.children}
              </div>
            </div>
          </div>
          <div className="ant-layout-footer">
            <a href="mailto:alvin198761@163.com"> alvin198761@163.com</a>&nbsp;练习
          </div>
        </div>
        <BackTop />
      </div>
    )
  }
}

IndexPage.propTypes = {};


function mapStateToProps({app}) {
  return {collapse: app.collapse};
}
export default connect(mapStateToProps)(IndexPage);

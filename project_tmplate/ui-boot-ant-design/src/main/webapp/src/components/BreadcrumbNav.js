import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Link} from 'dva/router';
import {Breadcrumb, Icon} from 'antd';
import {parseItem} from '../services/breadcrumbnav';

class BreadcrumbNav extends Component {

  constructor(props) {
    super(props);
  }

  render() {
    //console.log(this.props)
    const items = parseItem(this.props.pathname);
    return (
      <div className="ant-layout-breadcrumb">
        <Breadcrumb>
          {
            items.map(item => {
              // if (item.last) {
                return (<Breadcrumb.Item key={item.key}> {item.value}</Breadcrumb.Item>);
              // }
              // return (
              //   <Breadcrumb.Item key={item.key}><Link to={item.link}>{item.value}</Link></Breadcrumb.Item>
              // )
            })
          }
        </Breadcrumb>
      </div>
    );
  }
}


BreadcrumbNav.propTypes = {};

function mapStateToProps({app}) {
  return {};
}

export default connect(mapStateToProps)(BreadcrumbNav);

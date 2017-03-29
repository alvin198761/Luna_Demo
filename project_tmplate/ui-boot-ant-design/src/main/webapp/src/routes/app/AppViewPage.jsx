import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Link} from 'dva/router';
import {Tabs, Spin} from 'antd';

const TabPane = Tabs.TabPane;

class AppViewPage extends Component{

  constructor(props){
    super(props);
  }

  componentWillMount(){
     this.props.dispatch({type:"app/fetchRemote"})
  }

  callback ()  {

  }

  render() {

    return (
      <Spin spinning={this.props.loading}>
        <Tabs defaultActiveKey="1" onChange={this.callback.bind(this)}>
          <TabPane tab="Tab 1" key="1">Content of Tab Pane 1</TabPane>
          <TabPane tab="Tab 2" key="2">Content of Tab Pane 2</TabPane>
          <TabPane tab="Tab 3" key="3">Content of Tab Pane 3</TabPane>
        </Tabs>
      </Spin>);
  }
}

AppViewPage.protoTypes = {}

function mapStateToProps({app}){
  return {loading:app.loading}
}

export default connect(mapStateToProps)(AppViewPage);


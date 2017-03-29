import React, {Component, PropTypes} from 'react';
import {observer, inject} from 'mobx-react';
import {Button} from 'antd';

@inject('routing')
@inject('app')
@observer
export default class Overview extends Component {

  render() {
    console.log(this.props)
    return (
      <div>
        主页面 用户名：{this.props.app.userValue.name}<br/>
        {this.props.app.titleValue}
        <Button onClick={()=>{this.props.app.setTitle('测试修改')}}>点击修改 title</Button>
      </div>)
  }
}



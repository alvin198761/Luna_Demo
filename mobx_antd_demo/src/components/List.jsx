import React, {Component, PropTypes} from 'react';
import {observer, inject} from 'mobx-react';

@inject('routing')
@observer
export default class List extends Component {

  render() {
    return (
      <div>
       列表页面
      </div>)
  }
}



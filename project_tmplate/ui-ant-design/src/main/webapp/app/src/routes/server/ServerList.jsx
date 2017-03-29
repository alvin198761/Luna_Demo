/**
 * Created by tangzhichao on 2016/11/2.
 */
import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Link} from 'dva/router';
import {Button, Icon, Input, Row, Col, Table,Modal} from 'antd';

const ButtonGroup = Button.Group;

const columns = [{
  title: 'Name',
  dataIndex: 'name',
  key: 'name',
  render: ( (text) => {
    return <a href="#">{text}</a>
  }),
}, {
  title: 'Age',
  dataIndex: 'age',
  key: 'age',
}, {
  title: 'Address',
  dataIndex: 'address',
  key: 'address',
}, {
  title: 'Action',
  key: 'action',
  render: (text, record) => (
    <span>
      <a href="#">Action 一 {record.name}</a>
      <span className="ant-divider"/>
      <a href="#">Delete</a>
      <span className="ant-divider"/>
      <a href="#" className="ant-dropdown-link">
        More actions<Icon type="down"/>
      </a>
    </span>
  ),
}];

class ServerList extends Component {

  constructor(props) {
    super(props);
    this.state = {
      filter: '',
    }
  }

  componentWillMount() {
    this.props.dispatch({type: "server/queryByPage", payload: {page: 0}});
  }

  deleteRow(e){
    Modal.confirm({title:'你确定要删除吗?'})
    console.log(this.props)
  }


  render() {
    let rowData = [];
    if (this.state.filter == '') {
      rowData = this.props.data;
    } else {
      let rows = [];
      for (let i in this.props.data) {
        if (this.props.data[i].name.indexOf(this.state.filter) != -1) {
          rowData.push(this.props.data[i])
        }
      }
    }
    return (<div>
      <Row>
        <Col span="5">
          <Input placeholder="输入查找信息" addonBefore="查找" value={this.state.filter} onInput={(e) => {
              console.log(e)
              this.setState({filter:e.target.value});
          }}/> </Col>
        <Col span="3"> <ButtonGroup>
          <Button onClick={()=>{location.href ="#/server/add"}}><Icon type="plus-circle"/></Button>
          <Button onClick={this.deleteRow.bind(this)}><Icon type="minus-circle"/></Button>
          <Button><Icon type="edit"/></Button>
        </ButtonGroup></Col>
      </Row>
      <Table columns={columns} dataSource={rowData} loading={this.props.loading}> </Table>
    </div>);
  }

}

ServerList.propTypes = {};

function mapStateToProps({server}) {
  return {
    loading: server.loading,
    data: server.data,
    page: server.page,
    filter: server.filter,
  };
}

export default connect(mapStateToProps)(ServerList);

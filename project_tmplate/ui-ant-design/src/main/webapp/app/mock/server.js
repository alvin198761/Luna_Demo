'use strict';

const data = [{
  key: '1',
  name: 'John Brown',
  age: 32,
  address: 'New York No. 1 Lake Park',
}, {
  key: '2',
  name: 'Jim Green',
  age: 42,
  address: 'London No. 1 Lake Park',
}, {
  key: '3',
  name: 'Joe Black',
  age: 32,
  address: 'Sidney No. 1 Lake Park',
}];

const page = {
  total: 10,
  size: 2
}

module.exports = {

  'GET /server/list': function (req, res) {
    setTimeout(function () {
      res.json({
        page: page,
        data: data,
      });
    }, 500);
  },

};

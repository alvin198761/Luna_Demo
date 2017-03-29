'use strict';

module.exports = {

  'GET /api/app/list': function (req, res) {
    setTimeout(function () {
      res.json({
        success: true,
        data: ['foo', 'bar'],
      });
    }, 500);
  },

};

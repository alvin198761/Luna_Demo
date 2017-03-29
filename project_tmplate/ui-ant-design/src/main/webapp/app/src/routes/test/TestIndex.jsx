import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Link} from 'dva/router';
import  {Row} from 'antd';

import createG2 from 'g2-react';
import {Stat, Frame, Shape} from 'g2';

const data = [
  {
    id: 1,
    value: 1,
    r: 1,
  },
  {
    id: 2,
    value: 1,
    r: 2,
  },
  {
    id: 3,
    value: 1,
    r: 3,
  },
  {
    id: 4,
    value: 1,
    r: 4,
  },
];

const TestIndex = () => {

  Shape.registShape('line', 'arrow', {

    getShapePoints: function (cfg) {
      let x = cfg.x;
      let y = cfg.y;

      return [
        {x, y}
      ];
    },
    drawShape: function (cfg, container) {
      console.log(cfg)
      var points = this.parsePoints(cfg.points);
      let x =  points[points.length - 1].x;
      let y =  points[points.length - 1].y;
      let x2 =  points[points.length - 2].x;
      let y2 =  points[points.length - 2].y;


      return container.addShape('line', {
        attrs: {
          x1: x ,
          y1:  y  ,
          x2: 650,
          y2: 50 ,
          stroke: 'red',
          lineWidth: 2
        }
      });
    }
  });

  const NewDeviceChart = createG2(chart => {

    let frame = new Frame(data);
    frame = Frame.combinColumns(frame, ['r'], 'value', 'type', 'id');
    chart.source(frame);

    chart.col("id", {
      alias: "编号",
    });
    chart.col("value", {
      min: 0,
      alias: "结果"
    });
    chart.legend(false);
    // chart.line().position('id*value').color({type: "#0000ff"}).size(1);
    chart.line().position(Stat.smooth.exp('id*value')).size(3);
    chart.line().position(Stat.smooth.exp('id*value')).shape("name", (name)=> 'arrow').size(3);
    chart.interval().position("id*value").color({type: "gray"}).shape('gender', ()=> 'rect').size(12);
    chart.render();
  });

  return (<div>
    <Row>
      <NewDeviceChart data={[]} width={700} height={300}></NewDeviceChart>
    </Row>
  </div>);
}

TestIndex.propTypes = {};

export  default TestIndex;

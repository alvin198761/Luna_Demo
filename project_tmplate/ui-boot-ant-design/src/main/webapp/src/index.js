import './index.html';
import './index.less';
import dva from 'dva';
import {heartbeat} from './services/index';

// 1. Initialize
const app = dva();

// 2. Plugins
//app.use({});

// 3. Model
//app.model(require('./models/example'));
app.model(require('./models/app'));
app.model(require('./models/server'));

// 4. Router
app.router(require('./router'));

// 5. Start
app.start('#root');

setInterval(function () {
  heartbeat();
},60*1000);

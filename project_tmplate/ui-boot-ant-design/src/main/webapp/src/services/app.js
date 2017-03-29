import  reqwest from '../utils/reqwest'

export function  fetchApp() {
  return reqwest({
    url: 'api/app/list',
    method: 'get',
    type : 'json',
    data : {}
  });

}

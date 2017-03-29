import  reqwest from '../utils/reqwest'

export function  queryList(page) {
  return reqwest({
    url: 'server/list',
    method: 'get',
    type : 'json',
    data : page
  });

}

/**
 * Created by tangzhichao on 2016/11/2.
 */
const breadcrumbData = {
  account: {
    title: "账号管理",
  },
  server: {
    title: "服务器管理",
    list: "服务器列表",
    add: "添加服务器"
  }
}

export function parseItem(path) {
  if (path == "/") {
    return parseItem("/server/list");
  }

  const itemArray = path.split("/");
  const result = [];
  //
  let link = '';
  let breadcrumbItem;
  for (let i in itemArray) {
    let item = itemArray[i];
    if (item == null || item == "") {
      result.push({key: 1, value: "首页", link: '/', last: false});
      continue;
    }
    link += "/" + item;
    let value = '';
    if (!breadcrumbItem) {
      breadcrumbItem = breadcrumbData[item];
      if (!breadcrumbItem) {
        return [];
      }
      value = breadcrumbItem.title;
    } else {
      value = breadcrumbItem[item];
    }
    if (i == itemArray.length - 1) {
      result.push({key: item, value: value, link: link, last: true})
    } else {
      result.push({key: item, value: value, link: link, last: false})
    }
  }
  return result;
}

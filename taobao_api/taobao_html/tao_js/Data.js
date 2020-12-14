//保存信息到localStorage
function saveToLocalStorage(key, value) {
    var valueJson = JSON.stringify(value);
    sessionStorage.setItem(key, valueJson);
  //  localStorage.setItem(key, valueJson);
}

//从localStorage 获取信息
function getFromLocalStorage(key) {
    let valueJson = sessionStorage.getItem(key);
    if (null == valueJson) {
        return null;
    }
    return JSON.parse(valueJson);
}

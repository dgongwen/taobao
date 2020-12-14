function appendHost(url) {
    let host = "http://localhost:8080/taobao_api/";
    return host + url;
}

/**
 * 对返回结果进行统一处理
 */
function handlerResp(json, callback) {
    // console.log("handlerResp");
    // console.log(json);
    //返回json结果装换成对象
    let resp = JSON.parse(json);
    //判断code状态
    if (resp.code == 100) {
        //成功，调用回调方法
        callback(resp.data);
    } else if (resp.code == 200) {
        alert(resp.msg);
        //用户未登录
        location.href = "http://localhost:8080//taobao_html/登录.html";
    } else {
        //业务处理失败，统一提示错误信息
        alert(resp.msg);
    }
}


//get 无参
function get(url, callback) {
    url = appendHost(url);
    $.ajax({
        type: "get",
        url: url,
        success: function (resp) {
            handlerResp(resp, callback);
        }
    });
}

//get 有参
function getWithParams(url, params, callback) {
    url = appendHost(url);
    $.ajax({
        type: "get",
        url: url,
        data: params,
        success: function (resp) {
            handlerResp(resp, callback);
        }
    });
}

//post 有参(表单)
function postWithParams(url, params, callback) {
    url = appendHost(url);
    $.ajax({
        type: "post",
        url: url,
        data: params,
        success: function (resp) {
            handlerResp(resp, callback);
        }
    });
}

//post 有参(JSON)
function postWithJson(url, params, callback) {
    url = appendHost(url);
    let paramsJson = JSON.stringify(params);
    $.ajax({
        type: "post",
        url: url,
        data: paramsJson,
        success: function (resp) {
            handlerResp(resp, callback);
        }
    });
}

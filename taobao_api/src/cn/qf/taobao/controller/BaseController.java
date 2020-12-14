package cn.qf.taobao.controller;

import cn.qf.taobao.pojo.vo.BaseRespVO;
import com.alibaba.fastjson.JSON;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseController extends HttpServlet {


    //读取request对象中的参数，装换成指定类型
    protected <T> T convertParamsToEntity(HttpServletRequest req, Class<T> entityClass) throws IOException {
        StringBuilder jsonStr = new StringBuilder();
        InputStreamReader jsonReader = new InputStreamReader(req.getInputStream(), "UTF-8");
        char[] chars = new char[1024];
        int read;
        while ((read = jsonReader.read())!=-1){
            jsonStr.append((char) read);
        }
        jsonReader.close();
        T entity = JSON.parseObject(jsonStr.toString(), entityClass);
        return entity;
    }

    //返回结果BaseRespVO转换为json,写入输出流
    protected void writerResult(BaseRespVO result, HttpServletResponse resp) {
        String json = JSON.toJSONString(result);
        try {
            resp.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //成功将业务数据对象传入，直接写入输出流
    protected void writerSuccessResult(Object data, HttpServletResponse resp) {
        BaseRespVO result = new BaseRespVO<>();
        result.setData(data);

        String json = JSON.toJSONString(result);
        try {
            resp.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //失败将错误信息写入，直接写入输入流
    protected void writerErrorResult(String errorMsg, HttpServletResponse resp) {
        BaseRespVO result = new BaseRespVO<>();
        result.setCode(BaseRespVO.CodeType.FAILED.getValue());
        result.setMsg(errorMsg);

        String json = JSON.toJSONString(result);
        try {
            resp.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

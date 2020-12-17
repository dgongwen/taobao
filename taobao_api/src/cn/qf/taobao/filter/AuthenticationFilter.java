package cn.qf.taobao.filter;


import cn.qf.taobao.pojo.vo.BaseRespVO;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户认证验证过滤器
 * 判断用户是否已经登录
 */
@WebFilter("*.t")
public class AuthenticationFilter implements Filter {
    public final static List<String> whiteList = new ArrayList<>();

    static {
        whiteList.add("login.t");
        whiteList.add("verification.t");
        whiteList.add("commodityClassify.t");
        whiteList.add("classify.t");
        whiteList.add("random.t");
        whiteList.add("details.t");
        whiteList.add("add.t");
        whiteList.add("favorite.t");
        whiteList.add("deleteFavorite.t");
        whiteList.add("selectFootprint.t");
        whiteList.add("register.t");

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取到当前请求地址
        String requestURI = request.getRequestURI();
        //白名单地址跳过过滤
        boolean ifExist = whiteList.stream().anyMatch(item -> {
            return requestURI.contains(item);
        });
        if (ifExist) {
            //白名单地址，放行
            filterChain.doFilter(request, servletResponse);
            return;
        }
        //获取session中用户信息
        HttpSession session = request.getSession();
        Object sessionSeller = session.getAttribute("seller");
        if (null == session || null == sessionSeller) {
            //无：未登录,？
            BaseRespVO result = new BaseRespVO();
            result.setCode(BaseRespVO.CodeType.UN_LOGIN.getValue());
            result.setMsg("用户未登录");
            String json = JSON.toJSONString(result);
            response.getWriter().write(json);
            return;
        }
        //有：已登录，放行
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

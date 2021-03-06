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
        whiteList.add("addShop.t");
        whiteList.add("selectShop.t");
        whiteList.add("classifyCommodity.t");
        whiteList.add("register.t");
        whiteList.add("classifyPages.t");
        whiteList.add("alterShopCat.t");
        whiteList.add("selectAddress.t");
        whiteList.add("addAddress.t");
        whiteList.add("delCommodity.t");
        whiteList.add("insertCommodity.t");
        whiteList.add("selectAllByState.t");
        whiteList.add("selectAll.t");
        whiteList.add("selectDelCommodity.t");
        whiteList.add("selectByNameState.t");
        whiteList.add("selectById.t");
        whiteList.add("selectByName.t");
        whiteList.add("updateCancel.t");
        whiteList.add("updateById.t");
        whiteList.add("updateState.t");
        whiteList.add("selectOneAddress.t");
        whiteList.add("setDefaultAddress.t");
        whiteList.add("selectDefaultAddress.t");
        whiteList.add("deleteFootprint.t");
        whiteList.add("salesClassify.t");
        whiteList.add("priceBig.t");
        whiteList.add("priceSmallClassify.t");
        whiteList.add("logout.t");
        whiteList.add("cancelIndent.t");
        whiteList.add("indentList.t");
        whiteList.add("indent.t");
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

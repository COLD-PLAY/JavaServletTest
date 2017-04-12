/**
 * Created by coldplay on 17-4-10.
 */
//导入必需的 java 库
import javax.servlet.*;
import java.io.PrintWriter;
import java.util.*;

//实现 Filter 类
public class LoginFilter implements Filter  {

    public void  init(FilterConfig config) throws ServletException {
        // 获取初始化参数
        String site = config.getInitParameter("Site");

        // 输出初始化参数
        System.out.println("网站名称: " + site);
    }
    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("我是LoginFilter 拦截之后写下的，你怕是跑不掉的");  // 可以在拦截之后在页面上写
        // 输出站点名称
//        System.out.println("站点网址：http://www.runoob.com");

        // 把请求传回过滤链
        chain.doFilter(request,response);
    }
    public void destroy( ){
		/* 在 Filter 实例被 Web 容器从服务移除之前调用 */
    }
}
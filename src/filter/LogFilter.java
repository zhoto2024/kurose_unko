package filter;

import java.io.IOException;
import java.time.LocalDateTime;  //← 追記

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;  //← 追記

@WebFilter("/*")
public class LogFilter implements Filter {

    public LogFilter() {
    }

    public void destroy() {
    }
// フィルタの中では、request を HttpServletRequest 型にキャストした上で
    // getRequestURI() を実行する形で記述します。
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);

        // アクセスされた場所と日時を記録する
        System.out.println( ((HttpServletRequest)request).getRequestURI() + ":" + LocalDateTime.now() );
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}
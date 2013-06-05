package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(true);
		
		if (request.getRequestURI().endsWith(".xhtml")) {
			if (request.getRequestURI().equals(request.getContextPath() + "/faces/home/index.xhtml"))
				chain.doFilter(req, res);
			else {
	
				if (session == null || session.getAttribute("userBean") == null) {
					response.sendRedirect(request.getContextPath()
							+ "/faces/home/index.xhtml");
				} else {
					UserBean user = (UserBean) session.getAttribute("userBean");
	
					if (user.getCurrentUser().cpf.equals("true"))
						response.sendRedirect(request.getContextPath()
								+ "/faces/home/index.xhtml");
					else
						chain.doFilter(req, res);
				}
			}
		}
		else {
			chain.doFilter(req, res);
		}
	}

	@Override
	public void destroy() {
	}

}

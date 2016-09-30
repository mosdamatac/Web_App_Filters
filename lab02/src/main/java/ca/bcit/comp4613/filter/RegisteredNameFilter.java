package ca.bcit.comp4613.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class RegisteredNameFilter
 */
@WebFilter (filterName="RegisteredNameFilter", urlPatterns="/index.jsp", servletNames={"index"})
public class RegisteredNameFilter implements Filter {
	private FilterConfig filterConfig = null;
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("RegisteredNameFilter destroyed");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Filter called by index.jsp");
		
		String path = filterConfig.getServletContext().getInitParameter("duke");
		
		String name = request.getParameter("nameTb");
		if (name != null && !name.trim().isEmpty()) {
			name = name.trim();			
			if (filterConfig.getServletContext().getInitParameter(name.toLowerCase()) != null) {
				path = filterConfig.getServletContext().getInitParameter(name.toLowerCase());
			}
			
			request.setAttribute("name", name);
		}	
		
		request.setAttribute("imgPath", path);

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("RegisteredNameFilter started");
		this.filterConfig = fConfig;
	}

}

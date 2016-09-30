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
		System.out.println("Filter working");
		
		String path = filterConfig.getServletContext().getInitParameter("duke");
		System.out.println(path);
		
		String name;
		if (request.getParameter("nameTb") != null && !request.getParameter("nameTb").trim().isEmpty()) {
			name = request.getParameter("nameTb");
			if (filterConfig.getServletContext().getInitParameter(name) != null && !filterConfig.getServletContext().getInitParameter(name).trim().isEmpty()) {
				name = name.trim().toLowerCase();
				path = filterConfig.getServletContext().getInitParameter(name);
				request.setAttribute("name", name);
			}					
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

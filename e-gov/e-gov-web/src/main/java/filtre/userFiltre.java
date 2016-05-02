package filtre;
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

import tn.esprit.fiveoverfive.e_gov.presentation.mbeans.Authentification;



@WebFilter("/pages/citizen/*")
public class userFiltre implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest rec, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
         HttpServletRequest resquest=(HttpServletRequest) rec;
         HttpServletResponse response=(HttpServletResponse) resp;
         Authentification auth=(Authentification) resquest.getSession().getAttribute("authentification");
         if(auth.getUser_type().equals("Citizen") &&  auth!=null){
        	 chain.doFilter(resquest, response);
         }
         else response.sendRedirect(resquest.getContextPath()+"/public/login.jsf");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

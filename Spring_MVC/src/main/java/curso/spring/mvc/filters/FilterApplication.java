package curso.spring.mvc.filters;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

public class FilterApplication implements Filter{

	public static final Logger LOGGER = LoggerFactory.getLogger(FilterApplication.class);
	
	private FilterConfig filterConfig;
	private static Set<String> encodedParams = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		// Obtenemos los parámetros indicados en el web.xml
		String encodeParamSTR = filterConfig.getInitParameter("encodeParams");
		String[] parts = encodeParamSTR.split(",");
		encodedParams = new HashSet<>(parts.length);
		for(String c: parts) {
			encodedParams.add(c.trim());
			LOGGER.info("Incluido parámetro codificado {}", c.trim());
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LOGGER.info("Aplicando Filtros de seguridad");
		aplicarFiltrosCabecers(request, response, chain);
	}

	@Override
	public void destroy() {
		LOGGER.info("Se procede a parar la aplicacion");
		filterConfig = null;
	}

	private void aplicarFiltrosCabecers(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequestWrapper httpReqWrapper = new HttpServletRequestWrapper((HttpServletRequest) request);
		HttpServletResponseWrapper httpRespWrapper = new HttpServletResponseWrapper((HttpServletResponse) response);
		
		LOGGER.info("filter:"+ ((HttpServletRequest)httpReqWrapper).getRequestURL());
		
		if(request.isSecure()) {
			httpRespWrapper.setHeader("Strict-Transport-Security", "max-age=31622400, includeSubDomains");
			httpRespWrapper.setHeader("Content-Security-Policy", "script-src 'self' 'unsafe-inline' 'unsafe-eval' require-trusted-types-for 'script'");
			httpRespWrapper.setHeader("X-Xss-Protection", "1; mode=block");
			httpRespWrapper.setHeader("X-Content-Type-Options", "nosniff");
		}
		httpRespWrapper.setHeader("X-Frame-Options", "DENY");
		httpRespWrapper.setHeader("X-Powered-By", "none");
		httpRespWrapper.setHeader("Cache-Control", "max-age=0, no-cache, no-store, must-revalidate");
		httpRespWrapper.setHeader("Pragma", "no-cache");
		httpRespWrapper.setHeader("Expires", "0");
		
		String sessionId = ((HttpServletRequest) request).getSession().getId();
		httpRespWrapper.setHeader("Set-Cookie", "JSESSIONID=" + sessionId + "path=/; Secure; HttpOnly; SameSite=Strict");
		
		chain.doFilter(httpReqWrapper, httpRespWrapper);
	}
	
	
	
	
	
	
	
}

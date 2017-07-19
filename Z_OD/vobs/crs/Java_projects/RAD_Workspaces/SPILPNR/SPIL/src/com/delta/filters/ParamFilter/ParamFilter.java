package com.delta.filters.ParamFilter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;


public class ParamFilter implements Filter {
	private Pattern pattern;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		pattern = Pattern.compile(
				filterConfig.getInitParameter("excludeParams"), Pattern.DOTALL);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		chain.doFilter(new ParamFilteredRequest(request, pattern), response);
	}

	@Override
	public void destroy() {
	}

	static class ParamFilteredRequest extends HttpServletRequestWrapper {
		private final String body;
		private final Pattern pattern;

		public ParamFilteredRequest(ServletRequest request, Pattern pattern) {
			super((HttpServletRequest) request);
			this.pattern = pattern;
			StringBuilder stringBuilder = new StringBuilder();
			BufferedReader bufferedReader = null;
			try {
				InputStream inputStream = request.getInputStream();
				if (inputStream != null) {
					bufferedReader = new BufferedReader(new InputStreamReader(
							inputStream));
					char[] charBuffer = new char[128];
					int bytesRead = -1;
					while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
						stringBuilder.append(charBuffer, 0, bytesRead);
					}
				} else {
					stringBuilder.append("");
				}
			} catch (IOException ex) {
				// Add logger here
			} finally {
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					} catch (IOException ex) {
						// Add logger here
					}
				}
			}
			body = stringBuilder.toString();
		}

		@Override
		public Enumeration getParameterNames() {
			List<String> requestParameterNames = Collections
					.list((Enumeration<String>) super.getParameterNames());
			List<String> finalParameterNames = new ArrayList<String>();
			for (String parameterName : requestParameterNames) {
				if (!pattern.matcher(parameterName).matches()) {
					finalParameterNames.add(parameterName);
				}
			}
			return Collections.enumeration(finalParameterNames);
		}

		@Override
		public ServletInputStream getInputStream() throws IOException {
			System.out.println(body);
			final ByteArrayInputStream byteArrayInputStream;
			if (pattern.matcher(body).matches()) {
				byteArrayInputStream = new ByteArrayInputStream("".getBytes());
			} else {
				byteArrayInputStream = new ByteArrayInputStream(body.getBytes());
			}
			return new ServletInputStream() {
				public int read() throws IOException {
					return byteArrayInputStream.read();
				}
			};
		}
	}
}
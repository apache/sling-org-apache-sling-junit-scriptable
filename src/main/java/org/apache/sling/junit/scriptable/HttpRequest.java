/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sling.junit.scriptable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.descriptor.JspConfigDescriptor;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

/** Fake request used to acquire content from Sling */
public class HttpRequest implements HttpServletRequest {

    public static final String FAKE_URL_BASE = "http://example.com";
    private final String path;
    private final Map<String, Object> attributes;
    private final Map<String, String[]> parameters;

    HttpRequest(String path) {
        this.path = path;
        attributes = new HashMap<>();
        parameters = new HashMap<>();
    }

    @Override
    public String getAuthType() {
        return null;
    }

    @Override
    public String getContextPath() {
        return "";
    }

    @Override
    public Cookie[] getCookies() {
        return null;
    }

    @Override
    public long getDateHeader(String name) {
        return 0;
    }

    @Override
    public String getHeader(String name) {
        return null;
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        return null;
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        return null;
    }

    @Override
    public int getIntHeader(String name) {
        return 0;
    }

    @Override
    public String getMethod() {
        return "GET";
    }

    @Override
    public String getPathInfo() {
        return null;
    }

    @Override
    public String getPathTranslated() {
        return null;
    }

    @Override
    public String getQueryString() {
        return null;
    }

    @Override
    public String getRemoteUser() {
        return null;
    }

    @Override
    public String getRequestedSessionId() {
        return null;
    }

    @Override
    public String getRequestURI() {
        return path;
    }

    @Override
    public StringBuffer getRequestURL() {
        return new StringBuffer(FAKE_URL_BASE + path);
    }

    @Override
    public String getServletPath() {
        return path;
    }

    @Override
    public HttpSession getSession() {
        return null;
    }

    @Override
    public HttpSession getSession(boolean create) {
        return null;
    }

    @Override
    public Principal getUserPrincipal() {
        return null;
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromUrl() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
        return false;
    }

    @Override
    public boolean isRequestedSessionIdValid() {
        return false;
    }

    @Override
    public boolean isUserInRole(String role) {
        return false;
    }

    @Override
    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null;
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public int getContentLength() {
        return 0;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return null;
    }

    @Override
    public String getLocalAddr() {
        return null;
    }

    @Override
    public Locale getLocale() {
        return null;
    }

    @Override
    public Enumeration<Locale> getLocales() {
        return null;
    }

    @Override
    public String getLocalName() {
        return null;
    }

    @Override
    public int getLocalPort() {
        return 0;
    }

    @Override
    public String getParameter(String name) {
        return null;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return parameters;
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return null;
    }

    @Override
    public String[] getParameterValues(String name) {
        return null;
    }

    @Override
    public String getProtocol() {
        return null;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return null;
    }

    @Override
    public String getRealPath(String path) {
        return null;
    }

    @Override
    public String getRemoteAddr() {
        return null;
    }

    @Override
    public String getRemoteHost() {
        return null;
    }

    @Override
    public int getRemotePort() {
        return 0;
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path) {
        return null;
    }

    @Override
    public String getScheme() {
        return "http";
    }

    @Override
    public String getServerName() {
        return null;
    }

    @Override
    public int getServerPort() {
        return 0;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void removeAttribute(String name) {
        attributes.remove(name);
    }

    @Override
    public void setAttribute(String name, Object o) {
        attributes.put(name, o);
    }

    @Override
    public void setCharacterEncoding(String env)
            throws UnsupportedEncodingException {
    }

    @Override
    public long getContentLengthLong() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        // TODO Auto-generated method stub
        return new ServletContext() {

            @Override
            public Dynamic addFilter(String filterName, String className) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Dynamic addFilter(String filterName, Filter filter) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Dynamic addFilter(String filterName, Class<? extends Filter> filterClass) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void addListener(String className) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public <T extends EventListener> void addListener(T t) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void addListener(Class<? extends EventListener> listenerClass) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public javax.servlet.ServletRegistration.Dynamic addServlet(String servletName, String className) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public javax.servlet.ServletRegistration.Dynamic addServlet(String servletName, Servlet servlet) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public javax.servlet.ServletRegistration.Dynamic addServlet(String servletName,
                    Class<? extends Servlet> servletClass) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public <T extends Filter> T createFilter(Class<T> clazz) throws ServletException {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public <T extends EventListener> T createListener(Class<T> clazz) throws ServletException {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public <T extends Servlet> T createServlet(Class<T> clazz) throws ServletException {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void declareRoles(String... roleNames) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public Object getAttribute(String name) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Enumeration<String> getAttributeNames() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public ClassLoader getClassLoader() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public ServletContext getContext(String uripath) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String getContextPath() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Set<SessionTrackingMode> getDefaultSessionTrackingModes() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public int getEffectiveMajorVersion() {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public int getEffectiveMinorVersion() {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public Set<SessionTrackingMode> getEffectiveSessionTrackingModes() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public FilterRegistration getFilterRegistration(String filterName) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Map<String, ? extends FilterRegistration> getFilterRegistrations() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String getInitParameter(String name) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Enumeration<String> getInitParameterNames() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public JspConfigDescriptor getJspConfigDescriptor() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public int getMajorVersion() {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public String getMimeType(String file) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public int getMinorVersion() {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public RequestDispatcher getNamedDispatcher(String name) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String getRealPath(String path) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public RequestDispatcher getRequestDispatcher(String path) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public URL getResource(String path) throws MalformedURLException {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public InputStream getResourceAsStream(String path) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Set<String> getResourcePaths(String path) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String getServerInfo() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Servlet getServlet(String name) throws ServletException {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String getServletContextName() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Enumeration<String> getServletNames() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public ServletRegistration getServletRegistration(String servletName) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Map<String, ? extends ServletRegistration> getServletRegistrations() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Enumeration<Servlet> getServlets() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public SessionCookieConfig getSessionCookieConfig() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String getVirtualServerName() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void log(String msg) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void log(Exception exception, String msg) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void log(String message, Throwable throwable) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void removeAttribute(String name) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void setAttribute(String name, Object object) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public boolean setInitParameter(String name, String value) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public void setSessionTrackingModes(Set<SessionTrackingMode> sessionTrackingModes) {
                // TODO Auto-generated method stub
                
            }
            
        };
    }

    @Override
    public AsyncContext startAsync() throws IllegalStateException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse)
            throws IllegalStateException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isAsyncStarted() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAsyncSupported() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public AsyncContext getAsyncContext() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DispatcherType getDispatcherType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String changeSessionId() {
        return null;
    }

    @Override
    public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
        return false;
    }

    @Override
    public void login(String username, String password) throws ServletException {
    }

    @Override
    public void logout() throws ServletException {
    }

    @Override
    public Collection<Part> getParts() throws IOException, ServletException {
        return null;
    }

    @Override
    public Part getPart(String name) throws IOException, ServletException {
        return null;
    }

    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
        return null;
    }
}

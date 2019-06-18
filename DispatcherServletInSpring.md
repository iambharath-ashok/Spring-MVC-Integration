#	Dispatcher Servlet

-	DispatcherServlet acts as front controller for Spring based web applications
-	It provides a mechanism for request processing 
-	It is inherited from javax.servlet.http.HttpServlet, it is typically configured in the web.xml file
-	A web application can define any number of DispatcherServlet instances
-	Each servlet will operate in its own namespace, loading its own application context with mappings and handlers
-	Only the root application context will be loaded by ContextLoaderListener
-	Root application context will be shared b/w all the application contexts
-	In most cases, applications have only single DispatcherServlet with the context-root URL(/), that is, all requests coming to that domain will be handled by it



##	How Dispatcher Servlet uses WebApplicationContext

-	In a Spring-based application, our application objects live within an object container
-	This container creates objects and associations between objects, and manages their complete life cycle
-	These container objects are called Spring-managed beans and the container is called an application context in the Spring world

-	WebApplicationContext is an extension of a plain ApplicationContext. it is web aware ApplicationContext i.e it has Servlet Context information
- 	When DispatcherServlet is loaded, it looks for the bean configuration file of WebApplicationContext and initializes it
-	By having access to servlet context any beans which implement ServletContextAware interface can get access to ServletContext instance and do many things 
-	For example, it can get context init parameters, get context root information and get resources location inside web application folders



## Dispatcher Servlet Config in web.xml

-	In the below code, dispatcher-servlet-context.xml file will contain all beans definitions and associations which will be available to DispatcherServlet

			<web-app>
			  <listener>
				<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
			  </listener>
			 
			  <context-param>
				<param-name>contextConfigLocation</param-name>
				<param-value>/WEB-INF/dispatcher-servlet-context.xml</param-value>
			  </context-param>
			 
			  <servlet>
				<servlet-name>dispatcher-servlet</servlet-name>
				<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
				<init-param>
				  <param-name>contextConfigLocation</param-name>
				  <param-value></param-value>
				</init-param>
				<load-on-startup>1</load-on-startup>
			  </servlet>
			 
			  <servlet-mapping>
				<servlet-name>dispatcher-servlet</servlet-name>
				<url-pattern>/*</url-pattern>
			  </servlet-mapping>
			 
			</web-app>

			
-	applicationContext.xml
		
		
			<beans xmlns="http://www.springframework.org/schema/beans"
				xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				xsi:schemaLocation="http://www.springframework.org/schema/beans
				http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">
			 
				<bean id="viewResolver"
					class="org.springframework.web.servlet.view.InternalResourceViewResolver" >
					<property name="prefix">
						<value>/WEB-INF/views/</value>
					</property>
					<property name="suffix">
						<value>.jsp</value>
					</property>
				</bean>
			 
			</beans>
			
			
##	DispatcherServlet Java based Configuration

-	ApplicationInitializer.java


				public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
					   @Override
					   protected Class<?>[] getRootConfigClasses() {
						  return new Class[] { RootConfig.class };
					   }
					 
					   @Override
					   protected Class<?>[] getServletConfigClasses() {
						  return new Class[] { WebMvcConfig.class };
					   }
					 
					   @Override
					   protected String[] getServletMappings() {
						  return new String[] { "/" };
					   }
					}
					
##	Beans supporting DispatcherServlet


BEAN	| RESPONSIBILITIES
--------|---------------------
HandlerMapping	| Maps incoming web requests to handlers and pre- and post-processors
HandlerAdapter	| Invokes the handler which resolves arguments and dependencies, such as annotated arguments for URL-mapped controller method endpoints
HandlerExceptionResolver	| Allows programmatic handling of exceptions and maps exceptions to views
ViewResolver	| Resolves logical view names to view instances
LocaleResolver	| Resolves the client’s locale in order to enable internationalization
LocaleContextResolver	| A richer extension of LocaleResolver, with timezone information
ThemeResolver	| Resolves themes configured in wer app for enhanced user experience
MultipartResolver	| Handles multipart file uploads as part of HTTP requests
FlashMapManager	| Manages FlashMap instances that store temporary Flash attributes between requests redirected from one another



##	Spring 5 DispatcherServlet Example









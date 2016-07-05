# SpringMVCFramework

Spring MVC Fundamentals
------------------------
<p> A request through Spring MVC: </p>

![alt tag](https://github.com/sendkumaranil/SpringMVCFramework/blob/master/mvc_control_flow.png)

<b>Configuration of Dispatcher Servlet:</b><br>

![alt tag](https://github.com/sendkumaranil/SpringMVCFramework/blob/master/web.png)

<b>Handler Mapping Implementations:</b><br>
<ul>
	<li>BeanNameUrlHandlerMapping (Default)</li>
	<li>ControllerBeanNameHandlerMapping</li>
	<li>ControllerClassNameHandlerMapping</li>
	<li>DefaultAnnotationHandlerMapping (Default)</li>
	<li>SimpleUrlHandlerMapping</li>
</ul>

<b>Controller Annotations:</b><br>
<ul>
	<li>@RequestMapping
		<ul>
			<li>Method Level</li>
			<li>Class Level</li>
			<li>Attributes value, method=RequestMethod.POST</li>
		</ul>
	</li>
	<li>@PathVariable</li>
	<li>@RequestParam</li>
</ul>

<b>View Resolver:</b><br>
<ul>
	<li>BeanNameViewResolver</li>
	<li>ContentNegotiatingViewResolver</li>
	<li>FreeMarkerViewResolver</li>
	<li>InternalResourceViewResolver</li>
	<li>JasperReportsViewResolver</li>
	<li>ResourceBundleViewResolver</li>
	<li>TilesViewResolver</li>
	<li>UrlBasedViewResolver</li>
	<li>VelocityViewResolver</li>
</ul>
<hr>
<b>InternalResourceViewResolver:</b><br>

		/WEB-INF/views/home.jsp
		
		Prefix=> /WEB-INF/views/
		Suffix=> .jsp
		Logical View name=> home
		
		<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<property name="prefix" value="/WEB-INF/jsp/" />
			<property name="suffix" value=".jsp" />
		</bean>
		
<b>Mapping Exception:</b><br>

		public class MyCustomException extends RuntimeException{
			
			----------
			----------
		}
		
		<bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
			<property name="exceptionMappings">
				<props>
					<prop key="com.mypackage.example.MyCustomException">customException</prop>
				</props>
			</property>
			<property name="defaultErrorView" value="error"/>
		</bean>
		

<b>Spring Validation:</b><br>
<ul>
	<li>Using Annotation : @Valid and other annotation</li>
	<li>Programmatic : Validator, ValidatorUtil and Error Interface</li>
</ul>

<b>Project Tree Structure:</b><br>

![alt tag](https://github.com/sendkumaranil/SpringMVCFramework/blob/master/ProjectExplorer.PNG)

<b>Spring Security:</b>
<ul>
	<li>In-memory authentication: <br>
	
			<authentication-manager>
				<authentication-provider>
					<user-service>
						<user name="anil" password="kumar" authorities="ROLE_USER"/>
						<user name="admin" password="verma" authorities="ROLE_ADMIN"/>
					</user-service>
				</authentication-provider>
			</authentication-manager>	
	</li>
	<li>jdbc-authentication:  <br>
			<authentication-manager>
				<authentication-provider>
					<jdbc-user-service data-source-ref="myDataSource" 
					users-by-username-query="select username,password,userid from test.userdetails where username=?"
					authorities-by-username-query="select user.username,role.role_name from test.userdetails user 
					inner join test.user_role user_role on user.userid=user_role.userid
					inner join test.roledetails role on role.roleid=user_role.roleid and user.username=?"/>
				</authentication-provider>
			</authentication-manager>
	</li>
</ul>

<b>Spring Security configuration:</b><br>
		
		<beans:beans xmlns="http://www.springframework.org/schema/security"
			xmlns:beans="http://www.springframework.org/schema/beans" 
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:schemaLocation="http://www.springframework.org/schema/security 
					http://www.springframework.org/schema/security/spring-security.xsd
					http://www.springframework.org/schema/beans 
					http://www.springframework.org/schema/beans/spring-beans.xsd">
		 
		 
			<http auto-config="true">
				<intercept-url pattern="/welcome" access="ROLE_USER,ROLE_ADMIN"/>
				<intercept-url pattern="/createEmpPage" access="ROLE_ADMIN"/>
				<form-login login-page="/login" authentication-failure-url="/login" 
				always-use-default-target="true" default-target-url="/welcome"/>
				<logout logout-url="/logout"/>
			</http>
			
			<!-- In-memory authentication -->
			<authentication-manager>
				<authentication-provider>
					<user-service>
						<user name="anil" password="kumar" authorities="ROLE_USER"/>
						<user name="admin" password="verma" authorities="ROLE_ADMIN"/>
					</user-service>
				</authentication-provider>
			</authentication-manager>
			
			<!-- Spring Database access using JdbcDaoSupport -->
			<beans:bean id="myDataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
				<beans:property name="driverClassName" value="com.mysql.jdbc.Driver"/>
				<beans:property name="url" value="jdbc:mysql://localhost:3306/test"/>
				<beans:property name="username" value="root"/>
				<beans:property name="password" value="root"/>
			</beans:bean>
			
			<!-- jdbc-user authentication -->
			<authentication-manager>
				<authentication-provider>
					<jdbc-user-service data-source-ref="myDataSource" 
					users-by-username-query="select username,password,userid from test.userdetails where username=?"
					authorities-by-username-query="select user.username,role.role_name from test.userdetails user 
					inner join test.user_role user_role on user.userid=user_role.userid
					inner join test.roledetails role on role.roleid=user_role.roleid and user.username=?"/>
				</authentication-provider>
			</authentication-manager>
	
		</beans:beans>
	
<b>Register Spring security delegating filter in web.xml file:</b><br>

		<filter>
			<filter-name>springSecurityFilterChain</filter-name>
			<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
		</filter>
	 
		<filter-mapping>
			<filter-name>springSecurityFilterChain</filter-name>
			<url-pattern>/*</url-pattern>
		</filter-mapping>
		
		<context-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/spring-security.xml,/WEB-INF/EMS-servlet.xml</param-value>
		</context-param>
		
		<listener>
			<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
		</listener>

<b>Updated Project tree structure for Spring Security:<b><br>

![alt tag](https://github.com/sendkumaranil/SpringMVCFramework/blob/master/Spring_Security_tree_structure.PNG)

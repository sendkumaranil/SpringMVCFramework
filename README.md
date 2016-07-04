# SpringMVCFramework (under progress..)

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

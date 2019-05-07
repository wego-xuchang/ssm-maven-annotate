package com.gitboy.annotate.conf;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *  * tomcat启动时  * 1)找到类路径下的META-INF目录  * 2)找到META-INF文件夹下的services目录  *
 * 3)读取services目录下的/META-INF/services/javax.servlet.ServletContainerInitializer目录
 *  * 4)依据文件中定义的类全名(SpringServletContainerInitializer),并创建对象  *
 * 5)依据文件中定义的类上的注解@HandlesTypes注解声明的类型进行加载  *
 * 6)然后调用类(SpringServletContainerInitializer)中的onStartup方法,并将@HandlesTypes声明这些类型传递给此方法
 *  * 7)最后进行对象的创建和初始化  *  
 */

public class MyWebAppInitializerConf extends AbstractAnnotationConfigDispatcherServletInitializer {



@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { DispatcherServletConfig.class };
	}

	/**
	 * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletMappings()
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	/**
	 * 添加过滤器
	 * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletFilters()
	 */
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] { characterEncodingFilter };
	}
}

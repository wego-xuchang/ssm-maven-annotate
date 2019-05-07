package com.gitboy.conf;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;


/**   
*    
* 项目名称：ssm-maven-annotate2   
* 类名称：MyDispatcherServletInitializerConfig   
* 类描述：   初始化servlet WebApplicationContext 相关
* 创建人：No   
* 创建时间：2019年5月5日 下午11:12:43   
* 作者：No   
* @version    
*    
*/
public class MyDispatcherServletInitializerConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{DispatcherServlet.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
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
        return new Filter[]{characterEncodingFilter};
    }
}
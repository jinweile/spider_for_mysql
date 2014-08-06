package com.etaoshi.spider.web;

import org.apache.axis2.AxisFault;
import org.apache.axis2.ServiceObjectSupplier;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.description.Parameter;
import org.apache.axis2.i18n.Messages;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 可能出现Axis2 spring bean not found 或者 Spring applicationContext not found。
 * 
 * 解决办法：构建自己的ServiceObjectSupplier，实现接口ServiceObjectSupplier，
 * 同时也实现Spring的ApplicationContextAware接口
 * 
 * 
 * @author Administrator
 * 
 */
public class HelloWorldWebService implements ServiceObjectSupplier,
		ApplicationContextAware {
	private static ApplicationContext ctx;

	public Object getServiceObject(AxisService axisService) throws AxisFault {
		Parameter springBeanName = axisService.getParameter("SpringBeanName");
		String beanName = ((String) springBeanName.getValue()).trim();
		if (beanName != null) {
			if (ctx == null)
				throw new AxisFault("applicationContext is NULL! ");
			if (ctx.getBean(beanName) == null)
				throw new AxisFault("Axis2 Can't find Spring Bean: " + beanName);
			return ctx.getBean(beanName);
		} else {
			throw new AxisFault(Messages.getMessage("paramIsNotSpecified",
					"SERVICE_SPRING_BEANNAME"));
		}

	}

	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.ctx = ctx;
	}

}

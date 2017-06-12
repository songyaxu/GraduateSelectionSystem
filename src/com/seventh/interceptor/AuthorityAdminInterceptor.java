package com.seventh.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.seventh.entity.Admin;

@SuppressWarnings("serial")
public class AuthorityAdminInterceptor extends AbstractInterceptor{
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String,Object> session=invocation.getInvocationContext().getSession();
		ActionContext context=invocation.getInvocationContext();
		Admin admin = (Admin) session.get("admin");
		if (admin!=null) {
			return invocation.invoke();
		}
		context.put("message", "您还没有登录，请登录系统。");
		return Action.LOGIN;
	}
}

package com.seventh.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.seventh.entity.Student;

@SuppressWarnings("serial")
public class AuthorityStudentInterceptor extends AbstractInterceptor{
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String,Object> session=invocation.getInvocationContext().getSession();
		ActionContext context=invocation.getInvocationContext();
		Student student=(Student)session.get("student");
		if (student!=null) {
			return invocation.invoke();
		}
		context.put("message", "您还没有登录，请登录系统。");
		return Action.LOGIN;
	}
}

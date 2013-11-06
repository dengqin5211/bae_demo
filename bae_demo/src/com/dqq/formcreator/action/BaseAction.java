package com.dqq.formcreator.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * action父类，封装了通用方法.
 * 
 * @author jason
 * 
 */
public class BaseAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware, SessionAware {
	private static final long serialVersionUID = -6723777444654586547L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 返回数据到前台.
	 * 
	 * @param String
	 *            相关数据
	 */
	protected void printData(String dataStr) {
		try {
			response.setContentType("text/xml;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			pw.write(dataStr);
			pw.flush();
			pw.close();
		} catch (IOException e) {
		}
	}

	/**
	 * 对特殊的html字符进行编码
	 * 
	 * @param message
	 * @return
	 */
	protected String filter(String message) {
		if (message == null) {
			return null;
		}

		char content[] = new char[message.length()];
		message.getChars(0, message.length(), content, 0);
		StringBuilder result = new StringBuilder(content.length + 50);
		for (int i = 0; i < content.length; i++) {
			switch (content[i]) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '"':
				result.append("&quot;");
				break;
			default:
				result.append(content[i]);
			}
		}
		return result.toString();

	}
}

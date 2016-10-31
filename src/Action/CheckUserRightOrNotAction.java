package Action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
    
import com.opensymphony.xwork2.Action;
    
/**  
* @author 鲁炬 http://luju.me
*
*/

public class CheckUserRightOrNotAction {
	private String loginname;
	private String password;
	private String msg;

	public String getMsg() {
	    return msg;
	}
	    
	public void setMsg(String msg) {
	this.msg = msg;
	 }

	public String getLoginname() {
	return loginname;
	}

	public void setLoginname(String loginname) {
	this.loginname = loginname;
	}

	public String getPassword() {
	return password;
	}

	public void setPassword(String password) {
	this.password = password;
	}

	/** 用户登陆 */
	public String login() {
	if(StringUtils.isBlank(this.loginname)) {
	return Action.INPUT;
	}
	/*
	这里写你自己通过用户名查找用户信息的业务逻辑
	比如：使用手机号登陆
	Citizen user = prmService.queryEGovCitizenByMobile(this.loginname);
	....
	*/
	if(user == null || user.getPwd() == null || !user.getPwd().getValue().equals(this.password)) {
	//登陆失败
	this.msg = "用户不存在或密码错误！";
	return Action.INPUT;
	} else {
	//登陆成功
	//设置session
	this.getSession().setAttribute("_USER_INFO_LOGIN_NAME_", this.loginname);
	this.getSession().setAttribute("_USER_INFO_USER_ID_", user.getId().getValue());
	this.getSession().setAttribute("_USER_INFO_USER_INFO_", user);
	//设置cookie
	this.getResponse().addCookie(new Cookie("_USER_INFO_LOGIN_NAME_", this.loginname));
	this.getResponse().addCookie(new Cookie("_USER_INFO_USER_ID_", user.getId().getValue()));
	return Action.SUCCESS;
	}
	}
	    
	/**
	* 注销
	*/
	public String loginout() {
	//清空session
	this.getSession().invalidate();
	return Action.SUCCESS;
	}

	public HttpSession getSession() {
	return ServletActionContext.getRequest().getSession();
	}

	public HttpServletRequest getRequest() {
	return ServletActionContext.getRequest();
	}
	public HttpServletResponse getResponse() {
	return ServletActionContext.getResponse();
	}
}

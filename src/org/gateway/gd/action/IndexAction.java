package org.gateway.gd.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
@SuppressWarnings("serial")
public class IndexAction extends ActionSupport {

	public String index() {
		return "index";
	}

	public String top() {
		return "top";
	}

	public String left() {
		return "left";
	}

	public String right() {
		return "right";
	}
	
	public String bottom(){
		return "bottom";
	}

}

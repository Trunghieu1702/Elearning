package edu.mta.Elearning.controller;

import java.util.Map;

import org.springframework.ui.Model;

import edu.mta.Elearning.mgr.RoleMgr;
import edu.mta.Elearning.mgr.UserMgr;
import edu.mta.Elearning.object.CtxUser;

public abstract class BaseController {
	
	
	protected void GetTitle(Model model,String Page,Map<String,String> function) {
		model.addAttribute("title", Page);
		model.addAttribute("btnFunction", function);
	}
	

	
	protected UserMgr UserMgr() {
		return UserMgr.get();
	}
	
	protected RoleMgr RoleMgr() {
		return RoleMgr.get();
	}
	
	protected CtxUser getCtxUser() {
		return UserMgr.get().getContextUser();
	}
}
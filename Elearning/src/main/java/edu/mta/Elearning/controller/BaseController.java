package edu.mta.Elearning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.mta.Elearning.dto.PermissionConfig;
import edu.mta.Elearning.dto.RoleDisplay;
import edu.mta.Elearning.dto.SubPermissionConfig;
import edu.mta.Elearning.mgr.CboxDepthMgr;
import edu.mta.Elearning.mgr.CboxMgr;
import edu.mta.Elearning.mgr.RoleMgr;
import edu.mta.Elearning.mgr.UserMgr;
import edu.mta.Elearning.object.CtxUser;
import edu.mta.Elearning.object.Role;

public abstract class BaseController {

	protected void GetTitle(Model model, String Page, Map<String, String> function) {
		model.addAttribute("title", Page);
		model.addAttribute("btnFunction", function);
	}

	@ModelAttribute("roleOfUser")
	public Map<String, Boolean> getRoleListModel() {
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		CtxUser user = UserMgr.get().getContextUser();
		if (user != null) {
			Role role = RoleMgr().getRoleAll(user.getRole());
			if (role != null) {
				RoleDisplay roleD = new RoleDisplay(role);
				ObjectMapper mapper = new ObjectMapper();
				List<PermissionConfig> permissionConfigs = (List<PermissionConfig>) mapper
						.convertValue(roleD.getPermisssion(), new TypeReference<List<PermissionConfig>>() {
						});
				for (PermissionConfig permissionConfig : permissionConfigs) {
					List<SubPermissionConfig> subs = permissionConfig.getItems();
					for (SubPermissionConfig sub : subs) {
						result.put(permissionConfig.getName() + sub.getName(), sub.isValue());
					}
				}
			}
		}
		return result;
	}

	protected UserMgr UserMgr() {
		return UserMgr.get();
	}

	protected RoleMgr RoleMgr() {
		return RoleMgr.get();
	}
	
	protected CboxMgr CboxMgr() {
		return CboxMgr.get();
	}
	
	protected CboxDepthMgr CboxDepthMgr() {
		return CboxDepthMgr.get();
	}

	protected CtxUser getCtxUser() {
		return UserMgr.get().getContextUser();
	}
}
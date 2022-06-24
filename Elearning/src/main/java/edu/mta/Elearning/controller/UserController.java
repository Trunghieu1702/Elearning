package edu.mta.Elearning.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.mta.Elearning.dto.UserDisplay;
import edu.mta.Elearning.object.CtxUser;
import edu.mta.Elearning.object.Role;
import edu.mta.Elearning.object.User;
import edu.mta.Elearning.service.FileUploadService;

@Controller
public class UserController extends BaseController {

	Map<String, String> funtionTitle = new HashMap<String, String>();
	
	@Autowired
	protected FileUploadService fileUploadService;
	
	@RequestMapping(value = "/ViewUser", method = RequestMethod.GET)
	public String userPage(Model model) {
		try {
			funtionTitle.put("edit", "UpdateUser");
			GetTitle(model, "Tài Khoản của tôi", funtionTitle);
			CtxUser user = getCtxUser();
			User nv = UserMgr().findUserAccount(user.getUsername());
			model.addAttribute("user", user);
			model.addAttribute("UserDisplay", new UserDisplay(nv));
			model.addAttribute("readonly", true);
			
			return "userPage";
			
		} catch (Exception e) {
			model.addAttribute("message", e);
			return "403Page";
		}
	}

	@RequestMapping(value = "/UpdateUser", method = RequestMethod.GET)
	public String updateUserPage(Model model) {
		try {
			funtionTitle.put("edit", "UpdateUser");
			GetTitle(model, "Tài Khoản của tôi", funtionTitle);
			CtxUser ctxuser = getCtxUser();
			
			User user = UserMgr().findUserAccount(ctxuser.getUsername());
			List<Role> roles = RoleMgr().getRoleAll();
			model.addAttribute("user", ctxuser);
			model.addAttribute("ddRoles", roles);
			model.addAttribute("UserDisplay", new UserDisplay(user));
			model.addAttribute("readonly", false);
			return "UserPage";

		} catch (Exception e) {
			model.addAttribute("message", e);
			return "403Page";
		}
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUserPage(Model model, @ModelAttribute("UserDisplay") UserDisplay user
			, @RequestParam("fileAvatar")  MultipartFile file) {
		try {
			funtionTitle.put("edit", "UpdateUser");
			GetTitle(model, "Tài Khoản của tôi", funtionTitle);
			CtxUser ctxUser = getCtxUser();
			
			User nv = UserMgr().findUserAccount(ctxUser.getUsername());
			if(file != null &&file.getOriginalFilename()!="" &&file.getSize()>0) {
				String urlImg=fileUploadService.uploadFile(file,ctxUser.getUsername());
				nv.setImgurl(urlImg);
			}
			nv.setAddress(user.getAddress());
			nv.setBirthday(user.getBirthday());
			nv.setCode(user.getCode());
			nv.setEmail(user.getEmail());
			nv.setName(user.getName());
//			nv.setPassword(EncrytedPasswordUtils.encrytePassword(user.getPassword()));
			nv.setPhone_number(user.getPhone_number());
			nv.setRoleId(user.getRoleId());
			nv.setSex(user.getSex());
			nv.setStart_date(user.getStart_date());
			nv.setStatus(user.getStatus());
			UserMgr().persist(nv);
			
			ctxUser.setUser(nv.getDbUser());
			Map<String, Object> authorities = new HashMap<String, Object>();
			authorities.put("/saveUser", true);
			authorities.put("/UpdateUser", false);
			Role role = new Role();
			role.setName("Student");
			role.setPermisssion(authorities);

			RoleMgr().persist(role);
			
			System.out.println(role.getId());
			return "redirect:/ViewUser";
		} catch (Exception e) {
			model.addAttribute("message", e);
			return "403Page";
		}
	}
}

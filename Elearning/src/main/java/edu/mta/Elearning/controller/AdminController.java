package edu.mta.Elearning.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import edu.mta.Elearning.utils.EncrytedPasswordUtils;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

	Map<String, String> funtionTitle = new HashMap<String, String>();

	@Autowired
	protected FileUploadService fileUploadService;

	@RequestMapping(value = "/UsersList", method = RequestMethod.GET)
	public String userPage(Model model) {
		try {
			// funtionTitle.put("edit", "UpdateUser");
			GetTitle(model, "Hệ Thống", funtionTitle);
			CtxUser user = getCtxUser();
			List<User> users = UserMgr().getAll();
			List<UserDisplay> usersDisplay = new ArrayList<UserDisplay>();
			List<Role> roles = RoleMgr().getRoleAll();
			UserDisplay userdp = new UserDisplay();
			for (User u : users) {
				userdp = new UserDisplay(u);
				List<Role> resultRoleList = roles.stream().filter(r -> r.getId() == u.getRoleId())
						.collect(Collectors.toList());
				if (resultRoleList.size() == 1) {
					userdp.setStrRole(resultRoleList.get(0).getName());
				} else
					userdp.setStrRole("");
				usersDisplay.add(userdp);
			}
			model.addAttribute("ddRoles", roles);
			model.addAttribute("user", user);
			model.addAttribute("lstUser", usersDisplay);
			model.addAttribute("readonly", true);
			model.addAttribute("UserDisplay", new UserDisplay());
			return "SystemSetingPageUser";

		} catch (Exception e) {
			model.addAttribute("message", e);
			return "403Page";
		}
	}

	@RequestMapping(value = "/UsersDetail", method = RequestMethod.GET)
	public String viewUserDetail(Model model, @RequestParam(name = "code", defaultValue = "") String code) {
		try {
			// funtionTitle.put("edit", "UpdateUser");
			GetTitle(model, "Thông Tin Người Dùng", funtionTitle);
			
			CtxUser user = getCtxUser();
			User currUser = UserMgr().findUserAccount(code);
			if(currUser.getCode()==null) {
				model.addAttribute("message", "Không tìm thấy người dùng " + code);
				return "403Page";
			}
			List<Role> roles = RoleMgr().getRoleAll();
			
			model.addAttribute("ddRoles", roles);
			model.addAttribute("user", user);
			model.addAttribute("UserDisplay", new UserDisplay(currUser));
			return "userDeatail";

		} catch (Exception e) {
			model.addAttribute("message", e);
			return "403Page";
		}
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUserPage(Model model, @ModelAttribute("UserDisplay") UserDisplay user,
			@RequestParam("fileAvatar") MultipartFile file) {
		try {
			funtionTitle.put("edit", "UpdateUser");
			GetTitle(model, "Lưu  Người Dùng", funtionTitle);
			CtxUser ctxUser = getCtxUser();
			User nv = UserMgr().findUserAccount(user.getCode());
			String  urlTo ="";
			if (nv.getCode()==null) {
				nv = new User();
				nv.setCode(user.getCode());
				nv.setPassword(EncrytedPasswordUtils.encrytePassword("123"));
				urlTo="redirect:/admin/UsersList";
			}else {
				urlTo = "redirect:/admin/UsersDetail/?code=" + user.getCode();
			}
			
			if (file != null && file.getOriginalFilename() != "" && file.getSize() > 0) {
				String urlImg = fileUploadService.uploadFile(file, user.getCode());
				nv.setImgurl(urlImg);
			}
			nv.setAddress(user.getAddress());
			nv.setBirthday(user.getBirthday());
			nv.setEmail(user.getEmail());
			nv.setName(user.getName());
			nv.setPhone_number(user.getPhone_number());
			nv.setRoleId(user.getRoleId());
			nv.setSex(user.getSex());
			nv.setStart_date(user.getStart_date());
			nv.setStatus(user.getStatus());
			UserMgr().persist(nv);

			return urlTo;
		} catch (Exception e) {
			model.addAttribute("message", e);
			return "403Page";
		}
	}
	
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String deletUser(Model model, @RequestParam(name = "code", defaultValue = "") String code) {
		try {
			CtxUser user = getCtxUser();
			User currUser = UserMgr().findUserAccount(code);
			if(currUser.getCode()==null) {
				model.addAttribute("message", "Không tìm thấy người dùng " + code);
				return "403Page";
			}
			currUser.setDeleteflag(1);
			UserMgr().persist(currUser);
			return "redirect:/admin/UsersList";
		} catch (Exception e) {
			model.addAttribute("message", e);
			return "403Page";
		}
	}
}

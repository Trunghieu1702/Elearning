package edu.mta.Elearning.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.mta.Elearning.dto.CboxDto;
import edu.mta.Elearning.dto.RoleDisplay;
import edu.mta.Elearning.dto.UserDisplay;
import edu.mta.Elearning.object.CboxDepth;
import edu.mta.Elearning.object.Cboxs;
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

	@RequestMapping(value = "/system", method = RequestMethod.GET)
	public String systemPage(Model model) {
		try {
			// funtionTitle.put("edit", "UpdateUser");
			GetTitle(model, "Hệ Thống", funtionTitle);
			CtxUser user = getCtxUser();
			model.addAttribute("user", user);
			return "SystemSetingPage";

		} catch (Exception e) {
			model.addAttribute("message", e);
			return "403Page";
		}
	}

	@RequestMapping(value = "/subject", method = RequestMethod.GET)
	public String subjectPage(Model model) {
		try {
			// funtionTitle.put("edit", "UpdateUser");
			GetTitle(model, "Nội Dung", funtionTitle);
			CtxUser user = getCtxUser();
			model.addAttribute("user", user);
			return "ManagerContent";

		} catch (Exception e) {
			model.addAttribute("message", e);
			return "403Page";
		}
	}

	@RequestMapping(value = "/ContentList/{id}", method = RequestMethod.GET)
	public String contentPage(Model model, @PathVariable int id) {
		try {
			GetTitle(model, "Hệ Thống", funtionTitle);
			Date date = new Date();
			CtxUser user = getCtxUser();
			List<CboxDto> displays = new ArrayList<CboxDto>();
			if (id == 0) {
				List<Cboxs> cboxShares = CboxMgr().getInforCboxs(id, "Shared", null);

				if (cboxShares == null || cboxShares.size() == 0) {
					Cboxs cboxShare = new Cboxs();

					cboxShare.setCreationTime(new Timestamp(date.getTime()));
					cboxShare.setFolderName("Shared");
//					cboxShare.setUser_id(UUID.fromString("26672893-feaf-417b-86eb-fc2591340c8a"));
					cboxShare.setParentId(id);
					CboxMgr().persist(cboxShare);

					CboxDepth cboxDS = new CboxDepth();
					cboxDS.setDepth(id);
					cboxDS.setFolderId(cboxShare.getFolderId());
					cboxDS.setParentId(cboxShare.getFolderId());
					CboxDepthMgr().persist(cboxDS);
					cboxShares.add(cboxShare);
				}
				for (Cboxs cboxs : cboxShares) {
					displays.add(new CboxDto(cboxs, 0, CboxDto.FOLDER));
				}

				List<Cboxs> cboxPrivates = CboxMgr().getInforCboxs(id, "Privated", user.getUserObject().getUserId());
				if (cboxPrivates.size() == 0) {
					Cboxs cboxPrivate = new Cboxs();
					cboxPrivate.setCreationTime(new Timestamp(date.getTime()));
					cboxPrivate.setFolderName("Privated");
					cboxPrivate.setUser_id(user.getUserObject().getUser_id());
					cboxPrivate.setParentId(id);
					CboxMgr().persist(cboxPrivate);

					CboxDepth cboxDP = new CboxDepth();
					cboxDP.setDepth(id);
					cboxDP.setFolderId(cboxPrivate.getFolderId());
					cboxDP.setParentId(cboxPrivate.getFolderId());
					CboxDepthMgr().persist(cboxDP);
					cboxPrivates.add(cboxPrivate);
				}
				for (Cboxs cboxs : cboxPrivates) {
					displays.add(new CboxDto(cboxs, 1, CboxDto.FOLDER));
				}

			} else {
				Cboxs cboxPre = CboxMgr().getCboxById(id);
				if (cboxPre != null) {
					if (cboxPre.getParentId() == 0) {
						CboxDto cboxPreDto = new CboxDto(cboxPre, 0, CboxDto.BUTTON);
						cboxPreDto.setFolderid(0);
						cboxPreDto.setFolderName("(Previous Folder)");
						displays.add(cboxPreDto);
					}else {
						Cboxs cboxParent = CboxMgr().getCboxById(cboxPre.getParentId());
						if (cboxParent != null) {
							CboxDto cboxParentDto = new CboxDto(cboxPre, 0, CboxDto.BUTTON);
							cboxParentDto.setFolderName("(Previous Folder)");
							displays.add(cboxParentDto);
						}
					}
				}
				List<Cboxs> cboxs = CboxMgr().getInforCboxs(id,null,null);
				for (Cboxs cbox : cboxs) {
					displays.add(new CboxDto(cbox, 1, CboxDto.FOLDER));
				}
			}

			model.addAttribute("Cboxs", displays);
			model.addAttribute("user", user);
			return "ManagerContent";

		} catch (Exception e) {
			model.addAttribute("message", e);
			return "403Page";
		}
	}

	@RequestMapping(value = "/RoleList", method = RequestMethod.GET)
	public String rolePage(Model model) {
		try {
			// funtionTitle.put("edit", "UpdateUser");
			GetTitle(model, "Hệ Thống", funtionTitle);
			CtxUser user = getCtxUser();
			List<Role> roles = RoleMgr().getRoleAll();
			List<RoleDisplay> displays = new ArrayList<RoleDisplay>();
			for (Role role : roles) {
				RoleDisplay r = new RoleDisplay(role);
				displays.add(r);
			}

			model.addAttribute("RoleLst", displays);
			model.addAttribute("user", user);
			model.addAttribute("roleDisplay", new RoleDisplay());
			return "SystemSetingPageRole";

		} catch (Exception e) {
			model.addAttribute("message", e);
			return "403Page";
		}
	}

	@RequestMapping(value = "/RoleDetail", method = RequestMethod.GET)
	public String roleDetail(Model model, @RequestParam(name = "id") int id) {
		try {
			GetTitle(model, "Thông tin quyền", funtionTitle);
			CtxUser user = getCtxUser();
			Role roles = RoleMgr().getRoleAll(id);

			model.addAttribute("user", user);
			model.addAttribute("roleDisplay", new RoleDisplay(roles));
			return "roleDetail";

		} catch (Exception e) {
			model.addAttribute("message", e);
			return "403Page";
		}
	}

	@Transactional
	@RequestMapping(value = "/SaveRole", method = RequestMethod.POST)
	public ResponseEntity<Object> saveRolePage(Model model, @RequestBody RoleDisplay role) throws Exception {
		try {
			// funtionTitle.put("edit", "UpdateUser");
			Role currRole = RoleMgr().getRoleAll(role.getId());

			if (currRole == null) {
				currRole = new Role();
			}

			currRole.setName(role.getName());
			currRole.setPermisssion(role.getPermisssion());

			RoleMgr().persist(currRole);

			return new ResponseEntity<>("Thêm thành công", HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}

	@RequestMapping(value = "/UsersDetail", method = RequestMethod.GET)
	public String viewUserDetail(Model model, @RequestParam(name = "code", defaultValue = "") String code) {
		try {
			// funtionTitle.put("edit", "UpdateUser");
			GetTitle(model, "Thông Tin Người Dùng", funtionTitle);

			CtxUser user = getCtxUser();
			User currUser = UserMgr().findUserAccount(code);
			if (currUser.getCode() == null) {
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

	@Transactional
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUserPage(Model model, @ModelAttribute("UserDisplay") UserDisplay user,
			@RequestParam("fileAvatar") MultipartFile file) {
		try {
			funtionTitle.put("edit", "UpdateUser");
			GetTitle(model, "Lưu  Người Dùng", funtionTitle);
			// CtxUser ctxUser = getCtxUser();
			User nv = UserMgr().findUserAccount(user.getCode());
			String urlTo = "";
			if (nv.getCode() == null) {
				nv = new User();
				nv.setCode(user.getCode());
				nv.setPassword(EncrytedPasswordUtils.encrytePassword("123"));
				urlTo = "redirect:/admin/UsersList";
			} else {
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
	public String deletUser(Model model, @RequestParam(name = "code", defaultValue = "") String code) throws Exception {
		try {
			// CtxUser user = getCtxUser();
			User currUser = UserMgr().findUserAccount(code);
			if (currUser.getCode() == null) {
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

	@RequestMapping(value = "/deleteUsers", method = RequestMethod.POST)
	public String deletUserlst(Model model, @RequestParam(name = "codesDel[]", required = false) List<String> codes,
			HttpServletResponse resp) throws Exception {
		try {

			if (codes == null || codes.size() == 0) {
				resp.sendError(HttpServletResponse.SC_OK, "Không tìm thấy người dùng ");
				return "403Page";
			}
			List<User> users = UserMgr().getAllByCode(codes);

			for (User user : users) {
				user.setDeleteflag(1);
				UserMgr().persist(user);
			}
			resp.sendError(HttpServletResponse.SC_OK, "Xoa Thanh cong" + String.join(",", codes));
			return "403Page";
		} catch (Exception e) {
			resp.sendError(HttpServletResponse.SC_FORBIDDEN, e.toString());
			throw e;
		}
	}
}

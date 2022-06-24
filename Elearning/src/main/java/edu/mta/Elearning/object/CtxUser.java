package edu.mta.Elearning.object;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import edu.mta.Elearning.entity.DbRole;
import edu.mta.Elearning.entity.DbUser;
@SuppressWarnings("serial")
public class CtxUser extends User implements BaseUser{

	private int role;
	private String name;
	private String email;
	private String imgurl;

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	private DbUser userObject;
	
	public CtxUser(DbUser dbUser,DbRole dbRole) {
		super(dbUser.getCode(), dbUser.getPassword(), (dbUser.getStatus()==0), true, true, true, createAuthority(dbUser,dbRole));
		setUser(dbUser);
	}

	public DbUser getUserObject() {
		return userObject;
	}

	public void setUserObject(DbUser userObject) {
		this.userObject = userObject;
	}

	public static List<GrantedAuthority> createAuthority(DbUser dbNhanVien,DbRole dbRole) {
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + dbRole.getName().toString());
		grantList.add(authority);
		return grantList;
	}
	
	

	public void setUser(DbUser user) {
		userObject = user;
		setEmail(user.getEmail());
		setRole(user.getRoleId());
		setName(user.getName());
		setImgurl(user.getImgurl());
	}
	
	public String getAvatarImagePath() {
		if(imgurl==null||getUsername() ==null) return null;
		return "/Upload/Avatar/"+getUsername()+"/"+imgurl;
	}
}

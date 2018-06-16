package tk.mybatis.simple.model;

import java.util.Date;

/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: tk.mybatis.simple.model 
 * @author: createdByliuyx 
 * @date: 2018年5月31日 上午10:21:52 
 */
public class SysRole {
	
	private Long id;
	private String roleName;
	private int enabled;
	private Long createdBy;
	private Date createdTime;
	private SysUser user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	
	public SysUser getUser() {
		return user;
	}
	public void setUser(SysUser user) {
		this.user = user;
	}
	
	public String toString1() {
		return "SysRole [id=" + id + ", roleName=" + roleName + ", enabled=" + enabled + ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + "]";
	}
	
	public String toString2() {
		return "SysRole [id=" + id + ", roleName=" + roleName + ", enabled=" + enabled + ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + ", userName=" + user.getUserName() + ", userEmail=" + user.getUserEmail() +"]";
	}
	
	

}

package tk.mybatis.simple.model;
/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: tk.mybatis.simple.model 
 * @author: createdByliuyx 
 * @date: 2018年5月31日 上午10:22:22 
 */
public class SysRolePrivilege {
	private Long roleId;
	private Long privilegeId;
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}
	
	
	
}

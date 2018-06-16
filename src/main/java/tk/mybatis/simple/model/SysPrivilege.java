package tk.mybatis.simple.model;
/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: tk.mybatis.simple.model 
 * @author: createdByliuyx 
 * @date: 2018年5月31日 上午10:22:12 
 */
public class SysPrivilege {

	private Long id;
	private String privilegeName;
	private String privilegeUrl;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrivilegeName() {
		return privilegeName;
	}
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	public String getPrivilegeUrl() {
		return privilegeUrl;
	}
	public void setPrivilegeUrl(String privilegeUrl) {
		this.privilegeUrl = privilegeUrl;
	}
	
	
}

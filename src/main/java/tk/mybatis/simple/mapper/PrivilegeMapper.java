package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.SelectProvider;

import tk.mybatis.simple.model.SysPrivilege;
import tk.mybatis.simple.provider.PrivilegeProvider;

/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: tk.mybatis.simple.mapper 
 * @author: createdByliuyx 
 * @date: 2018年5月31日 上午10:40:53 
 */
public interface PrivilegeMapper {

	@SelectProvider(type=PrivilegeProvider.class,method="selectById")
	SysPrivilege selectById(Long id);
}

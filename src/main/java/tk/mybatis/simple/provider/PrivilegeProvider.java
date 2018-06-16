package tk.mybatis.simple.provider;

import org.apache.ibatis.jdbc.SQL;

/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: tk.mybatis.simple.provider 
 * @author: createdByliuyx 
 * @date: 2018年6月1日 下午1:38:57 
 */
public class PrivilegeProvider {

	public String selectById(final Long id){
		return new SQL(){
			{
				SELECT("id,privilege_name,privilege_url");
				FROM("sys_privilege");
				WHERE("id = #{id}");
			}
		}.toString();
	}
}

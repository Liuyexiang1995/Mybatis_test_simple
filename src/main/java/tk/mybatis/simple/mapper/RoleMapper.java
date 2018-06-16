package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import tk.mybatis.simple.model.SysRole;

/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: tk.mybatis.simple.mapper 
 * @author: createdByliuyx 
 * @date: 2018年5月31日 上午10:39:20 
 */
public interface RoleMapper {
	
	@Select({
		"select id,role_name roleName,enabled,create_by createdBy,create_time createdTime",
		"from sys_role",
		"where id = #{id}"
	})
	SysRole selectById(Long id);
	
	@Select({
		"select id,role_name,enabled,create_by,create_time",
		"from sys_role",
		"where id = #{id}"
	})
	SysRole selectById2(Long id);
	
	@Select({
		"select id,role_name roleName,enabled,create_by createdBy,create_time createdTime",
		"from sys_role",
		"where id = #{id} and create_by = #{createdBy}"
	})
	SysRole selectByExample(SysRole role);
	
	@Select({
		"select *",
		"from sys_role",
	})
	List<SysRole> selectAll();
	
	@Results({
		@Result(property="id",column="id",id=true),
		@Result(property="roleName",column="id"),
		@Result(property="enabled",column="enabled"),
		@Result(property="createdBy",column="create_by"),
		@Result(property="createdTime",column="create_time")
	})
	@Select({
		"select id,role_name,enabled,create_by,create_time",
		"from sys_role",
		"where id = #{id}"
	})
	SysRole selectById3(Long id);
	
	//设置@Results(id="");对应xml中的resultMap
	//使用@resultMap需要mybatis3.3.1及其以上版本;对应xml中的resultType
/*	@Results(id="roleResultMap",value={
		@Result(property="id",column="id",id=true),
		@Result(property="roleName",column="id"),
		@Result(property="enabled",column="enabled"),
		@Result(property="createdBy",column="create_by"),
		@Result(property="createdTime",column="create_time")
		//其他
	})
	@ResultMap("roleResultMap")
	@Select("select * from sys_role")
	List<SysRole> selectAll2();*/
	
	/**
	 * 不返回主键
	 * @param role
	 * @return
	 */
	@Insert({
		"insert into sys_role(id,role_name,enabled,create_by,create_time)",
		"values(#{id},#{roleName},#{enabled},#{createdBy},#{createdTime,jdbcType=TIMESTAMP})"
	})
	int insert(SysRole role);
	
	/**
	 * 返回自增主键
	 * @param role
	 * @return
	 */
	@Insert({
		"insert into sys_role(role_name,enabled,create_by,create_time)",
		"values(#{roleName},#{enabled},#{createdBy},#{createdTime,jdbcType=TIMESTAMP})"
	})
	@Options(useGeneratedKeys=true,keyProperty="id")
	int insert2(SysRole role);
	
	
	/**
	 * statement:从数据库获取的自增主键/序列
	 * DB2:values identity_val_local()
	 * Mysql:select last_index_id()
	 * SqlServer:select scope_identity()
	 * CloudScape:values identity_val_local()
	 * Derby:values identity_val_local()
	 * HSqlDB:call identity()
	 * SyBase:select @@identity
	 * DB2_MF:select identity_val_local() from sysibm.sysdummy1
	 * InforMax:select dbinfo('sqlca.sqlerrd1') from systables where tabid=1
	 * @param role
	 * @return
	 */
	@Insert({
		"insert into sys_role(role_name,enabled,create_by,create_time)",
		"values(#{roleName},#{enabled},#{createdBy},#{createdTime,jdbcType=TIMESTAMP})"
	})
	@SelectKey(
			statement="select last_insert_id()",
			keyProperty="id",
			resultType=Long.class,
			before=false
	)
	int insert3(SysRole role);
	
	@Update({
		"update sys_role",
		"set role_name = #{roleName},enabled = #{enabled},create_by = #{createdBy},create_time = #{createdTime,jdbcType=TIMESTAMP}",
		"where id = #{id}"
	})
	int updateById(SysRole role);
	
	@Delete({
		"delete from sys_role",
		"where role_name = #{roleName} and enabled = #{param2}"
	})
	int deleteById(@Param("roleName")String roleName,int enabled);
}

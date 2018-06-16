package tk.mybatis.simple.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import junit.framework.Assert;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: tk.mybatis.simple.mapper 
 * @author: createdByliuyx 
 * @date: 2018年6月1日 上午9:35:31 
 */
public class RoleMapperTestEx extends BaseMapperTest{

	@Test
	public void  testSelectById(){
		
		SqlSession sqlSession=getSqlSession();
		try {
			RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
			SysRole role = roleMapper.selectById(1l);
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
	
	@Test
	public void  testSelectByExample(){
		
		SqlSession sqlSession=getSqlSession();
		try {
			RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
			SysRole example=new SysRole();
			example.setId(2l);
			example.setCreatedBy(1l);
			SysRole role = roleMapper.selectByExample(example);
			System.out.println(role.getRoleName());
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
	
	@Test
	public void  testSelectAll(){
		
		SqlSession sqlSession=getSqlSession();
		try {
			RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
			List<SysRole> roleList = roleMapper.selectAll();
			for(SysRole role:roleList){
				System.out.println(role.getRoleName());
			}
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}

	@Test
	public void  testSelectById3(){
		
		SqlSession sqlSession=getSqlSession();
		try {
			RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
			SysRole role = roleMapper.selectById3(1l);
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
	
	
	@Test
	public void  insert(){
		
		SqlSession sqlSession=getSqlSession();
		try {
			RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
			SysRole role=new SysRole();
			role.setRoleName("小猪佩奇");
			role.setEnabled(1);
			role.setCreatedBy(1l);
			role.setCreatedTime(new Date());
			int result=roleMapper.insert(role);
			System.out.println(role.getId());
			int result2=roleMapper.insert2(role);
			System.out.println(role.getId());
			int result3=roleMapper.insert3(role);
			System.out.println(role.getId());
		} finally {
			// TODO: handle finally clause
			//为了不影响其他操作，设置为回滚，数据库自增长序列仍在进行，
			//默认的sqlSessionFactory.openSession()是不自动提交的
			//不手动执行commit就不会提交到数据库中
			//sqlSession.rollback();
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	@Test
	public void updateById(){
		SqlSession sqlSession=getSqlSession();
		
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole role = roleMapper.selectById(11l);
			role.setRoleName("test");
			int result = roleMapper.updateById(role);
		} finally {
			// TODO: handle finally clause
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	@Test
	public void deleteById(){
		SqlSession sqlSession=getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			int result = roleMapper.deleteById("小猪佩奇",1);
		} finally {
			// TODO: handle finally clause
			sqlSession.commit();
			sqlSession.close();
		}
	}
}

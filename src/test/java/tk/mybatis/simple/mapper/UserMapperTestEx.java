package tk.mybatis.simple.mapper;

import java.lang.reflect.Proxy;
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
 * @date: 2018年5月31日 下午4:24:04 
 */
public class UserMapperTestEx extends BaseMapperTest{
	
	@Test
	public void  testSelectById(){
		
		SqlSession sqlSession=getSqlSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectById(1l);
			printCountryList(user);
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}

	private void printCountryList(SysUser user){
			System.out.printf("%-4d%4s%4s\n",
					user.getId(),
					user.getUserEmail(),
					user.getUserPassword(),
					user.getUserEmail(),
					user.getUserInfo(),
					user.getHeadImg(),
					user.getCreateTime()
					);
	}

	@Test
	public void  selectById(){
		
		SqlSession sqlSession=getSqlSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectById(1l);
			Assert.assertNotNull(user);
			Assert.assertEquals("admin", user.getUserName());
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
	
	@Test
	public void  selectByAll(){
		
		SqlSession sqlSession=getSqlSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			List<SysUser> userList = userMapper.selectAll();
			Assert.assertNotNull(userList);
			Assert.assertTrue(userList.size()>0);
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
	
	@Test
	public void  selectRolesByUserId1(){
		
		SqlSession sqlSession=getSqlSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			List<SysRole> roleList = userMapper.selectRolesByUserId1(1l);
			Assert.assertNotNull(roleList);
			for(SysRole role:roleList){
				System.out.println(role.toString1());
			}
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
	
	@Test
	public void  selectRolesByUserId2(){
		
		SqlSession sqlSession=getSqlSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			List<SysRole> roleList = userMapper.selectRolesByUserId2(1l);
			for(SysRole role:roleList){
				System.out.println(role.toString2());
			}
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
	
	@Test
	public void  insert(){
		
		SqlSession sqlSession=getSqlSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			SysUser user=new SysUser();
			user.setUserName("liuyx");
			user.setUserPassword("eazytec@123");
			user.setUserEmail("liuyexiang@byosoft.com.cn");
			user.setUserInfo("liuyx info");
			user.setHeadImg(new byte[]{1,2,3,4,5,6,7,8,9,0});
			user.setCreateTime(new Date());
			int result=userMapper.insert(user);
			Assert.assertEquals(1, result);
			Assert.assertNull(user.getId());
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
	public void  insert2(){
		
		SqlSession sqlSession=getSqlSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			SysUser user=new SysUser();
			user.setUserName("liuyx");
			user.setUserPassword("eazytec@123");
			user.setUserEmail("liuyexiang@byosoft.com.cn");
			user.setUserInfo("liuyx info");
			user.setHeadImg(new byte[]{1,2,3,4,5,6,7,8,9,0});
			user.setCreateTime(new Date());
			int result=userMapper.insert2(user);
			Assert.assertEquals(1, result);
			Assert.assertNotNull(user.getId());
		} finally {
			// TODO: handle finally clause
			//sqlSession.rollback();
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	@Test
	public void update(){
		SqlSession sqlSession=getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectById(1001l);
			System.out.println("获取id为1001的用户userName,更新前为：" + user.getUserName());
			user.setUserName("test" + new Date().toString());
			user.setUserEmail("test@byosoft.com.cn");
			int result = userMapper.updateById(user);
			user = userMapper.selectById(user.getId());
			System.out.println("获取id为1001的用户userName为，更新后为：" + user.getUserName());
		} finally {
			// TODO: handle finally clause
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	@Test
	public void delete(){
		SqlSession sqlSession=getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//int result = userMapper.deleteById(1003l);
			int result2=userMapper.deleteByUser(userMapper.selectById(1004l));
		} finally {
			// TODO: handle finally clause
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	/**
	 * 多参数sql
	 */
	@Test
	public void  selectRolesByUserIdAndRoleEnabled(){
		
		SqlSession sqlSession=getSqlSession();
		try {
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			List<SysRole> roleList = userMapper.selectRolesByUserIdAndRoleEnabled(1l, 1,"admin","test");
			for(SysRole role:roleList){
				System.out.println(role.toString1());
			}
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
	
	/**
	 * 简单实现动态代理
	 */
	@Test
	public void testProxy(){
		SqlSession sqlSession=getSqlSession();
		MyMapperProxy userMapperProxy=new MyMapperProxy(UserMapper.class, sqlSession);
		UserMapper userMapper=(UserMapper) Proxy.newProxyInstance(
				Thread.currentThread().getContextClassLoader(),
				new Class[] {UserMapper.class},
				userMapperProxy
		);
		System.out.println("testProxy");
		List<SysUser> user=userMapper.selectAll();
	}
}

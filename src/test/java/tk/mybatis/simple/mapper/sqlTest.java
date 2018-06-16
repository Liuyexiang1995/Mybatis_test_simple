package tk.mybatis.simple.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.javassist.compiler.ast.Symbol;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.SysUser;
/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: tk.mybatis.simple.mapper 
 * @author: createdByliuyx 
 * @date: 2018年6月1日 下午1:57:20 
 */
public class sqlTest extends BaseMapperTest{

	@Test
	public void selectByExample(){
		SqlSession sqlSession=getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user1 = new SysUser();
			user1.setUserName("liuyx1");
			List<SysUser> userList1 = userMapper.selectByUser(user1);
			System.out.println(userList1.size());
			
			SysUser user2 = new SysUser();
			user2.setUserEmail("liuyexiang@byosoft.com.cn");
			List<SysUser> userList2 = userMapper.selectByUser(user2);
			System.out.println(userList2.size());
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
	
	/**
	 * 以集合来查结果集
	 * collection:list
	 */
	@Test
	public void selectByIdList(){
		SqlSession sqlSession=getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<Long> idList=new ArrayList<>();
			idList.add(1l);
			idList.add(2l);
			idList.add(1005l);
			idList.add(1007l);
			List<SysUser> userList1 = userMapper.selectByIdList(idList);
			System.out.println(userList1.size());
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
	
	/**
	 * 以数组来查结果集
	 * collection:array
	 */
	@Test
	public void selectByIdArray(){
		SqlSession sqlSession=getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			Long[] idArray={1l,2l,1001l,1005l};
			List<SysUser> userList1 = userMapper.selectByIdArray(idArray);
			System.out.println(userList1.size());
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
	
	/**
	 * 以map对象来查询结果集合
	 * xml中collection可以选择遍历对象：
	 * ①选的key值，则遍历对应的value值，此时map.get(key)必须为可遍历对象
	 * ②使用注解@Param指定collection值/使用默认值_parameter,
	 * 	循环map，取出所有的value值(这里把map当做list/array来用，key值没有意义)
	 */
	@Test
	public void selectByMap(){
		SqlSession sqlSession=getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			Map<String, Object> map=new HashMap<String,Object>();
			Long[] idArray={1l,1001l,1002l,1005l};
			map.put("id", idArray);
			map.put("userName", "liuyx");
			List<SysUser> userList1 = userMapper.selectByMap(map);
			System.out.println(userList1.size());
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
	
	@Test
	public void insertList(){
		SqlSession sqlSession=getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> userList=new ArrayList<SysUser>();
			for(int i=0;i<3;i++){
				SysUser user=new SysUser();
				user.setUserName("byo"+i);
				user.setUserEmail("byosoft"+i+"@test.com.cn");
				userList.add(user);
			}
			int result = userMapper.insertList(userList);
			System.out.println(1);
		} finally {
			// TODO: handle finally clause
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	@Test
	public void updateByMap(){
		SqlSession sqlSession=getSqlSession();
		
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("id", 1103l);
			map.put("user_password", null);
			map.put("user_email", "test@mybatis.tk");
			userMapper.updateByMap(map);
		} finally {
			// TODO: handle finally clause
			sqlSession.commit();
			sqlSession.close();
		}
	}
}

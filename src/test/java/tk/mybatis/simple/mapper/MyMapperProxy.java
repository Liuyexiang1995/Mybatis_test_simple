package tk.mybatis.simple.mapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: tk.mybatis.simple.mapper 
 * @author: createdByliuyx 
 * @date: 2018年5月31日 下午9:14:14 
 */
public class MyMapperProxy<T> implements  InvocationHandler{
	
	private Class<T> mappeInterface;
	private SqlSession sqlSession;

	public MyMapperProxy(Class<T> mappeInterface,SqlSession sqlSession) {
		// TODO Auto-generated constructor stub
		this.mappeInterface=mappeInterface;
		this.sqlSession=sqlSession;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		//针对不同的sql类型，需要调用sqlSession不同的方法
		//接口方法中的参数也有很多情况，这里只考虑没有参数的情况
		
		List<T> list=sqlSession.selectList(mappeInterface.getCanonicalName()+"."+method.getName());
		return list;
	}
	
}

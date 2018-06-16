package tk.mybatis.simple.mapper;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: tk.mybatis.simple.mapper 
 * @author: createdByliuyx 
 * @date: 2018年5月31日 下午1:33:42 
 */
public class BaseMapperTest {
	
	private static SqlSessionFactory sqlSessionFactory;
	@BeforeClass
	public static void init(){
		try{
			Reader reader=Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch(IOException ignore){
			ignore.printStackTrace();
		}
	}
	
	public SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}

}

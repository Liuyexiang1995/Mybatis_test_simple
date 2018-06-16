package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.Country;

/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: tk.mybatis.simple.mapper 
 * @author: createdByliuyx 
 * @date: 2018年5月31日 下午1:38:58 
 */
public class CountryMapperTestEx extends BaseMapperTest{
	
	@Test
	public void testSelectAll(){
		SqlSession sqlSession=getSqlSession();
		
		try {
			List<Country> countryList = sqlSession.selectList("tk.mybatis.simple.mapper.CountryMapper.selectAll");
			printCountryList(countryList);
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}

	private void printCountryList(List<Country> countryList){
		for(Country country:countryList){
			System.out.printf("%-4d%4s%4s\n",
					country.getId(),
					country.getCountryname(),
					country.getCountrycode()
			);
		}
	}
}

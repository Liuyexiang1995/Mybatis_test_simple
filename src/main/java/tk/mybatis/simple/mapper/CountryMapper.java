package tk.mybatis.simple.mapper;

import java.util.List;

import tk.mybatis.simple.model.Country;

/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: tk.mybatis.simple.mapper 
 * @author: createdByliuyx 
 * @date: 2018年5月31日 下午1:44:13 
 */
public interface CountryMapper {

	
	List<Country> selectAll();
}

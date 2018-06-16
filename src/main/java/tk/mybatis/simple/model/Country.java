package tk.mybatis.simple.model;
/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: tk.mybatis.simple.model 
 * @author: createdByliuyx 
 * @date: 2018年5月30日 下午4:41:25 
 */
public class Country {

	private Long id;
	private String countryname;
	private String countrycode;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
}

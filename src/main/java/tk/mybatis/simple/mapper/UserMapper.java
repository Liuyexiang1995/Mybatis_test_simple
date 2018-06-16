package tk.mybatis.simple.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

/**   
 * Copyright © 2018 eazytec.com(卓易科技) All rights reserved.
 * 
 * @Package: tk.mybatis.simple.mapper 
 * @author: createdByliuyx 
 * @date: 2018年5月31日 上午10:39:11 
 */
public interface UserMapper {

	/**
	 * 通过id查询用户
	 * @param id
	 * @return
	 */
	SysUser selectById(Long id);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	List<SysUser> selectAll();
	
	/**
	 * 根据用户id获取角色对象集合
	 * @param userId
	 * @return
	 */
	List<SysRole> selectRolesByUserId1(Long userId);
	
	/**
	 * 根据用户id获取角色对象集合，
	 * 还需要其他属性，如用户的一些基本信息，放入role属性为user对象中
	 * xml中手动映射查询结果的列名——实体类属性
	 * @param userId
	 * @return
	 */
	List<SysRole> selectRolesByUserId2(Long userId);
	
	/**
	 * 插入一条用户数据
	 * @param user
	 * @return
	 */
	int insert(SysUser user);
	
	/**
	 * 插入一条用户数据
	 * 并且返回自增主键值，这里需要数据库自己有主键自增功能
	 * mysql插入再返回主键值
	 * @param user
	 * @return
	 */
	int insert2(SysUser user);
	
	/**
	 * 插入一条用户数据
	 * 并且返回自增主键值，这里通过selectKey方法
	 * 如oracle没有主键自增功能，先通过序列中获取值，再插入
	 * 各数据库selectKey获取方式不同
	 * @param user
	 * @return
	 */
	int insert3(SysUser user);
	
	/**
	 * 根据id更新这条数据
	 * ①先取id值对应的数据对象
	 * ②再set需要更新的属性
	 * ③通过xml映射关系，执行update语句
	 * @param user
	 * @return
	 */
	int updateById(SysUser user);
	
	/**
	 * 删除id对应这条数据
	 * @param id
	 * @return
	 */
	int deleteById(Long id);
	
	/**
	 * 删除id对应这条数据
	 * @param id
	 * @return
	 */
	int deleteByUser(SysUser user);
	
	/**
	 * 根据用户id和角色的enabled状态获取用户的角色结果集合
	 * 单一参数，不需要考虑其他
	 * 多参数，xml不能自动对应，需要加注解
	 * 
	 * xml：参数N个
	 * xml：参数列表为{未加注解的参数所在数组的索引值,已经加注解的参数的名字,param1,param2,param3,...,param(N-1),param(N)
	 * 如xml需要取 #{userCode}的参数，接口参数列表中没有注解;
	 * 
	 * ①此处4个参数，前面3个都有注解，而第4个没有，则标出在参数列表数组索引值中的3(N个参数的索引值为0-【N-1】)
	 * 	第2个参数没加注解，则标出为1； [1, param1, param2, param3, param4, userId, userName]
	 *  第1个，第3个，第4个 没有注解，则标出0，2，3 [3, 2, enabled, 0, param1, param2, param3, param4] 
	 * ②已加参数名注解的 userId,userName,enabled
	 * ③所有参数，假设有N个，param1...param(N)
	 * [3, enabled, param1, param2, param3, param4, userId, userName]
	 * 
	 * 参数列表自动被封装成Map类型，key来映射xml中sql需要使用的参数值名字，value原来存放参数值
	 * @param id
	 * @param enabled
	 * @return
	 */
	List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId")Long userId,@Param("enabled")Integer enabled,@Param("userName")String userName,String bb);
	
	List<SysUser> selectByUser(SysUser user);
	
	/**
	 * 根据用户id集合来获取用户对象集合
	 * @param idList
	 * @return
	 */
	List<SysUser> selectByIdList(List<Long> idList);
	
	/**
	 * 根据用户id数组来获取用户对象集合
	 * @param idList
	 * @return
	 */
	List<SysUser> selectByIdArray(Long[] idArray);
	
	/**
	 * 传入参数为map对象
	 * @param mapObject
	 * @return
	 */
	List<SysUser> selectByMap(Map<String,Object> mapObject);
	
	int insertList(List<SysUser> userList);
	
	int updateByMap(Map<String,Object> map);
}

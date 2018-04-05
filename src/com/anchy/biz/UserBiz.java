package com.anchy.biz;

import java.text.ParseException;
import java.util.List;

import com.anchy.po.User;

public interface UserBiz {
	//根据nickname得到userid
	public int getUIdbynickname(String nickname);
	//根据phone得到uid
	public int getUIdByPhone(String phone);
	//根据Email得到uid
	public int getUIdByEmail(String email);
	//根据id得到user
	public User getUserById(int uid);
	//添加user
	public void addUser(String truename,String nickname,String email,String password,String phone,int flag,int gender,int status,String validateCode,String registerTime);
	//修改注册status
	public void chgStatus(int uid,int status);
	public User getUserByGoods(int gid);
	//修改普通用户信息
	public void changeUserInfo(int uid,String truename,String nickname,String email,String phone,int gender);
	//得到所有用户
	public List<User> getAllUser(int pageNum,int pageSize);
	//用户个数
	public int cUser();
	//修改密码
	public void changPassword(int uid,String new1,String new2);
	
}

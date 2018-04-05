package com.anchy.biz.impl;

import java.text.ParseException;
import java.util.List;

import com.anchy.biz.UserBiz;
import com.anchy.dao.UserDao;
import com.anchy.dao.impl.UserDaoImpl;
import com.anchy.po.User;

public class UserBizImpl implements UserBiz {

	UserDao userDao=new UserDaoImpl();
	@Override
	public int getUIdbynickname(String nickname) {
		// TODO Auto-generated method stub
		return userDao.getUIdbynickname(nickname);
	}
	//根据phone得到uid
	public int getUIdByPhone(String phone){
		return userDao.getUIdByPhone(phone);
	}
	//根据Email得到uid
	public int getUIdByEmail(String email){
		return userDao.getUIdByEmail(email);
	}
	@Override
	public User getUserById(int uid){
		// TODO Auto-generated method stub
		return userDao.getUserById(uid);
	}

	@Override
	public void addUser(String truename, String nickname, String email,
			String password, String phone, int flag, int gender,int status,String validateCode,String registerTime) {
		// TODO Auto-generated method stub
		userDao.addUser(truename, nickname, email, password, phone, flag, gender, status, validateCode, registerTime);

	}

	@Override
	public void changeUserInfo(int uid,String truename,String nickname, String email,
			String phone, int gender) {
		// TODO Auto-generated method stub
		userDao.changeUserInfo(uid, truename, nickname, email, phone, gender);
	}

	@Override
	public List<User> getAllUser(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return userDao.getAllUser(pageNum, pageSize);
	}
	@Override
	public User getUserByGoods(int gid) {
		// TODO Auto-generated method stub
		return userDao.getUserByGoods(gid);
	}
	@Override
	public void changPassword(int uid, String new1, String new2) {
		// TODO Auto-generated method stub
		userDao.changPassword(uid, new1, new2);
	}
	@Override
	public void chgStatus(int uid, int status) {
		// TODO Auto-generated method stub
		userDao.chgStatus(uid, status);
	}
	@Override
	public int cUser() {
		// TODO Auto-generated method stub
		return userDao.cUser();
	}

}

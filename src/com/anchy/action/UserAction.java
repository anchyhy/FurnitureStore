package com.anchy.action;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

























import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anchy.Exception.ServiceException;
import com.anchy.biz.CartBiz;
import com.anchy.biz.ComBiz;
import com.anchy.biz.GoodsBiz;
import com.anchy.biz.OrderBiz;
import com.anchy.biz.SellerBiz;
import com.anchy.biz.UserBiz;
import com.anchy.biz.impl.CartBizImpl;
import com.anchy.biz.impl.ComBizImpl;
import com.anchy.biz.impl.GoodsBizImpl;
import com.anchy.biz.impl.OrderBizImpl;
import com.anchy.biz.impl.SellerBizImpl;
import com.anchy.biz.impl.UserBizImpl;
import com.anchy.po.MD5Util;
import com.anchy.po.User;
import com.anchy.util.SendEmail;
import com.opensymphony.xwork2.ActionContext;

public class UserAction {
	private int uid;
	private int gid;
	private String truename;
	private String nickname;
	private String password;
	private String repassword;
	private String old;
	private String new1;
	private String new2;
	private String email;
	private String phone;
	private int flag;//判断类型（1：买主2：卖主3：管理员）
	private int gender;
	private String loginname;
	private int pageNum;
	private int pageSize;
	private int status;//激活状态  
    private String validateCode;//激活码  
    private Date  registerTime;//注册时间  
    private String action;
    private int loginflag;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
	public String getNew1() {
		return new1;
	}
	public void setNew1(String new1) {
		this.new1 = new1;
	}
	public String getNew2() {
		return new2;
	}
	public void setNew2(String new2) {
		this.new2 = new2;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String indexToLogin(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		session.remove("showMessage");
		return "indextologin";
	}
	public String loginToAccount(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		session.remove("showMessage");
		return "logintoaccount";
	}
	public String loginToForgetpass(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		session.remove("showMessage");
		return "logintoforgetpass";
	}
	public int getLoginflag() {
		return loginflag;
	}
	public void setLoginflag(int loginflag) {
		this.loginflag = loginflag;
	}
	//登录
	public String login()throws UnsupportedEncodingException, ParseException{
		Map<String, Object> session=ActionContext.getContext().getSession();
		UserBiz userBiz=new UserBizImpl();
		SellerBiz sellerBiz=new SellerBizImpl();
		System.out.println(loginname+password);
		this.nickname = new String(loginname.getBytes("ISO-8859-1"), "UTF-8");
		this.phone = new String(loginname.getBytes("ISO-8859-1"), "UTF-8");
		this.email = new String(loginname.getBytes("ISO-8859-1"), "UTF-8");
		this.password = new String(password.getBytes("ISO-8859-1"), "UTF-8");
		if(loginname!=null&&password!=null){
			int uid1=userBiz.getUIdbynickname(nickname);
			int uid2=userBiz.getUIdByPhone(phone);
			int uid3=userBiz.getUIdByEmail(email);
			if(uid1>0&&userBiz.getUserById(uid1).getStatus()==1){
				//该用户正在通过nickname登录
				System.out.println(1);
				uid=uid1;
				User user=userBiz.getUserById(uid);
				if(user.getPassword().equals(password)){
				session.put("user", user);
				CartBiz cartBiz=new CartBizImpl();
				session.put("ccount",cartBiz.cCount(user.getuid()));
				session.put("csum", cartBiz.cSum(user.getuid()));
				if(user.getFlag()<3) {
					session.remove("showMessage");
					if(loginflag==1)
						return "logincontact";
					if(loginflag==2)
						return "logincollect";
					if(loginflag==3)
						return "loginorder";
					if(loginflag==4)
						return "loginaddress";
					if(loginflag==5)
						return "logincart";
					if(loginflag==6)
						return "logingoods";
					return "logintrue1";
				}
				else {
					session.put("cseller", sellerBiz.cSeller());
					ComBiz comBiz=new ComBizImpl();
					session.put("acsum", comBiz.getCom().size());
					OrderBiz orderBiz=new OrderBizImpl();
					session.put("aosum", orderBiz.showAOrder().size());
					GoodsBiz goodsBiz=new GoodsBizImpl();
					session.put("agsum", goodsBiz.checkGoods().size());
					session.remove("showMessage");
					return "logintrue2";
				}
			}
			session.put("showMessage", "<script type='text/javascript'> alert('您输入的密码不正确，请重新登录!')</script>");
			return "loginfalse";
			}
			System.out.println(2);
			if(uid2>0&&userBiz.getUserById(uid2).getStatus()==1){
				//该用户正在通过phone登录
				uid=uid2;
				User user=userBiz.getUserById(uid);
				if(user.getPassword().equals(password)){
				session.put("user", user);
				CartBiz cartBiz=new CartBizImpl();
				session.put("ccount",cartBiz.cCount(user.getuid()));
				session.put("csum", cartBiz.cSum(user.getuid()));
				session.put("loginname", phone);
				session.put("password", password);
				if(user.getFlag()<3) {
					session.remove("showMessage");
					if(loginflag==1)
						return "logincontact";
					if(loginflag==2)
						return "logincollect";
					if(loginflag==3)
						return "loginorder";
					if(loginflag==4)
						return "loginaddress";
					if(loginflag==5)
						return "logincart";
					if(loginflag==6)
						return "logingoods";
					return "logintrue1";
				}
				else {
					session.remove("showMessage");
					return "logintrue2";
				}
			}
			session.put("showMessage", "<script type='text/javascript'> alert('您输入的密码不正确，请重新登录!')</script>");
			return "loginfalse";
			}
			if(uid3>0&&userBiz.getUserById(uid3).getStatus()==1){
				//该用户正在通过email登录
				uid=uid3;
				User user=userBiz.getUserById(uid);
				if(user.getPassword().equals(password)){
				session.put("user", user);
				CartBiz cartBiz=new CartBizImpl();
				session.put("ccount",cartBiz.cCount(user.getuid()));
				session.put("csum", cartBiz.cSum(user.getuid()));
				session.put("loginname", email);
				session.put("password", password);
				if(user.getFlag()<3) {
					session.remove("showMessage");
					if(loginflag==1)
						return "logincontact";
					if(loginflag==2)
						return "logincollect";
					if(loginflag==3)
						return "loginorder";
					if(loginflag==4)
						return "loginaddress";
					if(loginflag==5)
						return "logincart";
					if(loginflag==6)
						return "logingoods";
					return "logintrue1";
				}
				else {
					session.remove("showMessage");
					return "logintrue2";
				}
			}
			session.put("showMessage", "<script type='text/javascript'> alert('您输入的密码不正确，请重新登录!')</script>");
			return "loginfalse";
			}
		}
		session.put("showMessage", "<script type='text/javascript'> alert('您输入的账号不存在，请重新登录!')</script>");
		return "loginfalse";
	}
	//注册
	public String regist() throws Exception{
		System.out.println("lalal");
		Map<String, Object> session=ActionContext.getContext().getSession();
		UserBiz userBiz=new UserBizImpl();
		//验证该昵称、手机号码、邮箱是否已被注册
		int uid1=userBiz.getUIdbynickname(nickname);
		int uid2=userBiz.getUIdByPhone(phone);
		int uid3=userBiz.getUIdByEmail(email);
		if(uid1>0){
			session.put("showMessage", "<script type='text/javascript'> alert('您注册的昵称已存在，请直接登录')</script>");
			return "registfalse";
		}
		if(uid2>0){
			session.put("showMessage", "<script type='text/javascript'> alert('您注册的手机号已存在，请直接登录')</script>");
			return "registfalse";
		}
		if(uid3>0){
			return "registfalse";
		}
		if(!password.equals(repassword)){
			session.put("showMessage", "<script type='text/javascript'> alert('两次输入的密码不一致')</script>");
			return "registfalse";
		}
		//暂时保存user
		userBiz.addUser(truename, nickname, email, password, phone, 1, gender, 0, MD5Util.MD5(email), new Date().toString());
        System.out.println("要执行发邮件的步骤了"+action);
        this.processregister();//发邮箱激活 
        return "regist";
	}
	public String activate(){
		try {  
        	System.out.println("要执行激活的步骤了"+action);
            processActivate();//调用激活方法 
            Map<String, Object> session=ActionContext.getContext().getSession();
            return "activate";
        } catch (ServiceException e) {  
            return "activatefalse";
        } 
	}
	 public void processregister() throws Exception{  
		///邮件的内容  
		 System.out.println(email+MD5Util.MD5(email));
	        StringBuffer sb=new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！");  
	        sb.append("");  
	        sb.append(email);   
	        sb.append("&validateCode=");   
	        sb.append(MD5Util.MD5(email));  
	        sb.append("\">http://localhost:8080/furniturestore/activate?email=");   
	        sb.append(email);  
	        sb.append("&validateCode=");  
	        sb.append(MD5Util.MD5(email));  
	        sb.append("");  
	          
	        //发送邮件  
	        SendEmail.send("注册激活",email, sb.toString());  
	        System.out.println("发送邮件");  
	          
	    }  
	public void processActivate()throws ServiceException{    
        //数据访问层，通过email获取用户信息  
	   UserBiz userBiz=new UserBizImpl();
	   System.out.println("激活"+email);
       User user=userBiz.getUserById(userBiz.getUIdByEmail(email));  
       //验证用户是否存在   
       if(user!=null) {    
           //验证用户激活状态    
           if(user.getStatus()==0) {   
               ///没激活  
               Date currentTime = new Date();//获取当前时间    
               //验证链接是否过期   
               currentTime.before(user.getRegisterTime());  
               if(currentTime.before(user.getLastActivateTime())) {    
                   //验证激活码是否正确    
                   if(validateCode.equals(user.getValidateCode())) {    
                       //激活成功， //并更新用户的激活状态，为已激活   
                       System.out.println("==sh==="+user.getStatus()+"要改了哈");  
                       System.out.println(user.getuid());
                       userBiz.chgStatus(user.getuid(), 1);
                   } else {    
                      throw new ServiceException("激活码不正确");    
                   }    
               } else { throw new ServiceException("激活码已过期！");    
               }    
           } else {  
              throw new ServiceException("邮箱已激活，请登录！");    
           }    
       } else {  
           throw new ServiceException("该邮箱未注册（邮箱地址不存在）！");    
       }    
           
   }   

	public String logout(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		session.remove("user");
		return "logout";
	}
	public String showUser(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		UserBiz userBiz=new UserBizImpl();
		session.put("userList", userBiz.getAllUser(pageNum, pageSize));
		session.put("cuser", userBiz.cUser());
		session.put("pageNum", pageNum);
		session.put("pageSize", pageSize);
		return "showuser";
	}
	public String chgInfo() {
		Map<String, Object> session=ActionContext.getContext().getSession();
		UserBiz userBiz=new UserBizImpl();
		int uid1=userBiz.getUIdbynickname(nickname);
		int uid2=userBiz.getUIdByPhone(phone);
		int uid3=userBiz.getUIdByEmail(email);
		if(uid1<1&&uid2<1&&uid3<1){
			userBiz.changeUserInfo(uid, truename, nickname, email, phone, gender);
			session.put("user", userBiz.getUserById(uid));
			return "chginfo";
		}
		if(uid1==uid||uid2==uid||uid3==uid){
			userBiz.changeUserInfo(uid, truename, nickname, email, phone, gender);
			session.put("user", userBiz.getUserById(uid));
			return "chginfo";
		}
		return "false";
	}
	
	public String chgPass(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		UserBiz userBiz=new UserBizImpl();
		if(old.equals(userBiz.getUserById(uid).getPassword())){
			if(new1.equals(new2)){
				userBiz.changPassword(uid, new1, new2);
				session.put("user", userBiz.getUserById(uid));
				session.remove("showMessage");
				session.remove("showMessage");
				return "chgpass";
			}
			session.put("showMessage", "<script type='text/javascript'> alert('两次输入的密码不一致')</script>");
			return "false";
		}
		return "false";
	}
	public String userInfo(){
		return "userinfo";
	}
	public String forgetPass() throws Exception{
		Map<String, Object> session=ActionContext.getContext().getSession();
		UserBiz userBiz=new UserBizImpl();
		if((userBiz.getUIdByEmail(email)==userBiz.getUIdbynickname(nickname))&&(userBiz.getUIdByEmail(email)==userBiz.getUIdByPhone(phone))){
			password=userBiz.getUserById(userBiz.getUIdByEmail(email)).getPassword();
			StringBuffer sb=new StringBuffer("这是您的密码，请您牢记！密码"+"/n"+password);  
	        //发送邮件  
	        SendEmail.send("找回密码",email, sb.toString());  
	        session.remove("showMessage");
			return "forgetpass";
		}else{
			session.put("showMessage", "<script type='text/javascript'> alert('您输入的信息错误！')</script>");
			return "false";
		}
	}
}

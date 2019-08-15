package com.bean;

//对象类
/* database: usermanage
 *   
  CREATE TABLE `usermanage`.`people`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `sex` int(1) NULL,
  `birthplace` varchar(4) NULL,
  `imgName` varchar(100) NULL,
  PRIMARY KEY (`id`)
);
 *  
 * */
public class People {
	public int id;
    public String username;
    public String password;
    public String confirmPwd;
    public int sex;   //0 男 ，1 女
    public String birthplace;
    public String imgName;
    
    public People() {}
    
    public People(String username, int sex) {
		super();
		this.username = username;
		this.sex = sex;
	}
    
    
    public People(String username, String password, String confirmPwd, int sex, String birthplace) {
		super();
		this.username = username;
		this.password = password;
		this.confirmPwd = confirmPwd;
		this.sex = sex;
		this.birthplace = birthplace;
	}
    
	public People(String username, String password, String confirmPwd, int sex, String birthplace,String imgName) {
		super();
		this.username = username;
		this.password = password;
		this.confirmPwd = confirmPwd;
		this.sex = sex;
		this.birthplace = birthplace;
		this.imgName = imgName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	
	@Override	
    public String toString() {
    	return "用户名："+ username;
    }
	
	
}

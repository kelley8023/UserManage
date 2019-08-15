package com.test;

import java.util.ArrayList;

import com.bean.People;
import com.dao.PeopleDao;

public class Test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		People people = new People("lisi", "lisi", "lisi", 0, "BJ");
		PeopleDao peopleDao = new PeopleDao();
//        boolean flag = peopleDao.register(people);
//        if(flag) {
//        	System.out.println("插入成功");
//        }else {
//        	System.out.println("失败");
//        }
        
        ArrayList<People> userList = peopleDao.getAllUserList();
        for (People people2 : userList) {
			System.out.println("用户名："+people2.username);
		}
               
       int total =  peopleDao.getAllPeopleCount();
       System.out.println("用户总数："+total);
       
       People people2 = peopleDao.findPeopleById(5);
       System.out.println("people2："+people2);
	}

}

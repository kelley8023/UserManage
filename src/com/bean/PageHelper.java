package com.bean;


//分页实例
public class PageHelper {
	
	private int totalCount;   //数据总数
	private int countPerPage;  //每页数据数
	
	public PageHelper() {
		
	}
	
	public PageHelper(int totalCount, int countPerPage) {
		super();
		this.totalCount = totalCount;
		this.countPerPage = countPerPage;
	}


	/*
	 * 获取总页数
	 * 
	 * 总数/每页数据量，若能整除，结果为总页数    例如 totalPerPage = 10，totalCount=20，getTotalPage() = 2
	 * 否则 结果+1   例如 totalPerPage = 10，totalCount=23，getTotalPage() = 2+1=3
	 */
	public int getTotalPage() {
		
		return totalCount % countPerPage == 0 ? totalCount/countPerPage :(totalCount/countPerPage)+1;
	}
	
	
	/*
	 * 当前页数据起始数 
	 * 
	 * currentPage 当前页：页码
	 */
	
	public int getCurrentPageStart(int currentPage) {
		if( currentPage > totalCount || currentPage < 1) {
			throw new RuntimeException("页数错误");
		}
		
		return (currentPage-1) * countPerPage;
	}
	
	
	/*
	 * 当前页数据结束数
	 */
	
	public int getCurrentPageEnd(int currentPage) {
		if( currentPage > totalCount || currentPage < 1) {
			throw new RuntimeException("页数错误");
		}
		
		//currentPage = 2 ，10 + 10 > 15   起始：10-15   -------   10 + 10 > 23     起始：10-20
		return  getCurrentPageStart(currentPage)+ countPerPage > totalCount ?
				(totalCount):(getCurrentPageStart(currentPage)+ countPerPage);
	}

}

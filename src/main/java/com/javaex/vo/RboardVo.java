package com.javaex.vo;

public class RboardVo {
	private int no;
	private int userNo;
	private String title;
	private String content;
	private int hit;
	private String regDate;
	private String userName;
	private int groupNo;
	private int orderNo;
	private int depth;
	
	public RboardVo() {
		
	}
	
	public RboardVo(int userNo, String title, String content) {
		this.userNo = userNo;
		this.title = title;
		this.content = content;
	}
	
	public RboardVo(int no, int userNo, String title, String content, int hit, String regDate, String userName,
			int groupNo, int orderNo, int depth) {
		this.no = no;
		this.userNo = userNo;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.regDate = regDate;
		this.userName = userName;
		this.groupNo = groupNo;
		this.orderNo = orderNo;
		this.depth = depth;
	}

	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	
	@Override
	public String toString() {
		return "RboardVo [no=" + no + ", userNo=" + userNo + ", title=" + title + ", content=" + content + ", hit="
				+ hit + ", regDate=" + regDate + ", userName=" + userName + ", groupNo=" + groupNo + ", orderNo="
				+ orderNo + ", depth=" + depth + "]";
	}
}

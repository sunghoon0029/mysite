package com.bitacademy.mysite.vo;

public class BoardVo {
	private Long no;
	private String title;
	private String contents;
	private int hit;
	private String regDate;
	private Long userNo;
	private String userName;
	private Integer groupNo;
	private Integer orderNo;
	private Integer depth;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
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
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
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
	public void setGroupNo(Integer groupNo) {
		this.groupNo = groupNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", contents=" + contents + ", hit=" + hit + ", regDate="
				+ regDate + ", userNo=" + userNo + ", userName=" + userName + ", groupNo=" + groupNo + ", orderNo="
				+ orderNo + ", depth=" + depth + "]";
	}
}

package com.bitacademy.mysite.service;

import java.util.Map;

import com.bitacademy.mysite.vo.BoardVo;

public class BoardService {

	public void addContents(BoardVo vo) {

	}

	public BoardVo findContents(Long no) {
		return null;
	}

	public BoardVo findContents(Long no, Long userNo) {
		return null;
	}

	public Map<String, Object> findContentsList(int currentPage) {
		// view의 페이징을 처리하기 위한 데이터의 값 계산
		int beginPage = 0;
		int endPAge = 0;
		
		// 리스트 가져오기

		return null;
	}
	
	public void updateContents(BoardVo vo) {
	}
	
	public void deleteContents(Long no, Long UserNo) {
	}
}

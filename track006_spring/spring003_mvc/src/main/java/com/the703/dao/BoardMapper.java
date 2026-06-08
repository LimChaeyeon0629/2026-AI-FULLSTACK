package com.the703.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.the703.dto.BoardDto;

@Mapper
public interface BoardMapper {
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int update1(BoardDto dto);
	public int updateHit(int bno);
//	public int delete(int bno);
	public int delete(int bno);
	public int delete1(BoardDto dto);
    public BoardDto select(int bno);
    public List<BoardDto> selectAll();
    
    /* paging */
    public List<BoardDto> select10(HashMap<String, Integer> map);
    public int selectCnt();
}

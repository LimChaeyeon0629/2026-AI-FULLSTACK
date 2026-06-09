package com.the703.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.the703.dao.BoardMapper;
import com.the703.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired BoardMapper dao;		//db관련
	
	
	@Override public List<BoardDto> selectAll() { return dao.selectAll(); }
	
	@Override public int insert(BoardDto dto, MultipartFile file) {
		if( !file.isEmpty() ) {
			String fileName = file.getOriginalFilename();
			String uploadPath = "C:/file/";
			File demp = new File( uploadPath + fileName );
			
			try { file.transferTo(demp);
				dto.setBfile(fileName);
			} catch (IOException e) { e.printStackTrace(); }
		}
		
		try { dto.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch(UnknownHostException e) { e.printStackTrace(); }
		
		return dao.insert(dto);
	}
	
	@Override public BoardDto detail(int bno) {
		dao.updateHit(bno);	// 조회수
		return dao.select(bno);
	}
	
	@Override public BoardDto editView(int bno) {
		return dao.select(bno);
	}
	
	@Override public int edit(BoardDto dto, MultipartFile file) {
		int result = -1; //비번 안맞음
		
		BoardDto find = dao.select( dto.getBno() ); 	//사용자가 넣은 번호로 해당유저찾기
		if(find.getBpass().equals( dto.getBpass() )) {	//글번호의 비번과 사용자가 입력한 비번이 같은지 확인
			
			String fileName = dto.getBfile();	// 기본파일명으로 들어간 거 넣어놓고
			if( !file.isEmpty() ) {
				fileName = file.getOriginalFilename();
				String uploadPath = "C:/file/";
				File demp = new File( uploadPath + fileName );
				
				try { file.transferTo(demp);	// 파일올리기
				} catch (IOException e) { e.printStackTrace(); }
			}
			dto.setBfile(fileName);	//파일명 셋팅
			result = dao.update(dto);
		}
		return result;
	} //비번 맞으면 수정
	
	@Override public int delete(BoardDto dto) {
		int result = -1; //비번 안맞음
		
		BoardDto find = dao.select( dto.getBno() ); 	//사용자가 넣은 번호
		if(find.getBpass().equals( dto.getBpass() )) { 	//해당글번호 비밀번호 = 유저가 입력한 비번
			result = dao.delete(dto.getBno());
		}
		return result;
		
//		return dao.delete(dto.getBno());
//		return dao.delete(dto);
	} //비번 맞으면 삭제

	/* paging */
	/* paging */
	@Override
	public List<BoardDto> select10(int pstartno) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("start", (pstartno-1)*10);	//(1) 1 - 0번째부터,10개  (2) 2 - 10번째부터,10개  (3) 3 - 20번째부터,10개
		map.put("end", 10);
		return dao.select10(map); // MyBatis로 SQL 전달 (select from order by limit)
	}

	@Override
	public int selectCnt() {
		return dao.selectCnt();
	}
}
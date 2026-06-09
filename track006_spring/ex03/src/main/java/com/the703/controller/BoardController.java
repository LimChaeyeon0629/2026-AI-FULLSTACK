package com.the703.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.BoardDto;
import com.the703.service.BoardService;
import com.the703.util.PagingUtil;

@Controller
public class BoardController {
	@Autowired BoardService service;
	
	// ■1. 전체 리스트 list		http://localhost:8080/spring003_mvc/board/list.do
//	@RequestMapping("/board/list.do")
//	public String list(Model model) {
//		model.addAttribute("list", service.selectAll()); // Controller에서 JSP(View)로 데이터를 전달하는 메서드
//		return "board/list";	// /view(폴더)	+	board(폴더)/list(파일명)	+	.jsp(확장자)
//	}
	@RequestMapping("/board/list.do")
	public String list(Model model, @RequestParam(value="pstartno", defaultValue="1") int pstartno) {
		
//		System.out.println("전체 글 개수 = " + service.selectCnt());
		
		model.addAttribute("paging" , new PagingUtil( service.selectCnt(), pstartno )); //service전체갯수
		model.addAttribute("list"	, service.select10(pstartno) ); //list10
		return "board/list";
	}

	// ■2. 글쓰기 폼 write 	http://localhost:8080/spring003_mvc/board/write.do
	@RequestMapping( value="/board/write.do", method=RequestMethod.GET ) 
	public String write() {
		return "board/write";
	}
	
	// ■2. 글쓰기 기능		
	@RequestMapping( value = "/board/write.do", method = RequestMethod.POST )
	public String write_post(BoardDto dto, 
							@RequestParam("file") MultipartFile file,
							RedirectAttributes rttr) {
		String result="글쓰기 실패";
		
		if ( service.insert(dto, file) > 0 ) { result="글쓰기 성공 "; }
		rttr.addFlashAttribute("result", result);	// Flash - 한 번만 동작
		
		return "redirect:/board/list.do";	//response.sendRedirect + alert (x)
	}
	
	
	// ■3. 글 상세보기 detail 		http://localhost:8080/spring003_mvc/board/detail.do
	@RequestMapping("/board/detail.do")
	public String detail(int bno, Model model) {
		model.addAttribute( "dto", service.detail(bno) );
		return "board/detail";
	}

	
	// ■4. 글수정 폼 경로 edit
	@RequestMapping( value="/board/edit.do", method=RequestMethod.GET )
	public String edit( int bno, Model model ) {	// 넘겨받는 bno, detail.jsp
		model.addAttribute( "dto", service.editView(bno) );
		return "board/edit";
	}

	// ■4. 글수정 기능
	@RequestMapping( value="/board/edit.do", method=RequestMethod.POST )
	public String edit_post(BoardDto dto,
							@RequestParam("file") MultipartFile file,
							RedirectAttributes rttr) {
		//알림창
		String result="글수정 실패";
		if( service.edit(dto, file) > 0 ) { result="글수정 성공"; }
		rttr.addFlashAttribute("result", result);
		
		return "redirect:/board/detail.do?bno=" + dto.getBno();
	}
	
	// ■5. 글삭제 폼 경로 delete
	@RequestMapping( value="/board/delete.do", method=RequestMethod.GET)
	public String delete(int bno/*, Model model*/) {
		//model.addAttribute( "dto", service.detail(bno) );
		return "board/delete";
	}

	// ■5. 글삭제 기능 delete
	@RequestMapping( value="/board/delete.do", method=RequestMethod.POST)
	public String delete_post(BoardDto dto, RedirectAttributes rttr) {
		String result="글삭제 실패...";
		if( service.delete(dto) > 0) { result="글삭제 성공"; }
		rttr.addFlashAttribute("result", result);
		
		return "redirect:/board/list.do";
	}
}


// ■ RequestMapping 경로      ■ 해당view 설정
// /board/list.do            /view/board/list.jsp 
// /board/write.do           /view/board/write.jsp    (글쓰기폼)
// /board/detail.do          /view/board/detail.jsp    (상세보기)
// /board/edit.do            /view/board/edit.jsp     (수정하기폼)
// /board/delete.do          /view/board/delete.jsp   (삭제하기폼)
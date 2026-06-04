package com.the703.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	// list		http://localhost:8080/spring003_mvc/board/list.do
	@RequestMapping("/board/list.do")
	public String list() {
//		model.addAttribute(""); // Controller에서 JSP(View)로 데이터를 전달하는 메서드
		return "board/list";	// /view(폴더)	+	board(폴더)/list(파일명)	+	.jsp(확장자)
	}

	// write 글쓰기폼
	@RequestMapping("/board/write.do")
	public String write() {
//		model.addAttribute("");
		return "board/write";
	}
	
	// detail 상세보기 
	@RequestMapping("/board/detail.do")
	public String detail() {
//		model.addAttribute("");
		return "board/detail";
	}

	// edit 수정하기폼
	@RequestMapping("/board/edit.do")
	public String edit() {
//		model.addAttribute("");
		return "board/edit";
	}

	// delete 삭제하기폼
	@RequestMapping("/board/delete.do")
	public String delete() {
//		model.addAttribute("");
		return "board/delete";
	}
}


// ■ RequestMapping 경로      ■ 해당view 설정
// /board/list.do            /view/board/list.jsp 
// /board/write.do           /view/board/write.jsp    (글쓰기폼)
// /board/detail.do          /view/board/detail.jsp    (상세보기)
// /board/edit.do            /view/board/edit.jsp     (수정하기폼)
// /board/delete.do          /view/board/delete.jsp   (삭제하기폼)
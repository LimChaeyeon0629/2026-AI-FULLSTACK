package com.the703.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UtilPaging {
	private int listtotal;		// 전체글 193
	private int onepagelist;	// 1페이지에 보여줄 게시물의 수 10개
	private int pagetotal;		// 총 페이지 수 20개
	private int bottomlist;		// 하단 페이지 수 10개
	private int pstartno;		// 페이지 시작 번호 (1) 1,10 (2) 11,10 ( oracle version )
	private int current;		// 현재 번호
	private int start;			// 1
	private int end;			// 10

	public UtilPaging(int listtotal, int pageNo) {
		this(listtotal, pageNo, 10, 10); // 한 페이지10, 하단네버10
	}
	
	public UtilPaging(int listtotal, int pageNo, int onepagelist, int bottomlist) {
		this.listtotal = (listtotal <= 0) ? 1 : listtotal;
		this.onepagelist = onepagelist;
		this.pagetotal = (int) Math.ceil(this.listtotal / (double) onepagelist); // 193/10 = 19.3 = 20
//		Math.ceil() 올림 - Math.floor() 내림 - Math.round() 반올림

		this.bottomlist = bottomlist; // 23 -> start=21 / end=23
		
		this.current = pageNo;

		this.start = ((current - 1) / bottomlist) * bottomlist + 1;
//		30 = 29/10 = 앞자리2 , 앞자리2 * 10 + 1 = 21
//		29 = 28/10 = 앞자리2 , 앞자리2 * 10 + 1 = 21

		this.end = start + bottomlist - 1; // 21 + 10 - 1 = 30

		if (end > pagetotal) { // 30 > 26 마지막은 26
			end = pagetotal;
		}
		this.pstartno = (pageNo - 1) * onepagelist + 1;
	}
}

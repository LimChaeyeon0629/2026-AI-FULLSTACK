package ex02;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.TestMapper;
import com.the703.dao.BoardMapper;
import com.the703.dto.BoardDto;
import com.the703.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)	//1.spring 구동
@ContextConfiguration(locations = "classpath:config/root-context.xml") //2.설정파일
public class ModelTest {
	@Autowired ApplicationContext context; //bean (spring이 관리하는 객체들)
	@Autowired DataSource dataSource;
	@Autowired SqlSession sqlSession;
	@Autowired TestMapper testMapper;
	
	@Autowired BoardMapper board;
	@Autowired BoardService service;
	
	@Test
	public void test7() {
		HashMap<String, Integer> map = new HashMap();
		map.put("start", 0);
		map.put("end", 10);
		System.out.println( board.select10(map) );
		
		System.out.println( board.selectCnt() );
	}
	
	@Ignore //@Test
	public void test1() {
		System.out.println(context);
	}

	@Ignore //@Test
	public void test2() {
		System.out.println(dataSource);
	}
	
	@Ignore //@Test
	public void test3() {
		System.out.println(sqlSession);
	}
	
	@Ignore //@Test
	public void test4() {
		System.out.println(testMapper.now());
	} // 메서드명 now()
	
	@Ignore //@Test
	public void test5() {
		//삭제
//		System.out.println( board.delete(8) );
		
		//수정
//		BoardDto dto2 = new BoardDto();
//		dto2.setBname("ddd");
//		dto2.setBpass("ddd");
//		dto2.setBtitle("ddd");
//		dto2.setBcontent("DDD");
//		dto2.setBip("12.12.12");
//		dto2.setBno(8);
//		board.update(dto2);
//		System.out.println( board.update(dto2) ); //실행한 줄수1

		//insert
//		BoardDto dto = new BoardDto();
//		dto.setBname("cy_name");
//		dto.setBpass("cy_pass");
//		dto.setBtitle("cy_title");
//		dto.setBcontent("cy_content");
//		dto.setBip(InetAddress.getLocalHost().getHostAddress());
//		board.insert(dto);
//		System.out.println( board.insert(dto) ); //실행한 줄수1
		
		//선택출력
//		System.out.println( board.select(1) );
		
		//전체출력
//		System.out.println(board.selectAll());
	}
	
	@Ignore //@Test
	public void test6() throws UnknownHostException {
		//삭제
//		BoardDto dto = new BoardDto();
//		dto.setBno(10);
//		System.out.println( service.delete(dto) );
		
		//수정
//		BoardDto dto = new BoardDto();
//		dto.setBname("first");
//		dto.setBpass("1111");
//		dto.setBno(11);
//		dto.setBtitle("service-제목");
//		dto.setBcontent("service-글쓰기");
//		dto.setBip(InetAddress.getLocalHost().getHostAddress());
//		System.out.println( service.edit(dto) );
		
		//삽입
//		BoardDto dto = new BoardDto();
//		dto.setBname("second");
//		dto.setBpass("2222");
//		dto.setBtitle("service-제목");
//		dto.setBcontent("service-글쓰기");
//		System.out.println( service.insert(dto) );
		
		//전체출력
//		System.out.println( service.selectAll() );
	}
	
}

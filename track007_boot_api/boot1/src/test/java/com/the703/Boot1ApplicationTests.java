package com.the703;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.the703.dao.Sboard2Dao;
import com.the703.dao.TestDao;
import com.the703.dto.Sboard2Dto;
import com.the703.service.Sboard2Service;

@SpringBootTest
class Boot1ApplicationTests {

	@Autowired TestDao dao;
	@Autowired Sboard2Dao sdao;
	@Autowired Sboard2Service service;
	
	@Disabled //@Test
	public void service06_Delete() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setId(21);
		
		int result = service.delete(dto);
		assertEquals(1, result);
	}

	@Disabled //@Test
	public void service05_updateForm() {
		Sboard2Dto dto = new Sboard2Dto();
		
		Sboard2Dto result = service.updateForm(dto);
		assertEquals(21, result);
	}

	@Disabled //@Test
	public void service04_Detail() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setId(21);
		
		Sboard2Dto result = service.detail(dto);
		assertEquals( 21, result.getId() );
	}

	@Disabled //@Test
	public void service03_SelectPaging() {
//		assertEquals( 1, service.list10(1).size() ); //2
		
		assertEquals( 2, service.selectCnt() );
	}
	
	@Disabled //@Test
	public void service02_Update() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setId(21);
		dto.setAppUserId(1);
		dto.setBtitle("serviceUpdate");
		dto.setBcontent("serviceUpdate");
		dto.setBpass("2222");
		MockMultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain", "data".getBytes());
		
		int result = service.update(file, dto);
		assertEquals(1, result);
	}
	
	@Disabled //@Test
	public void service01_Insert() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setAppUserId(1);
		dto.setBtitle("title");
		dto.setBcontent("content");
		dto.setBpass("1111");
		MockMultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain", "data".getBytes());
		
		int result = service.insert(file, dto);
//		System.out.println( result );
		assertEquals(1, result);
	}
	
	@Disabled //@Test
	public void test05_Delete() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setId(6);
		
		int result = sdao.deleteById(dto);
		assertEquals(1, result);
	}

	@Disabled //@Test
	public void test04_Update() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setBtitle("update");
		dto.setBcontent("update");
		dto.setBfile("2.png");
		dto.setId(6);

		int result = sdao.updateById(dto);
		assertEquals(1, result);
	}
	
	@Disabled //@Test
	public void test03_byId() { // id, 조회수올리기
		Sboard2Dto dto = new Sboard2Dto();
		dto.setId(6);
		
		int hit = sdao.updateHit(dto); // 조회수올리기
		System.out.println( hit );
		
		Sboard2Dto result = sdao.selectById(dto); // id
		assertEquals(6, result.getId());
	}
	
	@Disabled //@Test
	public void test02_Paging() { //페이징, 갯수
		HashMap<String, Object> map = new HashMap<>();
		map.put("start", 0);
		map.put("end", 10);
		
		// 페이징
		List<Sboard2Dto> list10 = sdao.selectPaging(map);
		System.out.println( list10 );
		assertEquals(1, list10.size()); //지금 있는 list 갯수로 test (예상되는 결과, 해당코드)
		assertNotNull(list10);
		
		// cnt
		int result = sdao.selectCnt();
		assertEquals(1, result); //전체갯수 1
	}
	
	@Disabled //@Test
	public void test_All() {
		List<Sboard2Dto> result = sdao.selectAll();
		System.out.println( result );
//		assertEquals(1, result); //전체갯수 1
		
	}
	
	@Disabled //@Test
	public void test01_Insert() throws UnknownHostException {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setAppUserId(1);
		dto.setBtitle("title");
		dto.setBcontent("content");
		dto.setBpass("1111");
		dto.setBfile("1.png");
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		
		int result = sdao.insert(dto);
		System.out.println( "...... 1. " + result ); //수동확인: 콘솔에 1
		assertEquals(1, result); //자동확인: 결과물이 1인지 Junit 체크
//		assertEquals(2, result); //자동확인: 결과물이 1인지 Junit 체크 (error)
	}
	
	@Disabled //@Test
	void contextLoads() {
		System.out.println("..................");
		System.out.println( dao.readTime() );
		System.out.println("..................");
	}

}

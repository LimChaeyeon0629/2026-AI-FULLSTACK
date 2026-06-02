package spring002_db_mysql;

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
import com.the703.dao.UserInfoMapper;
import com.the703.dto.UserInfoDto;

@RunWith(SpringJUnit4ClassRunner.class) //1. spring 구동
@ContextConfiguration(locations = "classpath:config/root-context.xml") //2. 설정파일

public class ModelTest001 {
	@Autowired ApplicationContext  context; //3. Bean (스프링이 관리하는 객체) 생성~소멸
	@Autowired DataSource		dataSource;
	@Autowired SqlSession		sqlSession;
	@Autowired TestMapper		test;
	@Autowired UserInfoMapper	userinfo;
	
	@Ignore //@Test
	public void test1() { System.out.println(context ); }
	
	@Ignore //@Test
	public void test2() { System.out.println(dataSource ); }
	
	@Ignore //@Test
	public void test3() { System.out.println(sqlSession ); }

	@Ignore //@Test
	public void test4() { System.out.println(test.now()); }

	@Test
	public void test5() { 
		//삭제
		//userinfo.delete(6);
		
		//수정
//		UserInfoDto dto = new UserInfoDto();
//		dto.setEmail("haha@gmail.com");
//		dto.setAge(100);
//		dto.setNo(5);
//		System.out.println( userinfo.update(dto) );
		
		//한명검색
		//System.out.println( userinfo.select(5) );
		
		//삽입
//		UserInfoDto dto = new UserInfoDto();
//		dto.setEmail("hi@gmail.com");
//		dto.setAge(10);
//		userinfo.insert(dto);
		
		//전체검색
		System.out.println( userinfo.selectAll() );
	}
	
}

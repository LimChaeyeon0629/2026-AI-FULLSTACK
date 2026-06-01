package com.the703.di2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("animalFarm")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalFarm {
	@Value("poppi") // 설정 값 주입
	private String name;
	
	@Autowired @Qualifier("dog") // 설정 값 주입
	private Animal ani;
	
	public String aniEat()   { return name + ">" + ani.eat();   }
	public String aniSleep() { return name + ">" + ani.sleep(); }
	public String aniPoo()   { return name + ">" + ani.poo();   }
	
	public void print() {
		System.out.println( aniEat()   );
		System.out.println( aniSleep() );
		System.out.println( aniPoo()   );
	}
}

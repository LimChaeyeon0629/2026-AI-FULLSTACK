package com.the703.di3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("animalFarm")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalFarm {
	@Value("${name}")
	private String name;
	
	@Resource(name="${ani}") // °­¾ÆÁö
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

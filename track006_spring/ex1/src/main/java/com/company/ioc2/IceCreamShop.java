package com.company.ioc2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
// import lombok.NoArgsConstructor;


@Component("iceCreamShop")
@Data
@AllArgsConstructor // 전체 필드 생성자 자동 생성
// @NoArgsConstructor 기본 파라미터 없을 때
public class IceCreamShop {
	// @Value("bera31") // "bera31"
	@Value("${shopName}") // "SweetHouse"
    private String shopName;
	
	// @Autowired = 타입 매칭 시스템
	// @Resource = 이름 문자열 시스템
	// @Autowired @Qualifier("chocolate") // "chocolate"
	@Resource(name="${iceCream}") // name= @Component("vanilla")
    private IceCream iceCream;

    public IceCreamShop() { super(); }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }

    public IceCream getIceCream() { return iceCream; }
    public void setIceCream(IceCream iceCream) { this.iceCream = iceCream; }

    public String serveFlavor() { return shopName + ">" + iceCream.flavor(); }
    public String serveScoop()  { return shopName + ">" + iceCream.scoop(); }
    public String serveMelt()   { return shopName + ">" + iceCream.melt(); }

    public void print() {
        System.out.println(serveFlavor());
        System.out.println(serveScoop());
        System.out.println(serveMelt());
    }
}
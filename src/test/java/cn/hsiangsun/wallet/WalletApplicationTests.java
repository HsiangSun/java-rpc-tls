package cn.hsiangsun.wallet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class WalletApplicationTests {

	@Test
	void contextLoads() {
		String str = "0.04dkaskdhasjkdhasdas1001";
		String res = DigestUtils.md5DigestAsHex(str.getBytes()).toUpperCase();
		System.out.println(res);
	}

}

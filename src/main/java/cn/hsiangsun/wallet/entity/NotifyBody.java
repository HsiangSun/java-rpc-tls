package cn.hsiangsun.wallet.entity;

public class NotifyBody {
	
	private String value;
	
	private String secret;
	
	private String uid;
	
	private String sign;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "NotifyBody [value=" + value + ", secret=" + secret + ", uid=" + uid + ", sign=" + sign + "]";
	}
	

	
	

}

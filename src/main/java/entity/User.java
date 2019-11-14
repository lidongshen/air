package entity;

/**
 * 用户
 * @author s
 *
 */
public class User {
	private int uId;
	private int uNum;
	private String uPhone;
	private String uPassword;
	private String uName;
	private int uAge;	
	private String uSex;
	
	public User(int uId, int uNum, String uPhone, String uPassword, String uName, int uAge, String uSex) {
		super();
		this.uId = uId;
		this.uNum = uNum;
		this.uPhone = uPhone;
		this.uPassword = uPassword;
		this.uName = uName;
		this.uAge = uAge;
		this.uSex = uSex;
	}

	public User(int uNum, String uPhone, String uPassword, String uName, int uAge, String uSex) {
		super();
		this.uNum = uNum;
		this.uPhone = uPhone;
		this.uPassword = uPassword;
		this.uName = uName;
		this.uAge = uAge;
		this.uSex = uSex;
	}

	public User() {
		super();
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getuNum() {
		return uNum;
	}

	public void setuNum(int uNum) {
		this.uNum = uNum;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public int getuAge() {
		return uAge;
	}

	public void setuAge(int uAge) {
		this.uAge = uAge;
	}

	public String getuSex() {
		return uSex;
	}

	public void setuSex(String uSex) {
		this.uSex = uSex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + uAge;
		result = prime * result + uId;
		result = prime * result + ((uName == null) ? 0 : uName.hashCode());
		result = prime * result + uNum;
		result = prime * result + ((uPassword == null) ? 0 : uPassword.hashCode());
		result = prime * result + ((uPhone == null) ? 0 : uPhone.hashCode());
		result = prime * result + ((uSex == null) ? 0 : uSex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (uAge != other.uAge)
			return false;
		if (uId != other.uId)
			return false;
		if (uName == null) {
			if (other.uName != null)
				return false;
		} else if (!uName.equals(other.uName))
			return false;
		if (uNum != other.uNum)
			return false;
		if (uPassword == null) {
			if (other.uPassword != null)
				return false;
		} else if (!uPassword.equals(other.uPassword))
			return false;
		if (uPhone == null) {
			if (other.uPhone != null)
				return false;
		} else if (!uPhone.equals(other.uPhone))
			return false;
		if (uSex == null) {
			if (other.uSex != null)
				return false;
		} else if (!uSex.equals(other.uSex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uNum=" + uNum + ", uPhone=" + uPhone + ", uPassword=" + uPassword + ", uName="
				+ uName + ", uAge=" + uAge + ", uSex=" + uSex + "]";
	}
	
	
	
}

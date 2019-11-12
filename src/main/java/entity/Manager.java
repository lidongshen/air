package entity;

public class Manager {
	private int mId;
	private String mNumber;
	private String mPassword;
	public Manager(int mId, String mNumber, String mPassword) {
		super();
		this.mId = mId;
		this.mNumber = mNumber;
		this.mPassword = mPassword;
	}
	public Manager(String mNumber, String mPassword) {
		super();
		this.mNumber = mNumber;
		this.mPassword = mPassword;
	}
	public Manager() {
		super();
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmNumber() {
		return mNumber;
	}
	public void setmNumber(String mNumber) {
		this.mNumber = mNumber;
	}
	public String getmPassword() {
		return mPassword;
	}
	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mId;
		result = prime * result + ((mNumber == null) ? 0 : mNumber.hashCode());
		result = prime * result + ((mPassword == null) ? 0 : mPassword.hashCode());
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
		Manager other = (Manager) obj;
		if (mId != other.mId)
			return false;
		if (mNumber == null) {
			if (other.mNumber != null)
				return false;
		} else if (!mNumber.equals(other.mNumber))
			return false;
		if (mPassword == null) {
			if (other.mPassword != null)
				return false;
		} else if (!mPassword.equals(other.mPassword))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Manager [mId=" + mId + ", mNumber=" + mNumber + ", mPassword=" + mPassword + "]";
	}
	
}

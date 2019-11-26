package entity;

public class Trip {
	private int tId;
	private int uId;
	private int oId;
	private int fId;
	private int uIspay;
	private int bookId;
	
	public Trip(int tId, int uId, int oId, int fId, int uIspay, int bookId) {
		super();
		this.tId = tId;
		this.uId = uId;
		this.oId = oId;
		this.fId = fId;
		this.uIspay = uIspay;
		this.bookId = bookId;
	}
	
	public Trip(int uId, int oId, int fId, int uIspay, int bookId) {
		super();
		this.uId = uId;
		this.oId = oId;
		this.fId = fId;
		this.uIspay = uIspay;
		this.bookId = bookId;
	}
	
	public Trip() {
		super();
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public int getuIspay() {
		return uIspay;
	}

	public void setuIspay(int uIspay) {
		this.uIspay = uIspay;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		result = prime * result + fId;
		result = prime * result + oId;
		result = prime * result + tId;
		result = prime * result + uId;
		result = prime * result + uIspay;
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
		Trip other = (Trip) obj;
		if (bookId != other.bookId)
			return false;
		if (fId != other.fId)
			return false;
		if (oId != other.oId)
			return false;
		if (tId != other.tId)
			return false;
		if (uId != other.uId)
			return false;
		if (uIspay != other.uIspay)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trip [tId=" + tId + ", uId=" + uId + ", oId=" + oId + ", fId=" + fId + ", uIspay=" + uIspay
				+ ", bookId=" + bookId + "]";
	}
	
	
	
}
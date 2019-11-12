package entity;

import java.util.Date;

public class Booking {
	private int bookId;
	private int uId;
	private int cId;
	private int fId;
	private Date bDate;
	private int bIspay;
	
	public Booking(int bookId, int uId, int cId, int fId, Date bDate, int bIspay) {
		super();
		this.bookId = bookId;
		this.uId = uId;
		this.cId = cId;
		this.fId = fId;
		this.bDate = bDate;
		this.bIspay = bIspay;
	}

	public Booking(int uId, int cId, int fId, Date bDate, int bIspay) {
		super();
		this.uId = uId;
		this.cId = cId;
		this.fId = fId;
		this.bDate = bDate;
		this.bIspay = bIspay;
	}

	@Override
	public String toString() {
		return "Booking [bookId=" + bookId + ", uId=" + uId + ", cId=" + cId + ", fId=" + fId + ", bDate=" + bDate
				+ ", bIspay=" + bIspay + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bDate == null) ? 0 : bDate.hashCode());
		result = prime * result + bookId;
		result = prime * result + bIspay;
		result = prime * result + cId;
		result = prime * result + fId;
		result = prime * result + uId;
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
		Booking other = (Booking) obj;
		if (bDate == null) {
			if (other.bDate != null)
				return false;
		} else if (!bDate.equals(other.bDate))
			return false;
		if (bookId != other.bookId)
			return false;
		if (bIspay != other.bIspay)
			return false;
		if (cId != other.cId)
			return false;
		if (fId != other.fId)
			return false;
		if (uId != other.uId)
			return false;
		return true;
	}

	public int getbookId() {
		return bookId;
	}

	public void setbookId(int bookId) {
		this.bookId = bookId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	public int getbIspay() {
		return bIspay;
	}

	public void setbIspay(int bIspay) {
		this.bIspay = bIspay;
	}

	public Booking() {
		super();
	}
	
	
	
}

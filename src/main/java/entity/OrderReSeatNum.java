package entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;
@Alias("MyOrder")
public class OrderReSeatNum {
	private int fId;
	private String fName;
	private String fFromcity;
	private String fTocity;
	private int fSeatnum;
	private int seatnum;
	private int reseatnum;
	private Date fStarttime;
	private Date fEndtime;
	public OrderReSeatNum(int fId, String fName, String fFromcity, String fTocity, int fSeatnum, int seatnum,
			int reseatnum, Date fStarttime, Date fEndtime) {
		super();
		this.fId = fId;
		this.fName = fName;
		this.fFromcity = fFromcity;
		this.fTocity = fTocity;
		this.fSeatnum = fSeatnum;
		this.seatnum = seatnum;
		this.reseatnum = reseatnum;
		this.fStarttime = fStarttime;
		this.fEndtime = fEndtime;
	}
	public OrderReSeatNum(String fName, String fFromcity, String fTocity, int fSeatnum, int seatnum, Date fStarttime,
			Date fEndtime) {
		super();
		this.fName = fName;
		this.fFromcity = fFromcity;
		this.fTocity = fTocity;
		this.fSeatnum = fSeatnum;
		this.seatnum = seatnum;
		this.fStarttime = fStarttime;
		this.fEndtime = fEndtime;
	}
	public OrderReSeatNum() {
		super();
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfFromcity() {
		return fFromcity;
	}
	public void setfFromcity(String fFromcity) {
		this.fFromcity = fFromcity;
	}
	public String getfTocity() {
		return fTocity;
	}
	public void setfTocity(String fTocity) {
		this.fTocity = fTocity;
	}
	public int getfSeatnum() {
		return fSeatnum;
	}
	public void setfSeatnum(int fSeatnum) {
		this.fSeatnum = fSeatnum;
	}
	public int getSeatnum() {
		return seatnum;
	}
	public void setSeatnum(int seatnum) {
		this.seatnum = seatnum;
	}
	public int getReseatnum() {
		return reseatnum;
	}
	public void setReseatnum(int reseatnum) {
		this.reseatnum = reseatnum;
	}
	public Date getfStarttime() {
		return fStarttime;
	}
	public void setfStarttime(Date fStarttime) {
		this.fStarttime = fStarttime;
	}
	public Date getfEndtime() {
		return fEndtime;
	}
	public void setfEndtime(Date fEndtime) {
		this.fEndtime = fEndtime;
	}
	@Override
	public String toString() {
		return "OrderReSeatNum [fId=" + fId + ", fName=" + fName + ", fFromcity=" + fFromcity + ", fTocity=" + fTocity
				+ ", fSeatnum=" + fSeatnum + ", seatnum=" + seatnum + ", reseatnum=" + reseatnum + ", fStarttime="
				+ fStarttime + ", fEndtime=" + fEndtime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fEndtime == null) ? 0 : fEndtime.hashCode());
		result = prime * result + ((fFromcity == null) ? 0 : fFromcity.hashCode());
		result = prime * result + fId;
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + fSeatnum;
		result = prime * result + ((fStarttime == null) ? 0 : fStarttime.hashCode());
		result = prime * result + ((fTocity == null) ? 0 : fTocity.hashCode());
		result = prime * result + reseatnum;
		result = prime * result + seatnum;
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
		OrderReSeatNum other = (OrderReSeatNum) obj;
		if (fEndtime == null) {
			if (other.fEndtime != null)
				return false;
		} else if (!fEndtime.equals(other.fEndtime))
			return false;
		if (fFromcity == null) {
			if (other.fFromcity != null)
				return false;
		} else if (!fFromcity.equals(other.fFromcity))
			return false;
		if (fId != other.fId)
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (fSeatnum != other.fSeatnum)
			return false;
		if (fStarttime == null) {
			if (other.fStarttime != null)
				return false;
		} else if (!fStarttime.equals(other.fStarttime))
			return false;
		if (fTocity == null) {
			if (other.fTocity != null)
				return false;
		} else if (!fTocity.equals(other.fTocity))
			return false;
		if (reseatnum != other.reseatnum)
			return false;
		if (seatnum != other.seatnum)
			return false;
		return true;
	}
	
	
	
	
}

package entity;

import java.sql.Date;

public class TripByUserAndFlight {
	private int fId;
	private String uName;
	private String fFromcity;
	private String fTocity;
	private Date fStarttime;
	private Date fEndtime;
	private String uIspay;
	
	public TripByUserAndFlight(int fId, String uName, String fFromcity, String fTocity, Date fStarttime, Date fEndtime,
			String uIspay) {
		super();
		this.fId = fId;
		this.uName = uName;
		this.fFromcity = fFromcity;
		this.fTocity = fTocity;
		this.fStarttime = fStarttime;
		this.fEndtime = fEndtime;
		this.uIspay = uIspay;
	}

	public TripByUserAndFlight(String uName, String fFromcity, String fTocity, Date fStarttime, Date fEndtime,
			String uIspay) {
		super();
		this.uName = uName;
		this.fFromcity = fFromcity;
		this.fTocity = fTocity;
		this.fStarttime = fStarttime;
		this.fEndtime = fEndtime;
		this.uIspay = uIspay;
	}

	public TripByUserAndFlight() {
		super();
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
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

	public String getuIspay() {
		return uIspay;
	}

	public void setuIspay(String uIspay) {
		this.uIspay = uIspay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fEndtime == null) ? 0 : fEndtime.hashCode());
		result = prime * result + ((fFromcity == null) ? 0 : fFromcity.hashCode());
		result = prime * result + fId;
		result = prime * result + ((fStarttime == null) ? 0 : fStarttime.hashCode());
		result = prime * result + ((fTocity == null) ? 0 : fTocity.hashCode());
		result = prime * result + ((uIspay == null) ? 0 : uIspay.hashCode());
		result = prime * result + ((uName == null) ? 0 : uName.hashCode());
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
		TripByUserAndFlight other = (TripByUserAndFlight) obj;
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
		if (uIspay == null) {
			if (other.uIspay != null)
				return false;
		} else if (!uIspay.equals(other.uIspay))
			return false;
		if (uName == null) {
			if (other.uName != null)
				return false;
		} else if (!uName.equals(other.uName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TripByUserAndFlight [fId=" + fId + ", uName=" + uName + ", fFromcity=" + fFromcity + ", fTocity="
				+ fTocity + ", fStarttime=" + fStarttime + ", fEndtime=" + fEndtime + ", uIspay=" + uIspay + "]";
	}
	
	
	
}

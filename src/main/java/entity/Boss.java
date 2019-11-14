package entity;


public class Boss {
    private Integer boId;

    private String boNumber;

    private String boPassword;

    public Boss(Integer boId, String boNumber, String boPassword) {
        super();
        this.boId = boId;
        this.boNumber = boNumber;
        this.boPassword = boPassword;
    }

    public Boss(String boNumber, String boPassword) {
        super();
        this.boNumber = boNumber;
        this.boPassword = boPassword;
    }

    public Boss() {
        super();
    }

    public Integer getBoId() {
        return boId;
    }

    public void setBoId(Integer boId) {
        this.boId = boId;
    }

    public String getBoNumber() {
        return boNumber;
    }

    public void setBoNumber(String boNumber) {
        this.boNumber = boNumber;
    }

    public String getBoPassword() {
        return boPassword;
    }

    public void setBoPassword(String boPassword) {
        this.boPassword = boPassword;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((boId == null) ? 0 : boId.hashCode());
        result = prime * result + ((boNumber == null) ? 0 : boNumber.hashCode());
        result = prime * result + ((boPassword == null) ? 0 : boPassword.hashCode());
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
        Boss other = (Boss) obj;
        if (boId == null) {
            if (other.boId != null)
                return false;
        } else if (!boId.equals(other.boId))
            return false;
        if (boNumber == null) {
            if (other.boNumber != null)
                return false;
        } else if (!boNumber.equals(other.boNumber))
            return false;
        if (boPassword == null) {
            if (other.boPassword != null)
                return false;
        } else if (!boPassword.equals(other.boPassword))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Boss [boId=" + boId + ", boNumber=" + boNumber + ", boPassword=" + boPassword + "]";
    }


}
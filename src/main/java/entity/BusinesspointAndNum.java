package entity;


public class BusinesspointAndNum {
    private String bName;
    private int bNum;
    private String bDate;

    public BusinesspointAndNum(String bName, int bNum, String bDate) {
        super();
        this.bName = bName;
        this.bNum = bNum;
        this.bDate = bDate;
    }

    public BusinesspointAndNum() {
        super();
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public int getbNum() {
        return bNum;
    }

    public void setbNum(int bNum) {
        this.bNum = bNum;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    @Override
    public String toString() {
        return "BusinesspointAndNum [bName=" + bName + ", bNum=" + bNum + ", bDate=" + bDate + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bDate == null) ? 0 : bDate.hashCode());
        result = prime * result + ((bName == null) ? 0 : bName.hashCode());
        result = prime * result + bNum;
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
        BusinesspointAndNum other = (BusinesspointAndNum) obj;
        if (bDate == null) {
            if (other.bDate != null)
                return false;
        } else if (!bDate.equals(other.bDate))
            return false;
        if (bName == null) {
            if (other.bName != null)
                return false;
        } else if (!bName.equals(other.bName))
            return false;
        if (bNum != other.bNum)
            return false;
        return true;
    }

}

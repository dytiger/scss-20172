package org.forten.scss.dto.vo;

public class CreditVo {
    private int creditSum;
    private int minCredit;
    private int maxCredit;
    private String beginDate;
    private String endDate;

    public CreditVo() {
        this.creditSum = 0;
    }

    public int getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(int creditSum) {
        this.creditSum = creditSum;
    }

    public int getMinCredit() {
        return minCredit;
    }

    public void setMinCredit(int minCredit) {
        this.minCredit = minCredit;
    }

    public int getMaxCredit() {
        return maxCredit;
    }

    public void setMaxCredit(int maxCredit) {
        this.maxCredit = maxCredit;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "CreditVo{" +
                "creditSum=" + creditSum +
                ", minCredit=" + minCredit +
                ", maxCredit=" + maxCredit +
                ", beginDate='" + beginDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}

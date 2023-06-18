package com.cy.store.vo;

import java.io.Serializable;

public class OrderVO implements Serializable {
    private Integer oid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;
    private String title;
    private String image;
    private Long realPrice;
    private Integer status;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Long realPrice) {
        this.realPrice = realPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderVO)) return false;

        OrderVO orderVO = (OrderVO) o;

        if (getOid() != null ? !getOid().equals(orderVO.getOid()) : orderVO.getOid() != null) return false;
        if (getUid() != null ? !getUid().equals(orderVO.getUid()) : orderVO.getUid() != null) return false;
        if (getPid() != null ? !getPid().equals(orderVO.getPid()) : orderVO.getPid() != null) return false;
        if (getPrice() != null ? !getPrice().equals(orderVO.getPrice()) : orderVO.getPrice() != null) return false;
        if (getNum() != null ? !getNum().equals(orderVO.getNum()) : orderVO.getNum() != null) return false;
        if (getTitle() != null ? !getTitle().equals(orderVO.getTitle()) : orderVO.getTitle() != null) return false;
        if (getImage() != null ? !getImage().equals(orderVO.getImage()) : orderVO.getImage() != null) return false;
        if (getRealPrice() != null ? !getRealPrice().equals(orderVO.getRealPrice()) : orderVO.getRealPrice() != null)
            return false;
        return getStatus() != null ? getStatus().equals(orderVO.getStatus()) : orderVO.getStatus() == null;
    }

    @Override
    public int hashCode() {
        int result = getOid() != null ? getOid().hashCode() : 0;
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        result = 31 * result + (getPid() != null ? getPid().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getNum() != null ? getNum().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        result = 31 * result + (getRealPrice() != null ? getRealPrice().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", price=" + price +
                ", num=" + num +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", realPrice=" + realPrice +
                ", status=" + status +
                '}';
    }
}

package com.cy.store.entity;


//用这个实体类来表示省市区数据实体类
//实体类继承父类(基类)，然后实现get和set方法、equals方法和toSting方法
public class District extends BaseEntity{
    private Integer id;
    private String parent;
    private String code;
    private String name;

    //get和set方法

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //equals方法

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof District)) return false;
        if (!super.equals(o)) return false;

        District district = (District) o;

        if (getId() != null ? !getId().equals(district.getId()) : district.getId() != null) return false;
        if (getParent() != null ? !getParent().equals(district.getParent()) : district.getParent() != null)
            return false;
        if (getCode() != null ? !getCode().equals(district.getCode()) : district.getCode() != null) return false;
        return getName() != null ? getName().equals(district.getName()) : district.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getParent() != null ? getParent().hashCode() : 0);
        result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    //toString方法

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", parent='" + parent + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                "} " + super.toString();
    }
}

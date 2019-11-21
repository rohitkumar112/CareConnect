package com.example.careconnect;

public class userdepartmentmodel {
    private int id,departmentid;
    private String deparatmentname;
public userdepartmentmodel( int departmentidid, String departmentname)
{
    this.id=id;
    this.departmentid=departmentidid;
    this.deparatmentname=departmentname;
}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

public String getDeparatmentname()
{
    return  deparatmentname;
}
    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }
}

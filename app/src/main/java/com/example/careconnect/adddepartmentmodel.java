package com.example.careconnect;

public class adddepartmentmodel {
    private int id;
    private String name;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public adddepartmentmodel(int id,String name)
    {
        this.name=name;
        this.id=id;
    }
    public adddepartmentmodel()
    {

    }
}

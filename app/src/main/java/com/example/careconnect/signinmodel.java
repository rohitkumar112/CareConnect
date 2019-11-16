package com.example.careconnect;

class signinmodel {
    private String name,email,phonenumber,bloodgroup;
    private String pass;

    public signinmodel(String sname, String semail, String spass, String sphonenumber, String sbloodgroup) {
    this.name=sname;
    this.pass=spass;
    this.phonenumber=sphonenumber;
    this.bloodgroup=sbloodgroup;
    this.email=semail;
    }

    public String getName()
    {
        return name;
    }
    public String getPass()
    {
        return pass;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }

    public String getBloodgroup()
    {
        return bloodgroup;
    }


}

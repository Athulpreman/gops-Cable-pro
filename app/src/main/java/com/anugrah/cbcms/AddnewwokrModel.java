package com.anugrah.cbcms;

public class AddnewwokrModel {
    String Wname,Waddress,Wphone,Wemail,Wwrkrid,Wdesignation,Wpass;

    public AddnewwokrModel()
    {
        Wpass="0000";
    }

    public AddnewwokrModel(String wname, String waddress, String wphone, String wemail, String wwrkrid, String wdesignation, String wpass) {
        Wname = wname;
        Waddress = waddress;
        Wphone = wphone;
        Wemail = wemail;
        Wwrkrid = wwrkrid;
        Wdesignation = wdesignation;
        Wpass = wpass;
    }

    public String getWname() {
        return Wname;
    }

    public void setWname(String wname) {
        Wname = wname;
    }

    public String getWaddress() {
        return Waddress;
    }

    public void setWaddress(String waddress) {
        Waddress = waddress;
    }

    public String getWphone() {
        return Wphone;
    }

    public void setWphone(String wphone) {
        Wphone = wphone;
    }

    public String getWemail() {
        return Wemail;
    }

    public void setWemail(String wemail) {
        Wemail = wemail;
    }

    public String getWwrkrid() {
        return Wwrkrid;
    }

    public void setWwrkrid(String wwrkrid) {
        Wwrkrid = wwrkrid;
    }

    public String getWdesignation() {
        return Wdesignation;
    }

    public void setWdesignation(String wdesignation) {
        Wdesignation = wdesignation;
    }

    public String getWpass() {
        return Wpass;
    }

    public void setWpass(String wpass) {
        Wpass = wpass;
    }
}

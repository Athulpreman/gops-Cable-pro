package com.anugrah.cbcms;

public class AddnewusrModel {
    String Uname, Uaddress, Uphone, Uemail, Uconsno, Usectnboxno, Uarea, Upass;

    public AddnewusrModel() {
        Upass = "0000";
    }

    public AddnewusrModel(String uname, String uaddress, String uphone, String uemail, String uconsno, String usectnboxno, String uarea, String upass) {
        Uname = uname;
        Uaddress = uaddress;
        Uphone = uphone;
        Uemail = uemail;
        Uconsno = uconsno;
        Usectnboxno = usectnboxno;
        Uarea = uarea;
        Upass = upass;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUaddress() {
        return Uaddress;
    }

    public void setUaddress(String uaddress) {
        Uaddress = uaddress;
    }

    public String getUphone() {
        return Uphone;
    }

    public void setUphone(String uphone) {
        Uphone = uphone;
    }

    public String getUemail() {
        return Uemail;
    }

    public void setUemail(String uemail) {
        Uemail = uemail;
    }

    public String getUconsno() {
        return Uconsno;
    }

    public void setUconsno(String uconsno) {
        Uconsno = uconsno;
    }

    public String getUsectnboxno() {
        return Usectnboxno;
    }

    public void setUsectnboxno(String usectnboxno) {
        Usectnboxno = usectnboxno;
    }

    public String getUarea() {
        return Uarea;
    }

    public void setUarea(String uarea) {
        Uarea = uarea;
    }

    public String getUpass() {
        return Upass;
    }

    public void setUpass(String upass) {
        Upass = upass;
    }
}
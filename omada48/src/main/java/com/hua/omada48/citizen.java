package com.hua.omada48;

//citizen role
public class citizen extends user{
    private String name;
    private String afm;
    private String address;
    private String dounemp; //date of unemployement

    public void setName(String name) {
        this.name = name;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDounemp(String dounemp) {
        this.dounemp = dounemp;
    }

    public String getName() {
        return name;
    }

    public String getAfm() {
        return afm;
    }

    public String getAddress() {
        return address;
    }

    public String getDounemp() {
        return dounemp;
    }

    public citizen() {

    }
}

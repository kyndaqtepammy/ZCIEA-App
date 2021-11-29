package com.pamsillah.zciea.models;

public class ModelRecords {
    public String memberid;
    public String membername;
    public String trade;
    public String territory;
    public String age;
    public String gender;

    public ModelRecords(String memberid, String membername, String trade, String territory, String age, String gender) {
        this.memberid = memberid;
        this.membername = membername;
        this.trade = trade;
        this.territory = territory;
        this.age = age;
        this.gender = gender;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

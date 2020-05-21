package com.example.firebaselistexample;

public class User {

    private String profile;
    //firebase에서 데이터를 가져올때 url 주소로 가져옴 -> 바로 이미지 저장하기 위해
    private String id;
    private int pw;
    private String userName;

    public User(){


    }
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPw() {
        return pw;
    }

    public void setPw(int pw) {
        this.pw = pw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }




}

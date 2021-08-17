package com.example.project1;

public class Mentor {

    private int image;
    private String name;
    private String spec;
    private String intro;

    public Mentor(String name) {
        this.name = name;
        // this.spec = "스펙이 없습니다.";
        // this.spec = "설명이 없습니다.";
    }

    public void setImage(int image) {
        this.image = image;
    }
    public int getImage() {
        return this.image;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
    public String getSpec() {
        return this.spec;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
    public String getIntro() {
        return this.intro;
    }

}

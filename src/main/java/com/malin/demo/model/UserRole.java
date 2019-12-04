package com.malin.demo.model;

public class UserRole {
    private Long uid;

    private Long rid;

    public UserRole(Long uid, Long rid) {
        this.uid = uid;
        this.rid = rid;
    }

    public UserRole() {
        super();
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
}
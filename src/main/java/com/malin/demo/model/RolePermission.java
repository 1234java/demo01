package com.malin.demo.model;

public class RolePermission {
    private Long rid;

    private Long pid;

    public RolePermission(Long rid, Long pid) {
        this.rid = rid;
        this.pid = pid;
    }

    public RolePermission() {
        super();
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
package com.jk.model;

import java.io.Serializable;

public class Role implements Serializable {

    private static final long serialVersionUID = -7425204913966336944L;
    private Integer rid;
    private String rname;

    private String status;


    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getRid() {
        return rid;
    }
    public void setRid(Integer rid) {
        this.rid = rid;
    }
    public String getRname() {
        return rname;
    }
    public void setRname(String rname) {
        this.rname = rname;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Role [rid=" + rid + ", rname=" + rname + "]";
    }


}

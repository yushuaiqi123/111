package com.jk.model;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -7267272424958537936L;
    private Integer id;

    private String name;

    private String passWord;

    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }

}

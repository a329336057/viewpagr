package com.example.administrator.imagetest.Info;

import java.io.Serializable;

public class PersionInfo implements Serializable {
    public PersionInfo(String getnamestr){
        namestr=getnamestr;
    }
    public String getNamestr() {
        return namestr;
    }

    public void setNamestr(String namestr) {
        this.namestr = namestr;
    }

    public boolean isChick() {
        return chick;
    }

    public void setChick(boolean chick) {
        this.chick = chick;
    }

    private String namestr;
    private boolean chick;//标识
}

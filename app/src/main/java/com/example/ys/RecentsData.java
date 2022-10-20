package com.example.ys;

public class RecentsData {
    String ed;
    String te;
    int id;

    public RecentsData(String ed, int id, String te) {
        this.ed = ed;
        this.te=te;
        this.id = id;
    }
    public String getEd() {
        return ed;
    }

    public void setEd(String ed) {
        this.ed = ed;
    }

    public String getTe() {
        return te;
    }

    public void setTe(String te) {
        this.te = te;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

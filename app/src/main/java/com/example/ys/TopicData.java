package com.example.ys;

public class TopicData {
    String describe;
    int idd;
      public TopicData(String describe, int idd){
          this.describe=describe;
          this.idd=idd;
      }
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
    public int getIdd() {
        return idd;
    }
    public void setIdd(int idd) {
        this.idd = idd;
    }
}

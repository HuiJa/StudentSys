package org.studentSys.dto;

import java.util.ArrayList;

public class CacheEntry {
    private ArrayList<Object> arrayList;

    public CacheEntry(ArrayList<Object> arrayList) {
        this.arrayList = arrayList;
    }

    public ArrayList<Object> getarrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Object> arrayList) {
        this.arrayList = arrayList;
    }
}

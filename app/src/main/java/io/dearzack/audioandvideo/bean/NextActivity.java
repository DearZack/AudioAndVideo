package io.dearzack.audioandvideo.bean;

public class NextActivity {
    private String name;
    private Class next;

    public NextActivity(String name, Class next) {
        this.name = name;
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getNext() {
        return next;
    }

    public void setNext(Class next) {
        this.next = next;
    }
}

package com.project.news.util;

public class JsonResponse2<T1,T2> {

    private T1 links;
    private T2 data;

    public T1 getLinks() {
        return links;
    }

    public void setlinks(T1 links) {
        this.links = links;
    }

    public T2 getData() {
        return data;
    }

    public void setData(T2 data) {
        this.data = data;
    }
}

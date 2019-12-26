package com.project.news.util;

public class Token {
    private static int id=0;

    private String token="3632e944-dd84-4f55-9241-06a2c527"+id++;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

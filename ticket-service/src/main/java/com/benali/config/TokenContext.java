package com.benali.config;



public class TokenContext {
    private ThreadLocal<String> token = new ThreadLocal<>();

    public void clear(){
        token.remove();
    }

    public String getToken(){
        return token.get();
    }

    public void setToken(String t){
        token.set(t);
    }

}

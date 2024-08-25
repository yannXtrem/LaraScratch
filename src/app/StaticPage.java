/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author yanni
 */
class StaticPage {
    private String name;
    private String method = "get";
    private boolean inMiddleware = false;
    private String middleware;
    private String group = "web";

    public StaticPage() {
    }

    public StaticPage(String name, String middleware) {
        this.name = name;
        this.middleware = middleware;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public boolean isInMiddleware() {
        return inMiddleware;
    }

    public void setInMiddleware(boolean inMiddleware) {
        this.inMiddleware = inMiddleware;
    }

    public String getMiddleware() {
        return middleware;
    }

    public void setMiddleware(String middleware) {
        this.middleware = middleware;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    
}

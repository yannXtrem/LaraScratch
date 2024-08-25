/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author yanni
 */
class Route {
    private String name;
    private String methode;
    private boolean inMiddlewareGroup = false;
    private String modelName;
    private String group;

    public Route(String name, String methode, String modelName, String group) {
        this.name = name;
        this.methode = methode;
        this.modelName = modelName;
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethode() {
        return methode;
    }

    public void setMethode(String methode) {
        this.methode = methode;
    }

    public boolean isInMiddlewareGroup() {
        return inMiddlewareGroup;
    }

    public void setInMiddlewareGroup(boolean inMiddlewareGroup) {
        this.inMiddlewareGroup = inMiddlewareGroup;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}

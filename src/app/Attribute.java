/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author yanni
 */
public class Attribute {

    private String name;
    private String type;
    private boolean isReference = false;
    private String refModelName;
    private String refModelAttribute;

    public Attribute(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return  name + " : " + type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIsReference() {
        return isReference;
    }

    public void setIsReference(boolean isReference) {
        this.isReference = isReference;
    }

    public String getRefModelName() {
        return refModelName;
    }

    public void setRefModelName(String refModelName) {
        this.refModelName = refModelName;
    }

    public String getRefModelAttribute() {
        return refModelAttribute;
    }

    public void setRefModelAttribute(String refModelAttribute) {
        this.refModelAttribute = refModelAttribute;
    }

}

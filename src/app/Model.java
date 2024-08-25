/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yanni
 */
public class Model {

    private String name;
    private boolean hasController = true;
    private boolean hasViews = true;
    private boolean hasMigration = true;
    private boolean hasFactory = false;
    private List<Attribute> modelAttributes;

    @Override
    public String toString() {
        return  name;
    }

    public Model(String name) {
        this.name = name;
        modelAttributes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasController() {
        return hasController;
    }

    public void setHasController(boolean hasController) {
        this.hasController = hasController;
    }

    public boolean isHasViews() {
        return hasViews;
    }

    public void setHasViews(boolean hasViews) {
        this.hasViews = hasViews;
    }

    public boolean isHasMigration() {
        return hasMigration;
    }

    public void setHasMigration(boolean hasMigration) {
        this.hasMigration = hasMigration;
    }

    public boolean isHasFactory() {
        return hasFactory;
    }

    public void setHasFactory(boolean hasFactory) {
        this.hasFactory = hasFactory;
    }

    public List<Attribute> getModelAttributes() {
        return modelAttributes;
    }

    public void setModelAttributes(List<Attribute> modelAttributes) {
        this.modelAttributes = modelAttributes;
    }
    
    public void addModelAttribute(Attribute attribute){
        this.modelAttributes.add(attribute);
    }

}

package com.tcs.lendinglibrary.models;
import java.util.Map;

public interface MaterialCatalogInterface {
    void addMaterial(Material newMaterial);
    Map<String, Material> getMaterialMap();
    Material findMaterial (String title) throws MaterialNotFoundException;
    int getNumberOfMaterials();
    }

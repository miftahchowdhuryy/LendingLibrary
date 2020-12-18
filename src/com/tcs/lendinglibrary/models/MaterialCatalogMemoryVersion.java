package com.tcs.lendinglibrary.models;

import java.util.HashMap;
import java.util.Map;

public class MaterialCatalogMemoryVersion implements MaterialCatalogInterface {
    private  Map<String, Material> materialMap;

    public MaterialCatalogMemoryVersion() {
        materialMap = new HashMap<>();
    }

    public void addMaterial(Material newMaterial){
        materialMap.put(newMaterial.getId(), newMaterial);
    }

    public  Map<String, Material> getMaterialMap(){
        return materialMap;
    }

    public Material findMaterial(String title) throws MaterialNotFoundException {

        title = title.trim();

        for(Material nextBook : materialMap.values()){
            if(nextBook.getTitle().equalsIgnoreCase(title)) {
                return nextBook;
            }
        }
        throw new MaterialNotFoundException("Sorry! Material has not found. ");
    }

    public int getNumberOfMaterials(){
        return materialMap.size();
    }

}

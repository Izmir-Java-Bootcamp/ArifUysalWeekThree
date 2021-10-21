package com.example.homvork3v21.Categories;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainCategory extends Categories{
    private String mainName;
    private List<SubCategory> subCategoryList = new ArrayList<>();



    public MainCategory(String mainName) {
        this.mainName = mainName;
    }

    public void addCategory(SubCategory subCategory) {
        subCategoryList.add(subCategory);
    }
    public List<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

    @Override
    public String toString() {
        return  mainName + '\'';
    }
}


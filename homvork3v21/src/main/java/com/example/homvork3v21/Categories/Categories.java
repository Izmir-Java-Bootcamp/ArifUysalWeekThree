package com.example.homvork3v21.Categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor

public class Categories {
    private final List<MainCategory> mainCategoryList = new ArrayList<>();

    public void addCategory(MainCategory mainCategory) {
        mainCategoryList.add(mainCategory);
    }

    public List<MainCategory> getMainCategoryList() {
        return mainCategoryList;
    }

    @Override
    public String toString() {
        return "mainCategoryList=" + mainCategoryList +
                '}';
    }
}
package com.example.homvork3v21.Categories;


import com.example.homvork3v21.Models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory extends MainCategory {
    private String subName;
    private List<Product> productList=new ArrayList<>();

    public SubCategory(String mainName, String subName) {
        super(mainName);
        this.subName = subName;
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return subName + '\'';

    }
}


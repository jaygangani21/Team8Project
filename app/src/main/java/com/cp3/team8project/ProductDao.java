package com.cp3.team8project;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
 interface ProductDao  {
    public static final String TABLE_NAME = "product_table";
        @Insert
        Completable insertProduct(Product product);

        @Query("select * From product_table")
        Single<List<Product>> getProducts();

        @Query("SELECT * FROM product_table WHERE category_id = :catID")
        Single<List<Product>> getProductCat(int catID);

        @Query("SELECT * FROM product_table WHERE id = :ID")
        Single<List<Product>> getProductID(int ID);

        @Query("SELECT * FROM product_table WHERE name LIKE '%' || :searchQ || '%' ")
        Single<List<Product>> getProductName(String searchQ);

        @Query("DELETE FROM product_table WHERE id = :prodid")

        Completable delete (int prodid);


       @Entity(tableName = TABLE_NAME)
        class product {
//              public static final String TABLE_NAME = "product";
           @PrimaryKey (autoGenerate = true)
              private int id;

              private String p_name;
              private String p_price;
              private String p_description_price;
              private String p_specs;
              private String p_image1;

       }




}

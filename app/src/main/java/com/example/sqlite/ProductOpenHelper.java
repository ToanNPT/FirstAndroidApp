package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myfirstproject.Product;
import com.example.sqlite.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ProductOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ProductManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Product";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_INSTOCK = "inStock";

    public ProductOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql_query = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER)", TABLE_NAME, KEY_ID, KEY_NAME, KEY_INSTOCK);
        sqLiteDatabase.execSQL(sql_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        sqLiteDatabase.execSQL(drop_students_table);

        onCreate(sqLiteDatabase);
    }

    public void onInsertProduct(ProductModel product) {
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            ContentValues values = new ContentValues();
            values.put(KEY_ID, product.getId());
            values.put(KEY_NAME, product.getName());
            values.put(KEY_INSTOCK, product.getInStock());

            db.insert(TABLE_NAME, null, values);
        }catch(SQLiteException e){
            throw e;
        }finally {
            db.close();
        }
    }

    public void onDeleteProduct(ProductModel product){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, KEY_ID + " = ?", new String[] { String.valueOf(product.getId()) });
        db.close();
    }

    public int onUpdateProduct(ProductModel product){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.getName());
        values.put(KEY_INSTOCK, product.getInStock());

        return db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{String.valueOf(product.getId())});
    }

    public List<ProductModel> onGetAllProduct(){
        SQLiteDatabase db = this.getWritableDatabase();
        List<ProductModel> listProduct = new ArrayList<ProductModel>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ProductModel product = new ProductModel();
                product.setId(Integer.parseInt(cursor.getString(0)));
                product.setName(cursor.getString(1));
                product.setInStock(Integer.parseInt(cursor.getString(2)));

                listProduct.add(product);
            } while (cursor.moveToNext());
        }

        return listProduct;
    }
}

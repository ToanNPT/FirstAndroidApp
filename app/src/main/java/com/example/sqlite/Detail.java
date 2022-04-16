package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfirstproject.LoginHandler;
import com.example.myfirstproject.R;

import java.sql.SQLException;

public class Detail extends AppCompatActivity {
    EditText txtId;
    EditText txtName;
    EditText txtInStock;
    ProductOpenHelper helper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        helper = new ProductOpenHelper(this);
        txtId = findViewById(R.id.txtIdproductmodel);
        txtName = findViewById(R.id.txtNameproductmodel);
        txtInStock = findViewById(R.id.txtInStockProductmodel);

        Intent intent = getIntent();
        String id = intent.getStringExtra(sqlite.ID);
        String name = intent.getStringExtra(sqlite.NAME);
        String instock = intent.getStringExtra(sqlite.INSTOCK);

        txtId.setText(id);
        txtName.setText(name);
        txtInStock.setText(instock);
    }

    public void onAdd(View view){
        int id = Integer.parseInt(txtId.getText().toString()) ;
        String name = txtName.getText().toString();
        int instock =Integer.parseInt(txtInStock.getText().toString()) ;

        ProductModel p = new ProductModel(id, name, instock);
        try{
            helper.onInsertProduct(p);
            Toast.makeText(this," Success", Toast.LENGTH_SHORT).show();
            Intent back = new Intent(this, sqlite.class);
            finish();
            startActivity(back);
        }catch(SQLiteException e){
            txtId.setText("");
            txtName.setText("");
            txtInStock.setText("");
            Toast.makeText(this," Fail to add new product", Toast.LENGTH_SHORT).show();
        }
    }

    public void onUpdate(View view){
        int id = Integer.parseInt(txtId.getText().toString()) ;
        String name = txtName.getText().toString();
        int instock =Integer.parseInt(txtInStock.getText().toString()) ;

        ProductModel p = new ProductModel(id, name, instock);
        try{
            helper.onUpdateProduct(p);
            Toast.makeText(this," Success", Toast.LENGTH_SHORT).show();
            Intent back = new Intent(this, sqlite.class);
            finish();
            startActivity(back);
        }catch(Exception e){
            txtId.setText("");
            txtName.setText("");
            txtInStock.setText("");
            Toast.makeText(this," Fail to add new product", Toast.LENGTH_SHORT).show();
        }
    }

    public void onDelete(View view){
        int id = Integer.parseInt(txtId.getText().toString()) ;
        String name = txtName.getText().toString();
        int instock =Integer.parseInt(txtInStock.getText().toString()) ;

        ProductModel p = new ProductModel(id, name, instock);
        try{
            helper.onDeleteProduct(p);
            Toast.makeText(this," Success", Toast.LENGTH_SHORT).show();
            Intent back = new Intent(this, sqlite.class);
            finish();
            startActivity(back);
        }catch(Exception e){
            txtId.setText("");
            txtName.setText("");
            txtInStock.setText("");
            Toast.makeText(this," Fail to add new product", Toast.LENGTH_SHORT).show();
        }
    }

}
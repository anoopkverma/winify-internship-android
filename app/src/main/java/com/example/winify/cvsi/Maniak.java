package com.example.winify.cvsi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.dto.templates.ProductTemplate;


import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;


public class Maniak extends AppCompatActivity {

    public static ListDto<ProductTemplate> listdto = new ListDto<ProductTemplate>();
    private ProductController productController;
    TextView textView;
    Button button;
    boolean i = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maniak);
        textView = (TextView) findViewById(R.id.hz_tv);

        assert textView != null;

        productController = new ProductController();
        EventBus.getDefault().register(this);
        productController.getProductDTO();

        button = (Button) findViewById(R.id.button_test);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TestBaseActivity.class));
//            }
//        });

//        textView.setText(listdto.getList().get(0).getTitle());

    }

    @Subscribe
    public void onGetProductDTOEvent(ListDto<ProductTemplate> event) {
        Toast.makeText(Maniak.this, "ceva" + event.getList().get(0).getTitle(), Toast.LENGTH_SHORT).show();
        listdto = event;

        System.out.println();
    }

}

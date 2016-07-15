package com.example.winify.cvsi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.dto.templates.ProductTemplate;

import de.greenrobot.event.Subscribe;

public class TestBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_base);

        Maniak maniak = new Maniak();
        for (ProductTemplate productTemplate : maniak.listdto.getList()) {
            Log.i("GAT", productTemplate.getTitle());
        }
    }

    @Subscribe
    public void onGetProductDTOEvent(ListDto<ProductTemplate> event) {

    }
}

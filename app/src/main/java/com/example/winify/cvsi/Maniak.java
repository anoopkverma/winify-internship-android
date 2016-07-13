package com.example.winify.cvsi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.TextView;
import android.widget.Toast;

import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.dto.templates.ProductTemplate;


import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;


public class Maniak extends AppCompatActivity {

    private ListDto<ProductTemplate> listdto = new ListDto<ProductTemplate>();
    private ServiceManager serviceManager;
    TextView textView;
    boolean i = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maniak);
        textView = (TextView) findViewById(R.id.hz_tv);

        assert textView != null;

        serviceManager = new ServiceManager();
        EventBus.getDefault().register(this);
        serviceManager.getProductDTO();


//        textView.setText(listdto.getList().get(0).getTitle());

    }

    @Subscribe
    public void onGetProductDTOEvent(ListDto<ProductTemplate> event) {
        Toast.makeText(Maniak.this, "ceva" + event.getList().get(0).getTitle(), Toast.LENGTH_SHORT).show();
        listdto = event;

        System.out.println();
    }

    @Override
    public void onResume() {
        super.onResume();
        textView.setText(listdto.getList().get(0).getTitle());
    }

}

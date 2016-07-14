package com.example.winify.cvsi.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.winify.cvsi.controllers.ProductController;
import com.example.winify.cvsi.R;
import com.example.winify.cvsi.dto.ListDto;
import com.example.winify.cvsi.dto.templates.ProductTemplate;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

public class WelcomeActivity extends AppCompatActivity {

    private static Button sloginButton;
    private static Button sItemsListButton;
    private ProductController productController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        sloginButton = (Button) findViewById(R.id.go_to_login_button);
        sItemsListButton = (Button) findViewById(R.id.go_to_list_view_button);

        productController = new ProductController();
        EventBus.getDefault().register(this);
        productController.getProductDTO();
    }

    @Subscribe
    public void onGetProductDTOEvent(ListDto<ProductTemplate> event) {
        Toast.makeText(this, "ceva" + event.getList().get(0).getTitle(), Toast.LENGTH_SHORT).show();
//        event;
//        for (int i = 0; i < allPosts.size(); i++) {
//            allPosts.get(i).setTitle(event.getList().get(i).getTitle());
//        }
    }

    public void onSLoginButtonClicked(View view) {

        Intent getLoginIntent = new Intent(this, LoginActivity.class) ;
        final int result = 1;

        getLoginIntent.putExtra("callingActivity", "WelcomeActivity");
        startActivityForResult(getLoginIntent, result);
    }

    public void onSItemsListButtonClicked(View view) {
        Intent getLoginIntent = new Intent(this, ListItemsActivity.class) ;
        final int result = 1;

        getLoginIntent.putExtra("callingActivity", "ListItemsActivity");
        startActivityForResult(getLoginIntent, result);
    }
}

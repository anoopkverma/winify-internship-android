package com.example.winify.cvsi.activities;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.winify.cvsi.R;
import com.example.winify.cvsi.controllers.ProductController;
import com.example.winify.cvsi.controllers.SessionManager;
import com.example.winify.cvsi.interfaces.IRetrofit;
import com.example.winify.cvsi.model.Product;
import com.example.winify.cvsi.utils.NavigationDrawer;
import com.github.clans.fab.FloatingActionButton;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CreateSellProductActivity extends CreateProduct implements View.OnClickListener{

    private Button cancelButton;
    private Button createButton;
    private static int RESULT_LOAD_IMAGE = 1;
    private static final int PERMISSION_REQUEST_CODE = 12;
    private String fPath;
    private View view;
    private Context context;
    private Uri uri;
    private ProductController productController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_sell_product);
        productController = new ProductController(getApplicationContext(), new SessionManager(getApplicationContext()).getToken());
        this.context = getApplicationContext();
        this.nabDrawer = new NavigationDrawer(this);
        nabDrawer.buildDrawer(this, R.drawable.nina, savedInstanceState, "diana", "Cosinzeana", this.toolbar);
        imageView = (ImageView) findViewById(R.id.image_view);
        this.initToolbar("Create sell product");
        initSpinner();
        initFloatingActionButtonAddImage();

        cancelButton = (Button) findViewById(R.id.cancel_prod_creation_button_sell);
        createButton = (Button) findViewById(R.id.create_product_button_sell);
        cancelButton.setOnClickListener(this);
        createButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        view = v;
        int id = v.getId();
        switch (id){
            case R.id.cancel_prod_creation_button_sell:
                if (checkPermission()) {
                    Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(i, RESULT_LOAD_IMAGE);

                } else {
                    requestPermission();
                    Snackbar.make(view,"Please request permission.",Snackbar.LENGTH_LONG).show();
                }
                break;
            case R.id.create_product_button_sell:
                productController.postImage(fPath, uri);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            this.uri = data.getData();
            this.fPath = getFilePath(uri);
        }
    }

    public String getFilePath(Uri selectedImage) {
        String[] filePathColumn = { MediaStore.Images.Media.DATA };

        Cursor cursor = getContentResolver().query(selectedImage,
                filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        Log.i("CreateSellProduct", "Picture Path: " + picturePath);
        cursor.close();
        return picturePath;
    }


    private boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){
            Toast.makeText(context,"GPS permission allows us to access location data. Please allow in App Settings for additional functionality.",Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Snackbar.make(view,"Permission Granted, Now you can access location data.",Snackbar.LENGTH_LONG).show();

                } else {

                    Snackbar.make(view,"Permission Denied, You cannot access location data.",Snackbar.LENGTH_LONG).show();

                }
                break;
        }
    }
}


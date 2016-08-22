package com.example.winify.cvsi.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.winify.cvsi.R;
import com.github.clans.fab.FloatingActionButton;

/**
 * Created by diana on 8/1/16.
 */
public class CreateProduct extends ToolbarActivity {

    ImageView imageView;
    FloatingActionButton addImageFAB;
    private static final int PICK_IMAGE = 100;
    private static final int REQUEST_PERMISSIONS = 20;
    Uri imageUri;

    public void initFloatingActionButtonAddImage() {
        addImageFAB = (FloatingActionButton) findViewById(R.id.fab_add_image);
        addImageFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }

    public void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode ==  PICK_IMAGE) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }

    public void initSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.currency_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        assert spinner != null;
        spinner.setAdapter(adapter);
    }
}

package com.example.winify.cvsi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.winify.cvsi.R;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class BaseActivity extends AppCompatActivity {

    private static Drawer drawer;
    private IProfile profile;
    private Bundle savendInstanceState1;
    private AccountHeader headerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savendInstanceState1 = savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_base);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen()) {
            drawer.closeDrawer();

        } else {
            super.onBackPressed();
        }
    }

    public void initBuilder() {

        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withCompactStyle(false)
                .withHeaderBackground(R.drawable.header1)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com").withIcon(getResources().getDrawable(R.drawable.nina))
                )
                .withSavedInstance(savendInstanceState1)
                .build();

        PrimaryDrawerItem home = new PrimaryDrawerItem().withIcon(GoogleMaterial.Icon.gmd_home).withIdentifier(1).withName(R.string.drawer_item_home);
        PrimaryDrawerItem settings = new PrimaryDrawerItem().withIcon(GoogleMaterial.Icon.gmd_settings).withIdentifier(1).withName(R.string.drawer_item_settings);
        PrimaryDrawerItem about = new PrimaryDrawerItem().withIcon(GoogleMaterial.Icon.gmd_info).withIdentifier(1).withName(R.string.drawer_item_info);
        PrimaryDrawerItem logout = new PrimaryDrawerItem().withIcon(GoogleMaterial.Icon.gmd_exit_to_app).withIdentifier(1).withName(R.string.drawer_item_logout);

        SecondaryDrawerItem item2 = (SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(2).withName(R.string.drawer_item_settings);

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
//                .withToolbar(toolbar)
                .addDrawerItems(
                        home,
                        new DividerDrawerItem(),
                        settings,
                        new DividerDrawerItem(),
                        about,
                        new DividerDrawerItem(),
                        logout,
                        new DividerDrawerItem(),
                        item2,
                        new SecondaryDrawerItem().withName(R.string.drawer_item_settings)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        Toast.makeText(BaseActivity.this, "oand" + String.valueOf(position), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                })
                .build();
    }

    public void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Create a Borrow product");
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

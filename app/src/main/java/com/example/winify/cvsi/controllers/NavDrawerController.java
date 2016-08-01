package com.example.winify.cvsi.controllers;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.winify.cvsi.R;
import com.example.winify.cvsi.activities.BaseActivity;
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

/**
 * Created by diana on 8/1/16.
 */
public class NavDrawerController {

    private Drawer drawer;
    private AccountHeader headerResult;

    public Drawer getDrawer() {
        return drawer;
    }

    public void initBuilder(Activity activity, int resourceId, Bundle savendInstanceState1) {
        headerResult = new AccountHeaderBuilder()
                .withActivity(activity)
                .withCompactStyle(false)
                .withHeaderBackground(R.drawable.header1)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com").withIcon(resourceId)
                )
                .withSavedInstance(savendInstanceState1)
                .build();
        initDrawer(activity);
    }

    public void initDrawer(Activity someActivity) {
        PrimaryDrawerItem home = new PrimaryDrawerItem().withIcon(GoogleMaterial.Icon.gmd_home).withIdentifier(1).withName(R.string.drawer_item_home);
        PrimaryDrawerItem settings = new PrimaryDrawerItem().withIcon(GoogleMaterial.Icon.gmd_settings).withIdentifier(1).withName(R.string.drawer_item_settings);
        PrimaryDrawerItem about = new PrimaryDrawerItem().withIcon(GoogleMaterial.Icon.gmd_info).withIdentifier(1).withName(R.string.drawer_item_info);
        PrimaryDrawerItem logout = new PrimaryDrawerItem().withIcon(GoogleMaterial.Icon.gmd_exit_to_app).withIdentifier(1).withName(R.string.drawer_item_logout);

        SecondaryDrawerItem item2 = (SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(2).withName(R.string.drawer_item_settings);
        drawer = new DrawerBuilder()
                .withActivity(someActivity)
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
//                        Toast.makeText(getContext(), "oand" + String.valueOf(position), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                })
                .build();
    }
}

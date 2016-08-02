package com.example.winify.cvsi.utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

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

/**
 * Created by diana on 8/2/16.
 */
public class NavigationDrawer {

    public Drawer drawer;
    private PrimaryDrawerItem home;
    private PrimaryDrawerItem settings;
    private PrimaryDrawerItem about;
    private PrimaryDrawerItem logout;
    private SecondaryDrawerItem item2;
    private AccountHeader headerResult;



    public NavigationDrawer(Activity activity) {
        new DrawerBuilder().withActivity(activity).build();
    }

    public void initDrawerItems(Activity activity) {
        this.home = new PrimaryDrawerItem().withIcon(GoogleMaterial.Icon.gmd_home).withIdentifier(1).withName(R.string.drawer_item_home);
        this.settings = new PrimaryDrawerItem().withIcon(GoogleMaterial.Icon.gmd_settings).withIdentifier(1).withName(R.string.drawer_item_settings);
        this.about = new PrimaryDrawerItem().withIcon(GoogleMaterial.Icon.gmd_info).withIdentifier(1).withName(R.string.drawer_item_info);
        this.logout = new PrimaryDrawerItem().withIcon(GoogleMaterial.Icon.gmd_exit_to_app).withIdentifier(1).withName(R.string.drawer_item_logout);
        this.item2 = (SecondaryDrawerItem) new SecondaryDrawerItem().withIdentifier(2).withName(R.string.drawer_item_settings);
    }

    public void buildDrawer(Activity activity, int resourceId, Bundle savendInstanceState1, String name, String email) {
        initDrawerItems(activity);
        addAccountHeader(activity,resourceId, savendInstanceState1, name, email );
        setDrawerProperties(activity);
    }

    public void setDrawerProperties(Activity activity) {
        drawer = new DrawerBuilder()
                .withActivity(activity)
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

    private void addAccountHeader(Activity activity, int resourceId, Bundle savendInstanceState1, String name, String email) {
        // Create the AccountHeader
        headerResult = new AccountHeaderBuilder()
                .withActivity(activity)
                .withCompactStyle(false)
                .withHeaderBackground(R.drawable.header1)
                .addProfiles(
                        new ProfileDrawerItem().withName(name).withEmail(email).withIcon(resourceId)
                )
                .withSavedInstance(savendInstanceState1)
                .build();

    }

//    public void updateProfileInfo(String email, String name) {
//        headerResu
//        headerResult.getActiveProfile().withEmail(email);
//    }

    public Drawer getDrawer() {
        return this.drawer;
    }
}

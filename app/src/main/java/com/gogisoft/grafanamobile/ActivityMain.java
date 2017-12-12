package com.gogisoft.grafanamobile;

import com.gogisoft.grafanamobile.fragments.DashboardsList;

import android.app.Activity;
import android.os.Bundle;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;
import it.neokree.materialnavigationdrawer.elements.MaterialSection;


public class ActivityMain extends MaterialNavigationDrawer {

    @Override
    public void init(Bundle savedInstanceState) {
        MaterialNavigationDrawer mnd = (MaterialNavigationDrawer)this;
        Activity activity = (Activity)this;

        MaterialSection<DashboardsList> section = mnd.newSection(
            "All Dashboards",
            new DashboardsList()
        );

        mnd.addSection(section);
    }
}

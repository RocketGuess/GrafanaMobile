package com.gogisoft.grafanamobile.panels;

import java.util.List;

import com.gogisoft.grafanamobile.R;
import com.gogisoft.grafanamobile.api_client.models.Panel;
import com.gogisoft.grafanamobile.panels.TargetWrapper;
import com.gogisoft.grafanamobile.datasources.Series;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PanelUnavailable extends PanelContent {
    public PanelUnavailable(Panel panel, ViewGroup group, LayoutInflater inflater) {
        super(panel, group, R.layout.panel_unsupported, inflater);
    }

    @Override
    protected void drawPanel(View view, Panel panel) {
    }

    @Override
    protected void drawTarget(View view, TargetWrapper target, List<Series> series) {
    }
}

package com.example.btsettings;

import android.view.View;
import android.widget.AdapterView;

public interface SettingsActivityabc {
    void onItemSelected(AdapterView<?> parent, View view, int position, long id);

    void onNothingSelected(AdapterView<?> parent);
}

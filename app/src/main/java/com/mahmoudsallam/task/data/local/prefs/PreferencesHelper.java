
package com.mahmoudsallam.task.data.local.prefs;

import com.mahmoudsallam.task.data.DataManager;

public interface PreferencesHelper {

    void setIsFirstTime(String firstTime);

    String getIsFirstTime();
}

package com.playlistapp.data.settings;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Settings class for working with shared preferences.
 */
@Singleton
public class AppSettingsHelper implements IAppSettingsHelper {

    private HashMap<Class<?>, BaseSettings> components = null;

    @Inject
    public AppSettingsHelper(AppPreferences prefs) {
        initializeComponents(prefs);
    }

    @Override
    public GeneralSettings general() {
        return (GeneralSettings)components.get(GeneralSettings.class);
    }

    @Override
    public ProfileSettings profile() {
        return (ProfileSettings)components.get(ProfileSettings.class);
    }

    @Override
    public SearchSettings search() {
        return (SearchSettings )components.get(SearchSettings.class);
    }

    @Override
    public CitySettings city() {
        return (CitySettings)components.get(CitySettings.class);
    }

    private void initializeComponents(AppPreferences prefs) {
        components = new HashMap<>();
        components.put(GeneralSettings.class, new GeneralSettings(prefs));
        components.put(ProfileSettings.class, new ProfileSettings(prefs));
        components.put(SearchSettings.class, new SearchSettings(prefs));
        components.put(CitySettings.class, new CitySettings(prefs));
    }
}

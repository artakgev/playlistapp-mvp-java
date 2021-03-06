package com.playlistapp.data;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.playlistapp.data.db.IDbHelper;
import com.playlistapp.data.network.api.ApiHelper;
import com.playlistapp.data.network.data.track.TrackItem;
import com.playlistapp.data.network.data.track.TrackResData;
import com.playlistapp.data.settings.IAppSettingsHelper;

import java.util.List;

import io.reactivex.Observable;

public interface IDataManager {

    ApiHelper getApiHelper();

    IAppSettingsHelper getSettingsHelper();

    IDbHelper getDbHelper();

    Observable<TrackResData> doTracksApiCall(@NonNull String country,
                                             @Nullable Integer limit,
                                             @Nullable Integer page);

    Observable<List<TrackItem>> getAllTracks();

    Observable<Boolean> updateTrack(TrackItem trackItem, boolean remove);

    Observable<Boolean> saveTrackList(List<TrackItem> trackItems);

    void setUserAsLoggedOut();


    void setCurrentUserLoggedInMode(LoggedInMode loggedInMode);

    void setUserId(int userId);

    void setAuthToken(String authToken);

    boolean isUserRegistered();

    boolean isUserRegisterCompleted();

    void setRegisterCompleted(boolean isRegisterCompleted);

    void setRegisterKey(String key);

    int getCurrentUserLoggedInMode();


    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}

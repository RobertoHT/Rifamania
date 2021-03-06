package edu.galileo.android.rifamania;

import android.app.Application;
import android.content.Intent;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.raizlabs.android.dbflow.config.FlowManager;

import edu.galileo.android.rifamania.libs.di.LibsModule;
import edu.galileo.android.rifamania.login.ui.LoginActivity;
import edu.galileo.android.rifamania.rifalistitem.adapters.OnItemListClickListener;
import edu.galileo.android.rifamania.rifalistitem.di.DaggerRifaListItemComponent;
import edu.galileo.android.rifamania.rifalistitem.di.RifaListItemComponent;
import edu.galileo.android.rifamania.rifalistitem.di.RifaListItemModule;
import edu.galileo.android.rifamania.rifalistitem.ui.RifaListItemActivity;
import edu.galileo.android.rifamania.rifalistitem.ui.RifaListItemView;
import edu.galileo.android.rifamania.rifamain.adapters.OnItemCLickListener;
import edu.galileo.android.rifamania.rifamain.di.DaggerRifaMainComponent;
import edu.galileo.android.rifamania.rifamain.di.RifaMainComponent;
import edu.galileo.android.rifamania.rifamain.di.RifaMainModule;
import edu.galileo.android.rifamania.rifamain.ui.RifaMainActivity;
import edu.galileo.android.rifamania.rifamain.ui.RifaMainView;

/**
 * Created by praxis on 13/07/16.
 */
public class RifamaniaApp extends Application {
    public final static String NAME_KEY = "name";
    public final static String SHARED_PREFERENCES_NAME = "UserPrefs";

    @Override
    public void onCreate() {
        super.onCreate();
        initFacebook();
        initDB();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        FlowManager.destroy();
    }

    private void initDB() {
        FlowManager.init(this);
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(this);
    }

    public void logout(){
        LoginManager.getInstance().logOut();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public RifaMainComponent getRifaMainComponent(RifaMainActivity activity, RifaMainView view, OnItemCLickListener onItemCLickListener){
        return DaggerRifaMainComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .rifaMainModule(new RifaMainModule(view, onItemCLickListener))
                .build();
    }

    public RifaListItemComponent getRifaListItemComponent(RifaListItemActivity activity, RifaListItemView view, OnItemListClickListener onItemListClickListener){
        return DaggerRifaListItemComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .rifaListItemModule(new RifaListItemModule(view, onItemListClickListener))
                .build();
    }
}

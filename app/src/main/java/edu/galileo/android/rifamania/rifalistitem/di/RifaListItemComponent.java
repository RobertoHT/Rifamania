package edu.galileo.android.rifamania.rifalistitem.di;

import javax.inject.Singleton;

import dagger.Component;
import edu.galileo.android.rifamania.libs.di.LibsModule;
import edu.galileo.android.rifamania.rifalistitem.RifaListItemPresenter;
import edu.galileo.android.rifamania.rifalistitem.adapters.RifaListAdapter;

/**
 * Created by Roberto Hdez. on 16/07/16.
 */
@Singleton
@Component(modules = {RifaListItemModule.class, LibsModule.class})
public interface RifaListItemComponent {
    RifaListAdapter getAdapter();
    RifaListItemPresenter getPresenter();
}

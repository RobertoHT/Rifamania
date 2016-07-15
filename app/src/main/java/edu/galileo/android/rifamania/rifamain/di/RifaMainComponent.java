package edu.galileo.android.rifamania.rifamain.di;

import javax.inject.Singleton;

import dagger.Component;
import edu.galileo.android.rifamania.libs.di.LibsModule;
import edu.galileo.android.rifamania.rifamain.RifaMainPresenter;
import edu.galileo.android.rifamania.rifamain.adapters.RifasAdapter;

/**
 * Created by Roberto Hdez. on 14/07/16.
 */
@Singleton
@Component(modules = {RifaMainModule.class, LibsModule.class})
public interface RifaMainComponent {
    RifasAdapter getAdapter();
    RifaMainPresenter getPresenter();
}

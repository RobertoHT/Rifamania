package edu.galileo.android.rifamania.rifamain.di;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.android.rifamania.entities.Rifa;
import edu.galileo.android.rifamania.libs.base.EventBus;
import edu.galileo.android.rifamania.rifamain.RifaMainInteractor;
import edu.galileo.android.rifamania.rifamain.RifaMainInteractorImpl;
import edu.galileo.android.rifamania.rifamain.RifaMainPresenter;
import edu.galileo.android.rifamania.rifamain.RifaMainPresenterImpl;
import edu.galileo.android.rifamania.rifamain.RifaMainRepository;
import edu.galileo.android.rifamania.rifamain.RifaMainRepositoryImpl;
import edu.galileo.android.rifamania.rifamain.adapters.OnItemCLickListener;
import edu.galileo.android.rifamania.rifamain.adapters.RifasAdapter;
import edu.galileo.android.rifamania.rifamain.ui.RifaMainView;

/**
 * Created by Roberto Hdez. on 14/07/16.
 */
@Module
public class RifaMainModule {
    RifaMainView view;
    OnItemCLickListener onItemCLickListener;

    public RifaMainModule(RifaMainView view, OnItemCLickListener onItemCLickListener) {
        this.view = view;
        this.onItemCLickListener = onItemCLickListener;
    }

    @Provides
    @Singleton
    RifaMainView providesRifaMainView(){
        return this.view;
    }

    @Provides
    @Singleton
    RifaMainPresenter providesRifaMainPresenter(EventBus eventBus, RifaMainView view, RifaMainInteractor interactor){
        return new RifaMainPresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    RifaMainInteractor providesRifaMainInteractor(RifaMainRepository repository){
        return new RifaMainInteractorImpl(repository);
    }

    @Provides
    @Singleton
    RifaMainRepository providesRifaMainRepository(EventBus eventBus){
        return new RifaMainRepositoryImpl(eventBus);
    }

    @Provides
    @Singleton
    RifasAdapter providesRifasAdapter(List<Rifa> rifaList, OnItemCLickListener onItemClickListener){
        return new RifasAdapter(rifaList, onItemClickListener);
    }

    @Provides
    @Singleton
    OnItemCLickListener providesOnItemCLickListener(){
        return this.onItemCLickListener;
    }

    @Provides
    @Singleton
    List<Rifa> providesEmptyList(){
        return new ArrayList<Rifa>();
    }
}

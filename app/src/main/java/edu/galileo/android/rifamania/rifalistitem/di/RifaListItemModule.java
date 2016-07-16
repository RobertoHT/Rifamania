package edu.galileo.android.rifamania.rifalistitem.di;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.android.rifamania.entities.ItemRifa;
import edu.galileo.android.rifamania.libs.base.EventBus;
import edu.galileo.android.rifamania.rifalistitem.RifaListItemInteractor;
import edu.galileo.android.rifamania.rifalistitem.RifaListItemInteractorImpl;
import edu.galileo.android.rifamania.rifalistitem.RifaListItemPresenter;
import edu.galileo.android.rifamania.rifalistitem.RifaListItemPresenterImpl;
import edu.galileo.android.rifamania.rifalistitem.RifaListItemRepository;
import edu.galileo.android.rifamania.rifalistitem.RifaListItemRepositoryImpl;
import edu.galileo.android.rifamania.rifalistitem.adapters.OnItemListClickListener;
import edu.galileo.android.rifamania.rifalistitem.adapters.RifaListAdapter;
import edu.galileo.android.rifamania.rifalistitem.ui.RifaListItemView;

/**
 * Created by Roberto Hdez. on 16/07/16.
 */
@Module
public class RifaListItemModule {
    RifaListItemView view;
    OnItemListClickListener onItemListClickListener;

    public RifaListItemModule(RifaListItemView view, OnItemListClickListener onItemListClickListener) {
        this.view = view;
        this.onItemListClickListener = onItemListClickListener;
    }

    @Provides
    @Singleton
    RifaListItemView providesRifaListItemView(){
        return this.view;
    }

    @Provides
    @Singleton
    RifaListItemPresenter providesRifaListItemPresenter(EventBus eventBus, RifaListItemView view, RifaListItemInteractor interactor){
        return new RifaListItemPresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    RifaListItemInteractor providesRifaListItemInteractor(RifaListItemRepository repository){
        return new RifaListItemInteractorImpl(repository);
    }

    @Provides
    @Singleton
    RifaListItemRepository providesRifaListItemRepository(EventBus eventBus){
        return new RifaListItemRepositoryImpl(eventBus);
    }

    @Provides
    @Singleton
    RifaListAdapter providesRifaListAdapter(List<ItemRifa> itemRifaList, OnItemListClickListener onItemListClickListener){
        return new RifaListAdapter(itemRifaList, onItemListClickListener);
    }

    @Provides
    @Singleton
    OnItemListClickListener providesOnItemListClickListener(){
        return this.onItemListClickListener;
    }

    @Provides
    @Singleton
    List<ItemRifa> providesEmptyList(){
        return new ArrayList<ItemRifa>();
    }
}

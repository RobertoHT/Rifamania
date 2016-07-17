package edu.galileo.android.rifamania.rifalistitem;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.rifamania.entities.ItemRifa;
import edu.galileo.android.rifamania.libs.base.EventBus;
import edu.galileo.android.rifamania.rifalistitem.events.RifaListItemEvent;
import edu.galileo.android.rifamania.rifalistitem.ui.RifaListItemView;

/**
 * Created by Roberto Hdez. on 16/07/16.
 */

public class RifaListItemPresenterImpl implements RifaListItemPresenter {
    private EventBus eventBus;
    private RifaListItemView view;
    private RifaListItemInteractor interactor;

    public RifaListItemPresenterImpl(EventBus eventBus, RifaListItemView view, RifaListItemInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        view = null;
    }

    @Override
    public void getItemsRifa(int id) {
        interactor.getItemsRifa(id);
    }

    @Override
    public void saveItemRifa(ItemRifa itemRifa) {
        interactor.saveItemRifa(itemRifa);
    }

    @Override
    public void updateItemRifa(ItemRifa itemRifa) {
        boolean pay = itemRifa.getPaid();
        itemRifa.setPaid(!pay);
        interactor.updateItemRifa(itemRifa);
    }

    @Override
    @Subscribe
    public void onEventListThread(RifaListItemEvent event) {
        if(this.view != null){
            switch (event.getType()){
                case RifaListItemEvent.READ_EVENT:
                    view.setItemsRifa(event.getItemRifaList());
                    break;
                case RifaListItemEvent.SAVE_EVENT:
                    view.onItemRifaSaved();
                    view.setItemRifa(event.getItemRifa());
                    break;
                case RifaListItemEvent.UPDATE_EVENT:
                    ItemRifa itemRifa = event.getItemRifa();
                    view.onItemRifaUpdated(itemRifa);
                    break;
            }
        }
    }

    @Override
    public RifaListItemView getView() {
        return this.view;
    }
}

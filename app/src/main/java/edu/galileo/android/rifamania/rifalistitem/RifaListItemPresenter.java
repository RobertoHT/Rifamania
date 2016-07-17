package edu.galileo.android.rifamania.rifalistitem;

import edu.galileo.android.rifamania.entities.ItemRifa;
import edu.galileo.android.rifamania.rifalistitem.events.RifaListItemEvent;
import edu.galileo.android.rifamania.rifalistitem.ui.RifaListItemView;

/**
 * Created by Roberto Hdez. on 16/07/16.
 */

public interface RifaListItemPresenter {
    void onCreate();
    void onDestroy();

    void getItemsRifa(int id);
    void saveItemRifa(ItemRifa itemRifa);
    void updateItemRifa(ItemRifa itemRifa);
    void getWin(int id);
    void onEventListThread(RifaListItemEvent event);

    RifaListItemView getView();
}

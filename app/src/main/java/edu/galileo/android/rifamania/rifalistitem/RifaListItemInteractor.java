package edu.galileo.android.rifamania.rifalistitem;

import edu.galileo.android.rifamania.entities.ItemRifa;

/**
 * Created by Roberto Hdez. on 16/07/16.
 */

public interface RifaListItemInteractor {
    void getItemsRifa(int id);
    void saveItemRifa(ItemRifa itemRifa);
    void updateItemRifa(ItemRifa itemRifa);
    void getWin(int id);
}

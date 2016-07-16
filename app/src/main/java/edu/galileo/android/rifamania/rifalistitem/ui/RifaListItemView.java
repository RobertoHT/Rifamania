package edu.galileo.android.rifamania.rifalistitem.ui;

import java.util.List;

import edu.galileo.android.rifamania.entities.ItemRifa;

/**
 * Created by Roberto Hdez. on 16/07/16.
 */

public interface RifaListItemView {
    void onItemRifaSaved();
    void onItemRifaUpdated(ItemRifa item);
    void setItemRifa(ItemRifa item);
    void setItemsRifa(List<ItemRifa> items);
}

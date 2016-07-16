package edu.galileo.android.rifamania.rifalistitem.events;

import java.util.List;

import edu.galileo.android.rifamania.entities.ItemRifa;

/**
 * Created by Roberto Hdez. on 16/07/16.
 */

public class RifaListItemEvent {
    private int type;
    private ItemRifa itemRifa;
    private List<ItemRifa> itemRifaList;

    public static final int READ_EVENT = 0;
    public static final int SAVE_EVENT = 1;
    public static final int UPDATE_EVENT = 2;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ItemRifa getItemRifa() {
        return itemRifa;
    }

    public void setItemRifa(ItemRifa itemRifa) {
        this.itemRifa = itemRifa;
    }

    public List<ItemRifa> getItemRifaList() {
        return itemRifaList;
    }

    public void setItemRifaList(List<ItemRifa> itemRifaList) {
        this.itemRifaList = itemRifaList;
    }
}

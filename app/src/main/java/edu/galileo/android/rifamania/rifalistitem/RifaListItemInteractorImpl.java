package edu.galileo.android.rifamania.rifalistitem;

import edu.galileo.android.rifamania.entities.ItemRifa;

/**
 * Created by Roberto Hdez. on 16/07/16.
 */

public class RifaListItemInteractorImpl implements RifaListItemInteractor {
    RifaListItemRepository repository;

    public RifaListItemInteractorImpl(RifaListItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getItemsRifa(int id) {
        repository.getSavedItemsRifa(id);
    }

    @Override
    public void saveItemRifa(ItemRifa itemRifa) {
        repository.saveItemRifa(itemRifa);
    }

    @Override
    public void updateItemRifa(ItemRifa itemRifa) {
        repository.updateItemRifa(itemRifa);
    }

    @Override
    public void getWin(int id) {
        repository.getWin(id);
    }
}

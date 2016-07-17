package edu.galileo.android.rifamania.rifalistitem;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;
import java.util.Random;

import edu.galileo.android.rifamania.entities.ItemRifa;
import edu.galileo.android.rifamania.entities.ItemRifa_Table;
import edu.galileo.android.rifamania.libs.base.EventBus;
import edu.galileo.android.rifamania.rifalistitem.events.RifaListItemEvent;

/**
 * Created by Roberto Hdez. on 16/07/16.
 */

public class RifaListItemRepositoryImpl implements RifaListItemRepository {
    private EventBus eventBus;

    public RifaListItemRepositoryImpl(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void getSavedItemsRifa(int id) {
        List<ItemRifa> storedItemsRifa = new Select().from(ItemRifa.class).where(ItemRifa_Table.id_rifa.eq(id)).queryList();
        post(RifaListItemEvent.READ_EVENT, storedItemsRifa);
    }

    @Override
    public void saveItemRifa(ItemRifa itemRifa) {
        itemRifa.save();
        post(RifaListItemEvent.SAVE_EVENT, itemRifa);
    }

    @Override
    public void updateItemRifa(ItemRifa itemRifa) {
        itemRifa.update();
        post(RifaListItemEvent.UPDATE_EVENT, itemRifa);
    }

    @Override
    public void getWin(int id) {
        List<ItemRifa> storedItemsRifa = new Select()
                                                .from(ItemRifa.class)
                                                .where(ItemRifa_Table.id_rifa.eq(id))
                                                .and(ItemRifa_Table.paid.eq(true))
                                                .queryList();
        Random r = new Random();
        int number = r.nextInt((storedItemsRifa.size() - 1) + 1 ) + 1;
        ItemRifa currentItemRifa = storedItemsRifa.get(number - 1);
        post(RifaListItemEvent.WIN_EVENT, currentItemRifa);
    }

    private void post(int type, ItemRifa itemRifa){
        RifaListItemEvent event = new RifaListItemEvent();
        event.setType(type);
        event.setItemRifa(itemRifa);
        eventBus.post(event);
    }

    private void post(int type, List<ItemRifa> itemRifaList){
        RifaListItemEvent event = new RifaListItemEvent();
        event.setType(type);
        event.setItemRifaList(itemRifaList);
        eventBus.post(event);
    }
}

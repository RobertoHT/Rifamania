package edu.galileo.android.rifamania.rifamain;

import com.raizlabs.android.dbflow.list.FlowCursorList;

import java.util.Arrays;
import java.util.List;

import edu.galileo.android.rifamania.entities.Rifa;
import edu.galileo.android.rifamania.libs.base.EventBus;
import edu.galileo.android.rifamania.rifamain.events.RifaMainEvent;

/**
 * Created by Roberto Hdez. on 13/07/16.
 */

public class RifaMainRepositoryImpl implements RifaMainRepository {
    private EventBus eventBus;

    public RifaMainRepositoryImpl(EventBus eventBus) {
        this.eventBus = eventBus;
    }


    @Override
    public void getSavedRifas() {
        FlowCursorList storedRifas = new FlowCursorList<Rifa>(false, Rifa.class);
        post(RifaMainEvent.READ_EVENT, storedRifas.getAll());
        storedRifas.close();
    }

    @Override
    public void saveRifa(Rifa rifa) {
        rifa.save();
        post(RifaMainEvent.SAVE_EVENT, rifa);
    }

    @Override
    public void removeRifa(Rifa rifa) {
        rifa.delete();
        post(RifaMainEvent.DELETE_EVENT, Arrays.asList(rifa));
    }

    private void post(int type, List<Rifa> rifaList){
        RifaMainEvent event = new RifaMainEvent();
        event.setType(type);
        event.setRifaList(rifaList);
        eventBus.post(event);
    }

    private void post(int type, Rifa rifa) {
        RifaMainEvent event = new RifaMainEvent();
        event.setType(type);
        event.setRifa(rifa);
        eventBus.post(event);
    }
}
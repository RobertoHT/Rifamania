package edu.galileo.android.rifamania.rifamain;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.rifamania.entities.Rifa;
import edu.galileo.android.rifamania.libs.base.EventBus;
import edu.galileo.android.rifamania.rifamain.events.RifaMainEvent;
import edu.galileo.android.rifamania.rifamain.ui.RifaMainView;

/**
 * Created by Roberto Hdez. on 13/07/16.
 */

public class RifaMainPresenterImpl implements RifaMainPresenter{
    private EventBus eventBus;
    private RifaMainView view;
    private RifaMainInteractor interactor;

    public RifaMainPresenterImpl(EventBus eventBus, RifaMainView view, RifaMainInteractor interactor) {
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
    public void getRifas() {
        interactor.getRifas();
    }

    @Override
    public void saveFirma(Rifa rifa) {
        interactor.saveRifa(rifa);
    }

    @Override
    public void removeRifa(Rifa rifa) {
        interactor.removeRifa(rifa);
    }

    @Override
    @Subscribe
    public void onEventMainThread(RifaMainEvent event) {
        if(this.view != null){
            switch (event.getType()){
                case RifaMainEvent.READ_EVENT:
                    view.setRifas(event.getRifaList());
                    break;
                case RifaMainEvent.SAVE_EVENT:
                    view.onRifaSaved();
                    break;
                case RifaMainEvent.DELETE_EVENT:
                    Rifa rifa = event.getRifaList().get(0);
                    view.onRifaDeleted(rifa);
                    break;
            }
        }
    }

    @Override
    public RifaMainView getView() {
        return this.view;
    }
}

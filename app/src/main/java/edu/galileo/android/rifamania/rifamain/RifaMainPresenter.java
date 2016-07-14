package edu.galileo.android.rifamania.rifamain;

import edu.galileo.android.rifamania.entities.Rifa;
import edu.galileo.android.rifamania.rifamain.events.RifaMainEvent;
import edu.galileo.android.rifamania.rifamain.ui.RifaMainView;

/**
 * Created by Roberto Hdez. on 13/07/16.
 */

public interface RifaMainPresenter {
    void onCreate();
    void onDestroy();

    void getRifas();
    void saveFirma(Rifa rifa);
    void removeRifa(Rifa rifa);
    void onEventMainThread(RifaMainEvent event);

    RifaMainView getView();
}

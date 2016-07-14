package edu.galileo.android.rifamania.rifamain;

import edu.galileo.android.rifamania.entities.Rifa;

/**
 * Created by Roberto Hdez. on 13/07/16.
 */

public interface RifaMainRepository {
    void getSavedRifas();
    void saveRifa(Rifa rifa);
    void removeRifa(Rifa rifa);
}

package edu.galileo.android.rifamania.rifamain;

import edu.galileo.android.rifamania.entities.Rifa;

/**
 * Created by Roberto Hdez. on 13/07/16.
 */

public class RifaMainInteractorImpl implements RifaMainInteractor {
    private RifaMainRepository repository;

    public RifaMainInteractorImpl(RifaMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getRifas() {
        repository.getSavedRifas();
    }

    @Override
    public void saveRifa(Rifa rifa) {
        repository.saveRifa(rifa);
    }

    @Override
    public void removeRifa(Rifa rifa) {
        repository.removeRifa(rifa);
    }
}

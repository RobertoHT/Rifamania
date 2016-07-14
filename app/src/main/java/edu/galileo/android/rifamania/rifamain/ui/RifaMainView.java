package edu.galileo.android.rifamania.rifamain.ui;

import java.util.List;

import edu.galileo.android.rifamania.entities.Rifa;

/**
 * Created by Roberto Hdez. on 13/07/16.
 */

public interface RifaMainView {
    void onRifaSaved();
    void onRifaUpdate();
    void onRifaDeleted(Rifa rifa);
    void setRifa(Rifa rifa);
    void setRifas(List<Rifa> rifas);
}

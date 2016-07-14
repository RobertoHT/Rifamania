package edu.galileo.android.rifamania.rifamain.events;

import java.util.List;

import edu.galileo.android.rifamania.entities.Rifa;

/**
 * Created by Roberto Hdez. on 13/07/16.
 */

public class RifaMainEvent {
    private int type;
    private Rifa rifa;
    private List<Rifa> rifaList;

    public static final int READ_EVENT = 0;
    public static final int SAVE_EVENT = 1;
    public static final int DELETE_EVENT = 2;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Rifa getRifa() {
        return rifa;
    }

    public void setRifa(Rifa rifa) {
        this.rifa = rifa;
    }

    public List<Rifa> getRifaList() {
        return rifaList;
    }

    public void setRifaList(List<Rifa> rifaList) {
        this.rifaList = rifaList;
    }
}

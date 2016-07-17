package edu.galileo.android.rifamania.entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import edu.galileo.android.rifamania.db.RifasDatabase;

/**
 * Created by praxis on 13/07/16.
 */
@Table(database = RifasDatabase.class)
public class ItemRifa extends BaseModel{
    @PrimaryKey(autoincrement = true) public int id;
    @Column public String name;
    @Column public boolean paid;
    @Column public int id_rifa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public int getId_rifa() {
        return id_rifa;
    }

    public void setId_rifa(int id_rifa) {
        this.id_rifa = id_rifa;
    }
}

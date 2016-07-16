package edu.galileo.android.rifamania.rifamain.dialog;

/**
 * Created by Roberto Hdez. on 15/07/16.
 */

public interface ClickListenerDialog {
    public void onDialogPositiveClick(String name, int cost, String date);
    public void onDialogNegativeClick();
}

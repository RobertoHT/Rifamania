package edu.galileo.android.rifamania.rifalistitem.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import edu.galileo.android.rifamania.R;
import edu.galileo.android.rifamania.entities.ItemRifa;
import edu.galileo.android.rifamania.rifamain.dialog.ClickListenerDialog;

/**
 * Created by Roberto Hdez. on 16/07/16.
 */

public class RifaListItemDialog extends DialogFragment {
    private EditText txtName;
    private CheckBox checkPay;
    private ItemRifa itemRifa;
    ClickItemListenerDialog listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_list_item_rifa, null);

        AlertDialog.Builder createAlert = new AlertDialog.Builder(getActivity());
        createAlert.setTitle("Agregar persona")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //listener.onDialogPositiveClick(itemRifa);
                        txtName = (EditText)view.findViewById(R.id.txtDialogItemName);
                        checkPay = (CheckBox)view.findViewById(R.id.checkDialogItemPay);
                        String name = txtName.getText().toString();
                        boolean check = checkPay.isChecked();
                        Log.d("DIALOG ITEM",name + " - " + check);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });

        createAlert.setView(view);

        return createAlert.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (ClickItemListenerDialog) activity;
    }
}

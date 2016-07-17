package edu.galileo.android.rifamania.rifalistitem.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import edu.galileo.android.rifamania.R;

/**
 * Created by Roberto Hdez. on 17/07/16.
 */

public class WinDialog extends DialogFragment {
    private String namePerson, body;
    TextView txtName, txtBody;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_win, null);

        txtName = (TextView) view.findViewById(R.id.nameWin);
        txtName.setText(namePerson);
        txtBody = (TextView) view.findViewById(R.id.bodyWin);
        txtBody.setText(body);

        AlertDialog.Builder createAlert = new AlertDialog.Builder(getActivity());
        createAlert.setTitle("Ganador")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });

        createAlert.setView(view);
        return createAlert.create();
    }

    public void setParameters(String namePerson, String body) {
        this.namePerson = namePerson;
        this.body = body;
    }
}

package edu.galileo.android.rifamania.rifamain.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

import edu.galileo.android.rifamania.R;

/**
 * Created by Roberto Hdez. on 15/07/16.
 */

public class RifaMainDialog extends DialogFragment{
    private EditText txtName;
    private EditText txtCost;
    private static TextView txtDate;
    private ImageButton imgCalendar;
    private static String fecha;
    ClickListenerDialog listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_add_rifa, null);

        AlertDialog.Builder createAlert = new AlertDialog.Builder(getActivity());
        createAlert.setTitle("Agregar rifa")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txtName = (EditText) view.findViewById(R.id.dialogName);
                        txtCost = (EditText) view.findViewById(R.id.dialogCost);
                        String nombre = txtName.getText().toString();
                        int cost = Integer.parseInt(txtCost.getText().toString());
                        listener.onDialogPositiveClick(nombre,cost,fecha);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onDialogNegativeClick();
                    }
                });

        txtDate = (TextView) view.findViewById(R.id.dialogDate);

        imgCalendar = (ImageButton) view.findViewById(R.id.calendarButton);
        imgCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateofPicker();
            }
        });

        createAlert.setView(view);

        return createAlert.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (ClickListenerDialog) activity;
    }


    public void dateofPicker(){
        DateDialog dateDialog = new DateDialog();
        dateDialog.show(getFragmentManager(), "Simple Date");
    }

    public static void setDate(int year, int month, int day) {
        fecha = day + " de " + getMes(month) + " de " + year;
        txtDate.setText(fecha);
    }

    private static String getMes(int month){
        String name = "";
        switch (month){
            case 0:
                name = "enero";
                break;
            case 1:
                name = "febrero";
                break;
            case 2:
                name = "marzo";
                break;
            case 3:
                name = "abril";
                break;
            case 4:
                name = "mayo";
                break;
            case 5:
                name = "junio";
                break;
            case 6:
                name = "julio";
                break;
            case 7:
                name = "agosto";
                break;
            case 8:
                name = "septiembre";
                break;
            case 9:
                name = "octubre";
                break;
            case 10:
                name = "noviembre";
                break;
            case 11:
                name = "diciembre";
                break;
        }
        return name;
    }


    public static class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener{

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            setDate(year, monthOfYear, dayOfMonth);
        }
    }
}

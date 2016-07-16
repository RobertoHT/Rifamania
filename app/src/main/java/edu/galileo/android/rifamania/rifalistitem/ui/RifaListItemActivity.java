package edu.galileo.android.rifamania.rifalistitem.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.galileo.android.rifamania.R;
import edu.galileo.android.rifamania.RifamaniaApp;
import edu.galileo.android.rifamania.entities.ItemRifa;
import edu.galileo.android.rifamania.rifalistitem.RifaListItemPresenter;
import edu.galileo.android.rifamania.rifalistitem.adapters.OnItemListClickListener;
import edu.galileo.android.rifamania.rifalistitem.adapters.RifaListAdapter;
import edu.galileo.android.rifamania.rifalistitem.di.RifaListItemComponent;
import edu.galileo.android.rifamania.rifalistitem.dialog.ClickItemListenerDialog;
import edu.galileo.android.rifamania.rifalistitem.dialog.RifaListItemDialog;

public class RifaListItemActivity extends AppCompatActivity implements RifaListItemView, OnItemListClickListener, ClickItemListenerDialog {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.plusList)
    FloatingActionButton plusList;
    @Bind(R.id.main_list_content)
    CoordinatorLayout mainListContent;

    private RifaListAdapter adapter;
    private RifaListItemPresenter presenter;
    private RifaListItemComponent component;
    private RifaListItemDialog dialog;

    private String nameItem;
    private int idItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rifa_list_item);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        idItem = intent.getIntExtra("id", 0);
        nameItem = intent.getStringExtra("nombre");
        Log.d("DATOS", idItem + " - " + nameItem);

        setupToolbar();
        setupInjection();
        setupRecyclerView();

        presenter.onCreate();
        presenter.getItemsRifa(idItem);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    private void setupInjection() {
        RifamaniaApp app = (RifamaniaApp) getApplication();
        component = app.getRifaListItemComponent(this, this, this);
        presenter = getPresenter();
        adapter = getAdapter();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemRifaSaved() {
        Snackbar.make(mainListContent, R.string.rifamain_notice_saved, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onItemRifaUpdated(ItemRifa item) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setItemRifa(ItemRifa itemRifa) {
        adapter.setItemRifa(itemRifa);
    }

    @Override
    public void setItemsRifa(List<ItemRifa> items) {
        adapter.setItemsRifa(items);
    }

    @Override
    public void onUpdateClick(ItemRifa itemRifa) {
        presenter.updateItemRifa(itemRifa);
    }

    @OnClick(R.id.plusList)
    public void addItemRifa(){
        Log.d("CLICK ITEM","msg");
        dialog = new RifaListItemDialog();
        dialog.show(getFragmentManager(), "Simple Dialog");
    }

    public RifaListItemPresenter getPresenter(){
        return component.getPresenter();
    }

    public RifaListAdapter getAdapter(){
        return component.getAdapter();
    }

    @Override
    public void onDialogPositiveClick(ItemRifa itemRifa) {

    }
}

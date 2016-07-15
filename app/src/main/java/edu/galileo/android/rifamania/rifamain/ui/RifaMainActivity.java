package edu.galileo.android.rifamania.rifamain.ui;

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
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.galileo.android.rifamania.R;
import edu.galileo.android.rifamania.RifamaniaApp;
import edu.galileo.android.rifamania.entities.Rifa;
import edu.galileo.android.rifamania.rifamain.RifaMainPresenter;
import edu.galileo.android.rifamania.rifamain.adapters.OnItemCLickListener;
import edu.galileo.android.rifamania.rifamain.adapters.RifasAdapter;
import edu.galileo.android.rifamania.rifamain.di.RifaMainComponent;

public class RifaMainActivity extends AppCompatActivity implements RifaMainView, OnItemCLickListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.plus)
    FloatingActionButton plus;
    @Bind(R.id.main_content)
    CoordinatorLayout mainContent;

    private RifasAdapter adapter;
    private RifaMainPresenter presenter;
    private RifaMainComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rifa_main);
        ButterKnife.bind(this);
        setupToolbar();
        setupInjection();
        setupRecyclerView();

        presenter.onCreate();
        presenter.getRifas();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_logout){
            logout();
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        RifamaniaApp app = (RifamaniaApp)getApplication();
        app.logout();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    private void setupInjection() {
        RifamaniaApp app = (RifamaniaApp) getApplication();
        component = app.getRifaMainComponent(this, this, this);
        presenter = getPresenter();
        adapter = getAdapter();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onRifaSaved() {
        Snackbar.make(mainContent, R.string.rifamain_notice_saved, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onRifaUpdate() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRifaDeleted(Rifa rifa) {
        adapter.removeRifa(rifa);
    }

    @Override
    public void setRifa(Rifa rifa) {
        adapter.setRifa(rifa);
    }

    @Override
    public void setRifas(List<Rifa> rifas) {
        adapter.setRifas(rifas);
    }

    public RifaMainPresenter getPresenter() {
        return component.getPresenter();
    }

    public RifasAdapter getAdapter() {
        return component.getAdapter();
    }

    @Override
    public void onItemCLick(Rifa rifa) {
        Log.d("CLICK ITEM",rifa.getName());
    }

    @Override
    public void onDeleteClick(Rifa rifa) {
        Log.d("CLICK DELETE",rifa.getName());
    }

    @OnClick(R.id.plus)
    public void addRifa(){
        Log.d("CLICK PLUS","click");
    }
}

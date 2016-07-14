package edu.galileo.android.rifamania.rifamain.ui;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.rifamania.R;
import edu.galileo.android.rifamania.RifamaniaApp;
import edu.galileo.android.rifamania.entities.Rifa;

public class RifaMainActivity extends AppCompatActivity implements RifaMainView {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rifa_main);
        ButterKnife.bind(this);
        setupToolbar();
        setupInjection();
        setupRecyclerView();
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
    }

    private void setupRecyclerView() {
    }

    @Override
    public void onRifaSaved() {

    }

    @Override
    public void onRifaUpdate() {

    }

    @Override
    public void onRifaDeleted(Rifa rifa) {

    }

    @Override
    public void setRifa(Rifa rifa) {

    }

    @Override
    public void setRifas(List<Rifa> rifas) {

    }
}

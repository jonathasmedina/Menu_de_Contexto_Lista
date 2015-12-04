package com.example.asus.myapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private static final String[] CORES = new String[] {"Verde","Azul","Amarelo","Branco"};
    private ArrayAdapter<String> meuAdaptador;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        meuAdaptador  = new ArrayAdapter(this,android.R.layout.simple_list_item_1, CORES);
        setListAdapter(meuAdaptador);

        registerForContextMenu(getListView());
        //     ---------OU-----------;
        //    ListView lv = getListView();
        //   registerForContextMenu(lv);


//        get your ListView from your ListActivity. The ListView will handle the click and long press Android events for your ListActivity.
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(
                R.menu.menu_contexto, menu);

       /* super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Action 1");
        menu.add(0, v.getId(), 0, "Action 2");*/
    }


    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        String nomeSelecionado = (String)
                getListView().getItemAtPosition(info.position);

        switch (item.getItemId()) {
            case R.id.opcao1:
                Toast.makeText(this, "Opção 1 - "+
                        nomeSelecionado, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcao2:
                Toast.makeText(this, "Opção 2 - "+
                        nomeSelecionado, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcao3:
                Toast.makeText(this, "Opção 3 - "+
                        nomeSelecionado, Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }

    //@Override
    protected void onListItemClick (ListView l, View v, int posicao, long id)
    {
        super.onListItemClick(l, v, posicao, id);
        Toast.makeText(this, "Usuário selecionou a cor " + CORES[posicao], Toast.LENGTH_SHORT).show();
    }

}

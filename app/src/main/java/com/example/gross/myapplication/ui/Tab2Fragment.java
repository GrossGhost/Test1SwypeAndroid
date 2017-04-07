package com.example.gross.myapplication.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gross.myapplication.R;
import com.example.gross.myapplication.adapter.GuitarAdapter;
import com.example.gross.myapplication.model.DataClassicGuitar;
import com.example.gross.myapplication.model.DataElectroGuitar;

/**
 * Created by Gross on 04.04.2017.
 */

public class Tab2Fragment extends Fragment implements GuitarAdapter.ClickListener, View.OnClickListener {

    private RecyclerView recyclerView;
    private GuitarAdapter adapter;
    private View header, tab2Fragment;
    private TextView headerTitle;
    private ImageButton buyButton;
    private String title;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab2, container, false);

        header = rootView.findViewById(R.id.header_rec_view_classic);
        headerTitle = (TextView) rootView.findViewById(R.id.header_list_title);
        headerTitle.setText("Classic");

        buyButton = (ImageButton) rootView.findViewById(R.id.btn_buy_guitar);
        buyButton.setOnClickListener(this);

        tab2Fragment = rootView.findViewById(R.id.fragment_tab2);
        tab2Fragment.setOnClickListener(this);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycViewClassic);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));


        adapter = new GuitarAdapter(DataClassicGuitar.getListData(), rootView.getContext());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        return rootView;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return true;
            }
        });

    }

    @Override
    public void itemClicked(View view, int position) {

        title = adapter.getSelectedGuitar(position).getTitle();

        header.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        if (title.length() > 17) {
            title = title.substring(0, 16) + "...";
            headerTitle.setText(title);
        } else {
            headerTitle.setText(title);
        }

        buyButton.setVisibility(View.VISIBLE);
    }

    public void setHeaderStyleStart() {
        headerTitle.setText("Classic");
        header.setBackgroundColor(getResources().getColor(R.color.colorBackgroundHeader));
        buyButton.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onPause() {
        super.onPause();
        adapter.getFilter().filter("");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.fragment_tab2:
                setHeaderStyleStart();
                break;
            case R.id.btn_buy_guitar:
                Toast.makeText(getContext(), "Sorry, you cant buy " + title + "(\n Its just test application", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}

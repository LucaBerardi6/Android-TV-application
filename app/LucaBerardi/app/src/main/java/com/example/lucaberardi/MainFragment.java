package com.example.lucaberardi;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;

import androidx.leanback.app.BackgroundManager;
import androidx.leanback.app.BrowseFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.core.content.ContextCompat;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainFragment extends BrowseFragment {
    private static final String TAG = "MainFragment";

   //quando viene creata:
   public void onActivityCreated(Bundle savedInstanceState) {

       super.onActivityCreated(savedInstanceState);

       setScreen();

       addRows();

       eventListeners();
   }


    //aggiunta delle righe:
   private void addRows() {
       List<Mode> list = ModeList.getList();

       ArrayObjectAdapter rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
       CardPresenter cardPresenter = new CardPresenter();
       int j;
       //AGGIUNTA DELLA PRIMA RIGA:
      ArrayObjectAdapter cardAdapter = new ArrayObjectAdapter(cardPresenter);
       for ( j = 0; j < 3; j++) {
           cardAdapter.add(list.get(j)); // CREA LISTA DI SCHEDE
       }
       // aggiunge modalità un giocatore:
       HeaderItem header = new HeaderItem(0, ModeList.GAMEMODE[0]);
       rowsAdapter.add(new ListRow(header, cardAdapter)); //RIGA 1
       //
       //AGGIUNTA DELLA SECONDA RIGA:
       ArrayObjectAdapter cardAdapter2 = new ArrayObjectAdapter(cardPresenter);
       for ( j = 3; j < 6; j++) {
           cardAdapter2.add(list.get(j)); // CREA LISTA DI SCHEDE
       }
       // aggiunge modalità due giocatori:
       HeaderItem header2 = new HeaderItem(1, ModeList.GAMEMODE[1]);
       rowsAdapter.add(new ListRow(header2, cardAdapter2)); //RIGA 2
        //
        //IMPOSTA LE RIGHE:
       setAdapter(rowsAdapter);
   }



   private void setScreen() {

       setTitle(getString(R.string.title)); //titolo
       setHeadersState(HEADERS_ENABLED);
       setHeadersTransitionOnBackEnabled(true);

       setBrandColor(ContextCompat.getColor(getContext(), R.color.brand)); // (COLORE DELLA BARRA LATERALE CON LE MODALITA')
   }


    ///////// EVENTI ///////////////
   private void eventListeners() {

       setOnItemViewClickedListener(new ItemViewClickedListener());

        }

        //se si clicca una scheda
private final class ItemViewClickedListener implements OnItemViewClickedListener {
    @Override
    public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item,
                              RowPresenter.ViewHolder rowViewHolder, Row row) {

        if (item instanceof Mode) {
            Mode mode = (Mode) item;
            Log.d(TAG, "Item: " + item.toString());
            //intent per nuova activity:
            Intent intent = new Intent(getActivity(), GameActivity.class);
            intent.putExtra("mode", mode);

            getActivity().startActivity(intent);

        }
    }
}


}
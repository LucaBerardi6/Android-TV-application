package com.example.lucaberardi;

import android.content.Intent;
import android.os.Bundle;
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
import android.util.Log;
import java.util.List;

/**
 * The MainFragment class is used to create the main layout.
 * */

public class MainFragment extends BrowseFragment {
    private static final String TAG = "MainFragment";

   /**At the time of creation.*/
   public void onActivityCreated(Bundle savedInstanceState) {

       super.onActivityCreated(savedInstanceState);

       setScreen();

       addRows();

       eventListeners();
   }


    /**Load the game modes and cards of the different
     * types of challenges that the user can choose from.*/
   private void addRows() {
       List<Mode> list = ModeList.getList();
       ArrayObjectAdapter rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
       CardPresenter cardPresenter = new CardPresenter();
       int j;
       //ADDING THE FIRST ROW:
      ArrayObjectAdapter cardAdapter = new ArrayObjectAdapter(cardPresenter);
       for ( j = 0; j < 3; j++) {
           cardAdapter.add(list.get(j)); // CREATE CARDS LIST
       }
       //Adds one player mode:
       HeaderItem header = new HeaderItem(0, ModeList.GAMEMODE[0]);
       rowsAdapter.add(new ListRow(header, cardAdapter)); // row 1
       //
       //ADDING SECOND LINE:
       ArrayObjectAdapter cardAdapter2 = new ArrayObjectAdapter(cardPresenter);
       for ( j = 3; j < 6; j++) {
           cardAdapter2.add(list.get(j)); // CREATE CARDS LIST
       }
       //adds two player mode:
       HeaderItem header2 = new HeaderItem(1, ModeList.GAMEMODE[1]);
       rowsAdapter.add(new ListRow(header2, cardAdapter2)); //RIGA 2
        //SET ROWS:
       setAdapter(rowsAdapter);
   }

   /**It defines the style of some visible elements on the user interface.*/
   private void setScreen() {

       setTitle(getString(R.string.title)); //title
       setHeadersState(HEADERS_ENABLED);
       setHeadersTransitionOnBackEnabled(true);

       /*SIDEBAR COLOR WITH MODES*/
       setBrandColor(ContextCompat.getColor(getContext(), R.color.brand));
   }

   /**Defines listeners for events related to user interaction with the elements present.*/
   private void eventListeners() {

       setOnItemViewClickedListener(new ItemViewClickedListener());

        }

        //if you click a tab
private final class ItemViewClickedListener implements OnItemViewClickedListener {
    @Override
    public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item,
                              RowPresenter.ViewHolder rowViewHolder, Row row) {

        if (item instanceof Mode) {
            Mode mode = (Mode) item;
            Log.d(TAG, "Item: " + item.toString());
            //intent for new activity:
            Intent intent = new Intent(getActivity(), GameActivity.class);
            intent.putExtra("mode", mode);

            getActivity().startActivity(intent);

        }
    }
}


}
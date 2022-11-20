package com.example.lucaberardi;

import android.graphics.drawable.Drawable;

import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import androidx.core.content.ContextCompat;
import android.util.Log;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;

/**
 * The CardPresenter class extends the Presenter class
 * available in the AndroidX Leanback library.
 * CardPresenter is used for the cards visible
 * in the main screen and, through the ArrayObjectAdapter,
 * it is then possible to add these cards to the user interface.
 */

public class CardPresenter extends Presenter {
    private static final String TAG = "CardPresenter";

    private static final int WIDTH = 550;
    private static final int HEIGHT = 350;
    private static int selectedColor;
    private static int standardColor;
    private Drawable defaultImage;

    /**Change the background color of the tab.*/
    private static void changeBackground(ImageCardView view, boolean selected) {
        int color;
        if(selected==true) color= selectedColor;
        else color=standardColor;

        view.setBackgroundColor(color);
        view.findViewById(R.id.info_field).setBackgroundColor(color);
    }

    /**Create a ViewHolder capable of displaying an item.*/
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        //default image:
        defaultImage = ContextCompat.getDrawable(parent.getContext(), R.drawable.banner);
        //colors:
        standardColor = ContextCompat.getColor(parent.getContext(), R.color.defaultC);//not selected
        selectedColor = ContextCompat.getColor(parent.getContext(), R.color.selectedC); //selected

        ImageCardView cardView =
                new ImageCardView(parent.getContext()) {
                    @Override
                    public void setSelected(boolean selected) {
                        changeBackground(this, selected);
                        super.setSelected(selected);
                    }
                };

        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
        changeBackground(cardView, false);
        return new ViewHolder(cardView);
    }

    /**Used to associate a View with a specific element.*/
    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        ImageCardView cardView = (ImageCardView) viewHolder.view;
        Mode mode = (Mode) item;

        if (mode.getTitle() != null) {
            cardView.setTitleText(mode.getTitle());  //set a title
            cardView.setContentText(mode.getDescription()); // description
            cardView.setMainImageDimensions(WIDTH, HEIGHT); //card size
            Glide.with(viewHolder.view.getContext())
                    .load(mode.getImage()) //upload card image
                    .centerCrop()
                    .error(defaultImage) //default photo if problems in load method
                    .into(cardView.getMainImageView());
        }
    }

    /**The View is no longer constrained to the element and
     * the ImageCardView is stripped of references to images to free up memory.*/
    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        Log.d(TAG, "onUnbindViewHolder");
        ImageCardView cardView = (ImageCardView) viewHolder.view;
        // Remove image references, free up memory
        cardView.setBadgeImage(null);
        cardView.setMainImage(null);
    }
}
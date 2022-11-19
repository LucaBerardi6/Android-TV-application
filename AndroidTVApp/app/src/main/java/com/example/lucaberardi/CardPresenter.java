package com.example.lucaberardi;

import android.graphics.drawable.Drawable;

import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import androidx.core.content.ContextCompat;

import android.util.Log;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;


public class CardPresenter extends Presenter {
    private static final String TAG = "CardPresenter";

    private static final int WIDTH = 550;
    private static final int HEIGHT = 350;
    private static int selectedColor;
    private static int standardColor;
    private Drawable defaultImage;

    private static void changeBackground(ImageCardView view, boolean selected) {
        int color;
        if(selected==true) color= selectedColor;
        else color=standardColor;

        view.setBackgroundColor(color);
        view.findViewById(R.id.info_field).setBackgroundColor(color);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        //immagine di default:
        defaultImage = ContextCompat.getDrawable(parent.getContext(), R.drawable.banner);
        //colori:
        standardColor = ContextCompat.getColor(parent.getContext(), R.color.defaultC); //non selezionato
        selectedColor = ContextCompat.getColor(parent.getContext(), R.color.selectedC); //selezionato

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

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        ImageCardView cardView = (ImageCardView) viewHolder.view;
        Mode mode = (Mode) item;

        if (mode.getTitle() != null) {
            cardView.setTitleText(mode.getTitle());  //imposta un titolo
            cardView.setContentText(mode.getDescription()); // descrizione
            cardView.setMainImageDimensions(WIDTH, HEIGHT); //dimensioni scheda
            Glide.with(viewHolder.view.getContext())
                    .load(mode.getImage()) //carica immagine scheda
                    .centerCrop()
                    .error(defaultImage) //foto di default se problemi in load
                    .into(cardView.getMainImageView());
        }
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        Log.d(TAG, "onUnbindViewHolder");
        ImageCardView cardView = (ImageCardView) viewHolder.view;
        // Rimuove i riferimenti alle immagini, liberare memoria
        cardView.setBadgeImage(null);
        cardView.setMainImage(null);
    }
}
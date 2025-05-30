// Generated by view binder compiler. Do not edit!
package com.example.modul3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.modul3.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemFilmBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnDetail;

  @NonNull
  public final Button btnTrailer;

  @NonNull
  public final ImageView ivPoster;

  @NonNull
  public final TextView tvGenre;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final TextView tvYear;

  private ItemFilmBinding(@NonNull LinearLayout rootView, @NonNull Button btnDetail,
      @NonNull Button btnTrailer, @NonNull ImageView ivPoster, @NonNull TextView tvGenre,
      @NonNull TextView tvTitle, @NonNull TextView tvYear) {
    this.rootView = rootView;
    this.btnDetail = btnDetail;
    this.btnTrailer = btnTrailer;
    this.ivPoster = ivPoster;
    this.tvGenre = tvGenre;
    this.tvTitle = tvTitle;
    this.tvYear = tvYear;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemFilmBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemFilmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_film, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemFilmBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnDetail;
      Button btnDetail = ViewBindings.findChildViewById(rootView, id);
      if (btnDetail == null) {
        break missingId;
      }

      id = R.id.btnTrailer;
      Button btnTrailer = ViewBindings.findChildViewById(rootView, id);
      if (btnTrailer == null) {
        break missingId;
      }

      id = R.id.ivPoster;
      ImageView ivPoster = ViewBindings.findChildViewById(rootView, id);
      if (ivPoster == null) {
        break missingId;
      }

      id = R.id.tvGenre;
      TextView tvGenre = ViewBindings.findChildViewById(rootView, id);
      if (tvGenre == null) {
        break missingId;
      }

      id = R.id.tvTitle;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      id = R.id.tvYear;
      TextView tvYear = ViewBindings.findChildViewById(rootView, id);
      if (tvYear == null) {
        break missingId;
      }

      return new ItemFilmBinding((LinearLayout) rootView, btnDetail, btnTrailer, ivPoster, tvGenre,
          tvTitle, tvYear);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}

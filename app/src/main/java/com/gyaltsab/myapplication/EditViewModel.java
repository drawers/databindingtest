package com.gyaltsab.myapplication;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.Nullable;

/**
 * Created by David on 8/07/2017.
 */

public class EditViewModel extends BaseObservable {

    private String comment;

    public EditViewModel(@Nullable String comment) {
        this.comment = comment;
    }

    @Bindable
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        if (this.comment == null && comment == null) {
            // No changes, both NULL
            return;
        }

        if (this.comment != null && this.comment.equals(comment)) {
            //No changes, both equals
            return;
        }

        this.comment = comment;
        // Notification of change
        notifyPropertyChanged(BR.comment);
    }
}
package com.gyaltsab.myapplication;

import android.databinding.Observable;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

public class EditViewModelTest {

    @Test
    public void setNewNonNullCommentRaisesPropertyChange() {
        // Arrange
        EditViewModel sut = new EditViewModel(null);
        sut.setComment("One");
        Observable.OnPropertyChangedCallback listener = mock(Observable.OnPropertyChangedCallback.class);
        sut.addOnPropertyChangedCallback(listener);
        String newComment = "two";

        // Act
        sut.setComment(newComment);

        // Assert
        verify(listener).onPropertyChanged(sut, BR.comment);
    }

    @Test
    public void setNewNullCommentRaisesPropertyChange() {
        // Arrange
        EditViewModel sut = new EditViewModel(null);
        sut.setComment("One");
        Observable.OnPropertyChangedCallback listener = mock(Observable.OnPropertyChangedCallback.class);
        sut.addOnPropertyChangedCallback(listener);
        String newComment = null;

        // Act
        sut.setComment(newComment);

        // Assert
        verify(listener).onPropertyChanged(sut, BR.comment);
    }

    @Test
    public void setEqualCommentDoesntRaisePropertyChange() {
        // Arrange
        EditViewModel sut = new EditViewModel(null);
        sut.setComment("One");
        Observable.OnPropertyChangedCallback listener = mock(Observable.OnPropertyChangedCallback.class);
        sut.addOnPropertyChangedCallback(listener);
        String newComment = "One";

        // Act
        sut.setComment(newComment);

        // Assert
        verify(listener, never()).onPropertyChanged(sut, BR.comment);
    }

    @Test
    public void setNullToNullDoesntRaisePropertyChange() {
        // Arrange
        EditViewModel sut = new EditViewModel(null);
        sut.setComment(null);
        Observable.OnPropertyChangedCallback listener = mock(Observable.OnPropertyChangedCallback.class);
        sut.addOnPropertyChangedCallback(listener);
        String newComment = null;

        // Act
        sut.setComment(newComment);

        // Assert
        verify(listener, never()).onPropertyChanged(sut, BR.comment);
    }
}
package com.example.shoppinglist_v4.async;

import android.os.AsyncTask;

import com.example.shoppinglist_v4.models.Note;
import com.example.shoppinglist_v4.database.NoteDao;

public class UpdateAsyncTask extends AsyncTask<Note, Void, Void> {

    private NoteDao mNoteDao;

    public UpdateAsyncTask(NoteDao dao) {
        mNoteDao = dao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        mNoteDao.updateNotes(notes);
        return null;
    }

}
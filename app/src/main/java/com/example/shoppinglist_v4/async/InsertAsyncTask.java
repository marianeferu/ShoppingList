package com.example.shoppinglist_v4.async;

import android.os.AsyncTask;

import com.example.shoppinglist_v4.models.Note;
import com.example.shoppinglist_v4.database.NoteDao;

public class InsertAsyncTask extends AsyncTask<Note, Void, Void> {

    private NoteDao mNoteDao;

    public InsertAsyncTask(NoteDao dao) {
        mNoteDao = dao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        mNoteDao.insertNotes(notes);
        return null;
    }

}
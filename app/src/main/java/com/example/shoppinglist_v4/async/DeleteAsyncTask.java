package com.example.shoppinglist_v4.async;

import android.os.AsyncTask;
import com.example.shoppinglist_v4.models.Note;
import com.example.shoppinglist_v4.database.NoteDao;

public class DeleteAsyncTask extends AsyncTask<Note, Void, Void> {

    private NoteDao mNoteDao;

    public DeleteAsyncTask(NoteDao dao) {
        mNoteDao = dao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        mNoteDao.delete(notes);
        return null;
    }

}
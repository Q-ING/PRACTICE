package com.example.djochung.trial;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert  //annotate with the necessary db fn
    void  insert (Note note);

    @Update
    void update (Note note);


    @Delete  //ready made annotation
    void delete (Note note);

    @Query("DELETE FROM note_table") //for the annotations not ready made define data opps via string
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Note>> getAllNotes(); //activity notified once changes are made room will take care of it

}











//daos have to be interfaces or abstract classed because we just create the method and annotate
// it because the room adds extra code for you. one dao per entity
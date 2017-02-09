package com.epam.java.se.tasks.notebook;

import java.util.Arrays;

/**
 * Created by Мария on 09.02.2017.
 */
public class Notebook {
    private Note [] notes;
    private int size;

    public Notebook() {
        this.notes = new Note[0];
        size=notes.length;
    }

    public void addNote(String text){
        size += 1;
        Note [] buffer = Arrays.copyOf(notes, size);
        buffer[size-1]=new Note(text);
        notes=buffer;

    }
    public void remove (int index) {
        if (index<=0 || index>size) {
            throw new ArrayIndexOutOfBoundsException("Wrong number");
        }
        Note[] buffer1 = Arrays.copyOf(notes, index-1);

        Note [] buffer2 = new Note[size-index];
        System.arraycopy(notes, index, buffer2, 0, size-index);

        Note [] combined = new Note[buffer1.length+buffer2.length];

        System.arraycopy(buffer1, 0, combined, 0, buffer1.length);
        System.arraycopy(buffer2, 0, combined, buffer1.length, buffer2.length);

        size=combined.length;
        notes=combined;

    }
    public void showAllNotes(){
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("Notebook is empty");
        }
        for (int i=0; i<size; i++){
            System.out.println(i+1 + ". " + notes[i].getNote());
        }
    }

}

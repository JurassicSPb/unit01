package com.epam.java.se.tasks.notebook;

import java.util.Arrays;

/**
 * Class Notebook represents the list (array)
 * of notes with different methods @see below
 * created by Yuri on 09.02.16
 */

public class Notebook {
    private Note [] notes;
    private int size;

    public Notebook() {
        this.notes = new Note[0];
        size=notes.length;
    }

    /**
     * Adds single note in notebook
     * @param text - can add text directly in argument
     */
    public void addNote(String text){
        size += 1;
        Note [] buffer = Arrays.copyOf(notes, size);
        buffer[size-1]=new Note(text);
        notes=buffer;

    }

    /**
     * Removes single note from notebook by actual position
     * (not index)
     * @param number - position of note, begins with 1
     */
    public void removeByPosition(int number) {
        if (number<=0 || number>size) {
            throw new ArrayIndexOutOfBoundsException("Wrong number");
        }
        Note[] buffer1 = Arrays.copyOf(notes, number-1);

        Note [] buffer2 = new Note[size-number];
        System.arraycopy(notes, number, buffer2, 0, size-number);

        Note [] combined = new Note[buffer1.length+buffer2.length];

        System.arraycopy(buffer1, 0, combined, 0, buffer1.length);
        System.arraycopy(buffer2, 0, combined, buffer1.length, buffer2.length);

        size=combined.length;
        notes=combined;
    }

    /**
     * Removes single note from notebook by text
     * @param text - equals text (case ignored) for removal
     * @throws TextNotFoundException custom exception if text
     * is not found
     */
    public void removeByText(String text){
        int flag=0;
            for (int i = 0; i < notes.length; i++) {
                if (notes[i].getNote().equalsIgnoreCase(text)) {
                    flag++;
                    Note[] buffer1 = Arrays.copyOf(notes, i);

                    Note[] buffer2 = new Note[size - i - 1];
                    System.arraycopy(notes, i + 1, buffer2, 0, size - i - 1);

                    Note[] combined = new Note[buffer1.length + buffer2.length];

                    System.arraycopy(buffer1, 0, combined, 0, buffer1.length);
                    System.arraycopy(buffer2, 0, combined, buffer1.length, buffer2.length);

                    size = combined.length;
                    notes = combined;
                }
            }
            try {
                if (flag == 0) {
                    throw new TextNotFoundException();
                }
            } catch (TextNotFoundException e){
                System.out.println("Text does not exist");
            }
        }

    /**
     * Changes the content of single note in notebook
     * by actual position (not index)
     * @param position - position of note, begins with 1
     * @param text - change text of note
     */
    public void editNote(int position, String text){
        if (position<=0 || position>size) {
            throw new ArrayIndexOutOfBoundsException("Wrong number");
        }
        notes[position-1].setNote(text);
    }

    /**
     * Prints all notes with actual position starting from 1
     */
    public void showAllNotes(){
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("Notebook is empty");
        }
        for (int i=0; i<size; i++){
            System.out.println(i+1 + ". " + notes[i].getNote());
        }
    }
    class TextNotFoundException extends Exception{
        public TextNotFoundException (){
            super();
        }
    }

}

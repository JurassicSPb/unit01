package com.epam.java.se.tasks.notebook;

import org.junit.Test;

/**
 * Created by Мария on 09.02.2017.
 */
public class NotebookTest {
    @Test
    public void test(){
        Notebook book = new Notebook();
        book.addNote("hi");
        book.addNote("hey");
        book.addNote("J");
        book.addNote("buy");
        book.addNote("qwerty");
//        book.showAllNotes();
        book.removeByText("HI");
//        book.removeByPosition(1);
//        book.editNote(3, "hello");
        book.showAllNotes();
    }
}

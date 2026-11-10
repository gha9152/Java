
package com.example.vh_n;

import java.util.ArrayList;
import java.util.List;

public class Note {

    private static final List<String> notes = new ArrayList<>();

    public static List<String> getNotes() {
        return notes;
    }

    public static void addNote(String note) {
        if (note != null && !note.trim().isEmpty()) {
            notes.add(note.trim());
        }
    }
}

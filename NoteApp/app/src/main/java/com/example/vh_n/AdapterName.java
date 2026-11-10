
package com.example.vh_n;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterName extends RecyclerView.Adapter<NameViewHolder> {

    private final List<String> notes;

    public AdapterName() {
        notes = Note.getNotes();
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType
    ) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note, parent, false);

        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull NameViewHolder holder,
            int position
    ) {
        holder.setItems(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}

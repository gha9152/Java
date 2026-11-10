
package com.example.vh_n;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder {

    private final TextView txt;

    public NameViewHolder(@NonNull View itemView) {
        super(itemView);

        txt = itemView.findViewById(R.id.txt);
    }

    public void setItems(String name) {

        txt.setText(name);

        txt.setOnClickListener(v ->
                Toast.makeText(
                        v.getContext(),
                        name,
                        Toast.LENGTH_SHORT
                ).show()
        );
    }
}

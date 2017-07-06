package com.example.irem.tournament;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cemdeniz on 5.07.2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    public List<ListItem> listItems;
    private Context context;

    public Adapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);

                return new ViewHolder(v,new MyCustomEditTextListener());

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListItem listItem = listItems.get(position);

        holder.textViewHead.setText(listItem.getHead());
       holder.textViewDesc.setText(listItems.get(holder.getAdapterPosition()).getDesc());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public EditText textViewDesc;
        public MyCustomEditTextListener editTextListener;
        public ViewHolder(View itemView,MyCustomEditTextListener myCustomEditTextListener) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (EditText)itemView.findViewById(R.id.edtTextParticipant);
            this.editTextListener = myCustomEditTextListener;
            this.textViewDesc.addTextChangedListener(editTextListener);
        }
    }

    private class MyCustomEditTextListener implements TextWatcher{
        private int position;

        public void updatePosition(int position){
            this.position = position;
        }
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            listItems.get(position).setDesc(charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }
}

package com.example.android.listsample;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.listsample.ItemFragment.OnListFragmentInteractionListener;
import com.example.android.listsample.model.AuthorCommentItem;
import com.example.android.listsample.model.ICommentItem;
import com.example.android.listsample.model.MyCommentItem;
import com.example.android.listsample.model.UserCommentItem;
import java.util.List;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private static final int AUTHOR_MESSAGE_TYPE = 0;
    private static final int USER_MESSAGE_TYPE = 1;
    private static final int MY_MESSAGE_TYPE = 2;
    private static final int ERROR_MESSAGE_TYPE = -1;

    private final List<ICommentItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<ICommentItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        Log.e("myLogs", "onCreateViewHolder: viewType = " + viewType);
        switch (viewType){
            case ERROR_MESSAGE_TYPE :
                 view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.error_fragment_item, parent, false);

                return new ViewHolder(view);
            case AUTHOR_MESSAGE_TYPE :
                 view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.author_fragment_item, parent, false);

                return new ViewHolder(view);
            case MY_MESSAGE_TYPE :
                 view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.my_fragment_item, parent, false);

                return new ViewHolder(view);
            case USER_MESSAGE_TYPE :
                 view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.user_fragment_item, parent, false);

                return new ViewHolder(view);

        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.getItemViewType();

        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).getName());
        holder.mMessageView.setText(mValues.get(position).getMessage());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mValues == null)
            return ERROR_MESSAGE_TYPE;
        if (mValues.size() < position)
            return ERROR_MESSAGE_TYPE;

        if (mValues.get(position) instanceof AuthorCommentItem)
                return AUTHOR_MESSAGE_TYPE;
        if (mValues.get(position) instanceof UserCommentItem)
            return USER_MESSAGE_TYPE;
        if (mValues.get(position) instanceof MyCommentItem)
            return MY_MESSAGE_TYPE;

       return ERROR_MESSAGE_TYPE;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNameView;
        public final TextView mMessageView;
        public ICommentItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.tv_id);
            mMessageView = (TextView) view.findViewById(R.id.tv_message);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mMessageView.getText() + "'";
        }
    }
}

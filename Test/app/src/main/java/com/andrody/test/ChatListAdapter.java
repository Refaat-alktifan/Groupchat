package com.andrody.test;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.client.Query;

/**
 * Created by Abboudi_Aliwi on 10/24/2015.
 */
public class ChatListAdapter extends FirebaseListAdapter<Chat> {

    private String mUsername;
    private int[] colors = new int[] { 0x30FF0000, 0x300000FF };

    public ChatListAdapter(Query ref, Activity activity, int layout, String mUsername) {
        super(ref, Chat.class, layout, activity);
        this.mUsername = mUsername;
    }

    /**
     * Bind an instance of the <code>Chat</code> class to our view. This method is called by <code>FirebaseListAdapter</code>
     * when there is a data change, and we are given an instance of a View that corresponds to the layout that we passed
     * to the constructor, as well as a single <code>Chat</code> instance that represents the current data to bind.
     *
     * @param view A view instance corresponding to the layout we passed to the constructor.
     * @param chat An instance representing the current state of a chat message
     */
    @Override
    protected void populateView(View view, Chat chat) {
        // Map a Chat object to an entry in our listview
        String author = chat.getAuthor();
        TextView authorText = (TextView) view.findViewById(R.id.A_Mess);
        TextView messText = (TextView) view.findViewById(R.id.Mess);
        authorText.setText(author);
        messText.setText(chat.getMessage());
        // If the message was sent by this user, color it differently
        if (author != null && author.equals(mUsername)) {
            authorText.setText("أنت");
            messText.setTextColor(Color.GREEN);
            messText.setTextSize(18);

        } else {
            messText.setTextColor(Color.BLACK);
            messText.setTextSize(22);
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        int colorPos = position % colors.length;
        view.setBackgroundColor(colors[colorPos]);
        return view;
    }
}

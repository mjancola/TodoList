package org.hopto.mjancola.todolist;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * User: mjancola
 * Date: 10/24/12
 */
public class ExpandableListButtonFragment extends Fragment
{
    private ExpandableListButtonListener onExpandableListButtonPress;

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);

        try
        {
            onExpandableListButtonPress = (ExpandableListButtonListener)activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString() +
                    " must implement ExpandableListButtonListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View view = inflater.inflate(R.layout.expandable_list_button_fragment, container, false);


        final Button myButton = (Button) view.findViewById(R.id.expandable_list_button);
        myButton.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                onExpandableListButtonPress.onExpandableListButtonPress();
            }
        } );

        return view;


    }

    public interface ExpandableListButtonListener
    {
        public void onExpandableListButtonPress();
    }
}

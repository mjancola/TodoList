package org.hopto.mjancola.todolist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;

/**
 * User: mjancola
 * Date: 10/24/12
 */
public class ExpandableListActivity extends Activity
{
    private ExpandableListView mExpandableList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandable_list);


        mExpandableList = (ExpandableListView)findViewById(R.id.expandable_list);

        ArrayList<Parent> arrayParents = new ArrayList<Parent>();
        ArrayList<String> arrayChildren = new ArrayList<String>();

        //here we set the parents and the children
        for (int i = 0; i < 10; i++){
            //for each "i" create a new Parent object to set the title and the children
            Parent parent = new Parent();
            parent.setTitle("Parent " + i);
            arrayChildren.add("Child " + i);
            parent.setArrayChildren(arrayChildren);

            //in this array we add the Parent object. We will use the arrayParents at the setAdapter
            arrayParents.add(parent);
        }

        //sets the adapter that provides data to the list.
        mExpandableList.setAdapter(new MyCustomAdapter(ExpandableListActivity.this,arrayParents));

    }






    public static Intent createIntent(Context context)
    {
        return new Intent(context, ExpandableListActivity.class);
    }
}

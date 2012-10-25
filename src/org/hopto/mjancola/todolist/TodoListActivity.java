package org.hopto.mjancola.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class TodoListActivity extends FragmentActivity implements NewItemFragment.OnNewItemAddedListener,
                                        ExpandableListButtonFragment.ExpandableListButtonListener
{

    private ArrayAdapter<String> aa;
    private ArrayList<String> todoItems;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // get references to fragments
        FragmentManager fm = getSupportFragmentManager();
        TodoListFragment todoListFragment = (TodoListFragment)fm.findFragmentById(R.id.TodoListFragment);

        // create the array of items
        todoItems = new ArrayList<String>();

        aa = new ArrayAdapter<String>(this,
                                    R.layout.todolist_item,
                                    todoItems);

        // bind the array adapter to the list view
        todoListFragment.setListAdapter(aa);

    }

    @Override
    public void onNewItemAdded(String newItem)
    {
        todoItems.add(String.valueOf(todoItems.size() +1) + ". " + newItem);
        aa.notifyDataSetChanged();
    }

    @Override
    public void onExpandableListButtonPress()
    {
        Intent intent = ExpandableListActivity.createIntent(TodoListActivity.this);
        startActivity(intent);
    }
}

package org.hopto.mjancola.todolist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import java.io.ObjectInputStream;
import java.text.AttributedCharacterIterator;

/**
 * User: mjancola
 * Date: 10/19/12
 */
public class TodoListItemView extends TextView
{
    private Paint marginPaint;
    private Paint linePaint;
    private int paperColor;
    private float margin;

    public TodoListItemView(Context context, AttributeSet ats, int ds)
    {
        super(context, ats, ds);
        init();
    }

    public TodoListItemView (Context context)
    {
        super(context);
        init();
    }

    public TodoListItemView( Context context, AttributeSet ats)
    {
        super(context, ats);
        init();
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        // color as paper
        canvas.drawColor(paperColor);

        // Draw ruled lines
        canvas.drawLine(0,0,0,getMeasuredHeight(), linePaint);
        canvas.drawLine(0,getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(),
                linePaint);

        // Draw the margin
        canvas.drawLine(margin, 0, margin, getMeasuredHeight(), marginPaint);

        // move the text across from the margin
        canvas.save();
        canvas.translate(margin, 0);


        // use the base text view to display
        super.onDraw(canvas);
        canvas.restore();
    }

    // begin region private methods
    private void init()
    {
        // Get a reference to our resources table
        Resources myResources = getResources();

        // Create the paint brushes for onDraw
        marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        marginPaint.setColor(myResources.getColor(R.color.notepad_margin));

        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(myResources.getColor(R.color.notepad_lines));

        // Get the background color and margin
        paperColor = myResources.getColor(R.color.notepad_paper);
        margin = myResources.getDimension(R.dimen.notepad_margin);
    }
    // end region
}

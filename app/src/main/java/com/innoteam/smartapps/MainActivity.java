package com.innoteam.smartapps;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services_main);
        setupActionBar();

        ListView l1=(ListView)findViewById(R.id.services_list);
        l1.setAdapter(mListAdapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action ba
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupActionBar() {
         //ab.setIcon(R.drawable.your_left_action_icon);
        LayoutInflater inflator = LayoutInflater.from(this);
        View header = inflator.inflate(R.layout.action_bar_title, null);
        ImageView sa_image = (ImageView) header.findViewById(R.id.title);
        sa_image.setImageResource(R.drawable.actionbar_background);

        ActionBar ab = getActionBar();
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        ab.setCustomView(header);

        ab.setDisplayHomeAsUpEnabled(true);
    }

    private BaseAdapter mListAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position + 1;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.service_item, container, false);
            }


            // Because the list item contains multiple touch targets, you should not override
            // onListItemClick. Instead, set a click listener for each target individually.

            convertView.findViewById(R.id.primary_target).setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this,
                                    R.string.services_select_message,
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

            convertView.findViewById(R.id.service_action).setOnClickListener
                    (new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this,
                                    R.string.services_select_message,
                                    Toast.LENGTH_SHORT).show();


                        }
                    });
            convertView.findViewById(R.id.service_image).setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this,
                                    R.string.services_select_message,
                                    Toast.LENGTH_SHORT).show();

                        }
                    });

            return convertView;
        }
    };


}
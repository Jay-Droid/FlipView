package org.jay.flipview.flipview2.flipview2view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import org.jay.flipview.R;
import org.jay.flipview.flipview2.flip.FlipViewController;
import org.jay.flipview.flipview2.flipview2view.adapter.TravelAdapter;


/*
Copyright 2012 Aphid Mobile

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
 
   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

 */
public class FlipDynamicAdapterActivity extends Activity {

  private FlipViewController flipView;

  private TravelAdapter adapter;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setTitle(R.string.activity_title);

    flipView = new FlipViewController(this);

    adapter = new TravelAdapter(this);
    flipView.setAdapter(adapter);

    flipView.setOnViewFlipListener(new FlipViewController.ViewFlipListener() {
      @Override
      public void onViewFlipped(View view, int position) {
        if (position == adapter.getCount() - 1) {//expand the data size on the last page 
          adapter.setRepeatCount(adapter.getRepeatCount() + 1);
          adapter.notifyDataSetChanged();
        }
      }
    });

    setContentView(flipView);
  }

  @Override
  protected void onResume() {
    super.onResume();
    flipView.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
    flipView.onPause();
  }
}

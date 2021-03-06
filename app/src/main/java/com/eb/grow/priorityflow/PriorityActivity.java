package com.eb.grow.priorityflow;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import com.eb.grow.priorityflow.fragments.CalendarTrackerFragment;
import com.eb.grow.priorityflow.fragments.GoalsFragment;
import com.eb.grow.priorityflow.fragments.PrioritySlotFragment;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;

public class PriorityActivity extends AppCompatActivity
    implements CalendarTrackerFragment.OnFragmentInteractionListener,
      GoalsFragment.OnFragmentInteractionListener,
      PrioritySlotFragment.OnFragmentInteractionListener {

    // TODO Create RecylerView for PriorityFragment
    // TODO Create DatePicker for CalendarFragment
    // TODO Create RecyclerView for GoalsFragment

  FragmentManager manager = getSupportFragmentManager();

  PrioritySlotFragment priorityFragment = (PrioritySlotFragment) manager
      .findFragmentById(R.id.fragment_container);
  CalendarTrackerFragment trackerFragment = (CalendarTrackerFragment) manager
      .findFragmentById(R.id.fragment_container);
  GoalsFragment goalsFragment = (GoalsFragment) manager
      .findFragmentById(R.id.fragment_container);


  private TextView mTextMessage;
  private FirebaseAnalytics mFBAnalytics;

    /**
     * Auth members
     */
  private FirebaseAuth mFBAuth;
  private FirebaseAuth.AuthStateListener mAuthListener;

  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
      = new BottomNavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()) {
        case R.id.navigation_home:
              priorityFragment = new PrioritySlotFragment();
          manager.beginTransaction().replace(R.id.fragment_container, priorityFragment)
              .addToBackStack("Priority Slot").commit();
          return true;
        case R.id.navigation_dashboard:
          trackerFragment = new CalendarTrackerFragment();
          manager.beginTransaction().replace(R.id.fragment_container, trackerFragment)
              .addToBackStack("Priority Slot").commit();
          return true;
        case R.id.navigation_notifications:
          goalsFragment = new GoalsFragment();
          manager.beginTransaction().replace(R.id.fragment_container, goalsFragment)
              .addToBackStack("Priority Slot").commit();
          return true;
      }
      return false;
    }

  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_priority);

    if (priorityFragment == null) {
        priorityFragment = new PrioritySlotFragment();
        manager.beginTransaction().replace(R.id.fragment_container, priorityFragment)
                .addToBackStack("Priority Slot").commit();
    }
    BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
  }

  @Override
  public void onFragmentInteraction(Uri uri) {
    // Do nothing
  }
}

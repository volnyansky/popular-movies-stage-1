package stanislav.volnjanskij.popularmovies.ui.movie_details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import stanislav.volnjanskij.popularmovies.R;

public class DetailsActivity extends AppCompatActivity {

    Bundle params;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DetailsFragment fragment=new DetailsFragment();
        if (getIntent()!=null) {
            params=getIntent().getExtras();
            fragment.setArguments(params);
            getFragmentManager().beginTransaction().add(R.id.container,fragment).commit();
        }else if(savedInstanceState!=null){
            fragment.setArguments(savedInstanceState);
            getFragmentManager().beginTransaction().add(R.id.container,fragment).commit();
        }else {
            finish();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return (super.onOptionsItemSelected(item));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putAll(getIntent().getExtras());
    }
}

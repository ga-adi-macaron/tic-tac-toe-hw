package ly.generalassemb.drewmahrt.tictactoe;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Scott Lindley on 10/21/2016.
 */

public class MainActivityRecyclerAdapter extends RecyclerView.Adapter<MainActivityViewHolder>{
    private ArrayList<String> mWinners;

    public MainActivityRecyclerAdapter(ArrayList<String> winners) {
        mWinners = winners;
    }

    @Override
    public MainActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View returnView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.winner_list, parent, false);
        return new MainActivityViewHolder(returnView);
    }

    @Override
    public void onBindViewHolder(MainActivityViewHolder holder, int position) {
        holder.winnerName.setText(mWinners.get(position));
    }

    @Override
    public int getItemCount() {
        return mWinners.size();
    }
}

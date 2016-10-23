package ly.generalassemb.drewmahrt.tictactoe;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

/**
 * Created by Joe on 10/21/16.
 */

public class WinnerAdapter extends RecyclerView.Adapter<WinnerViewHolder> {
    private LinkedList<Player> mPlayersWon;

    public WinnerAdapter(LinkedList<Player> playersWon) {
        mPlayersWon = playersWon;
    }

    @Override
    public WinnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.winner_item,parent,false);
        return new WinnerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(WinnerViewHolder holder, int position) {
        holder.mWinner.setText((mPlayersWon.size()-position)+": "+mPlayersWon.get(position).getName()+" Won.");
    }

    @Override
    public int getItemCount() {
        return mPlayersWon.size();
    }
}

package ly.generalassemb.drewmahrt.tictactoe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Scott Lindley on 10/21/2016.
 */

public class MainActivityViewHolder extends RecyclerView.ViewHolder{
    public TextView winnerName;

    public MainActivityViewHolder(View itemView) {
        super(itemView);

        winnerName = (TextView)itemView.findViewById(R.id.winner_name);
    }
}

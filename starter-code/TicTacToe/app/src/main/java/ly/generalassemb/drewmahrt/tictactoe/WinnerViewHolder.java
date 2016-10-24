package ly.generalassemb.drewmahrt.tictactoe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Joe on 10/21/16.
 */

public class WinnerViewHolder extends RecyclerView.ViewHolder {
    TextView mWinner;

    public WinnerViewHolder(View itemView) {
        super(itemView);
        mWinner = (TextView) itemView.findViewById(R.id.winner_item);
    }
}

package ly.generalassemb.drewmahrt.tictactoe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by NikitaShuvalov on 10/23/16.
 */

public class ResultsViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    public ResultsViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(R.id.text);
    }
}

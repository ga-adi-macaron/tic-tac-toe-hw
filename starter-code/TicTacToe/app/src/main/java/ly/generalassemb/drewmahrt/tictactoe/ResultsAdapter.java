package ly.generalassemb.drewmahrt.tictactoe;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by NikitaShuvalov on 10/23/16.
 */

public class ResultsAdapter extends RecyclerView.Adapter<ResultsViewHolder> {
    List<GameResult> mGameResults;

    public ResultsAdapter(List<GameResult> gameResults){

        mGameResults= gameResults;

    }
    @Override
    public ResultsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resultsholderform, null);
        return new ResultsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ResultsViewHolder holder, int position) {
        TextView textView = (TextView) holder.itemView.findViewById(R.id.text);
        RelativeLayout layout = (RelativeLayout)holder.itemView.findViewById(R.id.holder_layout);

        textView.setText(mGameResults.get(position).getWinner());
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "This will load game details.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mGameResults.size();
    }
}

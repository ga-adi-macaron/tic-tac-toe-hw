package ly.generalassemb.drewmahrt.tictactoe;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NikitaShuvalov on 10/23/16.
 */

public class ResultsAdapter extends RecyclerView.Adapter<ResultsViewHolder> {
    List<GameResult> mGameResults;

    public ResultsAdapter(List<GameResult> gameResults){
        //This will keep the list down to the last 3 games. The if statements prevent an Out of Bounds exception.
        //FixMe:This bit of code doesn't work, so I'm just going to use a full recycler list for displaying results.
//        int i = gameResults.size()-4;
//        int e = gameResults.size();
//        if(i<0){
//            i=0;
//        }
//        if(e==0){
//            mGameResults =  gameResults;
//        }else{
//            mGameResults = gameResults.subList(i,e);
//        }
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
        LinearLayout layout = (LinearLayout)holder.itemView.findViewById(R.id.holder_layout);

        textView.setText(mGameResults.get(position).getWinner()+" won!");
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "This will load game details.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.i("Size of mGameResults: ", Integer.toString(mGameResults.size()));
        return mGameResults.size();
    }
}

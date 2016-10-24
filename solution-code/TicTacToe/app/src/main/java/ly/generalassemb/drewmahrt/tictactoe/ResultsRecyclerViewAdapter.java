package ly.generalassemb.drewmahrt.tictactoe;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Adapter for the results RecyclerView, with the ViewHolder defined as an inner class.
 *
 * Created by charlie on 10/20/16.
 */

public class ResultsRecyclerViewAdapter
        extends RecyclerView.Adapter<ResultsRecyclerViewAdapter.ResultViewHolder> {

    private List<String> mResults;

    public ResultsRecyclerViewAdapter(List<String> results) {
        mResults = results;
    }

    @Override
    public ResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ResultViewHolder holder, int position) {
        holder.bindData(mResults.get(position));
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    // Rather than put this class in its own file, I'm making it an *inner class* inside the adapter.
    // This is often a bad idea (for reasons too complicated to explain here) but in this case it's OK.
    public class ResultViewHolder extends RecyclerView.ViewHolder {

        private TextView mResultText;

        public ResultViewHolder(View itemView) {
            super(itemView);
            mResultText = (TextView) itemView.findViewById(android.R.id.text1);
        }

        // If we had a more complicated view, we could pass a custom object as a parameter here,
        // and use the data inside it to populate various views, but we only have one for now.
        public void bindData(String result) {
            mResultText.setText(result);
        }
    }
}

package ly.generalassemb.drewmahrt.tictactoe;

import java.util.LinkedList;
import java.util.List;

/**
 * Singleton class to hold game results in memory as long as the app is open.
 *
 * Created by charlie on 10/20/16.
 */
public class ResultsHolder {
    private static ResultsHolder sInstance;

    private List<String> mResults;

    private ResultsHolder() {
        mResults = new LinkedList<>();
    }

    public static ResultsHolder getInstance() {
        if (sInstance == null) {
            sInstance = new ResultsHolder();
        }
        return sInstance;
    }

    public void addResult(String result) {
        // Add at the beginning rather than the end so latest result is first
        mResults.add(0, result);
    }

    public List<String> getResults() {
        return mResults;
    }
}

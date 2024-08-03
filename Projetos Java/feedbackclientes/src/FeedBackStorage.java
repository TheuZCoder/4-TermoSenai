import java.util.ArrayList;
import java.util.List;

public class FeedBackStorage {
    private List<Feedback> feedbacks = new ArrayList<>();

    public void addFeedback(Feedback feedback) {
        feedbacks.add(feedback);
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }
}

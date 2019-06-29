package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Feedback {
    private int feedbackId;
    private String feedback;
    private Timestamp feedbackIime;
    private Integer authorId;

    @Id
    @Column(name = "feedback_id")
    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    @Basic
    @Column(name = "feedback")
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Basic
    @Column(name = "feedback_iime")
    public Timestamp getFeedbackIime() {
        return feedbackIime;
    }

    public void setFeedbackIime(Timestamp feedbackIime) {
        this.feedbackIime = feedbackIime;
    }

    @Basic
    @Column(name = "author_id")
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback1 = (Feedback) o;
        return feedbackId == feedback1.feedbackId &&
                Objects.equals(feedback, feedback1.feedback) &&
                Objects.equals(feedbackIime, feedback1.feedbackIime) &&
                Objects.equals(authorId, feedback1.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackId, feedback, feedbackIime, authorId);
    }
}

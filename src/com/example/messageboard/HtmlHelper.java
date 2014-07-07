package com.example.messageboard;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

public class HtmlHelper {

    public static String generateRowsFromTopicList(List<Topic> topics) {
        String output = "";
        if (topics.size() < 1) {
            return "<tr><td colspan='5'>No posts...</td></tr>";
        } else {
            for (Iterator iterator = topics.iterator(); iterator.hasNext();) {
                Topic t = (Topic) iterator.next();
                Message m = DatabaseHelper.getMostRecentMessage(t.getTitle());
                Timestamp creationDate = new Timestamp(t.getTimestamp().getTimeInMillis());
                Timestamp mostRecent = new Timestamp(m.getTimestamp().getTimeInMillis());
                int subLen;
                String dots;
                if (m.getText().length() < 50) {
                    subLen = m.getText().length();
                    dots = "";
                }
                else {
                    subLen = 50;
                    dots = "...";
                }
                output += "<tr><td><span>" + t.getTitle() + "</span></td><td>" + t.getCreatedBy() + "</td><td>"
                        + creationDate.toString() + "</td><td>" + m.getText().substring(0, subLen)
                        + dots + "<form name = \"" + t.getTitle()
                        + "\" method=\"post\" action=\"view_topic.jsp\">"
                        + "<input type='hidden' name='title' value='" + t.getTitle() + "'><br>"
                        + "<input type='submit' value='View Topic'></form>"
                        + "</td><td><p><span>Created By:</span> " + m.getCreatedBy()
                        + "</p><p><span>On:</span> "
                        + mostRecent.toString() + "</p></td></tr>";
            }
        }
        return output;
    }

    public static String generateTopicRows(List<Message> messages) {
        String output ="";
        for (Iterator iterator = messages.iterator(); iterator.hasNext();) {
            Message m = (Message) iterator.next();
            Timestamp timestamp = new Timestamp((m.getTimestamp().getTimeInMillis()));
            output += "<tr><td><p><span>Created By:</span> " + m.getCreatedBy() + "</p><p><span>At:</span> "
                    + timestamp.toString() + "</td><td>" + m.getText() + "</td></tr>";
        }
        return output;
    }

    public static String generateForm(String title) {
        String output = "<input type='hidden' name='title' value='" + title + "'><br>";
        return output;
    }
}

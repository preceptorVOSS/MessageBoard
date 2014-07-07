package com.example.messageboard;

public class JspHelper {

    public static String generateMessageBoardRows() {
        String output = HtmlHelper.generateRowsFromTopicList(DatabaseHelper.getTopicList());
        return output;
    }

    public static String generateTopicRows(String title) {
        String output = HtmlHelper.generateTopicRows(DatabaseHelper.getMessageList(title));
        return output;
    }

    public static String generateHiddenForm(String title) {
        String output = HtmlHelper.generateForm(title);
        return output;
    }
}

package com.study.chapter3;

public class HtmlExporter implements Exporter{
    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "<!DOCTYPE HTML>";
        result += "<html lang='en'>";
        result += "<head><title>Bank Transaction</title></head>";

        result += "<body>";
        result += "<ul>";

        result += "<li><strong>The sum is</strong>: " + summaryStatistics.getSum() + "</li>";
        result += "<li><strong>The average is</strong>: " + summaryStatistics.getAvg() + "</li>";
        result += "<li><strong>The max is</strong>: " + summaryStatistics.getMax() + "</li>";
        result += "<li><strong>The min is</strong>: " + summaryStatistics.getMin() + "</li>";

        result += "</ul>";
        result += "</body>";
        result += "</html>";

        return result;
    }
}

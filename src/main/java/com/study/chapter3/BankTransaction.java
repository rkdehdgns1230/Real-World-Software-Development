package com.study.chapter3;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;

    public BankTransaction(LocalDate date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Notification validate(){
        final Notification notification = new Notification();

        if(description.length() > 100){
            notification.addError("The description is too long.");
        }

        if(date.isAfter(LocalDate.now())){
            notification.addError("date cannot be in the future");
        }
        return notification;
    }

    @Override
    public String toString(){
        return "BankTransaction{" +
                "date=" + date +
                "amount=" + amount +
                "description=" + description + "\n}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, description);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        BankTransaction that = (BankTransaction) obj;
        // 동등성 비교
        return Double.compare(this.amount, that.amount) == 0 &&
                date.equals(that.date) &&
                description.equals(that.description);
    }
}

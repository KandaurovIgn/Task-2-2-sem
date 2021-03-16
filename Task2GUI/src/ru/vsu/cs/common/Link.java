package ru.vsu.cs.common;

public class Link {
    private String word;
    private Link next;

    public Link(String word, Link next) {
        this.word = word;
        this.next = next;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public String getWord() {
        return word;
    }
}

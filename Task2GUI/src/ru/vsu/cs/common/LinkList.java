package ru.vsu.cs.common;

public class LinkList {
    private Link first;
    private Link lastUsed;

    public LinkList() {
        first = null;
    }

    public void insertFirst(String word) {
        Link newLink = new Link(word, first);
        first = newLink;
        lastUsed = first;
    }

    public int swapEveryTwo() {
        if (first != null && first.getNext() != null) {
            Link newFirst = first.getNext();
            Link tempHead;
            Link tempFirst = first;
            Link tempSecond = first.getNext();
            while (true) {
                tempFirst.setNext(tempSecond.getNext());
                tempSecond.setNext(tempFirst);
                tempHead = tempFirst;

                if (tempFirst.getNext() != null)
                    tempFirst = tempFirst.getNext();
                else
                    break;
                if (tempFirst.getNext() != null)
                    tempSecond = tempFirst.getNext();
                else
                    break;
                tempHead.setNext(tempSecond);
            }
            first = newFirst;

            return 1;
        }

        return -1;
    }

    public String getWord() {
        if (lastUsed == null)
            return null;
        else {
            String word = lastUsed.getWord();
            lastUsed = lastUsed.getNext();
            return word;
        }
    }

    public void toStart() {
        lastUsed = first;
    }
}

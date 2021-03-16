package ru.vsu.cs.gui;

import ru.vsu.cs.common.LinkList;
import ru.vsu.cs.utils.FileUtils;

import java.io.IOException;

public class ListOfWords {
    private LinkList linkList;
    private String outputFile;

    public ListOfWords(LinkList linkList, String outputFile) {
        this.linkList = linkList;
        this.outputFile = outputFile;
    }

    public String getWord() {
        return linkList.getWord();
    }

    public void saveAll() throws IOException {
        linkList.toStart();
        FileUtils.writeToFile(linkList, outputFile);
    }

    public void swapEveryTwo() {
        linkList.swapEveryTwo();
    }

    public void addWord(String word) {
        linkList.insertFirst(word);
    }

    public void toStart()
    {
        linkList.toStart();
    }
}

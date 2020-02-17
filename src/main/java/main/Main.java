package main;

import document.Document;
import search.Searcher;
import tfidf.TFIDFEngine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Document doc1 = new Document("document 1", "The brown fox jumped over the brown dog.");
        Document doc2 = new Document("document 2", "The lazy brown dog, sat in the other corner");
        Document doc3 = new Document("document 3", "The Red Fox bit the lazy dog!");

        List<Document> documents = new ArrayList<>();
        documents.add(doc1);
        documents.add(doc2);
        documents.add(doc3);

        TFIDFEngine engine = new TFIDFEngine(documents);
        Searcher searcher = new Searcher(engine);

        Collection<Document> resultsBrown = searcher.searchTerm("brown");
        Collection<Document> resultsFox = searcher.searchTerm("fox");
        Collection<Document> resultsDog = searcher.searchTerm("dog");

        System.out.println("Brown: " + resultsBrown);
        System.out.println("Fox: " + resultsFox);
        System.out.println("Dog: " + resultsDog);
    }
}

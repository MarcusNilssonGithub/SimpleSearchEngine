package main;

import searchengine.document.Document;
import searchengine.engine.tfidf.TFIDFEngine;
import searchengine.search.Searcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Build search engine
        Document doc1 = new Document("document 1", "The brown fox jumped over the brown dog.");
        Document doc2 = new Document("document 2", "The lazy brown dog, sat in the other corner");
        Document doc3 = new Document("document 3", "The Red Fox bit the lazy dog!");

        List<Document> documents = new ArrayList<>();
        documents.add(doc1);
        documents.add(doc2);
        documents.add(doc3);

        TFIDFEngine engine = new TFIDFEngine(documents);
        Searcher searcher = new Searcher(engine);

        System.out.println("Documents in corpus: ");
        System.out.println(doc1 + "\n" + doc2 + "\n" + doc3 + "\n");
        System.out.println("Do Searches: ");

        // Pre-defined terms
        Collection<Document> resultsBrown = searcher.searchTerm("brown");
        Collection<Document> resultsFox = searcher.searchTerm("fox");
        Collection<Document> resultsDog = searcher.searchTerm("dog");
        System.out.println("Brown:  " + resultsBrown);
        System.out.println("Fox:    " + resultsFox);
        System.out.println("Dog:    " + resultsDog);

        // Manual input
        System.out.println();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Manual Search, enter term: ");
            String term = scan.nextLine();
            System.out.println(searcher.searchTerm(term));
        }

    }
}

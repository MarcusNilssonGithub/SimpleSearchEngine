# Simple TF-IDF Search Engine
A search engine that, provided with a list of documents, supports single term searches and returns a result list sorted by TF-IDF. Results also include the TF-IDF score.

## Example
The following documents are indexed:  
Document 1: “The brown fox jumped over the brown dog.”  
Document 2: “The lazy brown dog, sat in the other corner”  
Document 3: “The Red Fox bit the lazy dog!”  

A search for “brown” should now return the list: [document 1, document 2]  
A search for “fox” should return the list: [document 3, document 1]  
A search for “dog” should return the list: [document 3, document 1, document 2  

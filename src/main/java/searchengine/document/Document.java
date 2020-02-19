package searchengine.document;

public class Document {
    private String name;
    private String text;

    public Document(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return this.name;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return this.name + ": " + this.text;
    }
}

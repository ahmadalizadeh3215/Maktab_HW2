package Library.entity;

public class Book {

    private String name;
    private String subject;
    private String publisher;
    private Integer publishYear;
    private Integer quantity;
    private Author author;

    public Book(String name, String subject, String publisher, Integer publishYear,Author author, Integer quantity) {
        this.name = name;
        this.subject = subject;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.author = author;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

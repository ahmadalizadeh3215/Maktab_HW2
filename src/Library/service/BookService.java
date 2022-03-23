package Library.service;

import Library.entity.Book;
import Library.util.FakeDB;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private final FakeDB fakeDB;

    public BookService(FakeDB fakeDB) {
        this.fakeDB = fakeDB;
    }

    public List<Book> getBookByAuthorName(String firstName, String surName){
        List<Book> list = new ArrayList<>();
        for (Book search : fakeDB.getBooks()) {
            if(search.getAuthor().getFirstName().equals(firstName) && search.getAuthor().getSurName().equals(surName)){
                list.add(search);
            }
        }
        return list;
    }

    public Book getBookInfo(String name){
        for (Book search : fakeDB.getBooks()) {
            if(search.getName().equals(name)){
                return search;
            }
        }
        return null;
    }

    public List<Book> getAllBooks(){
        return fakeDB.getBooks();
    }

    public Boolean isBorrow(String bookName){
        if(getBookInfo(bookName).getQuantity() != null && getBookInfo(bookName).getQuantity() > 0){
            return true;
        }
        return false;
    }
}

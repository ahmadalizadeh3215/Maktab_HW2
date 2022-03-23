package Library.service;

import Library.entity.Author;
import Library.util.FakeDB;

import java.util.ArrayList;
import java.util.List;

public class AuthorService {

    private FakeDB fakeDB;

    public AuthorService(FakeDB fakeDB) {
        this.fakeDB = fakeDB;
    }

    public List<Author> getAuthors(String name) {
        List<Author> list =  new ArrayList<>();
        for (Author search : fakeDB.getAuthors()) {
            if(search.getSurName().equals(name)){
                list.add(search);
            }
        }
        return list;
    }
}

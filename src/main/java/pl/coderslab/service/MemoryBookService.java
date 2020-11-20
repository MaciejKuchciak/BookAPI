package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemoryBookService implements BookService {

    public List<Book> books;
    private static Long nextId = 1L;

    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(null, "9788324631766", "Thinking in Java", "Bruce Eckel","Helion", "programming"));
        books.add(new Book(null, "9788324627738", "Rusz	głową Java.", "Sierra Kathy,	Bates Bert", "Helion","programming"));
        books.add(new Book(null, "9780130819338", "Java 2. Podstawy", "Cay Horstmann,	Gary Cornell", "Helion","programming"));
        books.add(new Book(null, "3451283092103", "Władca Pierścieni", "John Ronald Reuel Tolkien", "Allen & Unwin", "fantasy"));
        books.add(new Book(null, "4567983209836", "Wiedźmin", "Andrzej Sapkowski", "SuperNowa", "fantasy"));
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void add(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public Optional<Book> get(Long id) {
        return books.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    @Override
    public void delete(Long id) {
        if (get(id).isPresent()) {
            books.remove(this.get(id).get());
        }
    }

    @Override
    public void update(Book book) {
        if (this.get(book.getId()).isPresent()) {
            int indexOf = books.indexOf(this.get(book.getId()).get());
            books.set(indexOf, book);
        }
    }
}

package pl.coderslab.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

public class MemoryBookService {

    private List<Book> list;
    private static Long nextId = 4L;

    public void MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book){
        // operacje na obiekcie book
    }


}

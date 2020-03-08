package practica1.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping("/")
    public void addAuthor(@RequestBody Author author) {
        this.authorRepository.save(author);
    }

    @PutMapping("/{id}")
    public void editAuthor(@PathVariable long id, @RequestBody Author author) {
        Optional<Author> optional = this.authorRepository.findById(id);
        if(optional.isPresent()){
            Author previousAuthor = optional.get();
            previousAuthor.updateAuthor(author);
            this.authorRepository.save(previousAuthor);
        }
    }
}

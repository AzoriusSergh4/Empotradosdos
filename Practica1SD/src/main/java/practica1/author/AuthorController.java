package practica1.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping("/addAuthor")
    public String addAuthor(Model model) {
        return "author";
    }

    @RequestMapping("/editAuthor/{id}")
    public String editAuthor(Model model, @PathVariable long id) {
        Optional<Author> optional = this.authorRepository.findById(id);
        if(optional.isPresent()){
            model.addAttribute("author", optional.get());
        }

        return "editAuthor";
    }

    @PostMapping("/")
    public String addAuthor(Model model, @RequestParam Map<String, String> mappedAuthor) {
        Author author = this.createAuthorFromMap(mappedAuthor);

        this.authorRepository.save(author);

        return "galeria";
    }

    @GetMapping("/{id}")
    public String editAuthor(Model model, @PathVariable long id,  @RequestParam Map<String, String> mappedAuthor) {
        Author author = this.createAuthorFromMap(mappedAuthor);

        Optional<Author> optional = this.authorRepository.findById(id);
        if(optional.isPresent()){
            Author previousAuthor = optional.get();
            previousAuthor.updateAuthor(author);
            this.authorRepository.save(previousAuthor);
        }

        return "galeria";
    }

    private Author createAuthorFromMap(Map<String, String> mappedAuthor) {
        Author author = new Author();

        author.setName(mappedAuthor.get("name"));
        author.setSurnames(mappedAuthor.get("surnames"));
        author.setNif(mappedAuthor.get("nif"));
        author.setBirthYear(Integer.parseInt(mappedAuthor.get("birthYear")));
        author.setBirthCountry(mappedAuthor.get("birthCountry"));
        author.setEmail(mappedAuthor.get("email"));
        author.setPhone(mappedAuthor.get("phone"));
        author.setPostalAddress(mappedAuthor.get("postalAddress"));

        return author;
    }
}

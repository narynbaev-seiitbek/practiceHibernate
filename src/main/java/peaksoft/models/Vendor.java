package peaksoft.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name="vendors")
@Getter@Setter
@ToString
@NoArgsConstructor
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @OneToMany(cascade = {PERSIST,MERGE},fetch = FetchType.EAGER)
    private List<Book> books;

    public Vendor(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setBook(Book newBook) {
        this.books.add(newBook);
    }

    public void removeBookById(Long id) {
        books.removeIf(book -> book.getId()==id);
    }
}
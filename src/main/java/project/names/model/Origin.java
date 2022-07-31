package project.names.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter @NoArgsConstructor @Entity
public class Origin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String originGroup;
    private String ethnicGroup;
}

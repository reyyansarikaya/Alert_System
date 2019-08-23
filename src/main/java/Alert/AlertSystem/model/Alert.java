package Alert.AlertSystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.http.HttpMethod;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Alert {

    @Id
    @GeneratedValue
    private Long id;


    private String name;
    private String url;
    private String method;
    private Long periyod;
    private Long remainingTime;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="resultId")
    private Set<Result> results;
}

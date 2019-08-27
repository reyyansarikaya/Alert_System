package Alert.AlertSystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
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
    private Long remaning_time = 0L ;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="resultId")
    private Set<Result> Result;


}

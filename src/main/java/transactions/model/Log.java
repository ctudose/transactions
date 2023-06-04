package transactions.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Log {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @NotNull
    @Size(
            min = 2,
            max = 255,
            message = "Info is required, maximum 255 characters."
    )
    @Getter
    @Setter
    private String info;

    @NotNull
    @Getter
    @Setter
    private LocalDate date;

    public Log(String info) {
        this.info = info;
        this.date = LocalDate.now();
    }
}

package java.ee.tlu.Kodutoo05.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Table(name = "auto")
@Entity
@NoArgsConstructor
public class AutoEntity {
    @Id
    private String tootja;
    private String mudel;
    private int aasta;
    private int labisoit;


}

package pks.example.ddd.pet.core;

import java.sql.Date;

import org.javamoney.moneta.Money;

// import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
// import lombok.NoArgsConstructor;

@Data @Builder // (buildMethodName = "build")
public class Pet {
    @Builder.Default private Long id = null;
    @Builder.Default private String name = null;
    private Double age;
    private Money value;
    private Date birthday;
    
    /*
     * lots of attempts to put in validation and throw exception if ( name == null )
     * but no luck so far.  likely need a factory.
     */

    public static Pet newPet(String name, Double age, Money value, Date birthday) {
        return Pet.builder()
                    .name(name)
                    .build();
    }

    // public Pet build() {
    //     // if (name == null || name.length() == 0) { throw new RuntimeException("Cannot create a pet without a name."); }
    //     return new Pet(id,name,age,value,birthday);
    // }
    
    // public Pet() {
    // }

    // @Default
    // public Pet(String name) {
    //     this.name = name;
    //     // if (name != null && name.length() != 0) { this.name = name; } else { throw new RuntimeException("cannot create a pet without a name."); }
    // }

    // public Pet(String name, Double age) {
    //     this(name);
    //     this.age = age;
    // }

    // public Pet(String name, Double age, Money value) {
    //     this(name);
    //     this.age   = age;
    //     this.value = value;
    // }
}

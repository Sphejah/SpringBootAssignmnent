import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class CourseRepository {
    // Getter and setter methods
    private long id;
        private String name;
        private String description;

        // Constructors
        public CourseRepository() {
        }

        public CourseRepository(Long id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }

}



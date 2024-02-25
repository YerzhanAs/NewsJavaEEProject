package kz.bitlab.model;

public class NewsCategories {

    private Long id;

    private String name;

    public NewsCategories() {
    }

    public NewsCategories(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NewsCategories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

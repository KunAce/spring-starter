public class Book {
    private Integer id;
    private String name;
    private Double price;

    // Constructors
    public Book() {
        System.out.println("-------book init-------");
    }

    public Book(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

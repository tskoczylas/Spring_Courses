package pl.javastart.equipy.dtos;


import java.util.Objects;

public class AssetsDto {

    long id;
    String name;
    String description;
    String serialNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssetsDto assetsDto = (AssetsDto) o;
        return id == assetsDto.id &&
                Objects.equals(name, assetsDto.name) &&
                Objects.equals(description, assetsDto.description) &&
                Objects.equals(serialNumber, assetsDto.serialNumber) &&
                Objects.equals(category, assetsDto.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, serialNumber, category);
    }

    String category;


    public AssetsDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public AssetsDto(long id, String name, String description, String serialNumber, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.serialNumber = serialNumber;
        this.category = category;
    }

    @Override
    public String toString() {
        return "AssetsDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

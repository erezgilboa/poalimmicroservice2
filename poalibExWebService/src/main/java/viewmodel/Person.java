package viewmodel;

import java.io.Serializable;

public class Person implements Serializable {



    private String id;

    private AddressVm addressVm;

    private Gender gender;

    private String name;

    private Integer age;

    private Double height;

    private Double weight;

    private ResultWithSuccess<String> saveResult = new ResultWithSuccess<>();

    public Person(String id, AddressVm addressVm, Gender gender, String name, Integer age, Double height, Double weight) {
        this.id = id;
        this.addressVm = addressVm;
        this.gender = gender;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.saveResult.setSuccess(true);

    }

    public Person() {
        this.saveResult.setSuccess(true);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AddressVm getAddressVm() {
        return addressVm;
    }

    public void setAddressVm(AddressVm addressVm) {
        this.addressVm = addressVm;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public ResultWithSuccess<String> getSaveResult() {
        return saveResult;
    }

    public void setSaveResult(ResultWithSuccess<String> saveResult) {
        this.saveResult = saveResult;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", address=" + addressVm +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", saveResult=" + saveResult +
                '}';
    }
}

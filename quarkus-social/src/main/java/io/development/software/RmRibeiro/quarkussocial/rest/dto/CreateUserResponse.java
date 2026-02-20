package io.development.software.RmRibeiro.quarkussocial.rest.dto;

public class CreateUserResponse {
    public Long id;
    public String name;
    public Integer age;
    public String email;

    public CreateUserResponse(Long id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}

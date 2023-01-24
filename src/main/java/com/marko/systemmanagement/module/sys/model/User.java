package com.marko.systemmanagement.module.sys.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EnableJpaAuditing
@Table(name = "sys_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty("username")
    @Column(name = "username")
    @NotBlank(message = "username is mandatory")
    private String username;

    @JsonProperty("password")
    @Column(name = "password")
    @NotBlank(message = "password is mandatory")
    private String password;

    @Column(name = "fullname", nullable = false)
    @JsonProperty("full_name")
    @NotBlank(message = "Full Name is mandatory")
    private String fullname;

    @Column(name = "sex", nullable = false)
    @JsonProperty("sex")
    private char sex;

    @Column(name = "contact_number", nullable = false)
    @JsonProperty("contact_number")
    private String contactNumber;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Email must be valid")
    private String email;

    @Column(name = "create_time")
    @JsonProperty("created_at")
    private Date createdAt;

    @Column(name = "update_time")
    @JsonProperty("updated_at")
    private Date updatedAt;

    @PrePersist
    public void onPrePersist() {
        setCreatedAt(new Date());
        setUpdatedAt(new Date());
    }
    @PreUpdate
    public void onPreUpdate () {
        setUpdatedAt (new Date ());
    }

}

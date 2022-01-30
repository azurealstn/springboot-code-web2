package com.azurealstn.springbootcodeweb2.domain.member;

import com.azurealstn.springbootcodeweb2.domain.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
public class Member extends BaseEntity {

    @Id
    private String email;

    private String password;

    private String name;
}

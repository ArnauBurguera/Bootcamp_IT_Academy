package com.BurgueraCallesArnau.s05t02n01.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;//Maybe not needed because i don't have any
    private String email;
    private String password;

}

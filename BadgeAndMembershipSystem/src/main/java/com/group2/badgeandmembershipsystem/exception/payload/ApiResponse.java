package com.group2.badgeandmembershipsystem.exception.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private boolean success;
    private HttpStatus status;
    private String message;
}

package com.group2.badgeandmembershipclient.dto;

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

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}

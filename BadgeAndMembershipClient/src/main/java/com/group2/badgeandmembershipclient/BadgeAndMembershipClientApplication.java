package com.group2.badgeandmembershipclient;

import com.group2.badgeandmembershipclient.dto.*;
import com.group2.badgeandmembershipclient.enums.MembershipType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class BadgeAndMembershipClientApplication implements CommandLineRunner {

    @Value("${app.serverURL}")
    private String serverURL;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpHeaders httpHeaders;
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        SpringApplication.run(BadgeAndMembershipClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        welcome();
        loginFunction();
    }

    private void welcome() {
        System.out.println("Welcome to MIU Badge and Membership Management System");
    }

    private void loginFunction() {
        try{
            System.out.println("__________________________________");
            System.out.println("____________Login__________");
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            LoginRequest loginRequest = new LoginRequest(username, password);
            ResponseEntity<LoginResponse> response = restTemplate.postForEntity(serverURL + "/authentication", loginRequest, LoginResponse.class);
            fetchMemberships(response.getBody().getMember().getId(), MembershipType.CHECKER, response.getBody());
        }catch (Exception ex){
            System.out.println("Invalid Credentials");
            loginFunction();
        }
    }

    private void fetchMemberships(long id, MembershipType membershipType, LoginResponse loginResponse) {
        try {
            System.out.println("__________________________________");
            System.out.println("__________________________________");
            System.out.println("__________________________________");
            System.out.println("__________________________________");
            System.out.println("__________________________________");
            System.out.println(loginResponse.getMember());
            httpHeaders.setBearerAuth(loginResponse.getAccessToken());
            HttpEntity request = new HttpEntity<>(httpHeaders);
            ResponseEntity<MembershipDTO[]> response = restTemplate.exchange(
                    serverURL + "/members/{id}/memberships/filterBy?membershipType="+MembershipType.CHECKER,
                    HttpMethod.GET,
                    request,
                    MembershipDTO[].class,
                    id
            );
//            MembershipDTO[] memberships = restTemplate.getForObject(serverURL + "/members/{id}/memberships/filterBy?membershipType={membershipType}", MembershipDTO[].class, id, membershipType);
            System.out.println("Your Membership plans are: ");
            MembershipDTO[] memberships = response.getBody();
            for (MembershipDTO membership : memberships) {
                System.out.println(membership.getPlan().getId() + " : " + membership.getPlan().getName());
            }
            boolean isInvalid;
            do {
                isInvalid = false;
                System.out.println("Select your membership plan: ");
                String enteredId = scanner.nextLine();
                if (Arrays.stream(memberships).filter(membership -> String.valueOf(membership.getPlan().getId()).equals(enteredId)).count() == 0) {
                    isInvalid = true;
                    System.out.println("You entered invalid id, Please enter again:");
                }else{
                getLocationsForPlan(enteredId,loginResponse);
                }
            } while (isInvalid);
        } catch (Exception ex) {
            System.out.println("You are not allowed to proceed further");
            System.out.println("Login again as Checker");
            loginFunction();
        }
    }

    private void getLocationsForPlan(String planId,LoginResponse loginResponse) {
        try {
            httpHeaders.setBearerAuth(loginResponse.getAccessToken());
            HttpEntity request = new HttpEntity<>(httpHeaders);
            ResponseEntity<LocationDTO[]> response = restTemplate.exchange(
                    serverURL + "/plans/{id}/locations",
                    HttpMethod.GET,
                    request,
                    LocationDTO[].class,
                    1
            );
            LocationDTO[] locations = response.getBody();
            System.out.println("Your locations are: ");
            for (LocationDTO location : locations) {
                System.out.println(location.getId() + " : " + location.getLocationId() + " : " + location.getName());
            }
            boolean isLocationInvalid;
            do {
                isLocationInvalid = false;
                System.out.println("Select your location: ");
                String enteredId = scanner.nextLine();
                if (Arrays.stream(locations).filter(location -> location.getLocationId().equals(enteredId)).count() == 0) {
                    isLocationInvalid = true;
                    System.out.println("You entered invalid id, Please enter again:");
                }else{
                doTransaction(planId, enteredId,loginResponse);
                }
            } while (isLocationInvalid);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("No locations found for this plan");
        }
    }

    private void doTransaction(String planId, String locationId,LoginResponse loginResponse) {
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("Badge Checking starts");
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        while (true) {
            System.out.println("Enter your badge number: ");
            String badgeId = scanner.nextLine();
            httpHeaders.setBearerAuth(loginResponse.getAccessToken());
            TransactionRequestDTO transactionRequestDTO = new TransactionRequestDTO();
            transactionRequestDTO.setBadgeId(badgeId);
            transactionRequestDTO.setPlanId(Long.parseLong(planId));
            transactionRequestDTO.setLocationId(locationId);
            HttpEntity<TransactionRequestDTO> request = new HttpEntity<>(transactionRequestDTO, httpHeaders);
            ApiResponse response = restTemplate.postForObject(serverURL + "/transactions", request, ApiResponse.class);
            System.out.println(response);
        }
    }
}

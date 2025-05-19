package com.example.usersubscriptionsapi.controllers;

import com.example.usersubscriptionsapi.models.dtos.SubscriptionDto;
import com.example.usersubscriptionsapi.models.dtos.UserDto;
import com.example.usersubscriptionsapi.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @Operation(summary = "Create a User ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created a User",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubscriptionDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request content",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Request to the wrong path or with an error in the URL.",
                    content = @Content),
            @ApiResponse(responseCode = "405", description = "Method is not supported at this URL or the HTTP method is not correct when requested",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "Incorrect data entry or the user doesn't exist",
                    content = @Content)
    })

    @PostMapping()
    void newUser(@RequestBody @Valid UserDto userDto) {
        userService.create(userDto);
    }


    @Operation(summary = "Update a User ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update a User",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubscriptionDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request content",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Request to the wrong path or with an error in the URL.",
                    content = @Content),
            @ApiResponse(responseCode = "405", description = "Method is not supported at this URL or the HTTP method is not correct when requested",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "Incorrect data entry or the user doesn't exist",
                    content = @Content)
    })

    @PutMapping("/{id}")
    void updateUser(@PathVariable Long id, @RequestBody @Valid UserDto userDto) {
        userService.updateUser(id, userDto);
    }


    @Operation(summary = "Delete a User by id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete a User by user_id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubscriptionDto.class))}),
            @ApiResponse(responseCode = "404", description = "Request to the wrong path or with an error in the URL.",
                    content = @Content),
            @ApiResponse(responseCode = "405", description = "Method is not supported at this URL or the HTTP method is not correct when requested",
                    content = @Content),
    })

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @Operation(summary = "Get User by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get  User by id ",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubscriptionDto.class))}),
            @ApiResponse(responseCode = "404", description = "Request to the wrong path or with an error in the URL.",
                    content = @Content),
            @ApiResponse(responseCode = "405", description = "Method is not supported at this URL or the HTTP method is not correct when requested",
                    content = @Content),
    })

    @GetMapping("/{id}")
    UserDto getUser(@PathVariable Long id) {
        return userService.findByid(id);
    }

    @Operation(summary = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all users",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubscriptionDto.class))}),
            @ApiResponse(responseCode = "404", description = "Request to the wrong path or with an error in the URL.",
                    content = @Content),
            @ApiResponse(responseCode = "405", description = "Method is not supported at this URL or the HTTP method is not correct when requested",
                    content = @Content),
    })

    @GetMapping()
    List<UserDto> getAllUsers() {
        return userService.findAll();
    }

}

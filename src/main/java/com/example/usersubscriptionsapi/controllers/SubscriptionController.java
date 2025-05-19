package com.example.usersubscriptionsapi.controllers;

import com.example.usersubscriptionsapi.models.dtos.SubscriptionDto;
import com.example.usersubscriptionsapi.services.SubscriptionService;
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
@RequestMapping("/subscription")
@AllArgsConstructor
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    @Operation(summary = "Create a Subscription ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created a subscription",
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

    @PostMapping("/users/{id}")
    void newSubscription(@RequestBody @Valid SubscriptionDto subscriptionDto, @PathVariable Long id) {
        subscriptionService.create(subscriptionDto, id);
    }


    @Operation(summary = "Delete a Subscription by id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete a Subscription by user_id and by subscription_id",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubscriptionDto.class))}),
            @ApiResponse(responseCode = "404", description = "Request to the wrong path or with an error in the URL.",
                    content = @Content),
            @ApiResponse(responseCode = "405", description = "Method is not supported at this URL or the HTTP method is not correct when requested",
                    content = @Content),
    })


    @DeleteMapping("/users/{user_id}/subscription/{id}")
    void delete(@PathVariable Long id) {
        subscriptionService.delete(id);
    }

    @Operation(summary = "Get all UserSubscriptions  ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all UserSubscriptions",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubscriptionDto.class))}),
            @ApiResponse(responseCode = "404", description = "Request to the wrong path or with an error in the URL.",
                    content = @Content),
            @ApiResponse(responseCode = "405", description = "Method is not supported at this URL or the HTTP method is not correct when requested",
                    content = @Content),
    })

    @GetMapping("/users/{id}")
    List<SubscriptionDto> findAllByUserId(@PathVariable Long id) {
        return subscriptionService.findAllByUserId(id);
    }


    @Operation(summary = "Get  TopThreeSubscriptions  ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all TopThreeSubscriptions",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubscriptionDto.class))}),
            @ApiResponse(responseCode = "404", description = "Request to the wrong path or with an error in the URL.",
                    content = @Content),
            @ApiResponse(responseCode = "405", description = "Method is not supported at this URL or the HTTP method is not correct when requested",
                    content = @Content),
    })

    @GetMapping("/top")
    List<SubscriptionDto> findTopThreeSubscriptions() {
        return subscriptionService.findTopThreeSubscriptions();
    }
}

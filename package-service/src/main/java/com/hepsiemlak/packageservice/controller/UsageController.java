package com.hepsiemlak.packageservice.controller;

import com.hepsiemlak.packageservice.model.CheckRequest;
import com.hepsiemlak.packageservice.model.CheckResponse;
import com.hepsiemlak.packageservice.model.IncrementRequest;
import com.hepsiemlak.packageservice.service.UsageService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usage")
public class UsageController {

    private final UsageService usageService;

    @Operation(summary = "", description = "Increment counter")
    @PostMapping("/increment")
    @ResponseBody
    public void increment(@RequestBody IncrementRequest request) { usageService.increment(request); }

    @Operation(summary = "", description = "Check limit")
    @PostMapping("/check")
    @ResponseBody
    public CheckResponse check(@RequestBody CheckRequest request) { return usageService.check(request);}

}

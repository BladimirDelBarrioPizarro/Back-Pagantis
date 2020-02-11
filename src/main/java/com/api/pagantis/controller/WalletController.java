package com.api.pagantis.controller;

import com.api.pagantis.model.dto.WalletDTO;
import com.api.pagantis.model.models.Transaction;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(value = "/api/v1")
public interface WalletController {
    @GetMapping(path="/wallets/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<WalletDTO>> findWalletsByUserId(@PathVariable("id") Long userId);

    @GetMapping(path="/wallets",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<WalletDTO>> findWalletsByUserName(@RequestParam("name") String name);

    @PostMapping(path = "/wallets",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Link> transaction(@RequestBody Transaction transaction);
}

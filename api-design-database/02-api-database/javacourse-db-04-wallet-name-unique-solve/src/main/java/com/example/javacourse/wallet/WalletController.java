package com.example.javacourse.wallet;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("")
    public List<Wallet> getWalletList() {
        return this.walletService.getWalletList();
    }

    @GetMapping("/{id}")
    public Wallet getWalletById(@PathVariable Integer id) {
        return this.walletService.getWalletById(id);
    }

    @PostMapping("")
    public Wallet createWallet(@Valid @RequestBody WalletRequestDto requestDto) throws Exception {
        return this.walletService.createWallet(requestDto);
    }

    @PutMapping("/{id}")
    public Wallet editWallet(@PathVariable Integer id, @RequestBody WalletRequestDto requestDto) {
        return this.walletService.editWalletById(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public String deleteWalletById(@PathVariable Integer id) {
        this.walletService.deleteWalletById(id);
        return "success";
    }

}



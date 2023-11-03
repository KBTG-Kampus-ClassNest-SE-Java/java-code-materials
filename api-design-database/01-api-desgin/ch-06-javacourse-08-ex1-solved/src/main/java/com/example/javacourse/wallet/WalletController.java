package com.example.javacourse.wallet;

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
    public List<Wallet> getUserList() {
        return walletService.getWalletList();
    }

    @PostMapping("")
    public Wallet createUser(@RequestBody WalletRequestDto requestDto) {
        return walletService.createWallet(requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.walletService.deleteWalletById(id);
    }

    @PutMapping("/{id}")
    public void editWallet(@PathVariable Integer id, @RequestBody WalletRequestDto requestDto) {
        this.walletService.editWalletById(id, requestDto);
    }

}

record WalletRequestDto(String name) {}
package com.example.javacourse.wallet;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
        return walletService.getWalletList();
    }

    @GetMapping("/{id}")
    public Wallet getWalletById(@PathVariable Integer id) {
        return this.walletService.getWalletById(id);
    }

    @PostMapping("")
    public Wallet createUser(@Valid @RequestBody WalletRequestDto requestDto) throws Exception {
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

record WalletRequestDto(
        @NotNull
        @Size(min = 3, max = 30, message = "Wallet name length should be 3-20 characters")
        String name
) {}
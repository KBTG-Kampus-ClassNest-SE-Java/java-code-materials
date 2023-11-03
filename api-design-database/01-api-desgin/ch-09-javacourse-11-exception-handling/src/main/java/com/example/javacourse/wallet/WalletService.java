package com.example.javacourse.wallet;

import com.example.javacourse.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    private List<Wallet> walletList = new ArrayList<>(
            List.of(new Wallet(1,"Saving house"),
                    new Wallet(2,"Saving car"))
    );


    public List<Wallet> getWalletList() {
        return walletList;
    }
    public Wallet getWalletById(Integer id) {
        return walletList.stream()
                .filter(wallet -> wallet.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Wallet " + id +" not found"));
    }

    public Wallet createWallet(WalletRequestDto requestDto) throws Exception {
        Optional<Integer> maxId = walletList.stream()
                .map(Wallet::getId)
                .max(Integer::compareTo);
        int nextId = maxId.orElse(0) + 1;

        Wallet wallet = new Wallet(nextId,requestDto.name());

        walletList.add(wallet);
        return wallet;
    }

    public void deleteWalletById(@PathVariable Integer id) {
        walletList.removeIf(user1 -> user1.getId().equals(id));
    }

    public void editWalletById(Integer id, WalletRequestDto requestDto) {
        for (Wallet wallet: walletList) {
            if (wallet.getId().equals(id)) {
                wallet.setName(requestDto.name());
                break;
            }
        }
    }
}

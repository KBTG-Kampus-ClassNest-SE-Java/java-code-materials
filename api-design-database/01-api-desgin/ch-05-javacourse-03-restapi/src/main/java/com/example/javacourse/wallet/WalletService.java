package com.example.javacourse.wallet;

import com.example.javacourse.exception.BadRequestException;
import com.example.javacourse.exception.NotFoundException;
import com.example.javacourse.mail.MailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    private final MailService mailService;

    public WalletService(MailService mailService) {
        this.mailService = mailService;
    }

    private List<Wallet> walletList = new ArrayList<>(
            List.of(new Wallet(1,"Saving house", "saving@mail.com"),
                    new Wallet(2,"Saving car", "car@mail.com"))
    );

    public List<Wallet> getWalletList() {
        return walletList;
    }


    public Wallet createWallet(WalletRequestDto requestDto) throws Exception {
        Wallet existWallet = walletList.stream()
                .filter(wallet -> wallet.getEmail().equalsIgnoreCase(requestDto.getEmail()))
                .findFirst()
                .orElse(null);
        if (existWallet != null) {
            throw new BadRequestException("Email exist in system: " + requestDto.getEmail());
        }


        Optional<Integer> maxId = walletList.stream()
                .map(Wallet::getId)
                .max(Integer::compareTo);
        int nextId = maxId.orElse(0) + 1;

        Wallet wallet = new Wallet(nextId,requestDto.getName(), requestDto.getEmail());

        walletList.add(wallet);
        mailService.sendMail("admin@gmail.com", "Wallet created : " + wallet.getEmail());
        return wallet;
    }


    public Wallet getWalletById(Integer id) {
        return walletList.stream()
                .filter(wallet -> wallet.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Wallet " + id +" not found"));
    }

    public Wallet editWalletById(Integer id, WalletRequestDto requestDto) {
        for (Wallet wallet: walletList) {
            if (wallet.getId().equals(id)) {
                wallet.setName(requestDto.getName());
                return wallet;
            }
        }
        return null;
    }

    public void deleteWalletById(Integer id) {
        walletList.removeIf(wallet -> wallet.getId().equals(id));
    }
}

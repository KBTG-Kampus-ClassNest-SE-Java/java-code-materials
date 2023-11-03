package com.example.javacourse.wallet;

import com.example.javacourse.exception.BadRequestException;
import com.example.javacourse.exception.NotFoundException;
import com.example.javacourse.mail.MailService;
import com.example.javacourse.profile.Profile;
import com.example.javacourse.profile.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    private final MailService mailService;

    private final WalletRepository walletRepository;

    public WalletService(MailService mailService, WalletRepository walletRepository, ProfileRepository profileRepository) {
        this.mailService = mailService;
        this.walletRepository = walletRepository;
    }

    public List<Wallet> getWalletList() {
        List<Wallet> wallets = walletRepository.findAll();
        return wallets;
    }


    public Wallet createWallet(WalletRequestDto requestDto) throws Exception {
        Wallet wallet = new Wallet();
        wallet.setWalletName(requestDto.getName());
        wallet.setActive(true);
        walletRepository.save(wallet);
        return wallet;
//        return new WalletResponseDto(wallet.getWalletName(), wallet.getActive(), wallet.getProfile());
    }


    public Wallet getWalletById(Integer id) {
//        return walletList.stream()
//                .filter(wallet -> wallet.getId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new NotFoundException("Wallet " + id +" not found"));
        return null;
    }

    public Wallet editWalletById(Integer id, WalletRequestDto requestDto) {
        Optional<Wallet> optionalWallet = walletRepository.findById(Long.valueOf(id));
        if (optionalWallet.isEmpty()) {
            throw new BadRequestException("Invalid wallet id");
        }
        Wallet wallet = optionalWallet.get();
        wallet.setWalletName(requestDto.getName());
        walletRepository.save(wallet);
        return wallet;
    }

    public void deleteWalletById(Integer id) {
        walletRepository.deleteById(Long.valueOf(id));
    }
}

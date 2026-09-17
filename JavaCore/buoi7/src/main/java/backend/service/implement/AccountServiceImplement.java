package backend.service.implement;

import backend.repository.IAccountRepository;
import backend.repository.implement.AccountRepositoryImplement;
import backend.service.IAccountService;
import entity.Account;

import java.util.List;

public class AccountServiceImplement implements IAccountService {
    IAccountRepository accountRepository;

    public AccountServiceImplement() {
        accountRepository = new AccountRepositoryImplement();
    }

    @Override
    public List<Account> getAccountS() {
        return accountRepository.getAccounts();
    }

    @Override
    public boolean kiemTraTonTaiAccountId(Integer accountId) {
        return accountRepository.kiemTraTonTaiAccountId(accountId);
    }

    @Override
    public boolean suaUsernameTheoId(Integer accountId, String userName) {
        return accountRepository.suaUsernameTheoId(accountId,userName);
    }

    @Override
    public boolean xoaAccountTheoId(Integer accountId) {
        return accountRepository.xoaAccountTheoId(accountId);
    }



    @Override
    public boolean themAccount(String email, String userName, String fullName, Integer departmentId, Integer positionId, String gender) {
        return accountRepository.themAccount(email,userName,fullName,departmentId,positionId,gender);
    }

    @Override
    public boolean checkTonTaiEmail(String email) {
        return accountRepository.checkTonTaiEmail(email);
    }

    @Override
    public boolean checkTonTaiUserNameThem(String userName) {
        return accountRepository.checkTonTaiUserNameThem(userName);
    }

    @Override
    public boolean checkTonTaiUserNameSua(Integer accountId, String userName) {
        return accountRepository.checkTonTaiUserNameSua(accountId,userName);
    }
}

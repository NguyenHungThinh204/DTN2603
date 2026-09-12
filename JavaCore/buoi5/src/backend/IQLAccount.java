package backend;
import entity.Account;
public interface IQLAccount {
    void hienThiAccount();

    void themAccount(Account account);

    void xoaAccount(int accountId);

    void suaUsername(int accountId, String username);
}

package in.ashokit.service;

import java.util.List;

import in.ashokit.entities.UserAccount;

public interface UserAccountService {

	public String saveOrUpdateUserAcc(UserAccount userAcc);

	public List<UserAccount> getAllUserAccounts();

	public UserAccount getUserAcc(Integer userId);

	public Boolean deletUserAcc(Integer userId);
	
	public Boolean updateUserAccStatus(Integer userId,String status);
}

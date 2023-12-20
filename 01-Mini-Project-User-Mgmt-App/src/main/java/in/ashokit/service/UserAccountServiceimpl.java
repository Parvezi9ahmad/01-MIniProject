package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.Repository.UserAccountRepo;
import in.ashokit.entities.UserAccount;

@Service
public class UserAccountServiceimpl implements UserAccountService {

	@Autowired
	private UserAccountRepo userAccRepo;

	@Override
	public String saveOrUpdateUserAcc(UserAccount userAcc) {
		Integer userId = userAcc.getUserId();

		if(userId==null) {
			userAcc.setActiveSw("Y");
		}
		userAccRepo.save(userAcc);

		if (userId == null) {
			return "User record is save";
		}
		return "User record updated";
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
//		List<UserAccount> account = userAccRepo.findAll();
		return userAccRepo.findAll();
	}

	@Override
	public UserAccount getUserAcc(Integer userId) {
		Optional<UserAccount> findById = userAccRepo.findById(userId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public Boolean deletUserAcc(Integer userId) {
		boolean existsById = userAccRepo.existsById(userId);
		if (existsById) {
			userAccRepo.deleteById(userId);
			return true;
		}
		return false;
	}

	@Override
	public Boolean updateUserAccStatus(Integer userId, String status) {
		try {
			userAccRepo.updateUserAccStatus(userId, status);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

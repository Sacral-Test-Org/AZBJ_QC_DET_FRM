package com.azbj.qc.service;

import com.azbj.qc.model.User;
import com.azbj.qc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public AuthenticationResult authenticate(User user) {
        if (user == null || user.getSupervisorId() == null || user.getPassword() == null) {
            return new AuthenticationResult(false, "Supervisor ID and Password must be provided.");
        }

        boolean isValid = validateCredentials(user.getSupervisorId(), user.getPassword());
        if (isValid) {
            return new AuthenticationResult(true, "Approved");
        } else {
            return new AuthenticationResult(false, "Invalid Supervisor ID or Password.");
        }
    }

    public boolean validateCredentials(String supervisorId, String password) {
        User user = userRepository.findBySupervisorIdAndPassword(supervisorId, password);
        return user != null;
    }

    public static class AuthenticationResult {
        private boolean success;
        private String message;

        public AuthenticationResult(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }
}

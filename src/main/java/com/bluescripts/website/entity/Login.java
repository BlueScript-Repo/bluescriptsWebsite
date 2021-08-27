package com.bluescripts.website.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

@Entity
@Data
@Builder
@Table(name = "gst_login")
@NoArgsConstructor
@AllArgsConstructor
@Lazy
public class Login implements Serializable {

	@Id
	private String userName;

	private String password;

	private String email;

	private String role;

	private static final long OTP_VALID_DURATION = 5 * 60 * 1000;   // 5 minutes

	@Column(name = "one_time_password")
	private String oneTimePassword;

	@Column(name = "otp_requested_time")
	private Date otpRequestedTime;

	public boolean isOTPRequired() {
		if (this.getOneTimePassword() == null) {
			return false;
		}

		long currentTimeInMillis = System.currentTimeMillis();
		long otpRequestedTimeInMillis = this.otpRequestedTime.getTime();

		if (otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeInMillis) {
			// OTP expires
			return false;
		}

		return true;
	}

}

package org.hubotek.model.google.adsense;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hubotek.model.AccountStatusEnum;
import org.hubotek.model.google.GoogleBase;


/**
 * 
 * @author JoseCanova
 *
 */
@Entity
@Table(name="google_adsense_account")
@SuppressWarnings("serial")
public class GoogleAdsenseAccount extends GoogleBase{

	@Column(name="client_id" , length=255 , insertable=true , updatable=true)
	private String clientId; 
	
	@Enumerated(EnumType.STRING)
	private AccountStatusEnum accountStatus;
	
	public GoogleAdsenseAccount(){}
	
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public AccountStatusEnum getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatusEnum accountStatus) {
		this.accountStatus = accountStatus;
	} 
	
	
}

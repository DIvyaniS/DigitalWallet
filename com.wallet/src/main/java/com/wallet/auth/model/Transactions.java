package com.wallet.auth.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transactions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private java.sql.Date startDate;
	private String fromCard;
	private String toUser;
	private Long amount;
	private Long uId;
	public Transactions() {
		super();
	}

	
	

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "START_DATE", columnDefinition = "DATE DEFAULT CURRENT_DATE")
	public java.sql.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}

	public String getFromCard() {
		return fromCard;
	}

	public void setFromCard(String fromCard) {
		this.fromCard = fromCard;
	}

	
	





	public String getToUser() {
		return toUser;
	}





	public void setToUser(String toUser) {
		this.toUser = toUser;
	}





	public Long getAmount() {
		return amount;
	}





	public void setAmount(Long amount) {
		this.amount = amount;
	}





	@Override
	public String toString() {
		return "Transactions [startDate=" + startDate + ", fromCard=" + fromCard + ", toUser=" + toUser + ", amount="
				+ amount + "]"+"\n";
	}





	public Long getuId() {
		return uId;
	}





	public void setuId(Long uId) {
		this.uId = uId;
	}
	
}

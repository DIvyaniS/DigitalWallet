package com.wallet.auth.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.wallet.auth.model.CardInfo;
import com.wallet.auth.model.*;

@Entity
@Table(name = "user")
public class User {
    public User() {
		super();
	}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private Long balance;
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_cardInfo", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "cardInfo_id"))
    private Set<CardInfo> cardInfo;
    
    @OneToMany(mappedBy="user" , cascade = CascadeType.ALL)
    private Set<Transactions> transactions;
    

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}
	
	
	public Set<CardInfo> getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(Set<CardInfo> cardInfo) {
		this.cardInfo = cardInfo;
	}

	public synchronized Set<Transactions> getTransactions() {
		return transactions;
	}

	public synchronized void setTransactions(Set<Transactions> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "User [transactions=" + transactions + "]";
	}

//	@Override
//	public String toString() {
//		String s = "";
//		
//		//if(transactions==null) return null;
//		//System.out.println("in USER");
//		//List<Transactions> list = new ArrayList<Transactions>(transactions);
//		for(Transactions t: transactions)
//		{
//			
//			//System.out.println("in USER");
//			
//			s += t.toString();
//			System.out.println(t.toString());
//		}
//		return s;
//	}
}

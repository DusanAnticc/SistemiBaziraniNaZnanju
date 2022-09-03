//package sbnz.integracija.example.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "penalties")
//public class Penalties{
//
//	@ManyToOne(fetch = FetchType.EAGER)
//    private User user;
//	
//	@Column(name = "approved", nullable = false)
//    private Long date;
//	
//	public Penalties() {
//	}
//	
//
//	public Penalties(User user, Long date) {
//		super();
//		this.user = user;
//		this.date = date;
//	}
//	
//	
//}

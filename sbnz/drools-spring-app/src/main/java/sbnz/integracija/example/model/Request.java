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
//@Table(name = "zahtjevi")
//public class Request{
//
//	@ManyToOne(fetch = FetchType.EAGER)
//    private User user;
//	
//	@Column(name = "approved", nullable = false)
//    private boolean approved = false;
//	
//	@Column(name = "reason_for_rejection", nullable = true)
//    private String reasonForRejection = null;
//	
//	public Request() {
//	}
//	
//	public Request(User user, boolean approved, String reasonForRejection) {
//		super();
//		this.user = user;
//		this.approved = approved;
//		this.reasonForRejection = reasonForRejection;
//	}
//	
//	
//}

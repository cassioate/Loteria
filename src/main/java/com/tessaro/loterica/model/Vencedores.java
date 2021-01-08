//package com.tessaro.loterica.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//
//import com.sun.istack.NotNull;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Getter @Setter
//@AllArgsConstructor @NoArgsConstructor
//public class Vencedores {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	
//	@NotNull
//	@OneToOne
//	@JoinColumn(name = "numero_id")
//	private NumeroDaSorte numero;
//	
//}

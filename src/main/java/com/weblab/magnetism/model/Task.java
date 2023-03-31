package com.weblab.magnetism.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="task")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Task {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name="text")
   private String text;

   @Column(name="userId")
   private Long userId;

   //TODO: add logic to work with Date type in ajax methods
   @Column(name="date")
   private Date date;
}

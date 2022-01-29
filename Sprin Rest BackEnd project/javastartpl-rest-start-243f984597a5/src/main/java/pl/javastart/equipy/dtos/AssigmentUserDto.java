package pl.javastart.equipy.dtos;

import java.time.LocalDateTime;

public class AssigmentUserDto {

   private int id;
    private LocalDateTime start;
    private   LocalDateTime end;
    private int userId;
    private String firstName;
    private    String lastName;
    private String pesel;

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public LocalDateTime getStart() {
  return start;
 }

 public void setStart(LocalDateTime start) {
  this.start = start;
 }

 public LocalDateTime getEnd() {
  return end;
 }

 public void setEnd(LocalDateTime end) {
  this.end = end;
 }

 public int getUserId() {
  return userId;
 }

 public void setUserId(int userId) {
  this.userId = userId;
 }

 public String getFirstName() {
  return firstName;
 }

 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }

 public String getLastName() {
  return lastName;
 }

 public void setLastName(String lastName) {
  this.lastName = lastName;
 }

 public String getPesel() {
  return pesel;
 }

 public void setPesel(String pesel) {
  this.pesel = pesel;
 }
}

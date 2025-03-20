@US21 @UI @E2E @Admin
Feature: Admin marks contact messages as read

  Scenario: Admin Contact mesajları okundu olarak isaretleyebilmelidir

    Given Contact mesajları sayfasına gidilir
    When Bir mesaj okundu olarak işaretlenir
    Then Mesajin okundu olarak isaretlendigi dogrulanir


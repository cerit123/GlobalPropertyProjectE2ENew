@US20 @Manager @UI @E2E
Feature: Manager marks contact messages as read

  Scenario: Manager Contact mesajları okundu olarak isaretleyebilmelidir

    Given Contact mesajları sayfasına gidilir
    When Bir mesaj okundu olarak işaretlenir
    Then Mesajin okundu olarak isaretlendigi dogrulanir


@US20 @Manager @UI @E2E
Feature: Manager searches contact messages with specific word

  Scenario: Manager belirli bir kelime ile contact mesaji aratabilmeli

    Given Contact mesajları sayfasına gidilir
    When Belirli bir kelime ile arama yapilir
    Then Arama sonuclarinin listelendigi dogrulanir


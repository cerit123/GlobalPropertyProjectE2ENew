@US20 @Manager @UI @E2E
Feature: Manager search within read and unread messages by giving a date range

  Scenario: Manager Okunan ve okunmayan mesajlar içerisinde tarih aralığı vererek arama yapabilmeli

    Given Contact mesajları sayfasına gidilir
    When Filter butonuna tiklanir
    And Start Date alanian tarih girilir
    And End Date alanian tarih girilir
    And Onay butonuna basilir
    Then Belirlitilen tarih araligindaki arama sonuclarinin listelendigi dogrulanir

